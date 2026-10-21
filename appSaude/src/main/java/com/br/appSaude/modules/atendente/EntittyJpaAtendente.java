package com.br.appSaude.modules.atendente;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "atendente")
public class EntittyJpaAtendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendente")
    private Long idAtendente;

    @Column(name = "cpf_atendente", length = 11, nullable = false, unique = true)
    private String cpfAtendente;

    @Column(name = "nome_atendente", length = 150, nullable = false)
    private String nomeAtendente;

    @Column(name = "email_atendente", length = 150)
    private String email;

    @Column(name = "telefone_atendente", length = 20)
    private String telefone;
}
