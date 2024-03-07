package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandTestcase;

import java.util.List;

@Repository
public interface CommandTestcaseRepository extends JpaRepository<CommandTestcase, Integer> {
    List<CommandTestcase> findByProjectId(int projectId);

    List<CommandTestcase> findByProjectIdOrderByTestNoAsc(int projectId);

    CommandTestcase findByProjectIdAndTestNo(int projectId, int testNo);

    void deleteAllByProjectId(int projectId);
}
