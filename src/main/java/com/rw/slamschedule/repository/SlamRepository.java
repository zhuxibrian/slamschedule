package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Slam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlamRepository extends JpaRepository<Slam, Long> {
}
