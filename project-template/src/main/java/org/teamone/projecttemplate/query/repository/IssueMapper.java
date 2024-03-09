package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Issue;

import java.util.List;

@Mapper
public interface IssueMapper {
//    List<Issue> selectIssueByProjectId(Issue issue);

    List<Issue> selectIssueByStatus(Issue issue);

    List<Issue> selectIssueByProjectId(int projectId);
}
