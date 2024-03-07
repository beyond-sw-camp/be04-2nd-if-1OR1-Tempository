package org.teamone.projecttemplate.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.teamone.projecttemplate.query.entity.Testcase;

import java.util.List;

@Mapper
public interface TestcaseMapper {
    List<Testcase> selectTestcaseByProjectId(int projectId);

    List<Testcase> selectTestcaseBySeparateAndProjectId(Testcase testcase);

    List<Testcase> selectTestcaseByResultAndProjectId(Testcase testcase);

    Testcase selectTestcaseById(int id);
}
