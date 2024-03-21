package org.teamone.projecttemplate.command.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teamone.projecttemplate.command.dto.CommandTestcaseDTO;
import org.teamone.projecttemplate.command.service.CommandTestcaseService;
import org.teamone.projecttemplate.command.vo.CommandTestcaseRequest;
import org.teamone.projecttemplate.command.vo.CommandTestcaseResponse;
import org.teamone.projecttemplate.command.vo.CommandTestcaseSequenceRequest;

@RestController
@RequestMapping("/testcase")
public class CommandTestcaseController {
    private final CommandTestcaseService commandTestcaseService;

    private final ModelMapper modelMapper;

    @Autowired
    public CommandTestcaseController(CommandTestcaseService commandTestcaseService, ModelMapper modelMapper) {
        this.commandTestcaseService = commandTestcaseService;
        this.modelMapper = modelMapper;
    }

    /* 설명. 테스트케이스 추가(testNo 자동 설정) */
    @PostMapping("/add")
    public ResponseEntity<CommandTestcaseResponse> AddTestcaseByProjectId(@RequestBody CommandTestcaseRequest commandTestcaseRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        try {
            CommandTestcaseDTO commandTestcaseDTO = modelMapper.map(commandTestcaseRequest, CommandTestcaseDTO.class);
            commandTestcaseService.AddTestcaseByProjectId(commandTestcaseDTO);
            CommandTestcaseResponse commandTestcaseResponse = modelMapper.map(commandTestcaseDTO, CommandTestcaseResponse.class);

            return ResponseEntity.status(HttpStatus.CREATED).body(commandTestcaseResponse);
        } catch(IllegalArgumentException e) {
            return handleBadRequest(e);
        } catch (Exception e) {
            return handleInternalServerError(e);
        }
        
    }

    /* 설명. 테스트케이스 수정 */
    @PutMapping("/modify")
    public ResponseEntity<CommandTestcaseResponse> modifyTestcase(
            @RequestBody CommandTestcaseRequest commandTestcaseRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            CommandTestcaseDTO commandTestcaseDTO = modelMapper.map(commandTestcaseRequest, CommandTestcaseDTO.class);
            commandTestcaseService.modifyTestcase(commandTestcaseDTO);
            CommandTestcaseResponse commandTestcaseResponse = modelMapper.map(commandTestcaseDTO, CommandTestcaseResponse.class);

            return ResponseEntity.ok().body(commandTestcaseResponse);
        } catch (EntityNotFoundException e) {
            return handlerEntityNotFoundException(e);
        } catch(IllegalArgumentException e) {
            return handleBadRequest(e);
        } catch (Exception e ) {
            return handleInternalServerError(e);
        }
    }

    /* 설명. 테스트케이스 순서 수정 */
    /* 설명. 프로젝트 id와 TEST_NO로 정수(-1: 순서 위로, 1: 순서 아래로)만큼 순서 변경 */
    @PutMapping("/modify/sequence")
    public ResponseEntity<CommandTestcaseResponse> modifyTestcaseSequence(
            @RequestBody CommandTestcaseSequenceRequest commandTestcaseSequenceRequest){
        try {
            CommandTestcaseDTO commandTestcaseDTO = new CommandTestcaseDTO();

            commandTestcaseDTO.setProjectId(commandTestcaseSequenceRequest.getProjectId());
            commandTestcaseDTO.setTestNo(commandTestcaseSequenceRequest.getTestNo());
            int num = commandTestcaseSequenceRequest.getNum();

            /* 설명.  순서 변경 후 변경된 DTO 반환 */
            commandTestcaseDTO = commandTestcaseService.modifyTestcaseSequence(commandTestcaseDTO, num);

            CommandTestcaseResponse commandTestcaseResponse = modelMapper.map(commandTestcaseDTO, CommandTestcaseResponse.class);

            return ResponseEntity.ok().body(commandTestcaseResponse);
        }  catch (EntityNotFoundException e) {
            return handlerEntityNotFoundException(e);
        } catch(IllegalArgumentException e) {
            return handleBadRequest(e);
        } catch (Exception e ) {
            return handleInternalServerError(e);
        }
    }

    /* 설명. 프로젝트 id와 testNo로 테스트케이스 삭제 */
    @DeleteMapping("/remove/{projectId}/{testNo}")
    public ResponseEntity<String> removeTestcase(
            @PathVariable("projectId") int projectId,
            @PathVariable("testNo") int testNo) {
        try {
            commandTestcaseService.removeTestcase(projectId, testNo);

            return ResponseEntity.ok("테스트케이스가 삭제되었습니다.");
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("유효하지 않은 요청입니다." + e);
        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body("서버 오류: " + e);
        }
    }

    /* 설명. 해당 프로젝트의 테스트케이스 전체 삭제 */
    @DeleteMapping("/removeAll/{projectId}")
    public ResponseEntity<String> removeAllTestcase(@PathVariable("projectId") int projectId) {
        try {
            commandTestcaseService.removeAllTestcase(projectId);

            return ResponseEntity.ok("테스트케이스가 전체 삭제되었습니다.");
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("유효하지 않은 요청입니다." + e);
        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body("서버 오류: " + e);
        }
    }

    /* 설명. 예외 처리 메소드 */
    private ResponseEntity<CommandTestcaseResponse> handlerEntityNotFoundException(EntityNotFoundException e) {
        CommandTestcaseResponse commandTestcaseResponse = new CommandTestcaseResponse();
        commandTestcaseResponse.setMessage("해당 테스트케이스를 찾을 수 없습니다.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(commandTestcaseResponse);
    }

    private ResponseEntity<CommandTestcaseResponse> handleBadRequest(IllegalArgumentException e) {
        CommandTestcaseResponse commandTestcaseResponse = new CommandTestcaseResponse();
        commandTestcaseResponse.setMessage("유효하지 않은 요청입니다." + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commandTestcaseResponse);
    }

    private ResponseEntity<CommandTestcaseResponse> handleInternalServerError(Exception e) {
        CommandTestcaseResponse commandTestcaseResponse = new CommandTestcaseResponse();
        commandTestcaseResponse.setMessage("서버에서 오류 발생: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(commandTestcaseResponse);
    }

}
