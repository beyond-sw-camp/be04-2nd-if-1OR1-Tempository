package org.teamone.projecttemplate.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.query.dto.RequirementDTO;
import org.teamone.projecttemplate.query.entity.Requirement;

import java.util.List;

@SpringBootTest
class RequirementServiceTest {

    @Autowired
    private RequirementService requirementService;

    @DisplayName("projectId로 요구사항 조회 테스트")
    @Test
    void findRequirementInfoByProjectIdTest() {
        List<Requirement> requirementList = requirementService.findRequirementByProjectId(1);

        Assertions.assertNotNull(requirementList);
    }

    @DisplayName("separate와 projectId 요구사항 조회")
    @Test
    void finRequirementInfoBySeparateAndProjectId() {
        RequirementDTO requirementDTO = new RequirementDTO("상품", 1);

        List<Requirement> requirementList = requirementService.findRequirementBySeparateAndProjectId(requirementDTO);

        Assertions.assertNotNull(requirementList);
    }

    @DisplayName("requirementNo와 projectId로 조회")
    @Test
    void findRequirementByRequirementNoAndProjectId() {
        Requirement requirement =
                requirementService.findRequirementByRequirementNoAndProjectId(3, 1);

        Assertions.assertNotNull(requirement);
    }
}