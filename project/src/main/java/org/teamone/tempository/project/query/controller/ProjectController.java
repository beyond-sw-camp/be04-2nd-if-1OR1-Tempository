package org.teamone.tempository.project.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.service.ProjectService;
import org.teamone.tempository.project.query.type.ProjectStatus;
import org.teamone.tempository.project.query.vo.ResponseProjectId;
import org.teamone.tempository.project.query.vo.ResponseProjectMember;

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
    @GetMapping("/findById/{id}")
    public ResponseEntity<List<Project>> getProjectInfoById(@PathVariable("id") String id) {

        List<Project> projectInfoById = projectService.getProjectInfoById(id);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoById);
    }


    /* 설명. Status를 이용하여 프로젝트 완료나 미완료 상태인 프로젝트를 조회 */
    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<List<Project>> getProjectInfoByStatus(@PathVariable("status") ProjectStatus Status) {

        List<Project> projectInfoByStatus = projectService.getProjectInfoByStatus(Status);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoByStatus);
    }

    /* 설명. 좋아요 순으로 프로젝트 조회 기능 */
    @GetMapping("/findOrderByLike")
    public ResponseEntity<List<Project>> getProjectInfoOrderByLike() {

        List<Project> projectInfoOrderByLike = projectService.getProjectInfoOrderByLike();

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoOrderByLike);

    }

    /* 설명. 공개 유무에 따른 프로젝트 조회 기능 */
    @GetMapping("/findByIsPublic/{isPublic}")
    public ResponseEntity<List<Project>> getProjectInfoByIsPublic(@PathVariable("isPublic") boolean isPublic) {

        List<Project> projectInfoByIsPublic = projectService.getProjectInfoByIsPublic(isPublic);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoByIsPublic);

    }

    /* 설명. 프로젝트 참여 회원 정보와 프로젝트 정보 조회 기능 */
    @GetMapping("/findProjectMember/{memberId}")
    public ResponseEntity<List<ResponseProjectMember>> findProjectByMemberId(@PathVariable String memberId
                                                                    ,@RequestHeader("Authorization") String token) {

        List<ProjectDTO> projectDTOId = projectService.getProjectByMemberId(memberId,token);

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
    @GetMapping("/searchContent/{content}")
    public ResponseEntity<List<Project>> getProjectInfoByContent(@PathVariable("content") String Content) {

        List<Project> projectInfoByContent = projectService.getProjectInfoByContent(Content);

        return ResponseEntity.status(HttpStatus.OK).body(projectInfoByContent);
    }

    /* 설명. 프로젝트 이름에 따른 프로젝트 조회 */
    @GetMapping("/searchName/{name}")
    public ResponseEntity<List<Project>> getProjectInfoByName(@PathVariable("name") String name) {

        List<Project> projectInfoByName = projectService.getProjectInfoByName(name);

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

}
