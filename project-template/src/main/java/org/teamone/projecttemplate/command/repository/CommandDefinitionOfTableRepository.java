package org.teamone.projecttemplate.command.repository;

import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandDefinitionOfTable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommandDefinitionOfTableRepository
        extends JpaRepository<CommandDefinitionOfTable, Integer> {}
