-- Cadastrando Estados
insert into "state" ("name", "acronym") values ('Acre','AC');
insert into "state" ("name", "acronym") values ('Alagoas','AL');
insert into "state" ("name", "acronym") values ('Amapá','AP');
insert into "state" ("name", "acronym") values ('Amazonas','AM');
insert into "state" ("name", "acronym") values ('Bahia','BA');
insert into "state" ("name", "acronym") values ('Ceará','CE');
insert into "state" ("name", "acronym") values ('Espírito Santo','ES');
insert into "state" ("name", "acronym") values ('Goiás','GO');
insert into "state" ("name", "acronym") values ('Maranhão','MA');
insert into "state" ("name", "acronym") values ('Mato Grosso','MT');
insert into "state" ("name", "acronym") values ('Mato Grosso do Sul','MS');
insert into "state" ("name", "acronym") values ('Minas Gerais','MG');
insert into "state" ("name", "acronym") values ('Pará','PA');
insert into "state" ("name", "acronym") values ('Paraíba','PB');
insert into "state" ("name", "acronym") values ('Paraná','PR');
insert into "state" ("name", "acronym") values ('Pernambuco','PE');
insert into "state" ("name", "acronym") values ('Piauí','PI');
insert into "state" ("name", "acronym") values ('Rio de Janeiro','RJ');
insert into "state" ("name", "acronym") values ('Rio Grande do Norte','RN');
insert into "state" ("name", "acronym") values ('Rio Grande do Sul','RS');
insert into "state" ("name", "acronym") values ('Rondônia','RO');
insert into "state" ("name", "acronym") values ('Roraima','RR');
insert into "state" ("name", "acronym") values ('Santa Catarina','SC');
insert into "state" ("name", "acronym") values ('São Paulo','SP');
insert into "state" ("name", "acronym") values ('Sergipe','SE');
insert into "state" ("name", "acronym") values ('Tocantins','TO');
insert into "state" ("name", "acronym") values ('Distrito Federal','DF');

-- Cadastrando municipios
-- Acre
insert into city ("name", "state_id") values ('Rio Branco', 1);
insert into city ("name", "state_id") values ('Cruzeiro do Sul', 1); 
insert into city ("name", "state_id") values ('Sena Madureira', 1);
-- Alagoas: 
insert into city ("name", "state_id") values ('Maceió', 2); 
insert into city ("name", "state_id") values ('Maragogi', 2);
insert into city ("name", "state_id") values ('Porto de Galinhas', 2);
-- Amapá: 
insert into city ("name", "state_id") values ('Macapá', 3);
insert into city ("name", "state_id") values ('Santana', 3);
insert into city ("name", "state_id") values ('Oiapoque', 3);
-- Amazonas: 
insert into city ("name", "state_id") values ('Manaus', 4); 
insert into city ("name", "state_id") values ('Parintins', 4);
insert into city ("name", "state_id") values ('Itacoatiara', 4);
-- Bahia: 
insert into city ("name", "state_id") values ('Salvador', 5);
insert into city ("name", "state_id") values ('Porto Seguro', 5);
insert into city ("name", "state_id") values ('Ilhéus', 5);
-- Ceará: 
insert into city ("name", "state_id") values ('Fortaleza', 6);
insert into city ("name", "state_id") values ('Jericoacoara', 6); 
insert into city ("name", "state_id") values ('Canoa Quebrada', 6);
-- Espírito Santo: 
insert into city ("name", "state_id") values ('Vitória', 7);
insert into city ("name", "state_id") values ('Vila Velha', 7);
insert into city ("name", "state_id") values ('Guarapari', 7);
-- Goiás: 
insert into city ("name", "state_id") values ('Goiânia', 8);
insert into city ("name", "state_id") values ('Caldas Novas', 8);
insert into city ("name", "state_id") values ('Pirenópolis', 8);
-- Maranhão: 
insert into city ("name", "state_id") values ('São Luís', 9);
insert into city ("name", "state_id") values ('Barreirinhas', 9);
insert into city ("name", "state_id") values ('Imperatriz', 9);
-- Mato Grosso: 
insert into city ("name", "state_id") values ('Cuiabá', 10);
insert into city ("name", "state_id") values ('Chapada dos Guimarães', 10);
insert into city ("name", "state_id") values ('Sinop', 10);
-- Mato Grosso do Sul: 
insert into city ("name", "state_id") values ('Campo Grande', 11);
insert into city ("name", "state_id") values ('Bonito', 11);
insert into city ("name", "state_id") values ('Corumbá', 11);
-- Minas Gerais: 
insert into city ("name", "state_id") values ('Belo Horizonte', 12);
insert into city ("name", "state_id") values ('Ouro Preto', 12);
insert into city ("name", "state_id") values ('Tiradentes', 12);
-- Pará: 
insert into city ("name", "state_id") values ('Belém', 13);
insert into city ("name", "state_id") values ('Santarém', 13);
insert into city ("name", "state_id") values ('Marabá', 13);
-- Paraíba: 
insert into city ("name", "state_id") values ('João Pessoa', 14);
insert into city ("name", "state_id") values ('Campina Grande', 14);
insert into city ("name", "state_id") values ('Cabedelo', 14);
-- Paraná: 
insert into city ("name", "state_id") values ('Curitiba', 15);
insert into city ("name", "state_id") values ('Foz do Iguaçu', 15);
insert into city ("name", "state_id") values ('Londrina', 15);
-- Pernambuco: 
insert into city ("name", "state_id") values ('Recife', 16);
insert into city ("name", "state_id") values ('Olinda', 16);
insert into city ("name", "state_id") values ('Porto de Galinhas', 16);
-- Piauí: 
insert into city ("name", "state_id") values ('Teresina', 17);
insert into city ("name", "state_id") values ('Parnaíba', 17);
insert into city ("name", "state_id") values ('Floriano', 17);
-- Rio de Janeiro: 
insert into city ("name", "state_id") values ('Rio de Janeiro', 18);
insert into city ("name", "state_id") values ('Búzios', 18);
insert into city ("name", "state_id") values ('Paraty', 18);
-- Rio Grande do Norte: 
insert into city ("name", "state_id") values ('Natal', 19);
insert into city ("name", "state_id") values ('Pipa', 19);
insert into city ("name", "state_id") values ('Mossoró', 19);
-- Rio Grande do Sul: 
insert into city ("name", "state_id") values ('Porto Alegre', 20);
insert into city ("name", "state_id") values ('Gramado', 20);
insert into city ("name", "state_id") values ('Santa Maria', 20);
-- Rondônia: 
insert into city ("name", "state_id") values ('Porto Velho', 21);
insert into city ("name", "state_id") values ('Ariquemes', 21);
insert into city ("name", "state_id") values ('Ji-Paraná', 21);
-- Roraima: 
insert into city ("name", "state_id") values ('Boa Vista', 22);
insert into city ("name", "state_id") values ('Caracaraí', 22);
insert into city ("name", "state_id") values ('Pacaraima', 22);
-- Santa Catarina: 
insert into city ("name", "state_id") values ('Florianópolis', 23);
insert into city ("name", "state_id") values ('Balneário Camboriú', 23);
insert into city ("name", "state_id") values ('Joinville', 23);
-- São Paulo: 
insert into city ("name", "state_id") values ('São Paulo', 24);
insert into city ("name", "state_id") values ('Campinas', 24);
insert into city ("name", "state_id") values ('Santos', 24);
-- Sergipe: 
insert into city ("name", "state_id") values ('Aracaju', 25);
insert into city ("name", "state_id") values ('São Cristóvão', 25);
insert into city ("name", "state_id") values ('Estância', 25);
-- Tocantins: 
insert into city ("name", "state_id") values ('Palmas', 26);
insert into city ("name", "state_id") values ('Gurupi', 26);
insert into city ("name", "state_id") values ('Araguaína', 26);
-- Distrito Federal: 
insert into city ("name", "state_id") values ('Brasília', 27);
insert into city ("name", "state_id") values ('Taguatinga', 27);
insert into city ("name", "state_id") values ('Ceilândia', 27);

-- Cadastrando Usuários
insert into users ("username", "password", "role") values ('client@gmail.com','client','CLIENT');
insert into users ("username", "password", "role") values ('admin@gmail.com','admin','ADMIN');

insert into person ("first_name", "last_name", "cpf", "rg", "user_id") values ('Cliente','Teste','123456789','123456',1);
insert into person ("first_name", "last_name", "cpf", "rg", "user_id") values ('Admin','Teste','987654321','654321',2);

insert into "address" ("address","complement","city_id","person_id") values ('Q. 1106 S Al. 2 Lt. 36','Plano Diretor Sul',76,1);
insert into "address" ("address","complement","city_id","person_id") values ('Q. 112 N Al. 10 Lt. 45','Plano Diretor Norte',76,2);

insert into pipe ("description", "characters", "price", "stock", "status", "material") values ('Cachimbo Dracula','Especial para noites de lua cheia',120,10, 'DISPONIVEL','Madeira Sangue de Virgem');
insert into pipe ("description", "characters", "price", "stock", "status", "material") values ('Cachimbo Heisenberg','Perfeito para as Jóias do Infinito!! Incluíndo aquela azulzinha',200,2, 'DISPONIVEL', 'Metal');
insert into pipe ("description", "characters", "price", "stock", "status", "material") values ('Cachimbo da Paz','Específico para ervas jamaicanas',420,420, 'DISPONIVEL', 'Cânhamo');
