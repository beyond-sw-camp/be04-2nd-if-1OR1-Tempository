package org.teamone.tempository.project.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.service.ProjectService;
import org.teamone.tempository.project.query.type.ProjectStatus;
import org.teamone.tempository.project.query.vo.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /* 설명. ID를 이용하여 프로젝트 정보 조회 */
    @GetMapping("/findProjectById/{id}")
    public ResponseEntity<List<Project>> findProjectInfoById(@PathVariable("id") String id) {

        List<Project> projectInfoById = projectService.findProjectInfoById(id);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoById);
    }


    /* 설명. Status를 이용하여 프로젝트 완료나 미완료 상태인 프로젝트를 조회 */
    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<List<Project>> findProjectInfoByStatus(@PathVariable("status") ProjectStatus Status) {

        List<Project> projectInfoByStatus = projectService.findProjectInfoByStatus(Status);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoByStatus);
    }

    /* 설명. 좋아요 순으로 프로젝트 조회 기능 */
    @GetMapping("/findProjectOrderByLike")
    public ResponseEntity<List<Project>> findProjectOrderByLike() {

        List<Project> projectInfoOrderByLike = projectService.findProjectOrderByLike();

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoOrderByLike);

    }

    /* 설명. 공개 유무에 따른 프로젝트 조회 기능 */
    @GetMapping("/findProjectByPublic/{isPublic}")
    public ResponseEntity<List<Project>> findProjectInfoByIsPublic(@PathVariable("isPublic") boolean isPublic) {

        List<Project> projectInfoByIsPublic = projectService.findProjectInfoByIsPublic(isPublic);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoByIsPublic);

    }

    /* 설명. 프로젝트 참여 회원 정보와 프로젝트 정보 조회 기능 */
    @GetMapping("/findProjectJoinMemberByMemberId/{memberId}")
    public ResponseEntity<List<ResponseProjectMember>> findProjectByMemberId(@PathVariable String memberId
            , @RequestHeader("Authorization") String token) {

        List<ProjectDTO> projectDTOId = projectService.findProjectJoinMemberByMemberId(memberId, token);

        List<ResponseProjectMember> responseProjectMemberJoinMemberList = ProjectDTOToResponseProject(projectDTOId);


        return ResponseEntity.status(HttpStatus.OK).body(responseProjectMemberJoinMemberList);
    }

    private List<ResponseProjectMember> ProjectDTOToResponseProject(List<ProjectDTO> projectId) {
        List<ResponseProjectMember> responseProjectMemberData = new ArrayList<>();

        for (ProjectDTO projectDTO : projectId) {
            ResponseProjectMember responseProjectMember = new ResponseProjectMember();

            responseProjectMember.setId(projectDTO.getId());
            responseProjectMember.setName(projectDTO.getName());
            responseProjectMember.setStatus(projectDTO.getStatus());
            responseProjectMember.setProjectMemberDTOList(projectDTO.getProjectMemberList());

            responseProjectMemberData.add(responseProjectMember);

        }

        return responseProjectMemberData;

    }

    /* 설명. 내용 검색을 통한 프로젝트 조회 */
    @GetMapping("/findProjectByContent/{content}")
    public ResponseEntity<List<Project>> findProjectInfoByContent(@PathVariable("content") String Content) {

        List<Project> projectInfoByContent = projectService.findProjectInfoByContent(Content);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoByContent);
    }

    /* 설명. 프로젝트 이름에 따른 프로젝트 조회 */
    @GetMapping("/findProjectByName/{name}")
    public ResponseEntity<List<Project>> findProjectInfoByName(@PathVariable("name") String name) {

        List<Project> projectInfoByName = projectService.findProjectInfoByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoByName);

    }

    /* 설명. 요청이 들어온 ID를 통하여 프로젝트 이름 전달하는 기능. */
    @GetMapping("/findProjectNameById/{id}")
    public ResponseEntity<List<ResponseProjectId>> findProjectNameById(@PathVariable("id") String id) {

        List<ProjectDTO> projectInfoById = projectService.findProjectNameById(id);


        List<ResponseProjectId> responseProjectList = ProjectDTOToResponseProjectId(projectInfoById);

        return ResponseEntity.status(HttpStatus.OK).body(responseProjectList);
    }

    /* 필기. 프로젝트 DTO을 ResponseProject 타입 List로 변환 */
    private List<ResponseProjectId> ProjectDTOToResponseProjectId(List<ProjectDTO> projectInfoById) {
        List<ResponseProjectId> Responselist = new ArrayList<>();

        for (ProjectDTO projectDTO : projectInfoById) {
            ResponseProjectId responseProjectMember = new ResponseProjectId();

            responseProjectMember.setId(projectDTO.getId());
            responseProjectMember.setName(projectDTO.getName());

            Responselist.add(responseProjectMember);
        }
        return Responselist;
    }


    /* 설명. feign client 를 이용하여 프로젝트 아이디를 이용하여 이슈 리스트 받아와서 조회 */
    @GetMapping("/issue/{id}")
    public ResponseEntity<List<ResponseId>> findProjectIssueById(@PathVariable("id") String id,
                                                                          @RequestHeader("Authorization") String token) {

        List<ProjectDTO> projectIssueById = projectService.findProjectIssueById(id, token);


        List<ResponseId> responseProjectWbsList = ProjectDTOToResponseIssue(projectIssueById);

        return ResponseEntity.status(HttpStatus.OK).body(responseProjectWbsList);
    }

    private List<ResponseId> ProjectDTOToResponseIssue(List<ProjectDTO> projectInfoById) {

        List<ResponseId> responseIdList = new ArrayList<>();
        for (ProjectDTO projectDTO : projectInfoById) {
            ResponseId responseId = new ResponseId();
            responseId.setId(projectDTO.getId());
            responseId.setIssueList(projectDTO.getIssueList());

            responseIdList.add(responseId);
        }
        return responseIdList;
    }

    /* 설명. feign client 를 이용하여 프로젝트 아이디를 이용하여 wbs 리스트 받아와서 조회 */
    @GetMapping("/wbs/{id}")
    public ResponseEntity<List<ResponseId>> findProjectWbsById(@PathVariable("id") String id,
                                                                @RequestHeader("Authorization") String token) {

        List<ProjectDTO> projectWbsById = projectService.findProjectWbsById(id, token);


        List<ResponseId> responseProjectList = ProjectDTOToResponseWbs(projectWbsById);

        return ResponseEntity.status(HttpStatus.OK).body(responseProjectList);
    }

    private List<ResponseId> ProjectDTOToResponseWbs(List<ProjectDTO> projectWbsById) {
        List<ResponseId> responseIdList = new ArrayList<>();

        for (ProjectDTO projectDTO : projectWbsById) {
            ResponseId responseId = new ResponseId();
            responseId.setId(projectDTO.getId());
            responseId.setWbsList(projectDTO.getWbsList());

            responseIdList.add(responseId);
        }
        return responseIdList;
    }

}
