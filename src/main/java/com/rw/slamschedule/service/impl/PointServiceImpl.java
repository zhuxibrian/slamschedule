package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.Point;
import com.rw.slamschedule.domain.Submessage;
import com.rw.slamschedule.repository.PointRepository;
import com.rw.slamschedule.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository repository;

    @Override
    public Point removePoint(Integer id) {
        Point point = repository.findOne(id);
        Submessage submessage = point.getSubmessage();
        submessage.getPoints().remove(point);
        repository.delete(id);

        return point;
    }

    @Override
    public Point updatePoint(Point submessage) {
        return repository.saveAndFlush( submessage);
    }

    @Override
    public Point findById(Integer id) {
        return repository.findOne(id);
    }
}

