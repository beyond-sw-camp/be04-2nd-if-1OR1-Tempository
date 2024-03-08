package org.teamone.tempository.project.query.dao;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.List;

@Mapper
public interface ProjectMapper {


    List<Project> getProjectInfoById(Project project);

    List<Project> getProjectInfoByStatus(ProjectStatus status);

    List<Project> getProjectInfoOrderByLike();

    List<Project> getProjectInfoByIsPublic(boolean isPublic);

    List<Project> getProjectInfoById(int id);

    List<Project> getProjectJoinUserById(String id);

    List<Project> getProjectInfoByContent(String content);

    List<Project> getProjectInfoByName(String name);
}
