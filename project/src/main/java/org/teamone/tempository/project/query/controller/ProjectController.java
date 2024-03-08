package org.teamone.tempository.project.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.service.ProjectService;
import org.teamone.tempository.project.query.type.ProjectStatus;
import org.teamone.tempository.project.query.vo.ResponseProject;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/project")
@RestController
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
    public String getProjectInfoByStatus(@RequestParam ProjectStatus Status) {

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

    /* 설명. 프로젝트 참여 회원 정보와 프로젝트 정보 조회 기능 */
    @GetMapping("/findProjectMember/{id}")
    public ResponseEntity<List<ResponseProject>> getProjectJoinUserById(@PathVariable String id) {

        List<ProjectDTO> projectId = projectService.getProjectJoinUserById(id);

        List<ResponseProject> responseProjectJoinMemberList = ProjectDTOToResponseProject(projectId);


        return ResponseEntity.status(HttpStatus.OK).body(responseProjectJoinMemberList);
    }

    private List<ResponseProject> ProjectDTOToResponseProject(List<ProjectDTO> projectId) {
        List<ResponseProject> responseProjectData = new ArrayList<>();

        for (ProjectDTO projectDTO : projectId) {
            ResponseProject responseProject = new ResponseProject();

            responseProject.setId(projectDTO.getId());
            responseProject.setName(projectDTO.getName());
            responseProject.setContent(projectDTO.getContent());
            responseProject.setPublic(projectDTO.isPublic());
            responseProject.setLikeCnt(projectDTO.getLikeCnt());
            responseProject.setStatus(projectDTO.getStatus());
            responseProject.setProjectMemberDTOList(projectDTO.getProjectMemberList());

            responseProjectData.add(responseProject);

        }

        return responseProjectData;

    }

    /* 설명. 내용 검색을 통한 프로젝트 조회 */
    @PostMapping("/searchContent")
    public String getProjectInfoByContent(@RequestBody String Content) {
        projectService.getProjectInfoByContent(Content);

        return "Server at " + environment.getProperty("local.server.port");
    }



}
