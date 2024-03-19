package org.teamone.projecttemplate.query.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
import org.teamone.projecttemplate.query.service.TestcaseService;
import org.teamone.projecttemplate.query.vo.TestcaseResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/testcase")
public class TestcaseController {

    private final TestcaseService testcaseService;

    private final ModelMapper modelMapper;

    @Autowired
    public TestcaseController(TestcaseService testcaseService, ModelMapper modelMapper) {
        this.testcaseService = testcaseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("find/{projectId}")
    public ResponseEntity<List<TestcaseResponse>> findTestcaseByProjectId (@PathVariable("projectId") int projectId) {
        List<TestcaseDTO> testcaseDTOList =  testcaseService.findTestcaseByProjectId(projectId);

        List<TestcaseResponse> testcaseResponseList = new ArrayList<>();
        for (TestcaseDTO testcaseDTO : testcaseDTOList) {
            TestcaseResponse testcaseResponse = modelMapper.map(testcaseDTO, TestcaseResponse.class);
            testcaseResponseList.add(testcaseResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(testcaseResponseList);
    }

    @GetMapping("findSeparate/{projectId}/{separate}")
    public ResponseEntity<List<TestcaseResponse>> findTestcaseBySeparateAndProjectId(
            @PathVariable("projectId") int projectId,
            @PathVariable("separate") String separate) {
        TestcaseDTO testcaseDTO = new TestcaseDTO(separate, projectId);
        List<TestcaseDTO> testcaseDTOList = testcaseService.findTestcaseBySeparateAndProjectId(testcaseDTO);

        List<TestcaseResponse> testcaseResponseList = new ArrayList<>();
        for (TestcaseDTO nextTestcaseDTO : testcaseDTOList) {
            TestcaseResponse testcaseResponse = modelMapper.map(nextTestcaseDTO, TestcaseResponse.class);
            testcaseResponseList.add(testcaseResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(testcaseResponseList);
    }

    @GetMapping("findResult/{projectId}/{result}")
    public ResponseEntity<List<TestcaseResponse>> findTestcaseByResultAndProjectId(
            @PathVariable("projectId") int projectId,
            @PathVariable("result") String result) {
        TestcaseDTO testcaseDTO = new TestcaseDTO(projectId, result);
        List<TestcaseDTO> testcaseDTOList = testcaseService.findTestcaseByResultAndProjectId(testcaseDTO);

        List<TestcaseResponse> testcaseResponseList = new ArrayList<>();
        for (TestcaseDTO nextTestcaseDTO : testcaseDTOList) {
            TestcaseResponse testcaseResponse = modelMapper.map(nextTestcaseDTO, TestcaseResponse.class);
            testcaseResponseList.add(testcaseResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(testcaseResponseList);
    }

    @GetMapping("findTestNo/{projectId}/{testNo}")
    public ResponseEntity<TestcaseResponse> findTestcaseByTestNoAndProjectId(
            @PathVariable("projectId") int projectId,
            @PathVariable("testNo") int testNo) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        TestcaseDTO testcaseDTO = testcaseService.findTestcaseByTestNoAndProjectId(testNo, projectId);

        TestcaseResponse testcaseResponse = modelMapper.map(testcaseDTO, TestcaseResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(testcaseResponse);
    }



}
