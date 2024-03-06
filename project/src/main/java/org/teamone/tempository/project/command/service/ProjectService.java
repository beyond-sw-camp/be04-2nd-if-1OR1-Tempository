package org.teamone.tempository.project.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.tempository.project.command.dto.ProjectDTO;
import org.teamone.tempository.project.command.entity.Project;
import org.teamone.tempository.project.command.repository.ProjectRepository;
import org.teamone.tempository.project.command.type.ProjectStatus;

@Service("projectServiceJpa")
public class ProjectService {

    private ModelMapper mapper;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ModelMapper modelMapper, ProjectRepository projectRepository) {
        this.mapper = modelMapper;
        this.projectRepository = projectRepository;
    }

    /* 설명. 프로젝트 작성하기 (Insert) */
    @Transactional
    public void registProject(ProjectDTO newProject) {
//        projectRepository.save(mapper.map(newProject, Project.class)); mapper 이용 (작동됨)

        Project project = Project.builder()
                .name(newProject.getName())
                .isPublic(newProject.isPublic())
                .likeCnt(newProject.getLikeCnt())
                .status(ProjectStatus.IN_PROGRESS)
                .content(newProject.getContent())
                .build();


        projectRepository.save(project);
    }

    /* 설명. 프로젝트 수정하기 (Update)*/
    @Transactional
    public void modifyProjectById(ProjectDTO modifyProject) throws IllegalAccessException {

        // 수정 할 프로젝트 id (번호)
        Project findProject = projectRepository.findById(modifyProject.getId()).orElseThrow(IllegalAccessException::new);

        findProject.setId(modifyProject.getId());
        findProject.setName(modifyProject.getName());
        findProject.setPublic(modifyProject.isPublic());
        findProject.setLikeCnt(modifyProject.getLikeCnt());
        findProject.setStatus(modifyProject.getStatus());
        findProject.setContent(modifyProject.getContent());

    }

    /* 설명. 프로젝트 삭제하기(Delete) */
    @Transactional
    public void deleteProjectById(int id) throws IllegalAccessException {

        projectRepository.findById(id).orElseThrow(IllegalAccessException::new);
        projectRepository.deleteById(id);
    }
}
