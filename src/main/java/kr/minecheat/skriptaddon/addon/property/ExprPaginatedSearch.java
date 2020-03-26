package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;

public class ExprPaginatedSearch extends SimplePropertyExpression<PaginatedGroupRecord, String> {
    static {
        register(ExprPaginatedSearch.class, String.class, "search[s]", "paginatedgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "search";
    }

    @Override
    public String convert(PaginatedGroupRecord paginatedGroupRecord) {
        return paginatedGroupRecord.getSearch();
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
