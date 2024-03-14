package org.teamone.tempository.project.query.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.teamone.tempository.project.query.vo.ResponseUser;

import java.util.List;

@FeignClient(name="issue", url="localhost:8000")
public interface ProjectIssueClient {

    @GetMapping("issue/{projectId}")
    List<ResponseUser> findProjectIssue(@PathVariable("projectId") String projectId
            , @RequestHeader("Authorization") String token);


}
