package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;

public class ExprPaginatedSearchType extends SimplePropertyExpression<PaginatedGroupRecord, String> {
    static {
        register(ExprPaginatedSearchType.class, String.class, "searchtype[s]", "paginatedgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "searchtype";
    }

    @Override
    public String convert(PaginatedGroupRecord paginatedGroupRecord) {
        return paginatedGroupRecord.getSearchType() == 1 ? "username" : paginatedGroupRecord.getSearchType() == 2 ? "uuid" : "unknown";
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
