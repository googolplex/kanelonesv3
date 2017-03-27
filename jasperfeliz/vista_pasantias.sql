CREATE OR REPLACE VIEW public.vista_pasantias AS
 SELECT bb.kan_nombreorientador AS orientador,
    j.kan_nombreapellido,
    j.kan_nrocedula,
    g.kan_nombreempresa,
    to_char(k.kan_fechainicio, 'YYYY/MM/DD'::text) AS fechainicio,
    xx.estado,
    xx.fechasituacion,
    nn.horasacumuladas
   FROM kan_pasantias k
     LEFT JOIN kan_alumno j ON k.idalumno_id::text = j.id::text
     LEFT JOIN kan_empresa g ON k.idempresa_id::text = g.id::text
     LEFT JOIN vista_ultimasituacion xx ON k.id::text = xx.idpasantias1_id::text
     LEFT JOIN vista_horasacumuladas nn ON k.id::text = nn.idpasantias2_id::text
     LEFT JOIN kan_orientadores bb ON k.idorientador_id::text = bb.id::text;
