

IMPORTANTE:
----------
El 'ARCHIVO DE CONFIGURACION' para el MICROSERVICIO: 'organization-service', se manejara en la ruta del 'GITHUB': '/organization-service.properties' 

SWAGGER:
--------
CREAR EL 'CONTRADO/API' ONLINE USANDO:
http://editor.swagger.io/

UNA VEZ DESPLEGADO EL 'MICROSERVICIO' ACCEDER A:  
http://localhost:8090/swagger-ui.html


**********************************************************************************
******************************** [ORGANIZACIONES] ********************************
********************************************************************************** 
Los LINK [GET] son:
------------------
1. consultarorganizacionesAll:  
   http://localhost:8090/organizationservice/get/organizaciones

2. consultarorganizacionesPorId:  
   http://localhost:8090/organizationservice/get/organizaciones/1
 
 
Los LINK [POST] son:
-------------------
3. agregarOrganizacion:  
   http://localhost:8090/organizationservice/post/organizaciones
	
	{    
	  "nombre":    "AMAZON", 
	  "direccion": "Calle Chincheros 121, La Molina"   
	}
	
 
Los LINK [DELETE] son: 
---------------------
4. eliminarOrganizacion:  
   http://localhost:8090/organizationservice/delete/organizaciones/1
   


DETALLE:
-------
* FEIGN:        Permite consumir WebService REST, apuntando directamente al 'NOMBRE' del WebService & 'URI' respectivamente, por medio de una Interface.
* EUREKACLIENT: Permite consumir WebService REST, apuntando directamente al 'ID' de EUREKA del WebService registrado en el.
 
- Para DETALLES del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://localhost:8090/actuator'

 