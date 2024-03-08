package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Wbs;

import java.util.List;

@Mapper
public interface WbsMapper {
    List<Wbs> selectAllWbsByProjectId(int projectId);

    List<Wbs> selectWbsByManagerId(int managerId);

    List<Wbs> selectWbsByProjectIdAndManagerId(int projectId, int managerId);
}