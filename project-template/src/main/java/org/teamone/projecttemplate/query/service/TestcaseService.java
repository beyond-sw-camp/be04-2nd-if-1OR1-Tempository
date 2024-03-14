package org.teamone.projecttemplate.query.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamone.projecttemplate.query.dto.IssueDTO;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
import org.teamone.projecttemplate.query.entity.Testcase;
import org.teamone.projecttemplate.query.repository.TestcaseMapper;
import org.teamone.projecttemplate.query.vo.IssueResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestcaseService {
    private final TestcaseMapper testcaseMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public TestcaseService(TestcaseMapper testcaseMapper, ModelMapper modelMapper) {
        this.testcaseMapper = testcaseMapper;
        this.modelMapper = modelMapper;
    }

    /* 설명. projectId를 이용하여 테스트케이스 조회 */
    public List<TestcaseDTO> findTestcaseByProjectId(int projectId) {
        List<Testcase> TestcaseList = testcaseMapper.selectTestcaseByProjectId(projectId);

        List<TestcaseDTO> testcaseDTOList = new ArrayList<>();
        for (Testcase testcase: TestcaseList) {
            TestcaseDTO testcaseDTO = modelMapper.map(testcase, TestcaseDTO.class);
            testcaseDTOList.add(testcaseDTO);
        }

        return testcaseDTOList;
    }

    /* 설명. projectId와 separate를 이용하여 테스트케이스 조회 */
    public List<Testcase> findTestcaseBySeparateAndProjectId(TestcaseDTO testcaseDTO) {

        Testcase testcase = new Testcase(testcaseDTO.getSeparate(), testcaseDTO.getProjectId());
        List<Testcase> testcaseList = testcaseMapper.selectTestcaseBySeparateAndProjectId(testcase);

        return testcaseList;
    }

    /* 설명. projectId와 result를 이용하여 테스트 통과된 테스트케이스 조회 */
    public List<Testcase> findTestcaseByResultAndProjectId(TestcaseDTO testcaseDTO) {
        Testcase testcase =  new Testcase(testcaseDTO.getProjectId(), testcaseDTO.getResult());
        List<Testcase> testcaseList = testcaseMapper.selectTestcaseByResultAndProjectId(testcase);

        return testcaseList;
    }

    /* 설명. 프로젝트 id와 testNo를 이용해서 테스트케이스 조회 */
    public Testcase findTestcaseByTestNoAndProjectId(int testNo, int projectId) {
        Map<String, Integer> intMap = new HashMap();
        intMap.put("testNo", testNo);
        intMap.put("projectId", projectId);

        Testcase testcase = testcaseMapper.selectTestcaseByTestNoAndProjectId(intMap);

        return testcase;
    }
}
