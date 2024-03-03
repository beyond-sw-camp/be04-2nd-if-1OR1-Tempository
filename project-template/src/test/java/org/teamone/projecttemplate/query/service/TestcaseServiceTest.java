package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
import org.teamone.projecttemplate.query.entity.Testcase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestcaseServiceTest {
    @Autowired
    private TestcaseService testcaseService;

    @DisplayName("projectId로 테스트케이스 조회")
    @Test
    void findTestcaseTestByProjectId() {
        List<Testcase> testcaseList = testcaseService.findTestcaseByProjectId(1);

        Assertions.assertNotNull(testcaseList);
    }

    @DisplayName("separate와 projectId 테스트케이스 조회")
    @Test
    void findTestcaseBySeparateAndProjectId() {
        TestcaseDTO testcaseDTO = new TestcaseDTO("상품", 1);

        List<Testcase> testcaseList = testcaseService.findTestcaseBySeparateAndProjectId(testcaseDTO);

        Assertions.assertNotNull(testcaseList);
    }

    @DisplayName("테스트케이스 추가")
    @Test
    void registTestcase() {
        TestcaseDTO testcaseDTO =
                new TestcaseDTO(
                        1,
                        "로그인",
                        "사용자가 유효한 계정으로 로그인할 수 있는지 확인",
                        "성공적으로 로그인되어 대시보드로 리디렉션 됨",
                        "PASS",
                        null,
                        2
                );

        Assertions.assertDoesNotThrow(
                () -> testcaseService.registTestcase(testcaseDTO)
        );
    }
}