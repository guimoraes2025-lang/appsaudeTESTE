package com.br.appSaude.modules.paciente;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "paciente")
public class EntityJpaPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    @Column(name = "nome_paciente", length = 150, nullable = false)
    private String nome;

    @Column(name = "email_paciente", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "telefone_paciente", length = 20)
    private String telefonePaciente;

    @Column(name = "cpf_paciente", length = 11, nullable = false, unique = true)
    private String cpfPaciente;

    @Column(name = "data_nascimento")
    private LocalDate dataDeNascimento;

    @Column(name = "criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEmPaciente;

}
