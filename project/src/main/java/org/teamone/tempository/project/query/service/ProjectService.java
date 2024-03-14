package org.teamone.tempository.project.query.service;

import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.List;

public interface ProjectService {

    List<Project> findProjectInfoById(String id);

    List<Project> findProjectInfoByStatus(ProjectStatus status);

    List<Project> findProjectOrderByLike();

    List<Project> findProjectInfoByIsPublic(boolean isPublic);


    List<ProjectDTO> findProjectJoinMemberByMemberId(String id, String token);


    List<Project> findProjectInfoByContent(String content);

    List<Project> findProjectInfoByName(String name);


    List<ProjectDTO> findProjectNameById(String id);

    List<ProjectDTO> findProjectIssueById(String id, String token);
}
