package com.rw.slamschedule.controller;

import com.rw.slamschedule.domain.Point;
import com.rw.slamschedule.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/points")
public class PointController {
    @Autowired
    PointService pointService;

    @DeleteMapping(value = "/{id}")
    @Transactional
    public Point deletePointById(@PathVariable("id") Integer id) {
        return pointService.removePoint(id);
    }

    @PutMapping()
    public Point putPoint(@RequestBody Point point ) throws IOException {
        Point pointOld = pointService.findById(point.getId());
        point.setSubmessage(pointOld.getSubmessage());
        return pointService.updatePoint(point);
    }
}
