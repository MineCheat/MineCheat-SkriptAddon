package kr.minecheat.skriptaddon.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class GroupRecord {
    private long recordId;
    private long groupId;
    private Group group;
    @JsonProperty("briefDescription")
    private String shortDescription;
    private String username;
    private UUID uuid;
    @JsonProperty("date")
    private Date written;
    private User writer;
    private int severeness;
}
