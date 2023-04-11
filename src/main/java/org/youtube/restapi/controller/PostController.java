package org.youtube.restapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youtube.restapi.data.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/post-api")
public class PostController {

    @PostMapping(value = "default")
    public String postMethod() {
        return "Hello world!";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, String> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue());
        });

        return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO dto) {
        return dto.toString();
    }
}
