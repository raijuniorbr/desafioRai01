--	==============================================================================================
--	Data: 	20/01/2017
--	Autor: 	Rai
--	Edição:	Este arquivo foi gerado automatiamente pelo Template WildFly encontrado no Maven
--			Modificado para atender especificação do DESAFIO IMB-desafio-tecnico.pdf
--
--	==============================================================================================

--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number, tp_member, memberActive) values (0, 'Rai Braga', 'rai.braga@ironmountain.com.br', '1122223333', 'FISICA','true') 
insert into IronUSer (id, name, email, memberActive, password) values (0, 'admin', 'admin@ironmountain.com.br','true', 'admin') 
