package org.teamone.projecttemplate.command.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.teamone.projecttemplate.command.dto.CommandIssueDTO;
import org.teamone.projecttemplate.query.dto.IssueDTO;
import org.teamone.projecttemplate.query.service.IssueService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommandIssueServiceImplTest {

    @Autowired
    CommandIssueServiceImpl commandIssueService;

    @Autowired
    IssueService issueService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @AfterEach
    void rollback() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        transactionManager.rollback(status);
    }

    @DisplayName("이슈 추가")
    @Test
    @Transactional
    void addIssue() {
        CommandIssueDTO commandIssueDTO = new CommandIssueDTO();

        commandIssueDTO.setIssueName("테스트코드 추가");
        commandIssueDTO.setIssueStatus("OPEN");
        commandIssueDTO.setIssueContent("이슈 테스트코드 추가");
        commandIssueDTO.setManagerId(6);
        commandIssueDTO.setWriterId(3);
        commandIssueDTO.setProjectId(1);

        commandIssueService.addIssue(commandIssueDTO);

        commandIssueDTO = commandIssueService.findIssueByProjectIdAndIssueNo(1, 6);

        Assertions.assertNotNull(commandIssueDTO);
    }

    @DisplayName("이슈 수정 CLOSED")
    @Test
    @Transactional
    void modifyAllStatusToClosedByProjectId() {
        commandIssueService.modifyAllStatusToClosedByProjectId(1);

        CommandIssueDTO commandIssueDTO = commandIssueService.findIssueByProjectIdAndIssueNo(1,2);

        Assertions.assertEquals(commandIssueDTO.getIssueStatus(), "CLOSED");
    }

    @DisplayName("이슈 수정 OPEN")
    @Test
    @Transactional
    void modifyAllStatusToReopenByProjectId() {
        commandIssueService.modifyAllStatusToReopenByProjectId(1);

        CommandIssueDTO commandIssueDTO = commandIssueService.findIssueByProjectIdAndIssueNo(1,2);

        Assertions.assertEquals(commandIssueDTO.getIssueStatus(), "OPEN");
    }

    @DisplayName("프로젝트ID로 이슈 전체 삭제")
    @Test
    @Transactional
    void removeAllIssueByProjectId() {
        commandIssueService.removeAllIssueByProjectId(1);
        List<CommandIssueDTO> commandIssueDTOList = commandIssueService.findIssueByProjectId(1);

        Assertions.assertEquals(commandIssueDTOList.size(), 0);
    }

    @DisplayName("프로젝트ID와 이슈 번호로 이슈삭제")
    @Test
    @Transactional
    void removeIssueByIssueNo() {
        CommandIssueDTO deleteCommandIssueDTO = commandIssueService.findIssueByProjectIdAndIssueNo(1, 2);
        commandIssueService.removeIssueByIssueNo(1, 2);
        CommandIssueDTO commandIssueDTO = commandIssueService.findIssueByProjectIdAndIssueNo(1, 2);

        Assertions.assertNotEquals(deleteCommandIssueDTO, commandIssueDTO);
    }
}