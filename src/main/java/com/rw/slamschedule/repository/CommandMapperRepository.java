package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.CommandMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandMapperRepository extends PagingAndSortingRepository<CommandMapper, Integer> {

    List<CommandMapper> findAll();

    CommandMapper findByName(String name);

    CommandMapper findOne(Integer id);

    Page<CommandMapper> findAll(Pageable pageable);
}
