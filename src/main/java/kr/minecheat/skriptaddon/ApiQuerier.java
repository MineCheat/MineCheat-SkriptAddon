package kr.minecheat.skriptaddon;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.minecheat.skriptaddon.data.AccessToken;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecordResponseData;
import lombok.Data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.UUID;

public class ApiQuerier {
    public static final String API_BaseURL = "http://minecheat.kr:8080/";

    public static AccessToken authenticate(String clientId, String clientSecret) throws IOException {
        String authorizationHeaderCredentials = clientId + ":" + clientSecret;
        String base64d = Base64.getEncoder().encodeToString(authorizationHeaderCredentials.getBytes());

        URL tokenURL = new URL(API_BaseURL+"oauth/token");
        HttpURLConnection huc = (HttpURLConnection) tokenURL.openConnection();
        huc.setRequestMethod("POST");
        huc.setRequestProperty("Accept", "application/json");
        huc.setRequestProperty("Authorization", "Basic "+base64d);
        huc.setDoInput(true);
        huc.setDoOutput(true);
        huc.getOutputStream().write("grant_type=client_credentials&scope=scope".getBytes());


        if (huc.getResponseCode() != 200) throw new RuntimeException("Client Data not valid :: "+clientId+" and "+clientSecret);

        ObjectMapper objectMapper = MineCheatAddon.getObjectMapper();
        AccessToken accessToken = objectMapper.readValue(huc.getInputStream(), AccessToken.class);

        return accessToken;
    }
    public static PaginatedGroupRecordResponseData queryByName(AccessToken accessToken, int page, int limit, String username) throws IOException {
        String authHeader = "Bearer " +accessToken.getAccess_token();

        URL tokenURL = new URL(API_BaseURL+"api/records/name?page="+page+"&limit="+limit+"&username="+ URLEncoder.encode(username, "UTF-8"));
        HttpURLConnection huc = (HttpURLConnection) tokenURL.openConnection();
        huc.setRequestMethod("GET");
        huc.setRequestProperty("Accept", "application/json");
        huc.setRequestProperty("Authorization", authHeader);
        huc.setDoOutput(true);

        ObjectMapper objectMapper = MineCheatAddon.getObjectMapper();
        PaginatedGroupRecordResponseData paginatedGroupRecord = objectMapper.readValue(huc.getInputStream(), PaginatedGroupRecordResponseData.class);
        if (huc.getResponseCode() == 200) {
            paginatedGroupRecord.getData().setSearch(username);
            paginatedGroupRecord.getData().setSearchType(1);
        } else {
            throw new RuntimeException("error: "+huc.getResponseCode()+" / "+paginatedGroupRecord.getError());
        }

        return paginatedGroupRecord;
    }
    public static PaginatedGroupRecordResponseData queryByUUID(AccessToken accessToken, int page, int limit, UUID uid) throws IOException {
        String authHeader = "Bearer " +accessToken.getAccess_token();

        URL tokenURL = new URL(API_BaseURL+"api/records/uuid?page="+page+"&limit="+limit+"&uuid="+uid.toString());
        HttpURLConnection huc = (HttpURLConnection) tokenURL.openConnection();
        huc.setRequestMethod("GET");
        huc.setRequestProperty("Accept", "application/json");
        huc.setRequestProperty("Authorization", authHeader);
        huc.setDoOutput(true);

        ObjectMapper objectMapper = MineCheatAddon.getObjectMapper();
        PaginatedGroupRecordResponseData paginatedGroupRecord = objectMapper.readValue(huc.getInputStream(), PaginatedGroupRecordResponseData.class);
        if (huc.getResponseCode() == 200) {
            paginatedGroupRecord.getData().setSearch(uid.toString());
            paginatedGroupRecord.getData().setSearchType(2);
        } else {
            throw new RuntimeException("error: "+huc.getResponseCode()+" / "+paginatedGroupRecord.getError());
        }

        return paginatedGroupRecord;
    }
}
