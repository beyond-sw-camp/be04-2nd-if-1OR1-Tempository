package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Wbs;

import java.util.List;
import java.util.Map;

@Mapper
public interface WbsMapper {
    List<Wbs> findAllWbsByProjectId(int projectId);

    List<Wbs> selectWbsByManagerId(int managerId);

    List<Wbs> selectWbsByProjectIdAndManagerId(int projectId, int managerId);

    List<Wbs> selectWbsByProjectId(String projectId);

    Wbs selectWbsByProjectIdAndWbsNo(Map<String, Integer> intMap);
}