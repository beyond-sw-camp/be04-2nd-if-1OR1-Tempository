package org.teamone.tempository.project.query.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.teamone.tempository.project.query.entity.Project;
import org.teamone.tempository.project.query.dto.ProjectDTO;


import java.util.List;

@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @DisplayName("프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoByIdTest(){
        ProjectDTO project = new ProjectDTO(1);
        List<Project> projectInfoById = projectServiceImpl.getProjectInfoById(project);
    }

    @DisplayName("완료유무를 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoByStatusTest() {
        String Status = "COMPLETED";
        ProjectDTO project = new ProjectDTO(Status);
        List<Project> projectInfoByStatus = projectServiceImpl.getProjectInfoByStatus(Status);

    }

    @DisplayName("좋아요 순을 기준으로 프로젝트 정보 조회 테스트")
    @Test
    void getProjectInfoOrderByLike() {

        List<Project> getProjectInfoOrderByLike = projectServiceImpl.getProjectInfoOrderByLike();
    }

    @DisplayName("공개 유무에 따른 프로젝트 조회 기능 테스트 ")
    @Test

    void getProjectInfoByIsPublic() {

        boolean isPublic = true;
        List<Project> getProjectInfoByIsPublic = projectServiceImpl.getProjectInfoByIsPublic(isPublic);

    }




}