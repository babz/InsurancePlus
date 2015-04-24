# InsurancePlus

insurance portal for secure coding workshop

## Default Credentials:

User admin password=Passwort
User agent password=Passwort
user controller password=Passwort

## HTTPS einrichten

- File .keystore in ${user.home} hinterlegen (zB C:/Users/<username>)
- File server.xml mit jener vom Repo überschreiben; das file befindet sich in Eclipse unter Servers-Tomcat

## Logging einrichten 

- unter "Servers" Doppelklick auf Tomcat -> open launch configuration 
	-> im Reiter Arguments unter "VM Arguments" folgendes hinzuf�gen
			-Dlog4j.debug -Dlog4j.configuration=log4j.properties
			
	-> im Reiter Classpath die "log4j-1.2.17.jar" hinzuf�gen

- im Projekt unter Build Path -> configure Build Path unter "Libraries" folgendes hinzuf�gen: log4j-1.2.17.jar
