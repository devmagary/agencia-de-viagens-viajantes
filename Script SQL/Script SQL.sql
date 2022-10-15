CREATE SCHEMA `viajantes_1` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `viajantes_1`.`locais` (
  `id_local` INT NOT NULL,
  `nome_local` VARCHAR(255) NULL,
  `valor` INT NULL,
  PRIMARY KEY (`id_local`));
INSERT INTO `viajantes_1`.`locais` (`id_local`, `nome_local`, `valor`) VALUES ('1', 'Rio de Janeiro', '500');
INSERT INTO `viajantes_1`.`locais` (`id_local`, `nome_local`, `valor`) VALUES ('2', 'São Paulo', '532');
INSERT INTO `viajantes_1`.`locais` (`id_local`, `nome_local`, `valor`) VALUES ('3', 'Salvador', '1232');
INSERT INTO `viajantes_1`.`locais` (`id_local`, `nome_local`, `valor`) VALUES ('4', 'Recife', '5345');
CREATE TABLE `viajantes_1`.`viajante` (
  `id_viajante` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `data_viagem_ida` DATE NOT NULL,
  `data_viagem_volta` DATE NOT NULL,
  `id_local` INT NULL,
  PRIMARY KEY (`id_viajante`),
  INDEX `viajanda_idlocal_idx` (`id_local` ASC) VISIBLE,
  CONSTRAINT `viajanda_idlocal`
    FOREIGN KEY (`id_local`)
    REFERENCES `viajantes_1`.`locais` (`id_local`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;