package org.teamone.projecttemplate.command.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.query.entity.Testcase;
import org.teamone.projecttemplate.query.service.TestcaseService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommandTestcaseServiceImplTest {

    @Autowired
    private CommandTestcaseServiceImpl commandTestcaseServiceImpl;

    @Autowired
    private TestcaseService testcaseService;

    @DisplayName("테스트케이스 추가")
    @Test
    void registTestcase() {
        CommandTestcaseDTO commandTestcaseDTO = new CommandTestcaseDTO();
        commandTestcaseDTO.setSeparate("로그인");
        commandTestcaseDTO.setContent("사용자가 유효한 계정으로 로그인할 수 있는지 확인");
        commandTestcaseDTO.setExpectedValue("성공적으로 로그인되어 대시보드로 리디렉션 됨");
        commandTestcaseDTO.setResult("FAIL");
        commandTestcaseDTO.setNote(null);
        commandTestcaseDTO.setProjectId(2);

        commandTestcaseServiceImpl.registTestcase(commandTestcaseDTO);

        Testcase testcase = testcaseService.findTestcaseByTestNoAndProjectId(2, 2);

        Assertions.assertNotNull(testcase);
    }

    @DisplayName("테스트케이스 변경")
    @Test
    void modifyTestcase() {
    }

    @DisplayName("테스트케이스 순서 변경")
    @Test
    void modifyTestcaseSequence() {
    }

    @DisplayName("테스트케이스 삭제")
    @Test
    void removeTestcase() {
    }

    @DisplayName("프로젝트ID에 해당하는 테스트케이스 전체 삭제")
    @Test
    void deleteAllTestcase() {
    }
}