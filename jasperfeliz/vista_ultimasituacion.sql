create view vista_ultimasituacion as

    select qq.kan_nombreestado as estado , vv.idpasantias1_id
	, to_char(vv.kan_fechasituacion,'YYYY/MM/DD')  as fechasituacion
from kan_situacionpasantia vv
inner join 
	( select max(zz.kan_fechasituacion) as fechasituacion
    			, zz.idpasantias1_id
		from kan_situacionpasantia zz
		group by zz.idpasantias1_id ) ddd
	on vv.kan_fechasituacion = ddd.fechasituacion
    	and vv.idpasantias1_id = ddd.idpasantias1_id
left join kan_estadopasantia qq on vv.idestado_id = qq.id
