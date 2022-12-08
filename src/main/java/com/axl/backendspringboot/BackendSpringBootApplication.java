package com.axl.backendspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*Es una anotacion que aparece en la funcion main de todo proyecto
* que definamos con spring boot.
* ahora bien la mayor parte de los desarrolladores no saben exactamente para que sirve
* esta anotacion y como funciona.*/
@SpringBootApplication
public class BackendSpringBootApplication {
    /*
    *¿Para que sirve?
    * Cuando nosotros usamos la notacion @SpringBootApplication esta anotacion herede el comportamiento de un
    * conjuntode anotaciones amplias que tenemos que explicar:
    *
    * 1-@EnableAutoConfiguration: Esta es una anotacion clasica de Spring que se encarga de forma inteligente de
    * intentar configurar Spring de forma automatica.
    * Es la anotacion encargada de buscar en el Classpath todas las clases con @Entity y registrarlas con el proveedor
    * de persistencia que tengamos.
    * por lo tanto por eso con Spring Boot es sificiente simplemente el dataSource a nivel
    * application.properties ya que spring buscara todas las clases-
    * 2- @SpringBootConfiguration Es la anotacion que define que el fichero es un fichero de Configuración de Spring
    * Normalmente esto se solia hacer antiguamente con @Configuratio.
    * La particularidad que tiene @SpringConfiguration es que solo puede haber una en la aplicacion
    *
    * 3- @ComponentScan: Se encarga de revisar los paquetes actuales y registrar de forma automatica
    * cualquier @Service @Repository y @Controller etc. que la aplicacion tenga de forma totalmente transparente para Spring Framework
    *
    * */

    public static void main(String[] args) {
        SpringApplication.run(BackendSpringBootApplication.class, args);
    }

}
