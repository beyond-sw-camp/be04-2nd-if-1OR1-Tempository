package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandIssue;

@Repository
public interface CommandIssueRepository
        extends JpaRepository<CommandIssue, Integer> {}
