package com.supraweb.roles.controller.congreso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraweb.roles.controller.congresotablaventas.CongresoVentasRepository;
import com.supraweb.roles.controller.congresotablaventas.TablaCongresoVentas;

 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestControllerCongresoUser {
	@Autowired
	private CongresoRepository congresoRepository;
	
	@Autowired
	private CongresoVentasRepository congresoVentasRepository;
	
	@RequestMapping("/api/test")
	public class TestController {
		@GetMapping("/all")
		public String allAccess() {
			return "Public Content.";
		}
	}
	
	
	@GetMapping("/user/items")
	@PreAuthorize("hasRole('USER')")
	public List<TablaCongreso> getAllTodos(){
		//return congresoRepository.findByUsername(username);
		return congresoRepository.findAll();
	
	}
	
	@GetMapping("/user/items/{id}")
	@PreAuthorize("hasRole('USER')")
	public TablaCongreso getTodo( @PathVariable String id){
		return congresoRepository.findById(id).get();
		//return todoService.findById(id);
	}
	
	//http://localhost:8080/api/test/user/items/ventas/ventastabla/
	@PostMapping("/user/items/ventas/ventastabla")
	@PreAuthorize("hasRole('USER')")
public List<TablaCongresoVentas> saveAllTodosVentas(@RequestBody List<TablaCongresoVentas> listSaveCongreso){
		//return congresoRepository.findByUsername(username);
		return congresoVentasRepository.saveAll(listSaveCongreso);

		//return todoService.findAll();
	}
}
