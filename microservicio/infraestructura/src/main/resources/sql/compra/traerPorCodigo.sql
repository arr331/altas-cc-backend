SELECT id, id_moto, cedula, nombre_completo, fecha, valor_total, abono, codigo, estado
FROM compra WHERE codigo = :codigo;