package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Submessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmessageRepository extends JpaRepository<Submessage, Integer>{
}
