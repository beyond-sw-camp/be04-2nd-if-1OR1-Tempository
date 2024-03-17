package org.teamone.tempository.project.command.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.tempository.project.command.dto.ProjectDTO;
import org.teamone.tempository.project.command.type.ProjectStatus;

@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    private ProjectService projectService;


    @DisplayName("프로젝트 정보 입력 테스트")
    @Test
    void insertProjectTest() {
        // 테스트에 필요한 데이터 설정
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Test Project");
        projectDTO.setPublic(true);
        projectDTO.setLikeCnt(0);
        projectDTO.setStatus(ProjectStatus.IN_PROGRESS);
        projectDTO.setContent("Test Content");

        // 프로젝트 등록 메서드 호출
        projectService.insertProject(projectDTO);

    }

    @DisplayName("프로젝트 정보 수정 테스트")
    @Test
    void updateProjectTest() throws IllegalAccessException {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(11);
        projectDTO.setName("UpdateTest Project");
        projectDTO.setPublic(false);
        projectDTO.setLikeCnt(12);
        projectDTO.setStatus(ProjectStatus.COMPLETED);
        projectDTO.setContent("UpdateTest Content");

        projectService.updateProjectById(projectDTO);
    }

    @DisplayName("프로젝트 정보 삭제 테스트")
    @Test
    void deleteProjectTest() throws IllegalAccessException {
        int id = 13;
        projectService.deleteProjectById(String.valueOf(id));

    }
}