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
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.entity.CommandWbs;

import java.util.List;


@SpringBootTest
public class CommandWbsServiceImplTest {

    @Autowired
    private CommandWbsServiceImpl commandWbsServiceImpl;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @AfterEach
    void rollback() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        transactionManager.rollback(status);
    }


    @DisplayName("WBS 조회")
    @Test
    void findWbsByProjectIdAndWbsNo() {
        // Given
        int projectId = 1;
        int managerId = 1;

        // When
        CommandWbsDTO commandWbsDTO = commandWbsServiceImpl.findWbsByProjectIdAndWbsNo(projectId, managerId);

        // Then
        Assertions.assertNotNull(commandWbsDTO);

    }

    @DisplayName("프로젝트 ID에 해당하는 모든 WBS 조회")
    @Test
    void findAllWbsByProjectId() {

        // Given
        int projectId = 1;

        // When
        List<CommandWbsDTO> wbsList = commandWbsServiceImpl.findAllWbsByProjectId(projectId);

        // Then
        Assertions.assertNotNull(wbsList);
        Assertions.assertFalse(wbsList.isEmpty());
    }


    @DisplayName("WBS 추가")
    @Test
    @Transactional
    void addWbs() {

        // Given
        CommandWbsDTO commandWbsDTO = new CommandWbsDTO();
        commandWbsDTO.setTaskStatus("IN_PROGRESS");
        commandWbsDTO.setContent("WBS 추가 테스트");
        commandWbsDTO.setStartDate(null);
        commandWbsDTO.setEndDate(null);
        commandWbsDTO.setProjectId(2);
        commandWbsDTO.setManagerId(1);

        // When
        commandWbsServiceImpl.addWbs(commandWbsDTO);

        // Then
        CommandWbsDTO addedWbsDTO = commandWbsServiceImpl.findWbsByProjectIdAndWbsNo(2, 1);

        Assertions.assertNotNull(addedWbsDTO);
    }

    @DisplayName("WBS 수정")
    @Test
    @Transactional
    void modifyWbs() {

        // Given
        CommandWbsDTO commandWbsDTO = commandWbsServiceImpl.findWbsByProjectIdAndWbsNo(1, 1);
        commandWbsDTO.setTaskStatus("COMPLETED");
        commandWbsDTO.setContent("WBS 수정 테스트");
        commandWbsDTO.setStartDate(null);
        commandWbsDTO.setEndDate(null);
        commandWbsDTO.setManagerId(5);

        // When
        commandWbsServiceImpl.modifyWbs(commandWbsDTO);

        // Then
        CommandWbsDTO modifiedWbsDTO = commandWbsServiceImpl.findWbsByProjectIdAndWbsNo(1, 1);

        Assertions.assertEquals(commandWbsDTO.getWbsNo(), modifiedWbsDTO.getWbsNo());
        Assertions.assertEquals(commandWbsDTO.getContent(), modifiedWbsDTO.getContent());
        Assertions.assertEquals(commandWbsDTO.getTaskStatus(), modifiedWbsDTO.getTaskStatus());
        Assertions.assertEquals(commandWbsDTO.getStartDate(), modifiedWbsDTO.getStartDate());
        Assertions.assertEquals(commandWbsDTO.getEndDate(), modifiedWbsDTO.getEndDate());
        Assertions.assertEquals(commandWbsDTO.getProjectId(), modifiedWbsDTO.getProjectId());
        Assertions.assertEquals(commandWbsDTO.getManagerId(), modifiedWbsDTO.getManagerId());
    }

    @DisplayName("WBS 전부 COMPLETED 상태로 바꾸기")
    @Test
    @Transactional
    void modifyAllWbsStatusToCompleted() {

        // Given
        int projectId = 2;

        // When
        List<CommandWbs> modifiedCommandWbsList = commandWbsServiceImpl.modifyAllWbsStatusToCompleted(projectId);

        // Then
        for (CommandWbs commandWbs : modifiedCommandWbsList) {
            Assertions.assertEquals("COMPLETED", commandWbs.getTaskStatus());
        }
    }

    @DisplayName("WBS 삭제")
    @Test
    @Transactional
    void removeWbs() {

        // Given
        int projectId = 1;
        int wbsNo = 1;

        // When
        commandWbsServiceImpl.removeWbs(projectId, wbsNo);

        // Then
        CommandWbsDTO deletedWbsDTO = commandWbsServiceImpl.findWbsByProjectIdAndWbsNo(1, 1);

        // WBS NO가 자동 업데이트 되므로 NO가 빌 수 없음
        Assertions.assertNotEquals(null, deletedWbsDTO);
    }

    @DisplayName("프로젝트 ID에 해당하는 WBS 전체 삭제")
    @Test
    @Transactional
    void removeAllWbsByProjectId() {

        // Given
        int projectId = 1;

        // When
        commandWbsServiceImpl.removeAllWbsByProjectId(projectId);

        // Then
        Assertions.assertEquals(commandWbsServiceImpl.findAllWbsByProjectId(1).size(), 0);
    }
}
