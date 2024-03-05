package org.teamone.tempository.project.command.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.tempository.project.command.dto.ProjectDTO;
import org.teamone.tempository.project.command.entity.Project;
import org.teamone.tempository.project.command.service.ProjectService;

@RestController
@RequestMapping("/")
@Slf4j
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @Transactional
    public void registProject(ProjectDTO newProject){

        projectService.registProject(newProject);


    }
}
