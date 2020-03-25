package kr.minecheat.skriptaddon.data;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private long id;
    private String nickname;
    private String publicized_email;
    private String avatar;
    private UUID minecraft;
}
