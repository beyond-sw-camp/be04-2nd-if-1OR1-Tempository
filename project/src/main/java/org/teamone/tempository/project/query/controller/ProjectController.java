package org.teamone.tempository.project.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.teamone.tempository.project.query.service.ProjectService;

@RequestMapping("/project")
@RestController("query")
public class ProjectController {
    private final ProjectService projectService;
    private final Environment environment;

    @Autowired
    public ProjectController(ProjectService projectService, Environment environment) {
        this.projectService = projectService;
        this.environment = environment;
    }

    /* 설명. ID를 이용하여 프로젝트 정보 조회 */
    @GetMapping("/findById/{id}")
    public String getProjectInfoById(@PathVariable("id") int id) {

        projectService.getProjectInfoById(id);

        return "Server at " + environment.getProperty("local.server.port");
    }


    /* 설명. Status를 이용하여 프로젝트 완료나 미완료 상태인 프로젝트를 조회 */
    @PostMapping("/findByStatus")
    public String getProjectInfoByStatus(@RequestParam String Status) {

        projectService.getProjectInfoByStatus(Status);

        return "Server at " + environment.getProperty("local.server.port");
    }

    /* 설명. 좋아요 순으로 프로젝트 조회 기능 */
    @GetMapping("/findOrderByLike")
    public String getProjectInfoOrderByLike() {

        projectService.getProjectInfoOrderByLike();

        return "Server at " + environment.getProperty("local.server.port");

    }

    /* 설명. 공개 유무에 따른 프로젝트 조회 기능 */
    @PostMapping("/findByIsPublic")
    public String getProjectInfoByIsPublic(@RequestParam("isPublic") boolean isPublic) {

        projectService.getProjectInfoByIsPublic(isPublic);

        return "Server at " + environment.getProperty("local.server.port");

    }


}
