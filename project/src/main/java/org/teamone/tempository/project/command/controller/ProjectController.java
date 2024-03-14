package org.teamone.tempository.project.command.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.tempository.project.command.dto.ProjectDTO;
import org.teamone.tempository.project.command.service.ProjectService;
import org.teamone.tempository.project.query.entity.Project;

import java.util.List;

@RestController("jpa")
@RequestMapping("/")
@Slf4j
public class ProjectController {

    private final Environment environment;
    private final ProjectService projectService;

    @Autowired
    public ProjectController(Environment environment, ProjectService projectService) {
        this.environment = environment;
        this.projectService = projectService;
    }

    /* 설명. 프로젝트 등록 기능 */
    @PostMapping("/insert")
    public ResponseEntity<List<Project>> insertProject(@RequestBody ProjectDTO newProject){

        projectService.insertProject(newProject);

        return ResponseEntity.ok().build();
    }

    /* 설명. 프로젝트 수정 기능 */
    @PostMapping("/update")
    public String updateProjectById(@RequestBody ProjectDTO newProject) throws IllegalAccessException {

        projectService.updateProjectById(newProject);
        log.info("수정 할 프로젝트 ID 값: {}", newProject.getId());

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 프로젝트 삭제 기능*/
    @PostMapping("/delete")
    public String deleteProjectById(@RequestParam("id") String id)  {

        projectService.deleteProjectById(id);


        return "Server at " + environment.getProperty("local.server.port");
    }
}
