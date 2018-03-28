package com.rw.slamschedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.domain.Point;
import com.rw.slamschedule.domain.Submessage;
import com.rw.slamschedule.service.SubmessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/submessages")
public class SubmessageController {

    @Autowired
    SubmessageService submessageService;

    @Autowired
    ObjectMapper mapper;

    @DeleteMapping(value = "/{id}")
    @Transactional
    public Submessage deleteSubmessageById(@PathVariable("id") Integer id) {
        return submessageService.removeSubmessage(id);
    }

    @PutMapping()
    public Submessage putSubmessage(@RequestBody Submessage submessage) throws IOException {

        Submessage submessageold = submessageService.findById(submessage.getId());

        submessage.setCommandMapper(submessageold.getCommandMapper());

        return submessageService.updateSubmessage(submessage);
    }

    @PatchMapping(value = "/addpoint/{id}")
    public Submessage patchAddPoint(@PathVariable("id") Integer id, @RequestBody Point point) throws IOException {
        return submessageService.addPoint(id, point);
    }


}
