package org.teamone.tempository.project.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.tempository.project.command.entity.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {


}
