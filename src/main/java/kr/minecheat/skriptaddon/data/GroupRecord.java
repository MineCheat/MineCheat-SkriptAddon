package kr.minecheat.skriptaddon.data;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class GroupRecord {
    private long recordId;
    private long groupId;
    private Group group;
    private String shortDescription;
    private String username;
    private UUID uuid;
    private Date written;
    private User writer;
    private int severeness;
}
