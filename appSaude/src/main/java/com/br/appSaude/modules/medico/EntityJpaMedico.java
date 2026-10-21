package com.br.appSaude.modules.medico;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "medico")
public class EntityJpaMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    Long id;

    @Column(name = "nome_medico", length = 155, nullable = false)
    private String nome;

    @Column(name = "especialidade_medico", length = 100)
    private String especialidadeMedico;

    @Column(name = "crm_medico", length = 20, nullable = false, unique = true)
    private String crmMedico;

    @Column(name = "cpf_medico", length = 11, nullable = false, unique = true)
    private String cpfMedico;

    @Column(name = "email_medico", length = 150)
    private String email;

    @Column(name = "telefone_medico", length = 20)
    private String telefone;


}
