package org.teamone.user.query.repository;


import org.apache.ibatis.annotations.Mapper;
import org.teamone.user.query.domainData.entity.QueryProjectMemberEntity;

import java.util.List;

@Mapper
public interface ProjectMemberMapper {
    List<QueryProjectMemberEntity> findProjectMembers(int projectId);
}
