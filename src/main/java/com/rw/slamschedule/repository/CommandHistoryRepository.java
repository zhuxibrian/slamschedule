package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.CommandHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandHistoryRepository extends JpaRepository<CommandHistory, Long> {
}
