

IMPORTANTE:
----------
El 'ARCHIVO DE CONFIGURACION' para el MICROSERVICIO: 'department-service', se manejara en la ruta del 'GITHUB': '/department-service.properties' 

SWAGGER:
--------
CREAR EL 'CONTRADO/API' ONLINE USANDO:
http://editor.swagger.io/

UNA VEZ DESPLEGADO EL 'MICROSERVICIO' ACCEDER A:  
http://localhost:8091/swagger-ui.html


*********************************************************************************
******************************** [DEPARTAMENTOS] ********************************
*********************************************************************************
Los LINK [GET] son:
------------------
1. consultardepartamentosAll: 
   http://localhost:8091/departmentservice/get/departamentos

2. consultardepartamentosPorId:  
   http://localhost:8091/departmentservice/get/departamentos/1
                                                             
3. consultardepartamentosPorDepartamento:  
   http://localhost:8091/departmentservice/get/departamentos-organizacion/1
 
 
Los LINK [POST] son:
-------------------
4. agregarDepartamento:  
   http://localhost:8091/departmentservice/post/departamentos
 
	{    
	  "nombre": "RRHH",  
	  
      "idOrg":  "1" 
	}
 
 
Los LINK [DELETE] son: 
---------------------
5. eliminarDepartamento: 
   http://localhost:8091/departmentservice/delete/departamentos/1
   


DETALLE:
-------
* FEIGN:        Permite consumir WebService REST, apuntando directamente al 'NOMBRE' del WebService & 'URI' respectivamente, por medio de una Interface.
* EUREKACLIENT: Permite consumir WebService REST, apuntando directamente al 'ID' de EUREKA del WebService registrado en el.
 
- Para DETALLES del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://localhost:8091/actuator'

 