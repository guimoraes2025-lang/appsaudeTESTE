-- Dados de demonstração para os cadastros de atendentes e médicos.
-- ON CONFLICT mantém a migration segura para reexecução manual.

INSERT INTO atendente (cpf_atendente, nome_atendente, email_atendente, telefone_atendente)
VALUES
    ('90000000001', 'Ana Souza',       'ana.souza@appsaude.local',       '(11) 90000-0001'),
    ('90000000002', 'Bruno Lima',      'bruno.lima@appsaude.local',      '(11) 90000-0002'),
    ('90000000003', 'Carla Mendes',    'carla.mendes@appsaude.local',    '(11) 90000-0003'),
    ('90000000004', 'Diego Santos',    'diego.santos@appsaude.local',    '(11) 90000-0004'),
    ('90000000005', 'Elisa Oliveira',  'elisa.oliveira@appsaude.local',  '(11) 90000-0005')
ON CONFLICT (cpf_atendente) DO NOTHING;

INSERT INTO medico (
    cpf_medico, nome_medico, especialidade_medico, crm_medico,
    email_medico, telefone_medico
)
VALUES
    ('91000000001', 'Mariana Costa',       'Clínico geral',  'CRM-SP 100001', 'mariana.costa@appsaude.local',       '(11) 91000-0001'),
    ('91000000002', 'Rafael Almeida',      'Clínico geral',  'CRM-SP 100002', 'rafael.almeida@appsaude.local',      '(11) 91000-0002'),
    ('91000000003', 'Juliana Ferreira',    'Clínico geral',  'CRM-SP 100003', 'juliana.ferreira@appsaude.local',    '(11) 91000-0003'),
    ('91000000004', 'Pedro Rodrigues',     'Clínico geral',  'CRM-SP 100004', 'pedro.rodrigues@appsaude.local',     '(11) 91000-0004'),
    ('91000000005', 'Camila Martins',      'Clínico geral',  'CRM-SP 100005', 'camila.martins@appsaude.local',      '(11) 91000-0005'),

    ('91000000006', 'Lucas Carvalho',      'Cardiologia',    'CRM-SP 100006', 'lucas.carvalho@appsaude.local',      '(11) 91000-0006'),
    ('91000000007', 'Beatriz Gomes',       'Cardiologia',    'CRM-SP 100007', 'beatriz.gomes@appsaude.local',       '(11) 91000-0007'),
    ('91000000008', 'Thiago Ribeiro',      'Cardiologia',    'CRM-SP 100008', 'thiago.ribeiro@appsaude.local',      '(11) 91000-0008'),
    ('91000000009', 'Fernanda Barbosa',    'Cardiologia',    'CRM-SP 100009', 'fernanda.barbosa@appsaude.local',    '(11) 91000-0009'),
    ('91000000010', 'Gabriel Nunes',       'Cardiologia',    'CRM-SP 100010', 'gabriel.nunes@appsaude.local',       '(11) 91000-0010'),

    ('91000000011', 'Isabela Castro',      'Oftalmologia',   'CRM-SP 100011', 'isabela.castro@appsaude.local',      '(11) 91000-0011'),
    ('91000000012', 'Matheus Araujo',      'Oftalmologia',   'CRM-SP 100012', 'matheus.araujo@appsaude.local',      '(11) 91000-0012'),
    ('91000000013', 'Larissa Monteiro',    'Oftalmologia',   'CRM-SP 100013', 'larissa.monteiro@appsaude.local',    '(11) 91000-0013'),
    ('91000000014', 'André Moreira',       'Oftalmologia',   'CRM-SP 100014', 'andre.moreira@appsaude.local',       '(11) 91000-0014'),
    ('91000000015', 'Patricia Cardoso',    'Oftalmologia',   'CRM-SP 100015', 'patricia.cardoso@appsaude.local',    '(11) 91000-0015'),

    ('91000000016', 'Eduardo Teixeira',    'Pediatria',      'CRM-SP 100016', 'eduardo.teixeira@appsaude.local',    '(11) 91000-0016'),
    ('91000000017', 'Leticia Correia',     'Pediatria',      'CRM-SP 100017', 'leticia.correia@appsaude.local',     '(11) 91000-0017'),
    ('91000000018', 'Vinicius Lopes',      'Pediatria',      'CRM-SP 100018', 'vinicius.lopes@appsaude.local',      '(11) 91000-0018'),
    ('91000000019', 'Mariana Dias',        'Pediatria',      'CRM-SP 100019', 'mariana.dias@appsaude.local',        '(11) 91000-0019'),
    ('91000000020', 'Felipe Batista',      'Pediatria',      'CRM-SP 100020', 'felipe.batista@appsaude.local',      '(11) 91000-0020')
ON CONFLICT (cpf_medico) DO NOTHING;
