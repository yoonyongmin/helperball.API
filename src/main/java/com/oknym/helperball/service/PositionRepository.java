package com.oknym.helperball.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oknym.helperball.model.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

}
