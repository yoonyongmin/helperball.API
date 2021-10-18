package com.oknym.helperball.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oknym.helperball.model.Info;
import com.oknym.helperball.model.User;

@Repository
public interface InfoRepository extends CrudRepository<Info, Long> {

}
