package com.idat.MayoServicioPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.MayoServicioPrueba.model.Productos;
import com.idat.MayoServicioPrueba.service.ProductoService;

@Controller
@RequestMapping(path = "/producto/v1")
public class ProductoController {
	
	
	@Autowired
	private ProductoService service;
	
	
	//METODO LISTAR
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Productos>> listar() {
		
		return new ResponseEntity<List<Productos>>(service.listarProductos(), HttpStatus.OK);
		
	}
	
	//METODO GUARDAR
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Productos productos) {
		service.guardarProducto(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//METODO ELIMINAR
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {	
		
	Productos producto =service.obtenerProductoId(id);
	
	if(producto !=null) {
	    service.eliminarProducto(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	
	}
	
	//METODO ACTUALIZAR
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Productos productos) {
		
	Productos producto =service.obtenerProductoId(productos.getIdProducto());
	
	if(producto !=null) {
	    service.actualizarProducto(productos);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	//METODO BUSCAR POR ID
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Productos> obtenerId(@PathVariable Integer id) { 
		
	Productos producto =service.obtenerProductoId(id);
	
	if(producto !=null) {
		return new ResponseEntity<Productos>(service.obtenerProductoId(id),(HttpStatus.OK));
		
	}
	
	return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
	}
	
}
