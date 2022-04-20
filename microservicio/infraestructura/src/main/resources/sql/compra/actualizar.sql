UPDATE compra
SET id = : id,
    id_moto = :idMoto,
    cedula = :cedula,
    nombre_completo = :nombreCompleto,
    fecha = :fecha,
    valor_total = :valorTotal,
    abono = :abono,
    codigo = :codigo,
    estado = :estado
WHERE id = :id;