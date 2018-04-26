package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Terminal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TerminalRepository extends PagingAndSortingRepository<Terminal, Integer> {
    List<Terminal> findAll();
    Page<Terminal> findAll(Pageable pageable);
}
