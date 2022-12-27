package com.supraweb.roles.controller.congreso;
 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;




// no es todo
public interface CongresoRepository extends JpaRepository<TablaCongreso, String> {


// that's it ... no need to write any code LOL!
    Optional<TablaCongreso> findById(String id);
//	List<TablaCongreso> findByUsername(String id);
	TablaCongreso findByIdCodigoDeBarra(String id);
	TablaCongreso deleteByIdCodigoDeBarra(String id);
	              

	//idCodigoDeBarra

}
