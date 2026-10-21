package com.br.appSaude.modules.auth;

import com.br.appSaude.modules.auth.dto.LoginRequest;
import com.br.appSaude.modules.auth.dto.LoginResponse;
import com.br.appSaude.modules.auth.dto.UsuarioAutenticadoResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import com.br.appSaude.modules.paciente.PacienteRepository;
import com.br.appSaude.modules.paciente.EntityJpaPaciente;
import com.br.appSaude.modules.paciente.dto.CadastroPacienteRequest;
import com.br.appSaude.modules.medico.MedicoRepository;
import com.br.appSaude.modules.atendente.AtendenteRepository;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UsuarioAuthRepository repository;
    private final JwtService jwtService;
    private final PacienteRepository pacienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final MedicoRepository medicoRepository;
    private final AtendenteRepository atendenteRepository;

    public AuthService(AuthenticationManager authenticationManager,
                       UsuarioAuthRepository repository,
                       JwtService jwtService,
                       PacienteRepository pacienteRepository,
                       PasswordEncoder passwordEncoder,
                       MedicoRepository medicoRepository,
                       AtendenteRepository atendenteRepository) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtService = jwtService;
        this.pacienteRepository = pacienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.medicoRepository = medicoRepository;
        this.atendenteRepository = atendenteRepository;
    }

    @Transactional
    public LoginResponse cadastrar(CadastroPacienteRequest request) {
        if (pacienteRepository.findByCpfPaciente(request.cpf()).isPresent()
                || repository.findByCpf(request.cpf()).isPresent()) {
            throw new IllegalStateException("CPF já cadastrado.");
        }
        if (pacienteRepository.existsByEmailIgnoreCase(request.email())) {
            throw new IllegalStateException("E-mail já cadastrado.");
        }
        EntityJpaPaciente paciente = EntityJpaPaciente.builder()
                .nome(request.nome().trim())
                .email(request.email().trim().toLowerCase())
                .cpfPaciente(request.cpf())
                .telefonePaciente(request.telefone())
                .build();
        paciente = pacienteRepository.save(paciente);
        UsuarioAuth usuario = new UsuarioAuth();
        usuario.setCpf(paciente.getCpfPaciente());
        usuario.setSenhaHash(passwordEncoder.encode(request.senha()));
        usuario.setRole(Role.USUARIO);
        usuario.setPerfilId(paciente.getId());
        usuario = repository.save(usuario);
        return new LoginResponse(jwtService.gerarToken(usuario), usuarioAtual(usuario));
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.cpf(), request.senha()));
        UsuarioAuth usuario = repository.findByCpf(request.cpf())
                .orElseThrow(() -> new IllegalStateException("Conta autenticada não encontrada."));
        return new LoginResponse(jwtService.gerarToken(usuario), usuarioAtual(usuario));
    }

    public UsuarioAutenticadoResponse usuarioAtual(UsuarioAuth usuario) {
        String nome = switch (usuario.getRole()) {
            case USUARIO -> pacienteRepository.findById(usuario.getPerfilId()).map(p -> p.getNome()).orElse("");
            case MEDICO -> medicoRepository.findById(usuario.getPerfilId()).map(m -> m.getNome()).orElse("");
            case ATENDENTE -> atendenteRepository.findById(usuario.getPerfilId()).map(a -> a.getNomeAtendente()).orElse("");
        };
        return new UsuarioAutenticadoResponse(usuario.getPerfilId(), usuario.getPerfilId(), usuario.getRole(),
                usuario.getRole().name(), nome);
    }
}
