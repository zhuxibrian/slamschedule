package com.rw.slamschedule.controller;

import com.rw.slamschedule.domain.Button;
import com.rw.slamschedule.service.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buttons")
public class ButtonController {

    @Autowired
    ButtonService buttonService;

    @DeleteMapping(value = "/{id}")
    Button deleteButtonById(@PathVariable("id") Integer id) {
        return buttonService.removeButtonById(id);
    }

    @PutMapping
    Button putButton(@RequestBody Button button) {
        Button buttonOld = buttonService.findById(button.getId());
        button.setTerminal(buttonOld.getTerminal());
        return buttonService.updateButton(button);
    }
}
