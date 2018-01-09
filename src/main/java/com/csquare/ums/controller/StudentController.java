package com.csquare.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.ums.model.Student;
import com.csquare.ums.service.IStudentService;


@RestController
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {

        student = iStudentService.addUpdateStudent(student);
        return student;
    }

    @RequestMapping(value = "/getStudentById/{studentid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable Long studentid) {

        Student student = iStudentService.getStudentById(studentid);

        return student;

    }

}
