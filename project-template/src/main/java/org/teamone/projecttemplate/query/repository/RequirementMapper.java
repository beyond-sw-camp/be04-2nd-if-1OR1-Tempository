package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Requirement;

import java.util.List;
import java.util.Map;

@Mapper
public interface RequirementMapper {
    List<Requirement> selectRequirementByProjectId(int projectId);

    List<Requirement> selectRequirementBySeparateAndProjectId(Requirement requirement);

    Requirement selectRequirementByRequirementNoAndProjectId(Map<String, Integer> intMap);
}
