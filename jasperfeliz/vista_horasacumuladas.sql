create view vista_horasacumuladas as 
select idpasantias2_id, sum(kan_horasacumuladas) as horasacumuladas
from kan_relatorioalumno ww
group by idpasantias2_id
