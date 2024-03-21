package org.teamone.tempository.project.query.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.teamone.tempository.project.query.vo.ResponseRequirement;
import org.teamone.tempository.project.query.vo.ResponseUser;

import java.util.List;

@FeignClient(name="requirement", url="localhost:8000")
public interface ProjectRequirementClient {
    @GetMapping("requirement/find/{projectId}")
    List<ResponseRequirement> findRequirement(@PathVariable("projectId") String projectId
            , @RequestHeader("Authorization") String token);
}
