UPDATE moto
SET precio = :precio,
    cc = :cc,
    marca = : marca,
    estado = :estado,
    descuento = :descuento,
    nombre_imagen = :nombreImagen,
    nombre_moto = :nombreMoto
WHERE id =:id;