-- DROP VIEW public.vista_atencionalestudiante;

CREATE OR REPLACE VIEW public.vista_atencionalestudiante AS
SELECT sum(s1.q1) OVER (ORDER BY s1.fecha,s1.kan_nombreapellido) AS q2,
	s1.periodo,
	s1.fecha,
    s1.kan_nombreapellido::text AS nombreapellido,
    max(s1.hora::text) AS hora,
    max(s1.lugar) AS lugar,
    max(s1.detalle) AS detalle,
    max(s1.materia::text) AS materia,
    max(s1.nombreorientador::text) AS orientador
   FROM ( SELECT 1 AS q1,
            to_char(k.kan_fechaatencion, 'YYYYMM'::text) AS periodo,
            to_char(k.kan_fechaatencion, 'DD-MM-YYYY'::text) AS fecha,
            w.kan_nombreapellido,
            btrim(upper(z.kan_lugar::text)) AS lugar,
            btrim(upper(k.ate_detallesdeatencion::text)) AS detalle,
            p.kan_nombremateria AS materia,
            k.kan_hhmm AS hora,
            j.kan_nombreorientador AS nombreorientador
           FROM kan_atencionalestudiante k
             LEFT JOIN kan_alumno w ON k.idalumno_id::text = w.id::text
             LEFT JOIN kan_lugaresdeatencion z ON k.idlugar_id::text = z.id::text
             LEFT JOIN kan_materia p ON k.idmateria_id::text = p.id::text
             LEFT JOIN kan_orientadores j ON k.idorientador_id::text = j.id::text) s1
  GROUP BY s1.fecha, s1.q1,s1.periodo, s1.kan_nombreapellido;
