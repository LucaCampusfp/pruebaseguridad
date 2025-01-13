set SQL_SAFE_UPDATES = 0;
select * from tienda.cliente;
update tienda.cliente
set pw = "{noop}123", activo = true, permiso = "CLIENTE";

set SQL_SAFE_UPDATES = 1;
