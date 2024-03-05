package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandWbs;

@Repository
public interface CommandWbsRepository extends JpaRepository<CommandWbs, Integer> {
}
