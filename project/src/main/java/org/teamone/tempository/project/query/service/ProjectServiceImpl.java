package org.teamone.tempository.project.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.teamone.tempository.project.query.client.ProjectServiceClient;
import org.teamone.tempository.project.query.dao.ProjectMapper;
import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.dto.ProjectMemberDTO;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.entity.ProjectMember;
import org.teamone.tempository.project.query.type.ProjectStatus;
import org.teamone.tempository.project.query.vo.ResponseUser;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectMapper projectMapper;
    private final ProjectServiceClient projectServiceClient;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectServiceClient projectServiceClient) {
        this.projectMapper = projectMapper;
        this.projectServiceClient = projectServiceClient;
    }

    /* 설명. ID를 이용하여 프로젝트 정보 조회 */
    @Override
    public List<Project> getProjectInfoById(String id) {

        List<Project> findProjectInfoById = projectMapper.getProjectInfoById(id);

        if (findProjectInfoById != null && findProjectInfoById.size() > 0) {

            findProjectInfoById.forEach(System.out::println);

            return findProjectInfoById;

        }

        System.out.println("프로젝트가 존재하지 않습니다.");
        throw new IllegalArgumentException("프로젝트가 존재하지않습니다.");


    }


    /* 설명. Status를 이용하여 프로젝트 완료나 미완료 상태인 프로젝트를 조회 */
    public List<Project> getProjectInfoByStatus(ProjectStatus Status) {

        List<Project> findProjectInfoByStatus = projectMapper.getProjectInfoByStatus(Status);

        findProjectInfoByStatus.forEach(System.out::println);

        return findProjectInfoByStatus;
    }

    /* 설명. 좋아요 순으로 프로젝트 조회 기능 */
    public List<Project> getProjectInfoOrderByLike() {

        List<Project> findProjectInfoOrderByLike = projectMapper.getProjectInfoOrderByLike();
        findProjectInfoOrderByLike.forEach(System.out::println);

        return findProjectInfoOrderByLike;
    }

    /* 설명. 공개 유무에 따른 프로젝트 조회 기능 */

    public List<Project> getProjectInfoByIsPublic(boolean isPublic) {

        if (!isPublic) {
            System.out.println("조회할 수 없는 프로젝트입니다.");
            throw new IllegalArgumentException("조회할 수 없는 프로젝트입니다.");
        }

        List<Project> findProjectInfoByIsPublic = projectMapper.getProjectInfoByIsPublic(isPublic);
        findProjectInfoByIsPublic.forEach(System.out::println);

        return findProjectInfoByIsPublic;
    }


    /* 설명. 프로젝트 참여 회원 조회 기능 */
    @Override
    public List<ProjectDTO> getProjectByMemberId(String id, String token) {

        HttpHeaders headers = new HttpHeaders();

        List<Project> project = projectMapper.getProjectByMemberId(id);


        List<ProjectDTO> projectDTOJoinMember = projectToProjectDTOMember(project, token, id);


        return projectDTOJoinMember;
    }

    private List<ProjectDTO> projectToProjectDTOMember(List<Project> projectList, String token, String id) {

        List<ProjectDTO> projectDTOMemberList = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();

        List<ResponseUser> userList = projectServiceClient.findProjectMembers(id, token);


        for (Project project : projectList) {
            ProjectDTO projectDTO = new ProjectDTO();

            projectDTO.setId(project.getId());
            projectDTO.setStatus(project.getStatus());
            projectDTO.setName(project.getName());

            List<ProjectMember> projectMemberList = project.getProjectMemberList();

            List<ProjectMemberDTO> projectMemberDTOList = new ArrayList<>();

            for (ProjectMember projectMember : projectMemberList) {

                ProjectMemberDTO projectMemberDTO = new ProjectMemberDTO();

                projectMemberDTO.setProjectId(projectMember.getProjectId());
                projectMemberDTO.setMemberId(projectMember.getMemberId());
                projectMemberDTO.setMemberStatus(projectMember.getMemberStatus());
                projectMemberDTO.setPosition(projectMember.getPosition());

                projectMemberDTO.setUsers(userList);


                projectMemberDTOList.add(projectMemberDTO);
            }

            projectDTO.setProjectMemberList(projectMemberDTOList);
            projectDTOMemberList.add(projectDTO);
        }

        return projectDTOMemberList;
    }

    /* 설명. 프로젝트 내용 검색을 통한 프로젝트 조회 기능 */
    @Override
    public List<Project> getProjectInfoByContent(String content) {

        List<Project> findProjectByContent = projectMapper.getProjectInfoByContent(content);
        findProjectByContent.forEach(System.out::println);

        return findProjectByContent;
    }

    /* 설명. 프로젝트 이름 검색을 통한 프로젝트 조회 기능 */

    @Override
    public List<Project> getProjectInfoByName(String name) {
        List<Project> findProjectByName = projectMapper.getProjectInfoByName(name);
        findProjectByName.forEach(System.out::println);

        return findProjectByName;
    }

    @Override
    public List<ProjectDTO> findProjectNameById(String id) {
        List<Project> findProjectInfoById = projectMapper.findProjectNameById(id);

        List<ProjectDTO> projectDTOProject = projectToProjectDTOProject(findProjectInfoById);

        if (findProjectInfoById != null && findProjectInfoById.size() > 0) {

            findProjectInfoById.forEach(System.out::println);

        } else {

            System.out.println("프로젝트가 존재하지 않습니다.");

        }

        return projectDTOProject;
    }

    private List<ProjectDTO> projectToProjectDTOProject(List<Project> findProjectInfoById) {
        List<ProjectDTO> projectDTOProjectList = new ArrayList<>();

        for (Project project : findProjectInfoById) {
            ProjectDTO projectDTO = new ProjectDTO();

            projectDTO.setId(project.getId());
            projectDTO.setStatus(project.getStatus());
            projectDTO.setLikeCnt(project.getLikeCnt());
            projectDTO.setPublic(project.isPublic());
            projectDTO.setName(project.getName());
            projectDTO.setContent(project.getContent());

            projectDTOProjectList.add(projectDTO);
        }

        return projectDTOProjectList;
    }
}