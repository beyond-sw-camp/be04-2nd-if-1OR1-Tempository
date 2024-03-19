package org.teamone.projecttemplate.query.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.query.dto.WbsDTO;
import org.teamone.projecttemplate.query.dto.WbsUserDTO;
import org.teamone.projecttemplate.query.service.WbsService;
import org.teamone.projecttemplate.query.vo.WbsResponse;
import org.teamone.projecttemplate.query.vo.WbsUserResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wbs")
public class WbsController {

    private final WbsService wbsService;

    private final ModelMapper modelMapper;

    @Autowired
    public WbsController(WbsService wbsService, ModelMapper modelMapper) {
        this.wbsService = wbsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/find/{projectId}")
    public ResponseEntity<List<WbsResponse>> findAllWbsByProjectId(@PathVariable("projectId") int projectId) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<WbsDTO> wbsDTOList = wbsService.findAllWbsByProjectId(projectId);

        List<WbsResponse> wbsResponseList = new ArrayList<>();
        for (WbsDTO wbsDTO : wbsDTOList) {
            WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);
            wbsResponseList.add(wbsResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(wbsResponseList);
    }

    @GetMapping("/find/{managerId}")
    public ResponseEntity<List<WbsResponse>> findWbsByManagerId(@PathVariable("managerId") int managerId) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<WbsDTO> wbsDTOList = wbsService.findWbsByManagerId(managerId);

        List<WbsResponse> wbsResponseList = new ArrayList<>();
        for (WbsDTO wbsDTO : wbsDTOList) {
            WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);
            wbsResponseList.add(wbsResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(wbsResponseList);
    }

    @GetMapping("/find/{projectId}/{managerId}")
    public ResponseEntity<List<WbsResponse>> findWbsByProjectIdAndManagerId(
            @PathVariable("projectId") int projectId,
            @PathVariable("managerId") int managerId) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        WbsDTO wbsDTO = new WbsDTO(projectId, managerId);
        List<WbsDTO> wbsDTOList = wbsService.findWbsByProjectIdAndManagerId(wbsDTO);

        List<WbsResponse> wbsResponseList = new ArrayList<>();

        for (WbsDTO nextWbsDTO : wbsDTOList) {
            WbsResponse wbsResponse = modelMapper.map(nextWbsDTO, WbsResponse.class);
            wbsResponseList.add(wbsResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(wbsResponseList);
    }

    @GetMapping("/find/{projectId}/{wbsNo}")
    public ResponseEntity<WbsResponse> findWbsByProjectIdAndWbsNo(
            @PathVariable("projectId") int projectId,
            @PathVariable("wbsNo") int wbsNo) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        WbsDTO wbsDTO = wbsService.findWbsByProjectIdAndWbsNo(projectId, wbsNo);

        WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(wbsResponse);
    }


//    @GetMapping("/{projectId}")
//    public ResponseEntity<List<WbsResponse>> findWbsByProjectId(@PathVariable("projectId") String projectId, @RequestHeader("Authorization") String token) {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        List<WbsDTO> wbsDTOList = wbsService.findWbsByProjectId(projectId);
//
//        List<WbsResponse> wbsResponseList = new ArrayList<>();
//        for (WbsDTO wbsDTO : wbsDTOList) {
//            WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);
//            wbsResponseList.add(wbsResponse);
//        }
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(wbsResponseList);
//
//    }

//    @GetMapping("/{projectId}/{wbsNo}")
//    public ResponseEntity<WbsUserResponse> findWbsByProjectIdAndWbsNo(@PathVariable("projectId") int projectId,
//                                                                      @PathVariable("wbsNo") int wbsNo,
//                                                                      @RequestHeader("Authorization") String token) {
//        WbsUserDTO wbsUserDTO = wbsService.selectWbsByProjectIdAndWbsNo(projectId, wbsNo, token);
//
//        WbsUserResponse wbsUserResponse = modelMapper.map(wbsUserDTO, WbsUserResponse.class);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(wbsUserResponse);
//    }
}
