package kr.minecheat.skriptaddon.data;

import lombok.Data;

@Data
public class Group {
    private long id;
    private String name;
    private String description;
    private boolean hidden;
}
