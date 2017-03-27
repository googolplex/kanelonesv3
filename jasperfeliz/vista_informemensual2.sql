drop view vista_informemensual2
create view vista_informemensual2 as 
select kan_yyyymm
, kan_fecha
, k.kan_narrativa
, kan_nombreorientador
, z.kan_narrativa as dirigidoa
, kan_carreranombre
, kan_enfasis as enfasis
, kan_qbeneficiariosmujer as beneficiariosMujer
, kan_qbeneficiariosvaron as BeneficiariosVaron
, kan_qinstituciones as Qinstituciones
, kan_ejecutormujer as ejecutormujer
, kan_ejecutorvaron as ejecutorvaron
, kan_tarea as tarea
, kan_lugar as lugar
, kan_nombreactividad as actividad
, cantidad
from kan_informesmensuales k 
left join kan_carrera w on k.idcarrera_id = w.id
left join kan_orientadores x on k.idorientador_id = x.id
left join kan_atencioninforme z on k.idattn_id = z.id
left join kan_informecuantitativo g on k.id  = idinformemensual_id
left join kan_lugaresdeatencion n on g.idlugar_id = n.id
left join kan_actividades e on g.idactividad_id = e.id
