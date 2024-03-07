package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandRequirement;

import java.util.List;

@Repository
public interface CommandRequirementRepository extends JpaRepository<CommandRequirement, Integer> {
    List<CommandRequirement> findByProjectId(int projectId);

    CommandRequirement findByProjectIdAndRequirementNo(int projectId, int requirementNo);

    List<CommandRequirement> findByProjectIdOrderByRequirementNoAsc(int projectId);
}
