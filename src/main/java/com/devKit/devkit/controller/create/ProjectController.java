package com.devKit.devkit.controller.create;

import com.devKit.devkit.repo.ProjectRepositoryJPA;
import com.devKit.devkit.repo.UserRepositoryJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    private final UserRepositoryJPA userRepositoryJPA;
    private final ProjectRepositoryJPA projectRepositoryJPA;

    public ProjectController(UserRepositoryJPA userRepositoryJPA, ProjectRepositoryJPA projectRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.projectRepositoryJPA = projectRepositoryJPA;
    }


    @GetMapping(value = "/project/{name}")
    private String projectMethod(@PathVariable(name = "name") String name, Model model) {

        Projects project = projectRepositoryJPA.findByName(name);

        model.addAttribute("project", project);
        return "project/base-project";
    }
}
