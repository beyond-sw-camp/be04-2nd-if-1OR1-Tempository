package org.teamone.projecttemplate.command.repository;

import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandDefinitionOfTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CommandDefinitionOfTableRepository
        extends JpaRepository<CommandDefinitionOfTable, Integer> {
    void deleteAllByProjectId(int projectId);

    void deleteByProjectIdAndDefinitionNo(int projectId, int definitionNo);

    CommandDefinitionOfTable findByProjectIdAndDefinitionNo(int projectId, int definitionNo);

    List<CommandDefinitionOfTable> findByProjectIdAndDefinitionNoGreaterThan(int projectId, int definitionNo);
}
