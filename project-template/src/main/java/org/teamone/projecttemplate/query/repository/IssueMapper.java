package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Issue;

import java.util.List;
import java.util.Map;

@Mapper
public interface IssueMapper {
//    List<Issue> selectIssueByProjectId(Issue issue);

    List<Issue> selectIssueByStatus(Issue issue);

    List<Issue> selectIssueByProjectId(int projectId);

    Issue selectIssueByProjectIdAndIssueNo(Map<String, Integer> intMap);
}
