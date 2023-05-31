-- Cadastrando Estados
insert into "state" ("name", "acronym") values ('Acre','AC');
insert into "state" ("name", "acronym") values ('Amapá','AP');
insert into "state" ("name", "acronym") values ('Tocantins','TO');

-- Cadastrando municipios
-- Acre
insert into city ("name", "state_id") values ('Rio Branco', 1);
insert into city ("name", "state_id") values ('Cruzeiro do Sul', 1); 
insert into city ("name", "state_id") values ('Sena Madureira', 1);
-- Amapá: 
insert into city ("name", "state_id") values ('Macapá', 2);
insert into city ("name", "state_id") values ('Santana', 2);
insert into city ("name", "state_id") values ('Oiapoque', 2);
-- Tocantins: 
insert into city ("name", "state_id") values ('Palmas', 3);
insert into city ("name", "state_id") values ('Gurupi', 3);
insert into city ("name", "state_id") values ('Araguaína', 3);

-- Cadastrando Produtos
insert into pipe ("description", "characters", "price", "stock", "status", "material") values ('Cachimbo Dracula','Especial para noites de lua cheia',120,10, 'DISPONIVEL','Madeira Sangue de Virgem');
insert into pipe ("description", "characters", "price", "stock", "status", "material") values ('Cachimbo Heisenberg','Perfeito para as Jóias do Infinito!! Incluíndo aquela azulzinha',200,2, 'DISPONIVEL', 'Metal');
insert into pipe ("description", "characters", "price", "stock", "status", "material") values ('Cachimbo da Paz','Específico para ervas jamaicanas',420,420, 'DISPONIVEL', 'Cânhamo');


-- Cadastrando Usuários
insert into users ("username", "password") values ('admin@gmail.com','Dqea/mtuitkfQ0CNCFp54QoW6mZLhWqZ1CbtUcqWegJ0YmJOEDWZjpiqBz31LlpSJ/Ro4Yz5wcVsG7UjDij74g==');
insert into users ("username", "password") values ('user@gmail.com','rfn8b4ovxCwc0nvvqCrFPBFIApxDRppESGK0krCm0dzvrVBJ7xHLaLCQQmq9L5QSUemLAtO7dwrnhNgq8AVu3A==');

-- Cadastrando Pessoas
insert into person ("first_name", "last_name", "cpf", "rg", "date_of_birth", "user_id") values ('Laura','Sbroglia','123456789','123456', '02/04/2000',1);
-- insert into person ("first_name", "last_name", "cpf", "rg", "date_of_birth", "user_id") values ('Iann','Braga','987654321','654321', '2000-02-03',2);

-- Cadastrando Endereços
-- insert into "address" ("address","complement","city_id","person_id") values ('Q. 1106 S Al. 2 Lt. 36','Plano Diretor Sul',76,1);
-- insert into "address" ("address","complement","city_id","person_id") values ('Q. 112 N Al. 10 Lt. 45','Plano Diretor Norte',76,2);

-- Cadastrando Perfis
insert into "role" (user_id, "role") values (1, 'Admin');
insert into "role" (user_id, "role") values (2, 'User');

