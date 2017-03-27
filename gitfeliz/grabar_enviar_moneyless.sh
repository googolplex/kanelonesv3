#!/bin/bash
# hecho para portatil HPO ENVY
# el 2017/02
# cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/workspace.dist/kanelonesv1.dist/*.war  /home/xoldfusion/Downloads/kanelones2017/amazon2017llave/
cp -r /home/xoldfusion/Downloads/openxava-5.6_kanelones/workspace/kanelonesv1  kanelones

cp "/home/xoldfusion/Downloads/openxava-5.6_kanelones/workspace/Servers/Tomcat v7.0 Server at localhost-config/server.xml"  /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/
cp "/home/xoldfusion/Downloads/openxava-5.6_kanelones/workspace/Servers/Tomcat v7.0 Server at localhost-config/context.xml" /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/
cp "/home/xoldfusion/Downloads/openxava-5.6_kanelones/workspace/Servers/Tomcat v7.0 Server at localhost-config/web.xml" /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/
cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/server.xml /home/xoldfusion/Downloads/kanelones2017/tomcatfeliz
cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/context.xml /home/xoldfusion/Downloads/kanelones2017/tomcatfeliz
cp /home/xoldfusion/Downloads/openxava-5.6_kanelones/tomcat/conf/web.xml /home/xoldfusion/Downloads/kanelones2017/tomcatfeliz
cp tomcatfeliz/server.xml  kanelones/tomcatfeliz/
cp tomcatfeliz/context.xml  kanelones/tomcatfeliz/
cp tomcatfeliz/web.xml  kanelones/tomcatfeliz/
cp *.sh kanelones/gitfeliz
cp -r openshiftfeliz kanelones/
cp -r jasperfeliz kanelones/
# cp  amazon2017llave/*.sh kanelones/amazon2017llave
# cp  amazon2017llave/*.war kanelones/amazon2017llave ### no llevo el war porque no es necesario
rm *.*~
rm kanelones/*.*~
cd kanelones
git add -A
git commit -a -m "vamos por la prueba de escritorio"
git push -u origin master
