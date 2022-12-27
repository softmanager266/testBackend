package com.supraweb.roles.controller.congreso;

 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraweb.roles.controller.congresotablaventas.CongresoVentasRepository;
import com.supraweb.roles.controller.congresotablaventas.TablaCongresoVentas;


 
 




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestControllerCongresoAdmin {

	
	@Autowired
	private CongresoRepository congresoRepository;
	
	@Autowired
	private CongresoVentasRepository congresoVentasRepository;
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	//****************  Interfaz de carga : get, delete, put, UPDATE.

	@GetMapping("/admin/items")
	@PreAuthorize("hasRole('ADMIN')")
	public List<TablaCongreso> getAllTodos(){
		//return congresoRepository.findByUsername(username);
		return congresoRepository.findAll();
	
	}
	@GetMapping("/admin/items/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public TablaCongreso getTodo( @PathVariable String id){
		return congresoRepository.findById(id).get();
	}	
	@DeleteMapping("/admin/items/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TablaCongreso> deleteTodo(@PathVariable String id) {
		TablaCongreso xd =	congresoRepository.findByIdCodigoDeBarra(id);

	//	Optional<TablaCongreso> xd =	congresoRepository.findById(id);
		congresoRepository.deleteById(id);
	//	return new ResponseEntity<TablaCongreso>(HttpStatus.OK);
		return new ResponseEntity<TablaCongreso>(xd, HttpStatus.OK);

	}
	
	@PostMapping("/admin/items/save/insert")
	@PreAuthorize("hasRole('ADMIN')")
	public TablaCongreso createTodo(@RequestBody TablaCongreso  tablaCongreso){
	//	System.out.println(" guardar ");
		//TablaCongreso createdTodo = congresoRepository.save(tablaCongreso);		

		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getIdCodigoDeBarra()).toUri();		
	//	return ResponseEntity.created(uri).build();
		return 		congresoRepository.save(tablaCongreso);		

		
	}
	
	
	
	
	
	@PutMapping("/admin/items/update/{id}")
	@PreAuthorize("hasRole('ADMIN')")
public TablaCongreso saveAllTodos(@RequestBody TablaCongreso listSaveCongreso,@PathVariable String id){
		TablaCongreso xd =	congresoRepository.findByIdCodigoDeBarra(id);	
		//System.out.println("xd "+xd.toString()); 	TablaCongreso deleteByIdCodigoDeBarra(String id);
		             
		                congresoRepository.delete(xd);
		             TablaCongreso guardar =          congresoRepository.save(listSaveCongreso);
		          
		             
		             
	//	TablaCongreso valor =	congresoRepository.deleteByIdCodigoDeBarra(xd.getIdCodigoDeBarra());
		return guardar;

	}
	
	
	
	
	
	 

	// INSERTAR VARIOS ITEMS DE VENTAS.
	@PostMapping("/admin/items/ventas")
	@PreAuthorize("hasRole('ADMIN')")
public List<TablaCongreso> saveAllTodos(@RequestBody List<TablaCongreso> listSaveCongreso){
		return congresoRepository.saveAll(listSaveCongreso);

	}
	//****************  Interfaz de VENTA ADMIN :  put, UPDATE.
	
	
	// INSERTA LOS TIEMES DE LA TABLA EN TABLACONGRESOVENTAS
	@PostMapping("/admin/items/ventas/ventastabla")
	@PreAuthorize("hasRole('ADMIN')")
public List<TablaCongresoVentas> saveAllTodosVentas(@RequestBody List<TablaCongresoVentas> listSaveCongreso){
		return congresoVentasRepository.saveAll(listSaveCongreso);

	}
	

	

	
// OBTIENE TODOS LOS ITEMS DE LAS VENTA DE LA TABLA TABLACONGRESOVENTAS
	@GetMapping("/admin/items/ventas/ventastabla")
	@PreAuthorize("hasRole('ADMIN')")
	public List<TablaCongresoVentas> getAllTodosVentas(){
	//	public List<TablaCongresoVentas> getAllTodos(@PathVariable String username){

		//return congresoRepository.findByUsername(username);
		return congresoVentasRepository.findAll();

		//return todoService.findAll();
	}
	
	//OBTIENE UN ITEM EN PARTICULAR DE LA TABLA TABLACONGRESOVENTAS
	@GetMapping("/admin/items/ventas/ventastabla/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Optional<TablaCongresoVentas> getAllTodosVentasId(@PathVariable int id){
	//	public List<TablaCongresoVentas> getAllTodos(@PathVariable String username){

		//return congresoRepository.findByUsername(username);
		return congresoVentasRepository.findById(id);

		//return todoService.findAll();
	}
	
	//OBTIENE UN ITEM EN PARTICULAR DE LA TABLA TABLACONGRESOVENTAS POR CODIGOS DE BARRAS.
	@GetMapping("/admin/items/ventas/ventastabla/codbarra/{Idcodigo}")
	//@GetMapping("/admin/items/ventas/ventastabla/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public List<TablaCongresoVentas> getAllTodosVentasCbarra(@PathVariable String Idcodigo){
	//	public List<TablaCongresoVentas> getAllTodos(@PathVariable String username){

		return congresoVentasRepository.findByIdCodigoDeBarra(Idcodigo);
	//	return congresoVentasRepository.findById(id);

		//return todoService.findAll();
	}
	//************* VER SUMAS 
	@GetMapping("/admin/items/ventas/suma/{var1}/{var2}")          
	@PreAuthorize("hasRole('ADMIN')")	
	public String  devolverSumasDeFechas(@PathVariable("var1")   String var1 , @PathVariable("var2")   String var2) {
		
	           
		 
		return  congresoVentasRepository.doAssDate(var1, var2);
		
	}
	
	
	
}
