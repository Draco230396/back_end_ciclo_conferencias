package com.axl.backendspringboot.repository;

import com.axl.backendspringboot.model.Employee;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * repository: Es el package que contiene las interfaces que
 * extienden de JPA para que estas clases se conecten a la
 * base de datos. Estas gestionan información ya sea de buscar, borrar,
 * actualizar o crear un registro en la base de datos.
 * */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
/**
 * Para poder implementar Spring JPA al proyecto lo podemos realizar de dos simples formas:
 *
 * La primera es utilizando la herramienta entregada por
 * Spring llamada Spring Initializr que genera un proyecto base
 * a partir de los parámetros que se llenen manualmente.
 * Para poder generar un proyecto JPA debes estar seguro de haber
 * seleccionado el campo donde se llenan las dependencias para que el
 * programa las agregue al pom.xml o al Gradle dependiendo del gestor
 * de dependencias que más te guste.
 *
 * La segunda manera se lleva a cabo al agregar unas líneas al pom.xml
 * del proyecto, con esta instrucción maven llevará a cabo la importación
 * de estas dependencias a tu proyecto.
 * */
}
