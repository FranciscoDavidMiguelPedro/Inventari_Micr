package com.inventario.dao;

import org.springframework.data.repository.CrudRepository;

import com.inventario.dto.CategoriaDto;

public interface ICategoriaDao extends CrudRepository<CategoriaDto, Integer> {// es una clase generica

}
