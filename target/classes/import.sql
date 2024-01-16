insert into mp_estado (id, nome, sigla) values (1, 'Minas Gerais', 'MG');
insert into mp_estado (id, nome, sigla) values (2, 'São Paulo', 'SP');
insert into mp_estado (id, nome, sigla) values (3, 'Ceará', 'CE');

insert into mp_cidade (id, nome, mp_estado_id) values (1, 'Uberlândia', 1);
insert into mp_cidade (id, nome, mp_estado_id) values (2, 'Belo Horizonte', 1);
insert into mp_cidade (id, nome, mp_estado_id) values (3, 'São Paulo', 2);
insert into mp_cidade (id, nome, mp_estado_id) values (4, 'Campinas', 2);
insert into mp_cidade (id, nome, mp_estado_id) values (5, 'Fortaleza', 3);

insert into mp_forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into mp_forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into mp_forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into mp_permissao (id, nome, descricao) values (1, 'CONSULTAR_ATIVIDADES', 'Permite consultar atividades');
insert into mp_permissao (id, nome, descricao) values (2, 'EDITAR_ATIVIDADES', 'Permite editar atividades');
insert into mp_permissao (id, nome, descricao) values (3, 'CONSULTAR_ENQUETES', 'Permite consultar enquetes');
insert into mp_permissao (id, nome, descricao) values (4, 'EDITAR_ENQUETES', 'Permite editar enquetes');
