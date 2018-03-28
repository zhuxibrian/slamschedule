package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TerminalRepository extends JpaRepository<Terminal, String> {
    Terminal findById(String id);
    Terminal deleteById(String id);
}
