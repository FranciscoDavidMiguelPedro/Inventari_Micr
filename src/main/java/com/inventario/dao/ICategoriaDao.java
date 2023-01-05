package com.inventario.dao;

import org.springframework.data.repository.CrudRepository;

import com.inventario.dto.CategiraDto;

public interface ICategoriaDao extends CrudRepository<CategiraDto, Long> {// es una clase generica

}
