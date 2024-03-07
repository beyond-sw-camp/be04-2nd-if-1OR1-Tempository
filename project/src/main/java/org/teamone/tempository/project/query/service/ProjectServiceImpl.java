package org.teamone.tempository.project.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.tempository.project.query.dao.ProjectMapper;
import org.teamone.tempository.project.query.entity.Project;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    /* 설명. ID를 이용하여 프로젝트 정보 조회 */
    @Override
    public List<Project> getProjectInfoById(int id) {

        List<Project> findProjectInfoById = projectMapper.getProjectInfoById(id);

        findProjectInfoById.forEach(System.out::println);

        return findProjectInfoById;
    }



    /* 설명. Status를 이용하여 프로젝트 완료나 미완료 상태인 프로젝트를 조회 */
    public List<Project> getProjectInfoByStatus(String Status) {

        List<Project> findProjectInfoByStatus = projectMapper.getProjectInfoByStatus(Status);

        findProjectInfoByStatus.forEach(System.out::println);

        return findProjectInfoByStatus;
    }

    /* 설명. 좋아요 순으로 프로젝트 조회 기능 */
    public List<Project> getProjectInfoOrderByLike() {

        List<Project> findProjectInfoOrderByLike = projectMapper.getProjectInfoOrderByLike();
        findProjectInfoOrderByLike.forEach(System.out::println);

        return findProjectInfoOrderByLike;
    }

    /* 설명. 공개 유무에 따른 프로젝트 조회 기능 */

    public List<Project> getProjectInfoByIsPublic(boolean isPublic) {
        List<Project> findProjectInfoByIsPublic = projectMapper.getProjectInfoByIsPublic(isPublic);
        findProjectInfoByIsPublic.forEach(System.out::println);

        return findProjectInfoByIsPublic;
    }
}