package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.dto.IssueDTO;
import org.teamone.projecttemplate.query.entity.Issue;

import java.util.List;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    private IssueService issueService;

    @DisplayName("프로젝트 ID에 해당하는 이슈 조회")
    @Test
    void findIssueByProjectId() {
        IssueDTO issueDTO = new IssueDTO(1);
        List<Issue> findIssueByProjectId = issueService.selectIssueByProjectId(issueDTO);
        findIssueByProjectId.forEach(System.out::println);
    }

    @DisplayName("조회하고자 하는 이슈 상태에 따른 이슈 조회")
    @Test
    void findIssueByStatus() {
        IssueDTO issueDTO = new IssueDTO("CLOSED");
        List<Issue> findIssueByStatus = issueService.selectIssueByStatus(issueDTO);
        findIssueByStatus.forEach(System.out::println);


    }



}