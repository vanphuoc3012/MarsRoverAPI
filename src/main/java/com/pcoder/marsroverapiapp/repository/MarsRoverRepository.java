package com.pcoder.marsroverapiapp.repository;

import com.pcoder.marsroverapiapp.entity.MarsRover;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarsRoverRepository extends CrudRepository<MarsRover, Long> {

}
