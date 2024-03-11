package org.teamone.tempository.project.query.dao;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.List;

@Mapper
public interface ProjectMapper {


    List<Project> getProjectInfoById(String id);

    List<Project> getProjectInfoByStatus(ProjectStatus status);

    List<Project> getProjectInfoOrderByLike();

    List<Project> getProjectInfoByIsPublic(boolean isPublic);

    List<Project> findProjectNameById(String id);

    List<Project> getProjectByMemberId(String id);

    List<Project> getProjectInfoByContent(String content);

    List<Project> getProjectInfoByName(String name);
}
