package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandTestcaseEntity;

@Repository
public interface CommandTestcaseRepository extends JpaRepository<CommandTestcaseEntity, Integer> {
}
