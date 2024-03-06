package org.teamone.projecttemplate.command.controller;

import jakarta.ws.rs.Path;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandWbsDTO;
import org.teamone.projecttemplate.command.service.CommandWbsService;
import org.teamone.projecttemplate.command.vo.WbsRequest;
import org.teamone.projecttemplate.command.vo.WbsResponse;

@RestController
@RequestMapping("/wbs")
public class WbsController {

    private final CommandWbsService commandWbsService;

    private final Environment env;

    private final ModelMapper modelMapper;

    @Autowired
    public WbsController(CommandWbsService commandWbsService, Environment env, ModelMapper modelMapper) {
        this.commandWbsService = commandWbsService;
        this.env = env;
        this.modelMapper = modelMapper;
    }

    /* Environment 활용해 설정 값 불러오기(getProperty) */
    @GetMapping("/health_check")
    public String status() {
        return "Server at " + env.getProperty("local.server.port");
    }


    /* wbs 추가 */
    @PostMapping("/regist")
    public ResponseEntity<WbsResponse> registWbs(@RequestBody WbsRequest wbs) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // model mapper를 이용해서 받은 데이터 DTO 형식으로 변환
        CommandWbsDTO wbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);

        commandWbsService.registWbs(wbsDTO);

        // 받은 DTO를 wbsresponse라는 vo로 변환
        WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(wbsResponse);
    }

    /* wbs 수정 */
    @PutMapping("/modify/{projectId}/{wbsNo}")
    public ResponseEntity<WbsResponse> modifyWbs(@PathVariable("projectId") int projectId,
                                                 @PathVariable("wbsNo") int wbsNo,
                                                 @RequestBody WbsRequest wbs) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // model mapper를 이용해서 받은 데이터(WbsRequest - VO)를 DTO 형식으로 변환
        CommandWbsDTO wbsDTO = modelMapper.map(wbs, CommandWbsDTO.class);

        // 받은 DTO에서 수정할 대상의 projectId와 wbsNo 설정
        wbsDTO.setProjectId(projectId);
        wbsDTO.setWbsNo(wbsNo);

        // commandWbsDTO를 사용하여 wbs 엔티티 수정
        commandWbsService.modifyWbs(wbsDTO);

        // 수정된 WBS 엔티티(받은 DTO)를 wbsresponse라는 vo로 변환
        WbsResponse wbsResponse = modelMapper.map(wbsDTO, WbsResponse.class);

        // responseentity로 반환
        return ResponseEntity.ok().body(wbsResponse);

    }

    /* 프로젝트 ID, WBS NO에 해당하는 WBS 하나 삭제 */
    @DeleteMapping("/delete/{projectId}/{wbsNo}")
    public ResponseEntity<Void> deleteWbs(@PathVariable("projectId") int projectId,
                                          @PathVariable("wbsNo") int wbsNo) {
        commandWbsService.deleteWbs(projectId, wbsNo);
        return ResponseEntity.ok().build();
    }

    /* 프로젝트 ID에 해당하는 WBS 전체 삭제 */
    @DeleteMapping("delete/{projectId}")
    public ResponseEntity<Void> deleteAllWbsByProjectId(@PathVariable("projectId") int projectId) {

        commandWbsService.deleteAllWbsByProjectId(projectId);
        return ResponseEntity.ok().build();
    }
}