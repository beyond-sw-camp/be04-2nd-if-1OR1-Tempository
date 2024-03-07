package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamone.projecttemplate.command.entity.CommandWbs;

import java.util.List;

@Repository
public interface CommandWbsRepository extends JpaRepository<CommandWbs, Integer> {
    List<CommandWbs> findByProjectId(int projectId);

    CommandWbs findByProjectIdAndWbsNo(int projectId, int wbsNo);

    void deleteByProjectIdAndWbsNo(int projectId, int wbsNo);

    void deleteAllWbsByProjectId(int projectId);

    List<CommandWbs> findAllByProjectId(int projectId);
}
