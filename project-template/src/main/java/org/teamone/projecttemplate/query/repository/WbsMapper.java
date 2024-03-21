package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Wbs;

import java.util.List;
import java.util.Map;

@Mapper
public interface WbsMapper {
    List<Wbs> selectAllWbsByProjectId(int projectId);

    List<Wbs> selectWbsByManagerId(int managerId);

    List<Wbs> selectWbsByProjectIdAndManagerId(Wbs wbs);

    Wbs selectWbsByProjectIdAndWbsNo(Map<String, Integer> intMap);

//    List<Wbs> selectWbsByProjectId(String projectId);

//    Wbs selectWbsByProjectIdAndWbsNo(Map<String, Integer> intMap);
}