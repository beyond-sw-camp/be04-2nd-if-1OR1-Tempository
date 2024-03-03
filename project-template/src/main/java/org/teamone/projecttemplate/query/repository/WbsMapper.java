package org.teamone.projecttemplate.query.repository;

import org.teamone.projecttemplate.query.entity.Wbs;

import java.util.List;

public interface WbsMapper {
    List<Wbs> selectAllWbsByProjectId(int projectId);

    List<Wbs> selectWbsByManagerId(int managerId);

    List<Wbs> selectWbsByProjectIdAndManagerId(int projectId, int managerId);
}