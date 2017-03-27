#!/bin/bash
# hecho para mi pc de escritorio
# el 2017/01
# cp /home/xoldfusion/Descargas/openxava-5.6_kanelones/workspace.dist/kanelonesv1.dist/*.war  /home/xoldfusion/Descargas/kanelones2017/amazon2017llave/
cp -r /home/xoldfusion/Descargas/openxava-5.6_kanelones/workspace/kanelonesv1  kanelones

cp "/home/xoldfusion/Descargas/openxava-5.6_kanelones/workspace/Servers/Tomcat v7.0 Server at localhost-config/server.xml"  /home/xoldfusion/Descargas/openxava-5.6_kanelones/tomcat/conf/
cp "/home/xoldfusion/Descargas/openxava-5.6_kanelones/workspace/Servers/Tomcat v7.0 Server at localhost-config/context.xml" /home/xoldfusion/Descargas/openxava-5.6_kanelones/tomcat/conf/
cp "/home/xoldfusion/Descargas/openxava-5.6_kanelones/workspace/Servers/Tomcat v7.0 Server at localhost-config/web.xml" /home/xoldfusion/Descargas/openxava-5.6_kanelones/tomcat/conf/
cp /home/xoldfusion/Descargas/openxava-5.6_kanelones/tomcat/conf/server.xml /home/xoldfusion/Descargas/kanelones2017/tomcatfeliz
cp /home/xoldfusion/Descargas/openxava-5.6_kanelones/tomcat/conf/context.xml /home/xoldfusion/Descargas/kanelones2017/tomcatfeliz
cp /home/xoldfusion/Descargas/openxava-5.6_kanelones/tomcat/conf/web.xml /home/xoldfusion/Descargas/kanelones2017/tomcatfeliz
cp tomcatfeliz/server.xml  kanelones/tomcatfeliz/
cp tomcatfeliz/context.xml  kanelones/tomcatfeliz/
cp tomcatfeliz/web.xml  kanelones/tomcatfeliz/
cp *.sh kanelones/gitfeliz
cp -r openshiftfeliz kanelones/
cp -r jasperfeliz kanelones/
cp  amazon2017llave/*.sh kanelones/amazon2017llave/
# cp  amazon2017llave/*.war kanelones/amazon2017llave/ ### no llevo el war porque no es necesario
rm *.*~
rm kanelones/*.*~
rm jasperfeliz/*.*~
rm jasperfeliz/*.jasper
cd kanelones
git add -A
git commit -a -m "ya presente el informe mensual de pasantias"
git push -u origin master
