# SPRING DATA CLOUD
Spring Data Cloud es un modelo de programación para microservicios de datos en la nube. Con Spring Data Cloud (SDC), los desarrolladores pueden programar y orquestar _Data Pipelines_

Los origenes de los datos pueden ser en _Streaming_ o en _Batch_.

En adelante nombraré Spring Data Cloud como SDC.

## Arquitectura

La arquitectura de un sistema SDC se compone de dos conceptos clave:

* Aplicaciones

    Habitualmente una _Pipeline_ de datos incluye consumo de eventos de sistemas externos, procesamiento de datos y persistencia.
    
    Estas fases se denominan _Source_, _Processor_ y _Slink_
    
    Las aplicaciones pueden ser alojadas en un repositorio Maven, un archivo, cualquier recurso Spring o Docker. Cada aplicacion 

    Desde **Spring Cloud Data Flow Team**, publican muchos recursos para casos de uso comunes (JDBC, HDFS, HTTP, ROUTER)

* Data Flow Server
    
   Es el componente que se encarga de desplegar las aplicaciones a un _runtime_. 
  
   Hay un Data Flow Server ejecutable para cada runtime.
   
   Interpreta _DSL Steams_ que describen el camino lógico entre varias aplicaciones y un _Manifest_ que describe los mapeos entre las aplicaciones.
       
       
Además necesitamos otros artefactos para utilizar/comprender SDC en su totalidad:

*  Data Flow Shell

    Es un cliente para el _Data Flow Server_. Nos permite ejecutar comandos DSL para interactuar con el servidor.
    
* Data Flow UI
   
   UI para el servidor Data Flow.
   
## Una POC de Spring Data Cloud

### Definición

Este proyecto es una prueba de concepto de Spring Data Cloud para procesamiento Batch. 

Esta compuesto de varios artefactos maven

## Bibliografía

Las funetes consultadas para la realización de esta prueba de concpeto han sido:
* [https://www.baeldung.com/spring-cloud-data-flow-stream-processing](https://www.baeldung.com/spring-cloud-data-flow-stream-processing)
* [https://www.baeldung.com/spring-cloud-data-flow-batch-processing](https://www.baeldung.com/spring-cloud-data-flow-batch-processing)