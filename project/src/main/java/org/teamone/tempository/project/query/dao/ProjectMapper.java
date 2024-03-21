package org.teamone.tempository.project.query.dao;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.type.ProjectStatus;

import java.util.List;

@Mapper
public interface ProjectMapper {


    List<Project> findProjectInfoById(String id);

    List<Project> findProjectInfoByStatus(ProjectStatus status);

    List<Project> findProjectOrderByLike();

    List<Project> findProjectInfoByIsPublic(boolean isPublic);

    List<Project> findProjectNameById(String id);

    List<Project> findProjectJoinMemberByMemberId(String id);

    List<Project> findProjectInfoByContent(String content);

    List<Project> findProjectInfoByName(String name);

    List<Project> findProjectIssueById(String id);

    List<Project> findProjectWbsById(String id);

    List<Project> findProjectRequirementById(String id);

    List<Project> findProjectTestCaseById(String id);
}
