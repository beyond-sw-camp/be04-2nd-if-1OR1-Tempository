package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Requirement;

import java.util.List;

@Mapper
public interface RequirementMapper {
    List<Requirement> selectRequirementByProjectId(int projectId);

    List<Requirement> selectRequirementBySeparateAndProjectId(Requirement requirement);

    Requirement selectRequirementById(int id);
}
