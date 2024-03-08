package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
import org.teamone.projecttemplate.query.entity.Testcase;

import java.util.List;

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

    @DisplayName("result와 projectId로 테스트케이스 조회")
    @Test
    void findTestcaseByResultAndProjectId() {
        TestcaseDTO testcaseDTO = new TestcaseDTO(1, "PASS");

        List<Testcase> testcaseList = testcaseService.findTestcaseByResultAndProjectId(testcaseDTO);

        Assertions.assertNotNull(testcaseList);
    }

    @DisplayName("테스트케이스id로 테스트케이스 조회")
    @Test
    void findTestcaseById() {
        int id = 1;

        Testcase testcase = testcaseService.findTestcaseById(id);

        Assertions.assertNotNull(testcase);
    }

    @DisplayName("testNo와 프로젝트 id로 테스트케이스 조회")
    @Test
    void findTestcaseByTestNoAndProjectId() {
        Testcase testcase = testcaseService.findTestcaseByTestNoAndProjectId(3, 1);

        Assertions.assertNotNull(testcase);
    }

}