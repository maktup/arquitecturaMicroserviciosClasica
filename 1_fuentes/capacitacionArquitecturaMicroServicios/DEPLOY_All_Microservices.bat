@ECHO OFF

REM *********************************************************************
REM * - DESCRIPCION: Shell para el despliegue de MICROSERVICES JAVA     *
REM * - EJECUCION:   SHELL    								            *
REM * - AUTOR:       Cesar Ricardo Guerra Arnaiz   		  	 	        *
REM * - FECHA:       21/01/2020				      				        *
REM * - VERSION:     1.0									            *
REM *********************************************************************

SET vFECHA=%DATE%
SET vHORA=%TIME%

SET vFECHA_ACTUAL=%vFECHA% [%vHORA%]
SET vTRANSACCION=%vFECHA_ACTUAL% - [INFO]: 

SET vRUTA_FILE_SYSTEM=D:\WORKSPACE_Eclipse\Capacitaciones\ArquitecturaMicroserviciosEnLaPractica\ArquitecturaMicroserviciosClasica\capacitacionArquitecturaMicroServicios\
SET vRUTA_JDK=C:\JAVA\JDK\jdk1.8.0_91\bin\

SET vNOMBRE_MICROSERVICE_config-server=config-server
SET vNOMBRE_MICROSERVICE_discovery-server=discovery-server
SET vNOMBRE_MICROSERVICE_boot-admin-server=boot-admin-server
SET vNOMBRE_MICROSERVICE_utl-capadb=utl-capadb
SET vNOMBRE_MICROSERVICE_employee-service=employee-service
SET vNOMBRE_MICROSERVICE_department-service=department-service
SET vNOMBRE_MICROSERVICE_organization-service=organization-service 
SET vNOMBRE_MICROSERVICE_gateway-server=gateway-server

ECHO. 
@ECHO %vTRANSACCION% -------------------- [INICIO] - [DESPLIEGUE 'MICROSERVICES'] --------------------
ECHO.

TIMEOUT /t 5 /nobreak
ECHO.
@ECHO %vTRANSACCION% -- DESPLIEGUE [config-server]:  
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_config-server%\DEPLOY_%vNOMBRE_MICROSERVICE_config-server%.bat"
TIMEOUT /t 35 /nobreak
ECHO.
@ECHO %vTRANSACCION% -- DESPLIEGUE [discovery-server]:
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_discovery-server%\DEPLOY_%vNOMBRE_MICROSERVICE_discovery-server%.bat"
TIMEOUT /t 35 /nobreak
ECHO.
@ECHO %vTRANSACCION% -- DESPLIEGUE [boot-admin-server]:
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_boot-admin-server%\DEPLOY_%vNOMBRE_MICROSERVICE_boot-admin-server%.bat"
TIMEOUT /t 20 /nobreak
ECHO.
@ECHO %vTRANSACCION% -- DESPLIEGUE [utl-capadb]:
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_utl-capadb%\DEPLOY_%vNOMBRE_MICROSERVICE_utl-capadb%.bat"
TIMEOUT /t 10 /nobreak
ECHO.
@ECHO %vTRANSACCION% -- DESPLIEGUE [employee-service]:
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_employee-service%\DEPLOY_%vNOMBRE_MICROSERVICE_employee-service%.bat"
TIMEOUT /t 5 /nobreak
ECHO.
@ECHO %vTRANSACCION% -- DESPLIEGUE [department-service]:
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_department-service%\DEPLOY_%vNOMBRE_MICROSERVICE_department-service%.bat"
TIMEOUT /t 5 /nobreak
ECHO.
@ECHO %vTRANSACCION% -- DESPLIEGUE [organization-service]:
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_organization-service%\DEPLOY_%vNOMBRE_MICROSERVICE_organization-service%.bat"
TIMEOUT /t 15 /nobreak
ECHO. 
@ECHO %vTRANSACCION% -- DESPLIEGUE [gateway-server]:
START CMD /k CALL "%vRUTA_FILE_SYSTEM%%vNOMBRE_MICROSERVICE_gateway-server%\DEPLOY_%vNOMBRE_MICROSERVICE_gateway-server%.bat"

ECHO.
@ECHO %vTRANSACCION% --------------------------------------- [FIN] ---------------------------------------

ECHO Pulsar para cerrar ....
PAUSE

EXIT

