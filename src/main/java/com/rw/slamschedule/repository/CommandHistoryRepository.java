package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.CommandHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandHistoryRepository extends PagingAndSortingRepository<CommandHistory, Integer> {

}
