package org.teamone.projecttemplate.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teamone.projecttemplate.command.entity.Wbs;

public interface WbsRepository extends JpaRepository<Wbs, Integer> {

    // 기본적인 INSERT, UPDATE, DELETE 기능 때에는 쓸 일이 없지만 우선 만들어둠
}
