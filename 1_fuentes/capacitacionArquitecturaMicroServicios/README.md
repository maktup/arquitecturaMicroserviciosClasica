

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


LONBOZ:
------
Para REDUCIR codigo repetido como: 'GET/SET/toSrtring/Constructores' en BEANs, DTOs, etc.
Para TODOS los proyectos 'SPRING-BOOT' se debe aplicar.

* Ubicar el 'lombok.jar' en la ruta raiz de ECLIPSE.
* java -jar lombok.jar & matricular el FileSystem de ECLIPSE.
* En el 'SpringToolSuite4.ini' deberán existir las rutas similares:

-vm
C:\JAVA\JDK\jdk1.8.0_91\bin\javaw.exe
-javaagent:C:\JAVA\ECLIPSE\sts-4.5.1.RELEASE\lombok.jar

* Reiniciar el ECLIPSE & recompilar el proyecto.


RUTAS 'HOST': 
------------ 
Las IPs ahi deberian ser manejadas como FIJAS, sino ACTUALIZARLAS constantemente.
 
#------------ [CONFIGURACION 'ARQUITECTURA-CLASICA'] ------------#
#-- 'IP de LOCAL':
127.0.0.1  arquitectura.microservicios.clasica.config-server
127.0.0.1  arquitectura.microservicios.clasica.boot-admin-server
127.0.0.1  arquitectura.microservicios.clasica.discovery-server
127.0.0.1  arquitectura.microservicios.clasica.zipkin-server 
#------------ [CONFIGURACION 'ARQUITECTURA-CLASICA'] ------------#


IMPORTANTE: Para el caso de 'NEXUS2', su URL es de un DNS Externo con 'NO-IP':
http://repositorio-nexus.ddns.net:8081/nexus/content/repositories/Repositorio_TallerMicroservicios_releases/ 



INICIANDO ['ZIPKIN' & 'SLEUTH']:
-------------------------------
Esta HERRAMIENTA permitira CENTRALIZAR todas la TRAZABILIDAD de las MICROSERVICIOS, para que se conozca de 'INICIO a FIN' dicha TRAZA de ejecucion manejada en una transaccion. 

1. Se debe tener el COMPRIMIDO llamado: [zipkin-server-2.12.9-exec.jar] 
2. Desde CONSOLA ejecutar el comando: java -jar zipkin-server-2.12.9-exec.jar
3. Acceder la CONSOLA WEB que se iniciara en la URL: [http://localhost:9411/zipkin]
 
 
TOPDOWN 'CONTRATO/API':
---------------------- 
Ubicar la libreria: 'swagger-codegen-cli-3.0.9.jar' & los APIS/CONTRATOS todos en un mismo directorio & ejecutar: 


1. 'employee-service': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_employee-service.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id employee-service --artifact-version 1.0.0 -l spring -o employee-service   

2. 'department-service': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_department-service.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id department-service --artifact-version 1.0.0 -l spring -o department-service   

3. 'organization-service': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_organization-service.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id organization-service --artifact-version 1.0.0 -l spring -o organization-service     

4. 'utl-capadb': 
   java -jar swagger-codegen-cli-3.0.9.jar generate -i API_utl-capadb.yaml --api-package pe.com.capacitacion --model-package pe.com.capacitacion.bean --group-id pe.com.capacitacion --artifact-id utl-capadb --artifact-version 1.0.0 -l spring -o utl-capadb   












 





  