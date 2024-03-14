package org.teamone.tempository.project.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.type.ProjectStatus;


import java.util.List;

@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    private ProjectServiceImpl projectService;

    @DisplayName("프로젝트 정보 조회 테스트")
    @Test
    void findProjectInfoByIdTest(){
        String id = "1";
        List<Project> projectInfoById = projectService.findProjectInfoById(id);
        Assertions.assertNotNull(projectInfoById);
    }

    @DisplayName("완료유무를 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void findProjectInfoByStatusTest() {
        ProjectStatus Status = ProjectStatus.COMPLETED;
        List<Project> projectInfoByStatus = projectService.findProjectInfoByStatus(Status);

        Assertions.assertNotNull(projectInfoByStatus);
    }

    @DisplayName("좋아요 순을 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void findProjectInfoOrderByLike() {

        List<Project> getProjectInfoOrderByLike = projectService.findProjectOrderByLike();

        Assertions.assertNotNull(getProjectInfoOrderByLike);

    }

    @DisplayName("공개 유무에 따른 프로젝트 조회 기능 테스트 ")
    @Test
    void findProjectInfoByIsPublic() {

        boolean isPublic = true;
        List<Project> projectInfoByIsPublic = projectService.findProjectInfoByIsPublic(isPublic);

        Assertions.assertNotNull(projectInfoByIsPublic);


    }

    @DisplayName("프로젝트 내용 검색을 통한 프로젝트 조회 기능 테스트")
    @Test
    void findProjectInfoByContentTest() {
        String Content = "인공 지능";
        List<Project> projectInfoByContent = projectService.findProjectInfoByContent(Content);

        Assertions.assertNotNull(projectInfoByContent);

    }

    @DisplayName("프로젝트 이름 검색을 통한 프로젝트 조회 기능 테스트")
    @Test
    void findProjectInfoByNameTest() {
        String name = "블록체인";
        List<Project> projectInfoByName = projectService.findProjectInfoByName(name);

        Assertions.assertNotNull(projectInfoByName);

    }

}