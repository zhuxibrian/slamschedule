package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
