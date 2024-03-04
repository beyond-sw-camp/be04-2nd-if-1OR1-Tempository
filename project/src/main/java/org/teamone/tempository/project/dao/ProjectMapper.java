package org.teamone.tempository.project.dao;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.tempository.project.entity.Project;

import java.util.List;

@Mapper
public interface ProjectMapper {


    List<Project> getProjectInfoById(Project project);
}
