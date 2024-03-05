package org.teamone.tempository.project.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamone.tempository.project.command.dto.ProjectDTO;
import org.teamone.tempository.project.command.entity.Project;
import org.teamone.tempository.project.command.repository.ProjectRepository;
import org.teamone.tempository.project.command.status.ProjectStatus;

@Service("projectService2")
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
//        projectRepository.save(mapper.map(newProject, Project.class));

        Project project = Project.builder()
                .name(newProject.getName())
                .isPublic(newProject.isPublic())
                .likeCnt(newProject.getLikeCnt())
                .status(ProjectStatus.IN_PROGRESS)
                .content(newProject.getContent())
                .build();


        projectRepository.save(project);
    }
}
