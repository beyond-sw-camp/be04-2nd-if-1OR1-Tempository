package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandTestcaseEntity;

import java.util.List;

@Repository
public interface CommandTestcaseRepository extends JpaRepository<CommandTestcaseEntity, Integer> {
    List<CommandTestcaseEntity> findByProjectId(int projectId);

    List<CommandTestcaseEntity> findByProjectIdOrderByTestNoAsc(int projectId);

    CommandTestcaseEntity findByProjectIdAndTestNo(int projectId, int testNo);
}
