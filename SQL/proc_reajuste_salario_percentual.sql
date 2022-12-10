USE  helpr;
SELECT * FROM cargo;

DELIMITER //
CREATE PROCEDURE proc_reajuste_salario(porcentagem INTEGER)
BEGIN
UPDATE cargo SET salario = salario + salario * porcentagem/100;
END//

DELIMITER ;

CALL proc_reajuste_salario(10);