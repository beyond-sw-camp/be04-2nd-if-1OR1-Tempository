package org.teamone.tempository.project.query.service;

import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.List;

public interface ProjectService {

    List<Project> getProjectInfoById(String id);

    List<Project> getProjectInfoByStatus(ProjectStatus status);

    List<Project> getProjectInfoOrderByLike();

    List<Project> getProjectInfoByIsPublic(boolean isPublic);


    List<ProjectDTO> getProjectByMemberId(String id, String token);


    List<Project> getProjectInfoByContent(String content);

    List<Project> getProjectInfoByName(String name);


    List<ProjectDTO> findProjectNameById(String id);
}
