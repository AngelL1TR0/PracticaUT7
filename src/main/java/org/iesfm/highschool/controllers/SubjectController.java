package org.iesfm.highschool.controllers;

import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    @Autowired
    private SchoolService schoolService;
}
