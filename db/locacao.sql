CREATE SCHEMA IF NOT EXISTS `locacao` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;USE `locacao` ;-- ------------------------------------------------------- Table `locacao`.`cliente`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`cliente` ;CREATE TABLE IF NOT EXISTS `locacao`.`cliente` (  `cpf` BIGINT(11) NOT NULL,  `nome` VARCHAR(45) NOT NULL,  `telefone` VARCHAR(45) NOT NULL,  `email` VARCHAR(45) NOT NULL,  `endereco` VARCHAR(45) NOT NULL,  `cidade` VARCHAR(45) NOT NULL,  `estado` VARCHAR(45) NOT NULL,  `cep` VARCHAR(9) NOT NULL,  `rg` VARCHAR(45) DEFAULT NULL,  `passaporte` VARCHAR(45) DEFAULT NULL,  `data_nascimento` VARCHAR(45) DEFAULT NULL,  `genero` VARCHAR(45) DEFAULT NULL,  `habilitacao` VARCHAR(45) DEFAULT NULL,  `registro` VARCHAR(45) DEFAULT NULL,  `estado_emissor` VARCHAR(45) DEFAULT NULL,  `validade` VARCHAR(45) DEFAULT NULL,  `razao_social` VARCHAR(45) DEFAULT NULL,  `nome_comercial` VARCHAR(45) DEFAULT NULL,  `cnpj` BIGINT(14) DEFAULT NULL,  `inscricao_estadual` VARCHAR(45) DEFAULT NULL,  `data_fundacao` VARCHAR(45) DEFAULT NULL,  `numero_funcionarios` INT DEFAULT 0,     `tipo` VARCHAR(45) DEFAULT "PF",  PRIMARY KEY (`cpf`))ENGINE = InnoDB;INSERT INTO `cliente` (`cpf`, `nome`, `rg`, `passaporte`, `telefone`, `email`, `data_nascimento`, `genero`, `habilitacao`, `registro`, `estado_emissor`, `validade`) VALUES(23232323, 'Gabriel', '23323232', NULL, '3333434', 'g@g', '11/11/92', 'M', '23232332', 'abc', 'SP', '12/45/76');-- ------------------------------------------------------- Table `locacao`.`idioma`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`idioma` ;CREATE TABLE IF NOT EXISTS `locacao`.`idioma` (  `id` INT NOT NULL auto_increment,  `nome` VARCHAR(45) NOT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB;INSERT INTO `idioma` (`id`, `nome`) VALUES(1, 'pt-BR'),(2, 'en-US');-- ------------------------------------------------------- Table `locacao`.`agencia`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`agencia` ;CREATE TABLE IF NOT EXISTS `locacao`.`agencia` (  `codigo` INT NOT NULL auto_increment,  `nome` VARCHAR(45) NOT NULL,  `idioma_id` INT NOT NULL,  PRIMARY KEY (`codigo`),    FOREIGN KEY (`idioma_id`)    REFERENCES `locacao`.`idioma` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDB;INSERT INTO `agencia` (`codigo`, `nome`, `idioma_id`) VALUES(1200, 'Agência da capital', 1),(1201, 'Agência do centro', 1);-- ------------------------------------------------------- Table `locacao`.`emprestimo`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`emprestimo` ;CREATE TABLE IF NOT EXISTS `locacao`.`emprestimo` (  `id` INT NOT NULL auto_increment,  `modelo_veiculo` VARCHAR(45) NOT NULL,  `data_inicial` DATE NOT NULL,  `hora` TIMESTAMP NOT NULL,  `local_emprestimo` VARCHAR(45) NOT NULL,  `data_devolucao` DATE NOT NULL,  `tipo_tarifa` VARCHAR(45) NOT NULL,  `pais_devolucao` VARCHAR(45) NOT NULL,  `estado` VARCHAR(45) NULL,  `cidade` VARCHAR(45) NULL,  `cliente_cpf` BIGINT(11) NOT NULL,  `agencia_id` INT NOT NULL,  PRIMARY KEY (`id`),    FOREIGN KEY (`cliente_cpf`)    REFERENCES `locacao`.`cliente` (`cpf`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,    FOREIGN KEY (`agencia_id`)    REFERENCES `locacao`.`agencia` (`codigo`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`reserva`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`reserva` ;CREATE TABLE IF NOT EXISTS `locacao`.`reserva` (  `id` INT NOT NULL auto_increment,  `cpf` VARCHAR(45) NOT NULL,  `rg` INT NOT NULL,  `passaporte` INT NOT NULL,  `telefone` INT NOT NULL,  `email` VARCHAR(45) NOT NULL,  `modelo` VARCHAR(45) NOT NULL,  `ano` INT NOT NULL,  `marca` VARCHAR(45) NOT NULL,  `cor` VARCHAR(45) NOT NULL,  `periodo_locacao` DATETIME NOT NULL,  `cliente_cpf` BIGINT(11) NOT NULL,  `agencia_id` INT NOT NULL,  PRIMARY KEY (`id`),  FOREIGN KEY (`cliente_cpf`)  REFERENCES `locacao`.`cliente` (`cpf`)  ON DELETE NO ACTION  ON UPDATE NO ACTION,  FOREIGN KEY (`agencia_id`)  REFERENCES `locacao`.`agencia` (`codigo`)  ON DELETE NO ACTION  ON UPDATE NO ACTION)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`grupo`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`grupo` ;CREATE TABLE IF NOT EXISTS `locacao`.`grupo` (  `id` INT NOT NULL auto_increment,  `nome` VARCHAR(45) NULL,  `sigla` CHAR(2) NOT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB;INSERT INTO `grupo` (`id`, `nome`, `sigla`) VALUES(1, 'Econômico', 'A'),(2, 'Econômico com Ar', 'C'),(3, 'Intermediário', 'F'),(4, 'Intermediário Wagon Especial', 'G'),(5, 'Executivo', 'H'),(6, 'Utilitário', 'I'),(7, 'Executivo Luxo', 'K'),(8, 'Intermediário Wagon', 'M'),(9, 'Pick-up', 'N'),(10, '4 x 4 Especial', 'P'),(11, 'Minivan', 'R'),(12, 'Furgão', 'U'),(13, 'Blindado', 'Y');-- ------------------------------------------------------- Table `locacao`.`acessorios`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`acessorios` ;CREATE TABLE IF NOT EXISTS `locacao`.`acessorios` (  `id` INT NOT NULL auto_increment,  `nome` VARCHAR(45) NOT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB;INSERT INTO `acessorios` (`id`, `nome`) VALUES(1, 'Navegador GPS'),(2, 'Cadeira de Bebê'),(3, 'Motorista');-- ------------------------------------------------------- Table `locacao`.`marcas`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`marcas` ;CREATE TABLE IF NOT EXISTS `locacao`.`marcas` (  `id` INT NOT NULL auto_increment,  `nome` VARCHAR(45) NOT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB;INSERT INTO `marcas` (`id`, `nome`) VALUES(1, 'FIAT'),(2, 'Chevrolet'),(3, 'Volkswagen');-- ------------------------------------------------------- Table `locacao`.`cores`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`cores` ;CREATE TABLE IF NOT EXISTS `locacao`.`cores` (  `id` INT NOT NULL auto_increment,  `nome` VARCHAR(45) NOT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB;INSERT INTO `cores` (`id`, `nome`) VALUES(1, 'Azul'),(2, 'Amarelo'),(3, 'Preto'),(4, 'Prata'),(5, 'Verde'),(6, 'Vermelho');-- ------------------------------------------------------- Table `locacao`.`veiculo`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`veiculo` ;CREATE TABLE IF NOT EXISTS `locacao`.`veiculo` (  `id` INT NOT NULL auto_increment,  `chassi` VARCHAR(45) NOT NULL,  `placa` VARCHAR(8) NOT NULL,  `cidade` VARCHAR(45) NOT NULL,  `estado` VARCHAR(45) NOT NULL,  `modelo` VARCHAR(45) NOT NULL,  `fabricante` VARCHAR(45) NOT NULL,  `ano` INT NOT NULL,  `tarifa_aluguel` VARCHAR(45) NOT NULL,  `km_rodado` double NOT NULL,  `grupo_id` INT NOT NULL,  `marca_id` INT NOT NULL,  `cor_id` INT NOT NULL,  PRIMARY KEY (`id`),    FOREIGN KEY (`grupo_id`)    REFERENCES `locacao`.`grupo` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,    FOREIGN KEY (`marca_id`)    REFERENCES `locacao`.`marcas` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,    FOREIGN KEY (`cor_id`)    REFERENCES `locacao`.`cores` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`acessorios_veiculos`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`acessorios_veiculos` ;CREATE TABLE IF NOT EXISTS `locacao`.`acessorios_veiculos` (  `veiculo_id` INT NOT NULL,  `acessorio_id` INT NOT NULL,   FOREIGN KEY (`veiculo_id`)   REFERENCES `locacao`.`veiculo` (`id`)   ON DELETE CASCADE   ON UPDATE CASCADE,   FOREIGN KEY (`acessorio_id`)   REFERENCES `locacao`.`acessorios` (`id`)   ON DELETE CASCADE   ON UPDATE CASCADE)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`devolucao`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`devolucao` ;CREATE TABLE IF NOT EXISTS `locacao`.`devolucao` (  `id` INT NOT NULL auto_increment,  `numero_locacao` INT NOT NULL,  `agencia_id` INT NOT NULL,  PRIMARY KEY (`id`, `numero_locacao`),  FOREIGN KEY (`numero_locacao`)  REFERENCES `locacao`.`emprestimo` (`id`)  ON DELETE NO ACTION  ON UPDATE NO ACTION,  FOREIGN KEY (`agencia_id`)  REFERENCES `locacao`.`agencia` (`codigo`)  ON DELETE NO ACTION  ON UPDATE NO ACTION)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`pagamento`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`pagamento` ;CREATE TABLE IF NOT EXISTS `locacao`.`pagamento` (  `id` INT NOT NULL auto_increment,  `nome_titular` VARCHAR(45) NULL,  `cpf` BIGINT(11) NULL,  `nome_banco` VARCHAR(45) NULL DEFAULT NULL,  `agencia` VARCHAR(45) NULL DEFAULT NULL,  `conta_corrente` VARCHAR(45) NULL DEFAULT NULL,  `telefone` INT NULL DEFAULT NULL,  `bandeira_cartao` VARCHAR(45) NULL DEFAULT NULL,  `numero_cartao` INT NULL DEFAULT NULL,  `validade` DATETIME NULL DEFAULT NULL,  `cod_seguranca` INT NULL DEFAULT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`itensEmprestimo`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`itensEmprestimo` ;CREATE TABLE IF NOT EXISTS `locacao`.`itensEmprestimo` (  `emprestimo_id` INT NOT NULL,  `veiculo_id` INT NOT NULL,    FOREIGN KEY (`emprestimo_id`)    REFERENCES `locacao`.`emprestimo` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,    FOREIGN KEY (`veiculo_id`)    REFERENCES `locacao`.`veiculo` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`itensReserva`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`itensReserva` ;CREATE TABLE IF NOT EXISTS `locacao`.`itensReserva` (  `reserva_id` INT NOT NULL,  `veiculo_id` INT NOT NULL,    FOREIGN KEY (`reserva_id`)    REFERENCES `locacao`.`reserva` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,    FOREIGN KEY (`veiculo_id`)    REFERENCES `locacao`.`veiculo` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`serasa`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`serasa` ;CREATE TABLE IF NOT EXISTS `locacao`.`serasa` (  `id` INT NOT NULL auto_increment,  `nome` VARCHAR(45) NOT NULL,  `status` VARCHAR(45) NULL,  `cliente_cpf` BIGINT(11) NOT NULL,  PRIMARY KEY (`id`, `cliente_cpf`),    FOREIGN KEY (`cliente_cpf`)    REFERENCES `locacao`.`cliente` (`cpf`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDB;-- ------------------------------------------------------- Table `locacao`.`atendente`-- -----------------------------------------------------DROP TABLE IF EXISTS `locacao`.`atendente` ;CREATE TABLE IF NOT EXISTS `locacao`.`atendente` (  `cpf` BIGINT(11) NOT NULL,  `nome` VARCHAR(45) NOT NULL,  `email` VARCHAR(45) NULL,  `senha` VARCHAR(45) NULL,  `telefone` VARCHAR(45) NULL,  `agencia_id` INT NOT NULL,  PRIMARY KEY (`cpf`),    FOREIGN KEY (`agencia_id`)    REFERENCES `locacao`.`agencia` (`codigo`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDB;INSERT INTO `atendente` (`cpf`, `nome`, `email`, `senha`, `telefone`, `agencia_id`) VALUES(12121212, 'Gabriel', 'gabriel@hotmail.com', '123', '2232323', 1200);