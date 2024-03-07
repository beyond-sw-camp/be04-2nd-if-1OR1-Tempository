package org.teamone.tempository.project.query.service;

import org.teamone.tempository.project.query.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getProjectInfoById(int id);

    List<Project> getProjectInfoByStatus(String status);

    List<Project> getProjectInfoOrderByLike();

    List<Project> getProjectInfoByIsPublic(boolean isPublic);
}
