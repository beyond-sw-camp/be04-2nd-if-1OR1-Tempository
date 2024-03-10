package org.teamone.tempository.project.query.service;

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
    void getProjectInfoByIdTest(){
        String id = "1";
        projectService.getProjectInfoById(id);
    }

    @DisplayName("완료유무를 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoByStatusTest() {
        ProjectStatus Status = ProjectStatus.COMPLETED;
        projectService.getProjectInfoByStatus(Status);

    }

    @DisplayName("좋아요 순을 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoOrderByLike() {

        List<Project> getProjectInfoOrderByLike = projectService.getProjectInfoOrderByLike();
    }

    @DisplayName("공개 유무에 따른 프로젝트 조회 기능 테스트 ")
    @Test

    void getProjectInfoByIsPublic() {

        boolean isPublic = true;
         projectService.getProjectInfoByIsPublic(isPublic);

    }

    @DisplayName("프로젝트 내용 검색을 통한 프로젝트 조회 기능 테스트")
    @Test
    void getProjectInfoByContentTest() {
        String Content = "인공 지능";
        projectService.getProjectInfoByContent(Content);
    }

    @DisplayName("프로젝트 이름 검색을 통한 프로젝트 조회 기능 테스트")
    @Test
    void getProjectInfoByNameTest() {
        String name = "블록체인";
        projectService.getProjectInfoByName(name);
    }

}