package com.br.appSaude.modules.consultas;

import com.br.appSaude.modules.medico.EntityJpaMedico;
import com.br.appSaude.modules.paciente.EntityJpaPaciente;
import com.br.appSaude.modules.atendente.EntittyJpaAtendente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "consulta")
public class EntityJpaConsultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long idConsulta;

    @Column(name = "data_consulta", nullable = false)
    private LocalDate dataConsulta;

    @Column(name = "hora_consulta", nullable = false)
    private LocalTime horaConsulta;

    @Column(name = "status_consulta", length = 20)
    private String statusConsulta;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoesConsulta;

    @Column(name = "criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEmConsulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private EntityJpaPaciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private EntityJpaMedico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atendente_id")
    private EntittyJpaAtendente atendente;

}
