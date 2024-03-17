package org.teamone.projecttemplate.command.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.projecttemplate.command.dto.CommandRequirementDTO;
import org.teamone.projecttemplate.query.dto.RequirementDTO;
import org.teamone.projecttemplate.query.entity.Requirement;
import org.teamone.projecttemplate.query.service.RequirementService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommandRequirementServiceImplTests {

    private final CommandRequirementServiceImpl commandRequirementServiceImpl;

    private final RequirementService requirementService;

    @Autowired
    public CommandRequirementServiceImplTests(CommandRequirementServiceImpl commandRequirementServiceImpl,
                                              RequirementService requirementService) {
        this.commandRequirementServiceImpl = commandRequirementServiceImpl;
        this.requirementService = requirementService;
    }

    @DisplayName("요구사항 명세서 추가")
    @Test
    void addRequirement() {
        CommandRequirementDTO commandRequirementDTO = new CommandRequirementDTO();

        commandRequirementDTO.setSeparate("로그인");
        commandRequirementDTO.setName("사용자 로그인");
        commandRequirementDTO.setContent("사용자는 자신의 계정으로 로그인할 수 있어야 합니다");
        commandRequirementDTO.setNote(null);
        commandRequirementDTO.setProjectId(2);

        commandRequirementServiceImpl.addRequirement(commandRequirementDTO);

        RequirementDTO requirementDTO = requirementService.findRequirementByRequirementNoAndProjectId(1, 2);

        Assertions.assertNotNull(requirementDTO);
    }

    @DisplayName("요구사항 명세서 변경")
    @Test
    void modifyRequirement() {
        CommandRequirementDTO commandRequirementDTO = new CommandRequirementDTO();

        commandRequirementDTO.setRequirementNo(1);
        commandRequirementDTO.setSeparate("로그인");
        commandRequirementDTO.setName("사용자 로그인");
        commandRequirementDTO.setContent("사용자는 자신의 계정으로 로그인할 수 있어야 합니다");
        commandRequirementDTO.setNote("네이버로 로그인 가능");
        commandRequirementDTO.setProjectId(2);

        commandRequirementServiceImpl.modifyRequirement(commandRequirementDTO);

        RequirementDTO requirementDTO = requirementService.findRequirementByRequirementNoAndProjectId(1, 2);

        Assertions.assertNotNull(requirementDTO);
    }

    @DisplayName("요구사항 명세서 순서변경")
    @Test
    void modifyRequirementSequence() {
        CommandRequirementDTO commandRequirementDTO = new CommandRequirementDTO();

        commandRequirementDTO.setRequirementNo(1);
        commandRequirementDTO.setProjectId(1);
        RequirementDTO beforeRequirementDTO = requirementService.findRequirementByRequirementNoAndProjectId(1, 1);

        commandRequirementServiceImpl.modifyRequirementSequence(commandRequirementDTO, 1);

        RequirementDTO afterRequirementDTO = requirementService.findRequirementByRequirementNoAndProjectId(2, 1);

        Assertions.assertEquals(beforeRequirementDTO.getId(), afterRequirementDTO.getId());
    }

    @DisplayName("요구사항 명세서 삭제")
    @Test
    void removeRequirement() {
        int projectId = 1;
        int requirementNo = 3;

        RequirementDTO removeRequirementDTO = requirementService.findRequirementByRequirementNoAndProjectId(3, 1);

        commandRequirementServiceImpl.removeRequirement(projectId, requirementNo);

        RequirementDTO requirementDTO = requirementService.findRequirementByRequirementNoAndProjectId(3, 1);

        Assertions.assertNotEquals(removeRequirementDTO.getId(), requirementDTO.getId());
    }

    @DisplayName("요구사항 명세서 전체 삭제")
    @Test
    void removeAllRequirement() {
        int projectId = 1;

        commandRequirementServiceImpl.removeAllRequirement(projectId);

        Assertions.assertEquals(requirementService.findRequirementByProjectId(1).size(),0);
    }
}