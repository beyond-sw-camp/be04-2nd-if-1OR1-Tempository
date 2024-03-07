package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.dto.RequirementDTO;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
import org.teamone.projecttemplate.query.entity.Requirement;
import org.teamone.projecttemplate.query.entity.Testcase;

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

    @DisplayName("separate와 projectId 요구사항 조회")
    @Test
    void requirementInfoBySeparateAndProjectId() {
        RequirementDTO requirementDTO = new RequirementDTO("상품", 1);

        List<Requirement> requirementList = requirementService.requirementInfoBySeparateAndProjectId(requirementDTO);

        Assertions.assertNotNull(requirementList);
    }

    @DisplayName("요구사항 id로 요구사항 조회")
    @Test
    void findRequirementById() {
        int id  = 1;

        Requirement requirement = requirementService.findRequirementById(id);

        Assertions.assertNotNull(requirement);
    }
}