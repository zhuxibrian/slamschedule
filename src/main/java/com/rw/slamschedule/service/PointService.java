package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Point;

public interface PointService {
    Point removePoint(Integer id);
    Point updatePoint(Point submessage);
    Point findById(Integer id);
}
