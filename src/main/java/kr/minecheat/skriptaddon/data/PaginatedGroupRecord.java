package kr.minecheat.skriptaddon.data;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedGroupRecord<GroupRecord> {
    private int page;
    private int limit;
    private int totalPages;

    private List<GroupRecord> items;
}
