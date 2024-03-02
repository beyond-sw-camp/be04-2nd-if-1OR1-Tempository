package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.entity.Testcase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestcaseServiceTest {
    @Autowired
    private TestcaseService testcaseService;

    @DisplayName("프로젝트id로 테스트케이스 조회")
    @Test
    void findProjectTestcaseTest() {
        List<Testcase> projectTestcases = testcaseService.findTestcaseByProjectId(1);

        Assertions.assertNotNull(projectTestcases);
    }
}