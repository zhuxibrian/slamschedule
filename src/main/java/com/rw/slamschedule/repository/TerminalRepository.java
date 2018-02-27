package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepository extends JpaRepository<Terminal, Long> {
}
