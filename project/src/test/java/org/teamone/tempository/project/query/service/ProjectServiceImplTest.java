package org.teamone.tempository.project.query.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.tempository.project.query.dto.ProjectDTO;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.type.ProjectStatus;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    private ProjectServiceImpl projectService;

    @DisplayName("프로젝트 정보 조회 테스트")
    @Test
    void findProjectInfoByIdTest() {
        int id = 1;
        List<Project> projectInfoById = projectService.findProjectInfoById(String.valueOf(id));

        for (Project project : projectInfoById) {
            assertThat(project.getId()).isEqualTo(id);
        }
    }

    @DisplayName("완료유무를 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void findProjectInfoByStatusTest() {
        ProjectStatus status = ProjectStatus.COMPLETED;
        List<Project> projectInfoByStatus = projectService.findProjectInfoByStatus(status);

        ProjectStatus status2 = ProjectStatus.IN_PROGRESS;
        for (Project project : projectInfoByStatus) {
            assertThat(project.getStatus()).isEqualTo(status);
        }
    }

    @DisplayName("좋아요 순을 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void findProjectInfoOrderByLike() {

        List<Project> getProjectInfoOrderByLike = projectService.findProjectOrderByLike();

    }

    @DisplayName("공개 유무에 따른 프로젝트 조회 기능 테스트 ")
    @Test
    void findProjectInfoByIsPublic() {

        boolean isPublic = true;

        List<Project> projectInfoByIsPublic = projectService.findProjectInfoByIsPublic(isPublic);

        for (Project project : projectInfoByIsPublic) {
            assertThat(project.isPublic()).isEqualTo(isPublic);
        }

    }

    @DisplayName("프로젝트 내용 검색을 통한 프로젝트 조회 기능 테스트")
    @Test
    void findProjectInfoByContentTest() {
        String Content = "인공 지능";
        List<Project> projectInfoByContent = projectService.findProjectInfoByContent(Content);

        boolean result = false;
        for (Project project : projectInfoByContent) {
            if (project.getContent().contains(Content))
                result = true;
            assertThat(result).isTrue();
        }


    }

    @DisplayName("프로젝트 이름 검색을 통한 프로젝트 조회 기능 테스트")
    @Test
    void findProjectInfoByNameTest() {
        String name = "블록체인";
        List<Project> projectInfoByName = projectService.findProjectInfoByName(name);

        boolean result = false;
        for (Project project : projectInfoByName) {
            if (project.getName().contains(name))
                result = true;
            assertThat(result).isTrue();
        }
    }

}