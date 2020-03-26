package kr.minecheat.skriptaddon.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private long id;
    private String nickname;
    private String publicized_email;
    private String avatar;
    @JsonProperty("minecraftUUID")
    private UUID minecraft;
}
