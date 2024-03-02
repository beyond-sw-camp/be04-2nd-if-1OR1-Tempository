package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.entity.Requirement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequirementServiceTest {

    @Autowired
    private RequirementService requirementService;

    @DisplayName("projectId로 요구사항 조회 테스트")
    @Test
    void requirementInfoByProjectIdTest() {
        List<Requirement> requirementList = requirementService.requirementInfoByProjectId(1);

        Assertions.assertNotNull(requirementList);
    }
}