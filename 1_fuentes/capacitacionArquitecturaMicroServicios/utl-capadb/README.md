

IMPORTANTE:
----------
El 'ARCHIVO DE CONFIGURACION' para el MICROSERVICIO: 'utl-capadb', se manejara en la ruta del 'GITHUB': '/utl-capadb.properties' 

SWAGGER:
--------
CREAR EL 'CONTRADO/API' ONLINE USANDO:
http://editor.swagger.io/

UNA VEZ DESPLEGADO EL 'MICROSERVICIO' ACCEDER A:  
http://localhost:8093/swagger-ui.html


*********************************************************************************
********************************** [EMPLEADOS] **********************************
*********************************************************************************
Los LINK [GET] son:
------------------
1. consultarEmpleadosAll:  
   http://localhost:8093/utlcapadb/get/empleados

2. consultarEmpleadosPorId:   
   http://localhost:8093/utlcapadb/get/empleados/1
  
3. consultarEmpleadosPorDepartamento:   
   http://localhost:8093/utlcapadb/get/empleados-departamento/1
 
 
Los LINK [POST] son:
------------------
4. agregarEmpleado:  
   http://localhost:8093/utlcapadb/post/empleados

	{   
	  "nombre": "PAOLO GUERRERO", 
	  "edad":   35, 
	  "rol":    "CONSULTOR",
	  
	  "idDep":  "1" 
	}


Los LINK [DELETE] son:
---------------------
5. eliminarEmpleado:   
   http://localhost:8093/utlcapadb/delete/empleados/1 
   

*********************************************************************************
******************************** [DEPARTAMENTOS] ********************************
********************************************************************************* 
Los LINK [GET] son:
------------------
1. consultarDepartamentosAll:  
   http://localhost:8093/utlcapadb/get/departamentos

2. consultarDepartamentosPorId:   
   http://localhost:8093/utlcapadb/get/departamentos/1
  
3. consultarDepartamentosPorEmpleados:  
   http://localhost:8093/utlcapadb/get/departamentos-organizacion/1
  
 
Los LINK [POST] son:
------------------
4. agregarDepartamento:  
   http://localhost:8093/utlcapadb/post/departamentos

	{    
	  "nombre": "RRHH",  
	  
      "idOrg":  "1" 
	}


Los LINK [DELETE] son:
---------------------
5. eliminarEmpleado: 
   http://localhost:8093/utlcapadb/delete/departamentos/1 
     
   
**********************************************************************************
******************************** [ORGANIZACIONES] ********************************
********************************************************************************** 
Los LINK [GET] son:
------------------
1. consultarOrganizacionesAll: 
   http://localhost:8093/utlcapadb/get/organizaciones

2. consultarOrganizacionesPorId:  
   http://localhost:8093/utlcapadb/get/organizaciones/1
 
 
Los LINK [POST] son:
------------------
3. agregarOrganizacion: 
   http://localhost:8093/utlcapadb/post/organizaciones

	{    
	  "nombre":    "AMAZON", 
	  "direccion": "Calle Chincheros 121, La Molina"   
	}
	

Los LINK [DELETE] son:
---------------------
4. eliminarOrganizacion:  
   http://localhost:8093/utlcapadb/delete/organizaciones/1 

 

DETALLE:
-------
* FEIGN:        Permite consumir WebService REST, apuntando directamente al 'NOMBRE' del WebService & 'URI' respectivamente, por medio de una Interface.
* EUREKACLIENT: Permite consumir WebService REST, apuntando directamente al 'ID' de EUREKA del WebService registrado en el.

- Para DETALLES del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://localhost:8093/actuator'
 
