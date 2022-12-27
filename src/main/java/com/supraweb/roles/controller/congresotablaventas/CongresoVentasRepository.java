package com.supraweb.roles.controller.congresotablaventas;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



// no es todo
public interface CongresoVentasRepository extends JpaRepository<TablaCongresoVentas, String> {


// that's it ... no need to write any code LOL!
//Optional<TablaCongreso> findById(String username);
	//List<TablaCongreso> findByUsername(String username);
	List<TablaCongresoVentas> findByIdCodigoDeBarra(String Idcodigo);
	
	Optional<TablaCongresoVentas> findById(int id);
	
	
	  @Query(value = "select buscarventasumas(?1 ,?2)"  ,nativeQuery =true       )
      String doAssDate(String fecha1 ,    String fecha2);
	
	
	

}