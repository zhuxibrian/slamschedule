package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Slam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlamRepository extends JpaRepository<Slam, Integer> {
}
