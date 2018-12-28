# ejb-application
Use Apache ear and ejb plugins to deploy a separated EAR application

Separated Deployment of an EJB application with Hibernate, check client here: https://github.com/mhddurrah/ejb-jsf-client/
 
Build and Usage:

cd ejb-service

mvn clean install -U

mvn ejb:ejb package deploy

cd .. (or cd.. in Windows :D )

mvn ear:generate-application-xml package deploy
