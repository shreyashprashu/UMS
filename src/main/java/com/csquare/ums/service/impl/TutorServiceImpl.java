package com.csquare.ums.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ums.dao.TutorRepository;
import com.csquare.ums.model.Tutor;
import com.csquare.ums.service.ITutorService;


@Service
public class TutorServiceImpl implements ITutorService {

    @Autowired
    TutorRepository iTutorRepository;

    @Override
    public Tutor addUpdateTutor(Tutor tutor) {

        // TODO Auto-generated method stub
        iTutorRepository.save(tutor);
        return tutor;
    }

    @Override
    public Tutor getTutorById(Long tutorid) {

        // TODO Auto-generated method stub
        return iTutorRepository.findOne(tutorid);
    }

}
