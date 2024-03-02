package org.teamone.projecttemplate.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.entity.Testcase;
import org.teamone.projecttemplate.query.repository.TestcaseMapper;

import java.util.List;

@Service
public class TestcaseService {
    private final TestcaseMapper TestcaseMapper;

    @Autowired
    public TestcaseService(TestcaseMapper testcaseMapper) {
        this.TestcaseMapper = testcaseMapper;
    }

    /* 설명. projectId를 이용하여 해당 테스트케이스 전체 조회 */
    public List<Testcase> findTestcaseByProjectId(int projectId) {
        List<Testcase> Testcases = TestcaseMapper.findTestcaseByProjectId(projectId);
        Testcases.forEach(System.out::println);

        return Testcases;
    }
}
