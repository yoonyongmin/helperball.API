package com.oknym.helperball.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oknym.helperball.model.Foot;

@Repository
public interface FootRepository extends CrudRepository<Foot, Long> {

}
