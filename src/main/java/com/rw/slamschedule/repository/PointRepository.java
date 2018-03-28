package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
}
