

IMPORTANTE:
----------
El 'ARCHIVO DE CONFIGURACION' para el MICROSERVICIO: 'employee-service', se manejara en la ruta del 'GITHUB': '/employee-service.properties' 

SWAGGER:
--------
CREAR EL 'CONTRADO/API' ONLINE USANDO:
http://editor.swagger.io/


UNA VEZ DESPLEGADO EL 'MICROSERVICIO' ACCEDER A:  
http://localhost:8092/swagger-ui.html


*********************************************************************************
********************************** [EMPLEADOS] **********************************
*********************************************************************************
Los LINK [GET] son:
------------------
1. consultarEmpleadosAll: 
   http://localhost:8092/employeeservice/get/empleados

2. consultarEmpleadosPorId:   
   http://localhost:8092/employeeservice/get/empleados/1
                                                             
3. consultarEmpleadosPorDepartamento: 
   http://localhost:8092/employeeservice/get/empleados-departamento/1
 
 
Los LINK [POST] son:
-------------------
4. agregarEmpleado:  
   http://localhost:8092/employeeservice/post/empleados
 
	{   
	  "nombre": "PAOLO GUERRERO", 
	  "edad":   35, 
	  "rol":    "CONSULTOR",
	  
	  "idDep":  "1" 
	}
	
 
Los LINK [DELETE] son: 
---------------------
5. eliminarEmpleado:  
   http://localhost:8092/employeeservice/delete/empleados/1
 
 
 
DETALLE:
-------
* FEIGN:        Permite consumir WebService REST, apuntando directamente al 'NOMBRE' del WebService & 'URI' respectivamente, por medio de una Interface.
* EUREKACLIENT: Permite consumir WebService REST, apuntando directamente al 'ID' de EUREKA del WebService registrado en el.

- Para DETALLES del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://localhost:8092/actuator'

