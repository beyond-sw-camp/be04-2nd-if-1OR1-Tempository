package org.teamone.projecttemplate.command.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.query.entity.Testcase;
import org.teamone.projecttemplate.query.service.TestcaseService;

@SpringBootTest
class CommandTestcaseServiceImplTest {

    @Autowired
    private CommandTestcaseServiceImpl commandTestcaseServiceImpl;

    @Autowired
    private TestcaseService testcaseService;

    @DisplayName("테스트케이스 추가")
    @Test
    void AddTestcaseByProjectId() {
        CommandTestcaseDTO commandTestcaseDTO = new CommandTestcaseDTO();
        commandTestcaseDTO.setSeparate("로그인");
        commandTestcaseDTO.setContent("사용자가 유효한 계정으로 로그인할 수 있는지 확인");
        commandTestcaseDTO.setExpectedValue("성공적으로 로그인되어 대시보드로 리디렉션 됨");
        commandTestcaseDTO.setResult("FAIL");
        commandTestcaseDTO.setNote(null);

        commandTestcaseServiceImpl.AddTestcaseByProjectId(2, commandTestcaseDTO);

        Testcase testcase = testcaseService.findTestcaseByTestNoAndProjectId(2, 2);

        Assertions.assertNotNull(testcase);
    }

    @DisplayName("테스트케이스 변경")
    @Test
    void modifyTestcase() {
        CommandTestcaseDTO commandTestcaseDTO = new CommandTestcaseDTO();
        commandTestcaseDTO.setTestNo(1);
        commandTestcaseDTO.setSeparate("로그인");
        commandTestcaseDTO.setContent("사용자가 유효한 계정으로 로그인할 수 있는지 확인");
        commandTestcaseDTO.setExpectedValue("성공적으로 로그인되어 대시보드로 리디렉션 됨");
        commandTestcaseDTO.setResult("PASS");
        commandTestcaseDTO.setNote("로그인 시 토큰 발행");
        commandTestcaseDTO.setProjectId(2);

        commandTestcaseServiceImpl.modifyTestcase(commandTestcaseDTO);

        Testcase testcase = testcaseService.findTestcaseByTestNoAndProjectId(1, 2);

        Assertions.assertEquals(commandTestcaseDTO.getNote(), testcase.getNote());
    }

    @DisplayName("테스트케이스 순서 변경")
    @Test
    void modifyTestcaseSequence() {
        CommandTestcaseDTO commandTestcaseDTO = new CommandTestcaseDTO();

        commandTestcaseDTO.setProjectId(1);
        commandTestcaseDTO.setTestNo(2);

        commandTestcaseDTO = commandTestcaseServiceImpl.modifyTestcaseSequence(commandTestcaseDTO,1);

        Assertions.assertEquals(commandTestcaseDTO.getTestNo(), 3);
    }

    @DisplayName("테스트케이스 삭제")
    @Test
    void removeTestcase() {
        commandTestcaseServiceImpl.removeTestcase(1, 1);

//        Assertions.assertNull(testcaseService.findTestcaseByTestNoAndProjectId(1, 1));
    }

    @DisplayName("프로젝트ID에 해당하는 테스트케이스 전체 삭제")
    @Test
    void deleteAllTestcase() {
        commandTestcaseServiceImpl.deleteAllTestcase(1);

        Assertions.assertEquals(testcaseService.findTestcaseByProjectId(1).size(), 0);
    }
}