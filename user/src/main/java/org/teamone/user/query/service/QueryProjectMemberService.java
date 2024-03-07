package org.teamone.user.query.service;

import org.teamone.user.query.dto.QueryProjectMemberDTO;
import org.teamone.user.query.dto.QueryUserDTO;

import java.util.List;

public interface QueryProjectMemberService {

    List<QueryUserDTO> getProjectMembers(String projectId);
}
