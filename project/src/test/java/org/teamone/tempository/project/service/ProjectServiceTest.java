package org.teamone.tempository.project.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.tempository.project.entity.Project;
import org.teamone.tempository.project.dto.ProjectDTO;


import java.util.List;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @DisplayName("프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoByIdTest(){
        ProjectDTO project = new ProjectDTO(1);
        List<Project> projectInfoById = projectService.getProjectInfoById(project);
    }

    @DisplayName("완료유무를 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoByStatusTest() {
        String Status = "COMPLETED";
        ProjectDTO project = new ProjectDTO(Status);
        List<Project> projectInfoByStatus = projectService.getProjectInfoByStatus(Status);

    }

    @DisplayName("좋아요 순을 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoOrderByLike() {

        List<Project> getProjectInfoOrderByLike = projectService.getProjectInfoOrderByLike();
    }




}