package org.teamone.projecttemplate.query.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamone.projecttemplate.query.dto.TestcaseDTO;
import org.teamone.projecttemplate.query.entity.Testcase;
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

        return ResponseEntity.status(HttpStatus.CREATED).body(testcaseResponseList);
    }



}
