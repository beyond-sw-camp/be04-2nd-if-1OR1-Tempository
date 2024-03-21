package org.teamone.projecttemplate.command.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
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
        commandTestcaseDTO.setProjectId(2);

        commandTestcaseServiceImpl.AddTestcaseByProjectId(commandTestcaseDTO);

        TestcaseDTO testcaseDTO = testcaseService.findTestcaseByTestNoAndProjectId(2, 1);

        Assertions.assertNotNull(testcaseDTO);
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

        TestcaseDTO testcaseDTO = testcaseService.findTestcaseByTestNoAndProjectId(1, 2);

        Assertions.assertEquals(commandTestcaseDTO.getNote(), testcaseDTO.getNote());
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

        Assertions.assertNotEquals("유효한 이메일과 비밀번호를 입력하고 회원가입 버튼을 클릭했을 때, 회원가입이 성공적으로 이루어져야 함",testcaseService.findTestcaseByTestNoAndProjectId(1, 1));
    }

    @DisplayName("프로젝트ID에 해당하는 테스트케이스 전체 삭제")
    @Test
    void deleteAllTestcase() {
        commandTestcaseServiceImpl.removeAllTestcase(1);

        Assertions.assertEquals(testcaseService.findTestcaseByProjectId(1).size(), 0);
    }
}