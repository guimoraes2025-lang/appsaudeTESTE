DO $$
DECLARE
    atendente_id BIGINT;
    medico_id BIGINT;
BEGIN
    IF '${staff_atendente_cpf}' <> '' AND '${staff_atendente_hash}' <> ''
       AND NOT EXISTS (SELECT 1 FROM usuario_auth WHERE cpf = '${staff_atendente_cpf}') THEN
        INSERT INTO atendente (cpf_atendente, nome_atendente)
        VALUES ('${staff_atendente_cpf}', 'Atendente inicial')
        RETURNING id_atendente INTO atendente_id;
        INSERT INTO usuario_auth (cpf, senha_hash, role, perfil_id)
        VALUES ('${staff_atendente_cpf}', '${staff_atendente_hash}', 'ATENDENTE', atendente_id);
    END IF;

    IF '${staff_medico_cpf}' <> '' AND '${staff_medico_hash}' <> ''
       AND '${staff_medico_crm}' <> ''
       AND NOT EXISTS (SELECT 1 FROM usuario_auth WHERE cpf = '${staff_medico_cpf}') THEN
        INSERT INTO medico (cpf_medico, nome_medico, especialidade_medico, crm_medico)
        VALUES ('${staff_medico_cpf}', 'Médico inicial', 'Clínica Geral', '${staff_medico_crm}')
        RETURNING id_medico INTO medico_id;
        INSERT INTO usuario_auth (cpf, senha_hash, role, perfil_id)
        VALUES ('${staff_medico_cpf}', '${staff_medico_hash}', 'MEDICO', medico_id);
    END IF;
END $$;
