package com.oknym.helperball.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oknym.helperball.model.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

}
