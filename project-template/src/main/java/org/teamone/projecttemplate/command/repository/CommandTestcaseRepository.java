package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandTestcase;

import java.util.List;

@Repository
public interface CommandTestcaseRepository extends JpaRepository<CommandTestcase, Integer> {
    List<CommandTestcase> findByProjectId(int projectId);

    CommandTestcase findByProjectIdAndTestNo(int projectId, int testNo);

    void deleteAllByProjectId(int projectId);

    void deleteByProjectIdAndTestNo(int projectId, int testNo);

    List<CommandTestcase> findByProjectIdAndTestNoGreaterThanOrderByTestNoAsc(int projectId, int testNo);
}
