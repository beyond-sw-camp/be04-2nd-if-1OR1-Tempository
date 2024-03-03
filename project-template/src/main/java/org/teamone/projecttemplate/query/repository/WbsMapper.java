package org.teamone.projecttemplate.query.repository;

import org.teamone.projecttemplate.query.entity.Wbs;

import java.util.List;

public interface WbsMapper {
    List<Wbs> selectAllWbsByProjectId(int projectId);

}