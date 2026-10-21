package com.br.appSaude.modules.atendente;

import com.br.appSaude.modules.consultas.EntityJpaConsultas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteConsultaRepository extends JpaRepository<EntityJpaConsultas, Long> {}
