#!/bin/sh

## *********************************************************************
## * - DESCRIPCION: Shell para el despliegue de MICROSERVICES JAVA     *
## * - EJECUCION:   SHELL    								           *
## * - AUTOR:       Cesar Ricardo Guerra Arnaiz   		  	 	       *
## * - FECHA:       21/01/2020				      				       *
## * - VERSION:     1.0									               *
## *********************************************************************

vFECHA=$(date +%F)
vHORA=$(date +%T)

vFECHA_ACTUAL="$vFECHA [$vHORA]"
vTRANSACCION="$vFECHA_ACTUAL - [INFO]" 

vRUTA_FILE_SYSTEM='D:\WORKSPACE_Eclipse\Capacitaciones\ArquitecturaMicroserviciosEnLaPractica\ArquitecturaMicroserviciosClasica\capacitacionArquitecturaMicroServicios\'
vRUTA_JDK='C:\JAVA\JDK\jdk1.8.0_91\bin\' 
vCOMPLEMENTO='\'

vNOMBRE_MICROSERVICE_config_server='config-server'
vNOMBRE_MICROSERVICE_discovery_server='discovery-server'
vNOMBRE_MICROSERVICE_boot_admin_server='boot-admin-server'
vNOMBRE_MICROSERVICE_utl-capadb='utl-capadb'
vNOMBRE_MICROSERVICE_employee_service='employee-service'
vNOMBRE_MICROSERVICE_department_service='department-service'
vNOMBRE_MICROSERVICE_organization_service='organization-service' 
vNOMBRE_MICROSERVICE_gateway-server='gateway-server'

ECHO 
ECHO [$vTRANSACCION] -------------------- [INICIO] - [DESPLIEGUE 'MICROSERVICES'] --------------------
ECHO 

sleep 5
ECHO $vTRANSACCION -- DESPLIEGUE [config-server]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_config_server}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_config_server}.sh 
sleep 35
ECHO 
ECHO $vTRANSACCION -- DESPLIEGUE [discovery_server]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_discovery_server}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_discovery_server}.sh 
sleep 35
ECHO 
ECHO $vTRANSACCION -- DESPLIEGUE [boot_admin_server]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_boot_admin_server}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_boot_admin_server}.sh 
sleep 20
ECHO 
ECHO $vTRANSACCION -- DESPLIEGUE [utl-capadb]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_utl-capadb}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_utl-capadb}.sh  
sleep 5
ECHO 
ECHO $vTRANSACCION -- DESPLIEGUE [employee_service]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_employee_service}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_employee_service}.sh 
sleep 5
ECHO 
ECHO $vTRANSACCION -- DESPLIEGUE [department_service]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_department_service}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_department_service}.sh 
sleep 5
ECHO 
ECHO $vTRANSACCION -- DESPLIEGUE [organization_service]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_organization_service}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_organization_service}.sh 
sleep 15
ECHO 
ECHO $vTRANSACCION -- DESPLIEGUE [gateway_server]:  
sh ${vRUTA_FILE_SYSTEM}${vNOMBRE_MICROSERVICE_gateway-server}${vCOMPLEMENTO}DEPLOY_${vNOMBRE_MICROSERVICE_gateway-server}.sh 

ECHO 
ECHO [$vTRANSACCION] --------------------------------------- [FIN] ---------------------------------------
ECHO 

read -p "Pulsar para cerrar ...."

exit

