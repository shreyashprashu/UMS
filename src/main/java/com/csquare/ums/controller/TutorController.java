package com.csquare.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.ums.model.Tutor;
import com.csquare.ums.service.ITutorService;


@RestController
public class TutorController {

    @Autowired
    ITutorService iTutorService;

    @RequestMapping(value = "/addTutor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tutor addTutor(@RequestBody Tutor tutor) {

        tutor = iTutorService.addUpdateTutor(tutor);

        return tutor;
    }

    @RequestMapping(value = "/getTutorById/{tutorid}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Tutor getTutorById(@PathVariable Long tutorid) {

        Tutor tutor = iTutorService.getTutorById(tutorid);

        return tutor;

    }

}
