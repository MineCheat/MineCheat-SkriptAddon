package kr.minecheat.skriptaddon.data;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedGroupRecord {
    private int page;
    private int limit;
    private int totalPages;

    /**
     * 1 for username
     * 2 for uuid
     */
    private int searchType;

    private String search;

    private List<GroupRecord> items;
}
