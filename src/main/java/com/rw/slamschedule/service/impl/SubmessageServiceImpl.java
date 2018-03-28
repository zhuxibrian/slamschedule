package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Point;
import com.rw.slamschedule.domain.Submessage;
import com.rw.slamschedule.repository.SubmessageRepository;
import com.rw.slamschedule.service.SubmessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmessageServiceImpl implements SubmessageService{

    @Autowired
    SubmessageRepository repository;

    @Override
    public Submessage removeSubmessage(Integer id) {
        Submessage submessage = repository.findOne(id);
        CommandMapper commandMapper = submessage.getCommandMapper();
        commandMapper.getSubmessages().remove(submessage);
        repository.delete(id);
        return submessage;
    }

    @Override
    public Submessage updateSubmessage(Submessage submessage) {
        return repository.saveAndFlush(submessage);
    }

    @Override
    public Submessage addPoint(Integer id, Point point) {
        Submessage submessage = repository.findOne(id);
        submessage.getPoints().add(point);
        point.setSubmessage(submessage);
        return repository.saveAndFlush(submessage);
    }

    @Override
    public Submessage findById(Integer id) {
        return repository.findOne(id);
    }
}
