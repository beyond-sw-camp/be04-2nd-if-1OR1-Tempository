package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandIssue;

import java.util.List;

@Repository
public interface CommandIssueRepository
        extends JpaRepository<CommandIssue, Integer> {
    List<CommandIssue> findAllByProjectId(int projectId);

    void deleteAllByProjectId(int projectId);

    void deleteByProjectIdAndIssueNo(int projectId, int issueNo);

    List<CommandIssue> findByProjectIdAndIssueNoGreaterThan(int projectId, int issueNo);

    CommandIssue findByProjectIdAndIssueNo(int projectId, int issueNo);
}
