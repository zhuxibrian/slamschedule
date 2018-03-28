package com.rw.slamschedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Point;
import com.rw.slamschedule.domain.Submessage;
import com.rw.slamschedule.exception.RwException;
import com.rw.slamschedule.service.CommandMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cmdmappers")
public class CommandMapperController {

    @Autowired
    private CommandMapperService service;


    @Autowired
    ObjectMapper mapper;


    @GetMapping(value = "/all")
    public List<CommandMapper> getAllCommandMapper() {
        return service.findAll();
    }

    @GetMapping(value="/{id}")
    public  CommandMapper getCommandMapperById(@PathVariable Integer id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public CommandMapper deleteCommandMapperById(@PathVariable("id") Integer id) {
        return service.removeCommandMapper(id);
    }

    @PostMapping
    @Transactional(rollbackFor=RwException.class)
    public CommandMapper postCommandMapper(@RequestBody CommandMapper commandMapper) throws IOException, RwException {

        if (service.findByName(commandMapper.getName()) != null) {
            throw new RwException("CommandMapper already Exist", "");
        }

        setSubmessage(commandMapper);

        return service.addCommandMapper(commandMapper);
    }

    @PutMapping()
    public CommandMapper putCommandMapper(@RequestBody CommandMapper commandMapper) throws IOException {

        setSubmessage(commandMapper);

        return service.updateCommandMapper(commandMapper);
    }

    @PatchMapping(value = "/addSubmessage/{id}")
    public CommandMapper patchAddSubmessage(@PathVariable("id") Integer id, @RequestBody Submessage submessage) throws IOException {
        service.addSubmessage(id, submessage);
        return service.findOne(id);
    }

    @GetMapping(value = "/page/{page}/size/{size}")
    public Page<CommandMapper> getCommandMapperByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return service.findAll(page, size);
    }


    private void setSubmessage(CommandMapper commandMapper) {

        if(commandMapper.getSubmessages() == null)
            return;
        for (Submessage submessage:commandMapper.getSubmessages()) {
            if (submessage == null)
                continue;
            submessage.setCommandMapper(commandMapper);
            for (Point point:submessage.getPoints()) {
                point.setSubmessage(submessage);
            }
        }
    }
}
