package org.teamone.projecttemplate.query.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.teamone.projecttemplate.query.vo.UserResponse;

@FeignClient(name="user", url="localhost:8000")
public interface IssueServiceClient {

    @GetMapping("user/id/{id}")
    UserResponse getUserById(@PathVariable("id") int id, @RequestHeader("Authorization") String token);
}
