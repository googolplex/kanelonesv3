# kanelonesv3

Sistema de seguimiento de pasantias curriculares universitarias
para marzo2017
----------------------------------------------------------------
hecho con openxava 5.6
eclipse neon
java 8
tomcat 7 
postgres 9.3

1. El common-dbutils es necesario para impresion
commons-dbutils-1.6
2. Note que los reportes JASPER que usan collections en vez de query
son iguales, solo que no tienen el TAGQUERY EXPRESSION. 
Esto quiere decir que puede diseñar sus report con SQL QUERY
luego pasarlos a beans collections con solo borrar ese tag del JRXML
