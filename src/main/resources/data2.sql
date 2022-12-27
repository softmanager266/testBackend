INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');




-- Function: descuentoprincipal()

-- DROP FUNCTION descuentoprincipal();

CREATE OR REPLACE FUNCTION descuentoprincipal()
  RETURNS trigger AS
$BODY$
BEGIN

UPDATE tabla_congreso SET cantidad_de_productos=cantidad_de_productos-NEW.cantidad_de_productos WHERE (id_codigo_de_barra=NEW.id_codigo_de_barra);
	RETURN NEW;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION descuentoprincipal()
  OWNER TO postgres;







CREATE TRIGGER updatestockcongreso
  BEFORE INSERT
  ON tabla_congreso_ventas
  FOR EACH ROW
  EXECUTE PROCEDURE descuentoprincipal();








-- Function: buscarventasumas(character varying, character varying)

-- DROP FUNCTION buscarventasumas(character varying, character varying);

CREATE OR REPLACE FUNCTION buscarventasumas(
    var1 character varying,
    var2 character varying)
  RETURNS text AS
$BODY$



  select  to_char( sum(cantidad_de_productos * remarcacion_resultado_final), 'FM999999999.00') as sumas_global_entre_fechas
 from tabla_congreso_ventas
where to_char(fechadeventas::date,'YYYY-MM-DD') BETWEEN var1 and var2

$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
ALTER FUNCTION buscarventasumas(character varying, character varying)
  OWNER TO postgres;












