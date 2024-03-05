package org.teamone.tempository.project.command.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.tempository.project.command.dto.ProjectDTO;
import org.teamone.tempository.project.command.repository.ProjectRepository;
import org.teamone.tempository.project.command.status.ProjectStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;
    private ProjectRepository projectRepository;




    @DisplayName("프로젝트 정보 입력 테스트")
    @Test
    @Transactional
    public void testRegistProject() {
        // 테스트에 필요한 데이터 설정
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Test Project");
        projectDTO.setPublic(true);
        projectDTO.setLikeCnt(0);
        projectDTO.setStatus(ProjectStatus.IN_PROGRESS);
        projectDTO.setContent("Test Content");

        // 프로젝트 등록 메서드 호출
        projectService.registProject(projectDTO);

        // 프로젝트 저장이 올바르게 호출되었는지 검증

    }
}