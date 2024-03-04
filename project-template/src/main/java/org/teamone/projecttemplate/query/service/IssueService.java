package org.teamone.projecttemplate.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.dto.IssueDTO;
import org.teamone.projecttemplate.query.entity.Issue;
import org.teamone.projecttemplate.query.repository.IssueMapper;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private final IssueMapper issueMapper;

    @Autowired
    public IssueService(IssueMapper issueMapper) {
        this.issueMapper = issueMapper;
    }

    /* 설명. Project ID로 해당 이슈 모두 조회 */
    public List<Issue> selectIssueByProjectId(IssueDTO issueDTO) {
        Issue issue = new Issue(issueDTO.getProjectId());
        List<Issue> result = issueMapper.selectIssueByProjectId(issue);
        return result;
    }

    public List<Issue> selectIssueByStatus(IssueDTO issueDTO) {
        Issue issue = new Issue(issueDTO.getIssueStatus());
        List<Issue> result = issueMapper.selectIssueByStatus(issue);
        return result;
    }
}
