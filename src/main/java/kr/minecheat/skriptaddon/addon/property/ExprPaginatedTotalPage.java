package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;

public class ExprPaginatedTotalPage extends SimplePropertyExpression<PaginatedGroupRecord, Number> {
    static {
        register(ExprPaginatedTotalPage.class, Number.class, "totalpage[s]", "paginatedgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "totalpage";
    }

    @Override
    public Number convert(PaginatedGroupRecord paginatedGroupRecord) {
        return paginatedGroupRecord.getTotalPages();
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
