package kr.minecheat.skriptaddon.data;

import lombok.Data;

@Data
public class AccessToken {
    private String token_type;
    private String access_token;
    private String scope;
}
