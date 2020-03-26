package kr.minecheat.skriptaddon.data;

import lombok.Data;

@Data
public class PaginatedGroupRecordResponseData {
    private String status;
    private String error;
    private PaginatedGroupRecord data;
}
