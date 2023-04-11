package org.youtube.restapi.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MemberDTO {
    private String name;
    private String email;
    private String organization;

}
