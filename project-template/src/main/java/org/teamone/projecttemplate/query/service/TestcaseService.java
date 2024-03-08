package org.teamone.projecttemplate.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
import org.teamone.projecttemplate.query.entity.Testcase;
import org.teamone.projecttemplate.query.repository.TestcaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestcaseService {
    private final TestcaseMapper testcaseMapper;

    @Autowired
    public TestcaseService(TestcaseMapper testcaseMapper) {
        this.testcaseMapper = testcaseMapper;
    }

    /* 설명. projectId를 이용하여 테스트케이스 조회 */
    public List<Testcase> findTestcaseByProjectId(int projectId) {
        List<Testcase> TestcaseList = testcaseMapper.selectTestcaseByProjectId(projectId);
        TestcaseList.forEach(System.out::println);

        return TestcaseList;
    }

    /* 설명. projectId와 separate를 이용하여 테스트케이스 조회 */
    public List<Testcase> findTestcaseBySeparateAndProjectId(TestcaseDTO testcaseDTO) {

        Testcase testcase = new Testcase(testcaseDTO.getSeparate(), testcaseDTO.getProjectId());
        List<Testcase> testcaseList = testcaseMapper.selectTestcaseBySeparateAndProjectId(testcase);
        testcaseList.forEach(System.out::println);

        return testcaseList;
    }

    /* 설명. projectId와 result를 이용하여 테스트 통과된 테스트케이스 조회 */
    public List<Testcase> findTestcaseByResultAndProjectId(TestcaseDTO testcaseDTO) {
        Testcase testcase =  new Testcase(testcaseDTO.getProjectId(), testcaseDTO.getResult());
        List<Testcase> testcaseList = testcaseMapper.selectTestcaseByResultAndProjectId(testcase);
        testcaseList.forEach(System.out::println);

        return testcaseList;
    }

    /* 설명. 테스트케이스 id로 테스트케이스 조회 */
    public Testcase findTestcaseById(int id) {
        Testcase testcase = testcaseMapper.selectTestcaseById(id);
        System.out.println(testcase);

        return testcase;
    }

    /* 설명. 프로젝트 id와 testNo를 이용해서 테스트케이스 조회 */
    public Testcase findTestcaseByTestNoAndProjectId(int testNo, int projectId) {
        Map<String, Integer> intMap = new HashMap();
        intMap.put("testNo", testNo);
        intMap.put("projectId", projectId);

        Testcase testcase = testcaseMapper.selectTestcaseByTestNoAndProjectId(intMap);
        System.out.println(testcase);

        return testcase;
    }
}
