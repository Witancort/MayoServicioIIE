package com.idat.MayoServicioPrueba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Productos;


@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer>{
	
	
}
