

IMPORTANTE:
----------
Proyecto PRINCIPAL que permite la 'COMPILACION & EMPAQUETAMIENTO & EJECUCION' de TODOS los proyectos (MODULOS) que forman parte del DUMMY de 'ARQUITECTURA de MICROSERVICIOS'
manejado. 


El ORDEN de MODULOS que se debe manejar para el 'DESPLIEGUE' respectivo 'CORRECTO' debe ser el siguiente:

1. config-service
2. discovery-server
3. boot-admin-server 
4. utl-capadb
5. employee-service
6. department-service
7. organization-service 
8. gateway-server

----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
--------------------------------------------------------------------------- [LONBOZ] ---------------------------------------------------------------------------- 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
 
Para REDUCIR codigo repetido como: 'GET/SET/toSrtring/Constructores' en BEANs, DTOs, etc.
Para TODOS los proyectos 'SPRING-BOOT' se debe aplicar.

* Ubicar el 'lombok.jar' en la ruta raiz de ECLIPSE.
* java -jar lombok.jar & matricular el FileSystem de ECLIPSE.
* En el 'SpringToolSuite4.ini' deberán existir las rutas similares:

-vm
C:\JAVA\JDK\jdk1.8.0_91\bin\javaw.exe
-javaagent:C:\JAVA\ECLIPSE\sts-4.5.1.RELEASE\lombok.jar

* Reiniciar el ECLIPSE & recompilar el proyecto.


----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
-------------------------------------------------------------------------- [DNS / HOST] ------------------------------------------------------------------------- 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

'DNS' A CONFIGURAR EN EL ARCHIVO 'HOST':
-------------------------------------
Las IPs deberían ser manejadas como 'FIJAS', sino 'ACTUALIZARLAS' constantemente a nivel de HOST.


#------ [CONFIGURACION 'ARQUITECTURA-CONTENERIZADA' ('KUBERNETES' - INGRESS)] ------#
#-- 'IP de KUBERNETES':
192.168.99.100  capacitacion.microservicios.employee
192.168.99.100  capacitacion.microservicios.department
192.168.99.100  capacitacion.microservicios.organization
192.168.99.100  capacitacion.microservicios.utlcapadb
192.168.99.100  capacitacion.microservicios.boot-admin-server
192.168.99.100  capacitacion.microservicios.zipkin-server
192.168.99.100  capacitacion.microservicios.grafana-server
192.168.99.100  capacitacion.microservicios.prometheus-server
192.168.99.100  capacitacion.microservicios.jaeger-server
192.168.99.100  capacitacion.microservicios.jaeger-server-view
#------ [CONFIGURACION 'ARQUITECTURA-CONTENERIZADA' ('KUBERNETES' - INGRESS)] ------#


#------------------ [CONFIGURACION 'GENERICOS'] ------------------#
127.0.0.1  capacitacion.microservicios.logstash
127.0.0.1  capacitacion.microservicios.elasticsearch
127.0.0.1  capacitacion.microservicios.kibana
127.0.0.1  capacitacion.microservicios.nexus2
#------------------ [CONFIGURACION 'GENERICOS'] ------------------#


----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
---------------------------------------------------------------------------- [MAVEN] ---------------------------------------------------------------------------- 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 

* VARIABLE DE ENTORNO: 
  - JAVA_HOME => C:\JAVA\MAVEN\SOFTWARE\apache-maven-3.6.0_local
  - PATH      => %JAVA_HOME%\bin

* RUTA CONFIG:  C:\JAVA\MAVEN\SOFTWARE\apache-maven-3.6.0_local\conf\settings.xml

  - REFERENCIAR REPOSITORIO:  <localRepository>C:\JAVA\MAVEN\REPOSITORIO\MavenRepo_3.6_Local</localRepository>
  

----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
---------------------------------------------------------------------------- [NEXUS] ---------------------------------------------------------------------------- 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

IMPORTANTE: Se debe levantar la plataforma del 'NEXUS':
---------- 
 $ cd C:\JAVA\NEXUS2\nexus-2.14.12-02-bundle\nexus-2.14.12-02
 - nexus console start

- CONSOLA WEB:  http://capacitacion.microservicios.nexus2:8081/nexus 
- ACCESO:       admin/ admin123


REPOSITORIO [NEXUS]: 
------------------- 
  
A. 'ADD HOSTED REPOSITORY': Reposirio PRINCIPAL & CENTRAL de la EMPRESA. 
  
   * Repository ID:                    CapaMicroserviciosRepositorioNexus
   * Repository Name:                  CapaMicroserviciosRepositorioNexus 
   * Override Local Storage Location:  C:\JAVA\NEXUS2\nexus-2.14.12-02-bundle\sonatype-work\nexus\storage\CapaMicroserviciosRepositorioNexus
     
   - CREARÁ los directorios: [.index, .meta, .nexus & archetype-catalog.xml].  
   - URL (LOCAL):    http://capacitacion.microservicios.nexus2:8081/nexus/content/repositories/CapaMicroserviciosRepositorioNexus/
   - NO-IP:          http://repositorio-nexus.ddns.net:8081/nexus/content/repositories/CapaMicroserviciosRepositorioNexus/        
             
B. 'ADD PROXY REPOSITORY': Repositorios EXTERNOS para conectar & reutilizar.   

    - Repository ID:           REPO_search.repo1.maven.org       
	- Repository Name:         REPO_search.repo1.maven.org       [YA EXISTE: 'ACTUALIZAR']
	- Remote Storage Location: https://repo1.maven.org/maven2/  
		  
	- Repository ID:           REPO_search.maven.org
	- Repository Name:         REPO_search.maven.org
	- Remote Storage Location: http://search.maven.org/classic      
		  
	- Repository ID:           REPO_jboss.com_Release
	- Repository Name:         REPO_jboss.com_Release
	- Remote Storage Location: http://repository.jboss.com    
		 
	- Repository ID:           REPO_springsource_Release
	- Repository Name:         REPO_springsource_Release
	- Remote Storage Location: https://maven.springframework.org/milestone/ 
		 
	- Repository ID:           REPO_mvnrepository.com
	- Repository Name:         REPO_mvnrepository.com
	- Remote Storage Location: http://mvnrepository.com 
		 
    - Repository ID:           REPO_objectweb
	- Repository Name:         REPO_objectweb
	- Remote Storage Location: http://maven.objectweb.org/maven2 
		 
	- Repository ID:           REPO_ops4j
	- Repository Name:         REPO_ops4j
	- Remote Storage Location: http://repository.ops4j.org/maven2 
		 
	- Repository ID:           REPO_redhat-ga
	- Repository Name:         REPO_redhat-ga
	- Remote Storage Location: http://maven.repository.redhat.com/techpreview/all 
		 
	- Repository ID:           REPO_apache-maven_Snapshot
	- Repository Name:         REPO_apache-maven_Snapshot
	- Remote Storage Location: http://repository.apache.org/snapshots 
		 
	- Repository ID:           REPO_com.springsource_Snapshot
	- Repository Name:         REPO_com.springsource_Snapshot
	- Remote Storage Location: https://maven.springframework.org/snapshot 
		                                            
	- Repository ID:           REPO_jboss.org_Snapshot
	- Repository Name:         REPO_jboss.org_Snapshot
	- Remote Storage Location: http://snapshots.jboss.org/maven2   


C. 'ADD PROXY GROUP': Agrupación de Repositorios 'EXTERNOS'.
    (IMPORTANTE: El ORDEN asignado SI importa). 
  
	* Group ID:   GROUP_Proxy_CapaMicroservicios
	* Group Name: GROUP_Proxy_CapaMicroservicios    
    * Provider:   Maven2
     
    - Jalar a la IZQ. todos los REPO_*  
    - URL (LOCAL): http://capacitacion.microservicios.nexus2:8081/nexus/content/groups/GROUP_Proxy_CapaMicroservicios/
    - NO-IP:       http://repositorio-nexus.ddns.net:8081/nexus/content/groups/GROUP_Proxy_CapaMicroservicios/
 
  
    <!-- AGREGAR EN: POM.xml [TODOS LOS 'MICROSERVICIOS'] --> 
	<repositories>
		<repository>
			<id>GROUP_Proxy_CapaMicroservicios</id>
			<name>Repositorio CENTRAL proporcionado por NEXUS 2 [GRUPO-PROXY]</name>
			<url>http://localhost:8081/nexus/content/groups/GROUP_Proxy_CapaMicroservicios/</url> 
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>
 
 
    <!-- AGREGAR EN: conf\settings.xml [SOLO EN CASO DE APLICAR SEGURIDAD] -->  
    <server>
      <id>GROUP_Proxy_CapaMicroservicios</id> 
      <username>admin</username> 
      <password>admin123</password> 
    </server> 
    
    
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
------------------------------------------------------------------------- [HERRAMIENTAS] ------------------------------------------------------------------------ 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------  

INICIANDO ['ZIPKIN' & 'SLEUTH']:
-------------------------------
Esta HERRAMIENTA permitira CENTRALIZAR todas la TRAZABILIDAD de las MICROSERVICIOS, para que se conozca de 'INICIO a FIN' dicha TRAZA de ejecucion manejada en una transaccion. 

1. Se debe tener el COMPRIMIDO llamado: [zipkin-server-2.12.9-exec.jar] 
2. Desde CONSOLA ejecutar el comando: java -jar zipkin-server-2.12.9-exec.jar
3. Acceder la CONSOLA WEB que se iniciara en la URL: [http://localhost:9411/zipkin]
 
 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
--------------------------------------------------------------------------- [POSTMAN] --------------------------------------------------------------------------- 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
 
* IMPORTAR 'SCRIPTs': 
  ------------------ 
  - CLASICA:       capacitacionMicroservicios_CLASICA.postman_collection.json
  - CONTENERIZADA: capacitacionMicroservicios_CONTENERIZADA.postman_collection.json
  
 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
-------------------------------------------------------------------- [TOPDOWN 'CONTRATO/API] -------------------------------------------------------------------- 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 

Ubicar la libreria: 'swagger-codegen-cli-3.0.9.jar' & los APIS/CONTRATOS todos en un mismo directorio & ejecutar: 


1. 'employee-service': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_employee-service.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id employee-service --artifact-version 1.0.0 -l spring -o employee-service   

2. 'department-service': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_department-service.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id department-service --artifact-version 1.0.0 -l spring -o department-service   

3. 'organization-service': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_organization-service.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id organization-service --artifact-version 1.0.0 -l spring -o organization-service     

4. 'utl-capadb': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_utl-capadb.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id utl-capadb --artifact-version 1.0.0 -l spring -o utl-capadb   


----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
-------------------------------------------------------------------- [STACK (ELASTICSEARCH)] -------------------------------------------------------------------- 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 

CONFIGURAR: 
----------
A. ELASTICSEARCH: 
   $ cd D:\ELASTIC_STACK\ELASTICSEARCH\elasticsearch-7.5.2\config
   - elasticsearch.yml

B. KIBANA:
   - NO requiere.   
 
C. LOGSTASH: (Creamos el directorio 'CONFIGURACIONES' & su archivo)
   $ cd D:\ELASTIC_STACK\LOGSTASH\logstash-7.5.2
   $ cd configuraciones
   - ETL_CapacitacionMicroservicios_v1.0.conf

D. FILEBEAT: 
   $ cd D:\ELASTIC_STACK\BEATS\filebeat-7.5.2-windows-x86_64
   - filebeat.yml

EJECUTAR: 
-------- 
A. ELASTICSEARCH: 
   $ cd D:\ELASTIC_STACK\ELASTICSEARCH\elasticsearch-7.5.2\bin
   $ elasticsearch.bat 

B. KIBANA:
   $ cd D:\ELASTIC_STACK\KIBANA\kibana-7.5.2-windows-x86_64\bin
   $ kibana.bat 

C. LOGSTASH: 
   $ cd D:\ELASTIC_STACK\LOGSTASH\logstash-7.5.2
   $ .\bin\logstash.bat -f .\configuraciones\ETL_CapacitacionMicroservicios_v1.0.conf

D. FILEBEAT:  
   $ cd D:\ELASTIC_STACK\BEATS\filebeat-7.5.2-windows-x86_64
   $ .\filebeat.exe -c .\filebeat.yml
 
 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 
-------------------------------------------------------------------- [REPOSITORIOS (GITHUB)] -------------------------------------------------------------------- 
----------------------------------------------------------------------------------------------------------------------------------------------------------------- 

ARQUITECTURA [CLÁSICA]:
----------------------
https://github.com/maktup/arquitecturaMicroserviciosClasica.git
https://github.com/maktup/arquitecturaMicroserviciosClasica-properties.git


ARQUITECTURA [CONTENERIZADA]:
----------------------------
https://github.com/maktup/arquitecturaMicroserviciosContenerizada.git

https://github.com/maktup/utl-capadb.git
https://github.com/maktup/employee-service.git
https://github.com/maktup/department-service.git 
https://github.com/maktup/organization-service.git
https://github.com/maktup/boot-admin-server.git


