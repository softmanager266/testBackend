package com.supraweb.roles.controller.congreso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class TestControllerCongresoMod {
	
	@Autowired
	private CongresoRepository congresoRepository;
	
	@Autowired
	private CongresoVentasRepository congresoVentasRepository;
	
	
	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}
	//****************  Interfaz de carga : get, delete, put, UPDATE.

	@GetMapping("/mod/items")
	@PreAuthorize("hasRole('MODERATOR')")
	public List<TablaCongreso> getAllTodos(){
		//return congresoRepository.findByUsername(username);
		return congresoRepository.findAll();

		//return todoService.findAll();
	}
	
	@GetMapping("/mod/items/{id}")
	@PreAuthorize("hasRole('MODERATOR')")
	public TablaCongreso getTodo( @PathVariable String id){
		return congresoRepository.findById(id).get();
		//return todoService.findById(id);
	}
	

	
	@PutMapping("/mod/items/ventas/{id}")
	@PreAuthorize("hasRole('MODERATOR')")
public TablaCongreso saveAllTodos(@RequestBody TablaCongreso listSaveCongreso,@PathVariable String id){
		TablaCongreso tDel =	congresoRepository.findByIdCodigoDeBarra(id);	
	     congresoRepository.delete(tDel);
		return congresoRepository.save(listSaveCongreso);

	}
	
	// update 2022
	@PostMapping("/mod/items/ventas/insert")
	@PreAuthorize("hasRole('MODERATOR')")
	public TablaCongreso createTodo(@RequestBody TablaCongreso  tablaCongreso){
	//	System.out.println(" guardar ");
		//TablaCongreso createdTodo = congresoRepository.save(tablaCongreso);		

		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getIdCodigoDeBarra()).toUri();		
	//	return ResponseEntity.created(uri).build();
		return 		congresoRepository.save(tablaCongreso);		

		
	}
	
	@PostMapping("/mod/items/ventas/ventastabla")
	@PreAuthorize("hasRole('MODERATOR')")
public List<TablaCongresoVentas> saveAllTodosVentas(@RequestBody List<TablaCongresoVentas> listSaveCongreso){
		//return congresoRepository.findByUsername(username);
		return congresoVentasRepository.saveAll(listSaveCongreso);

		//return todoService.findAll();
	}
	
}
