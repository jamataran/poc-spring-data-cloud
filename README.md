# POC SPRING DATA CLOUD

Repositorio para pruebas del proyecto [https://cloud.spring.io/spring-cloud-dataflow/](https://cloud.spring.io/spring-cloud-dataflow/).

## Fundamentos téoricos
* Spring Cloud Data Flow es un modelo de programación para microservicios **de datos** en la nube. Con Spring Cloud Data Flow, los desarrolladores pueden programar y orquestar _Data Pipelines_

* Los origenes de los datos pueden ser en _Streaming_ o en _Batch_.

* En adelante nombraré Spring Cloud Data Flow como SCDF.

### Arquitectura

La arquitectura de un sistema SCDF se compone de dos conceptos clave:

* Aplicaciones

    Habitualmente una _Pipeline_ de datos incluye consumo de eventos de sistemas externos, procesamiento de datos y persistencia.
    
    Estas aplicaciones son microservicios y se clasifican según su tipo: _Source_, _Processor_ y _Slink_  (Origen, Procesador y Destino). Son empaquetadas como aplicaciones independientes, que serán registradas en el servidor mediante la Shell.
    
    Las aplicaciones pueden ser alojadas en un repositorio Maven, un archivo, cualquier recurso Spring o Docker.

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
   
## Este proyecto

### Propósito

Este proyecto es una prueba de concepto de Spring Data Cloud, probando varios de sus posibles usos.

### Requisitos

Para correr el proyecto suponemos en nuestro equipo:

1. **Local server**: Servidor en el que registraremos el resto de microservicios (es el _runtime_ de la solución) 
    
    Es necesario tener corriendo una instancia de ``Spring Cloud Dataflow Local Server``
    
    Levantamos con [Docker Compose](https://docs.docker.com/compose/) la imagen.
    
    Para corerrlo desde este repositorio necesitamos ejecutar (sobre la raíz del proyecto)
    ```
    cd spring-cloud-data-flow-local-server-docker
    DATAFLOW_VERSION=1.7.0.RELEASE docker-compose up
    ```
    
    Una vez ejecutado, podemos acceder al servidor [http://localhost:9393/dashboard](http://localhost:9393/dashboard)

2. **Spring Cloud Data Flow Shell**: Nos permite comunicarnos via _Shell_ con el servidor del punto 1; puede ser descargado o construido mediante la aplicación maven que se encuentra en ``spring-cloud-dataflow-shell``

    Para correrla desde este repositorio necesitamos ejecutar (sobre la raíz del proyecto)
    
    ```
    cd spring-cloud-dataflow-shell
    mvn clean install
    spring-boot: run
    ```

## Casos de uso probados

### Spring Batch

El primer caso de uso es crear una tarea a partir de un Spring Batch. El proyecto Batch se encuentra dentro de ``depot-batch`` y consiste en un Batch par gestión de un fichero con datos de un almacén.

* Debemos registrar la aplicación.  
    
    En la consola(*):
    
   ```app register --name batch-job --type task --uri maven://com.arrobaautowired:depotbatch:jar:0.0.1-SNAPSHOT```
   
 * A continuación debemos crear la tarea
 
    En la consola(*):
    ``
    task create depot-job --definition batch-job
    ``
 
 * Lanzamiento
 
    En la consola(*):
    
    ``
    task launch depot-job
    ``
 
(*) Todas las tareas pueden hacerse en la consola


## Bibliografía

Las fuentes consultadas para la realización de esta prueba de concpeto han sido:
* [https://www.baeldung.com/spring-cloud-data-flow-stream-processing](https://www.baeldung.com/spring-cloud-data-flow-stream-processing)
* [https://www.baeldung.com/spring-cloud-data-flow-batch-processing](https://www.baeldung.com/spring-cloud-data-flow-batch-processing)
* [https://cloud.spring.io/spring-cloud-dataflow/](https://cloud.spring.io/spring-cloud-dataflow/)
* [https://www.baeldung.com/spring-cloud-task](https://www.baeldung.com/spring-cloud-task)
* [https://www.baeldung.com/introduction-to-spring-batch](https://www.baeldung.com/introduction-to-spring-batch)