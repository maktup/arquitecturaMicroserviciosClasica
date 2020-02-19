

IMPORTANTE:
----------
El 'ARCHIVO DE CONFIGURACION' para el SERVER: 'gateway-server', se manejara en la ruta del 'GITHUB': '/gateway-server.properties' 
Todo de maejara por medio de un PUERTO propio del 'GATEWAY'. 

Los LINKs [GET] son:
  

*********************************************************************************
********************************** [EMPLEADOS] **********************************
*********************************************************************************
Los LINK [GET] son:
------------------
1. consultarEmpleadosAll: 
   http://localhost:8060/employeeservice/get/empleados

2. consultarEmpleadosPorId:  
   http://localhost:8060/employeeservice/get/empleados/1
                                                             
3. consultarEmpleadosPorDepartamento:  
   http://localhost:8060/employeeservice/get/empleados-departamento/1
 
 
Los LINK [POST] son:
-------------------
4. agregarEmpleado:  
   http://localhost:8060/employeeservice/post/empleados
 
 
Los LINK [DELETE] son: 
---------------------
5. eliminarEmpleado:  
   http://localhost:8060/employeeservice/delete/empleados/1



*********************************************************************************
******************************** [DEPARTAMENTOS] ********************************
*********************************************************************************
Los LINK [GET] son:
------------------
1. consultardepartamentosAll:  
   http://localhost:8060/departmentservice/get/departamentos

2. consultardepartamentosPorId:  
   http://localhost:8060/departmentservice/get/departamentos/1
                                                             
3. consultardepartamentosPorDepartamento:  
   http://localhost:8060/departmentservice/get/departamentos-organizacion/1
 
 
Los LINK [POST] son:
-------------------
4. agregarDepartamento:  
   http://localhost:8060/departmentservice/post/departamentos
 
 
Los LINK [DELETE] son: 
---------------------
5. eliminarDepartamento:  
   http://localhost:8060/departmentservice/delete/departamentos/1



**********************************************************************************
******************************** [ORGANIZACIONES] ********************************
********************************************************************************** 
Los LINK [GET] son:
------------------
1. consultarorganizacionesAll: 
   http://localhost:8060/organizationservice/get/organizaciones

2. consultarorganizacionesPorId:  
   http://localhost:8060/organizationservice/get/organizaciones/1
 
 
Los LINK [POST] son:
-------------------
3. agregarOrganizacion:  
   http://localhost:8060/organizationservice/post/organizaciones
 
 
Los LINK [DELETE] son: 
---------------------
4. eliminarOrganizacion:  
   http://localhost:8060/organizationservice/delete/organizaciones/1

      
   
DETALLE:
-------
Esta HERRAMIENTA permite dar la cara al 'TRAFICO EXTERNO' de los MICROSERVICIOS, para que NO interactue directamente contra el BACKEND (filtro). 
Esta centraliza el acceso por un mismo PUERTO: [8060] de las URI's respectivas, por medio de PATRONES de acceso de como se arman dichas URIs.


Para DETALLES del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://localhost:8060/actuator'

