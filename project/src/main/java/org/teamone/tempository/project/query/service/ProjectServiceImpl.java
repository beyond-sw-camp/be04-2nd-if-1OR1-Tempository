package org.teamone.tempository.project.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.tempository.project.query.dao.ProjectMapper;
import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.dto.ProjectMemberDTO;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.entity.ProjectMember;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    /* 설명. ID를 이용하여 프로젝트 정보 조회 */
    @Override
    public List<Project> getProjectInfoById(int id) {

        List<Project> findProjectInfoById = projectMapper.getProjectInfoById(id);

        findProjectInfoById.forEach(System.out::println);

        return findProjectInfoById;
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
        List<Project> findProjectInfoByIsPublic = projectMapper.getProjectInfoByIsPublic(isPublic);
        findProjectInfoByIsPublic.forEach(System.out::println);

        return findProjectInfoByIsPublic;
    }


    /* 설명. 프로젝트 참여 회원 조회 기능 */
    @Override
    public List<ProjectDTO> getProjectJoinUserById(String id) {

        List<Project> project = projectMapper.getProjectJoinUserById(id);


        List<ProjectDTO> projectDTOJoinMember = projectToProjectDTOMember(project);


        return projectDTOJoinMember;
    }

    private List<ProjectDTO> projectToProjectDTOMember(List<Project> projectList) {

        List<ProjectDTO> projectDTOMemberList = new ArrayList<>();

        for (Project project : projectList)
        {
            ProjectDTO projectDTO = new ProjectDTO();

            projectDTO.setId(project.getId());
            projectDTO.setStatus(project.getStatus());
            projectDTO.setLikeCnt(project.getLikeCnt());
            projectDTO.setPublic(project.isPublic());
            projectDTO.setName(project.getName());
            projectDTO.setContent(project.getContent());

            List<ProjectMember> projectMemberList = project.getProjectMemberList();

            List<ProjectMemberDTO> projectMemberDTOList = new ArrayList<>();

            for (ProjectMember projectMember : projectMemberList) {

                ProjectMemberDTO projectMemberDTO = new ProjectMemberDTO();

                projectMemberDTO.setProjectId(projectMember.getProjectId());
                projectMemberDTO.setMemberId(projectMember.getMemberId());
                projectMemberDTO.setMemberStatus(projectMember.getMemberStatus());
                projectMemberDTO.setPosition(projectMember.getPosition());

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
}