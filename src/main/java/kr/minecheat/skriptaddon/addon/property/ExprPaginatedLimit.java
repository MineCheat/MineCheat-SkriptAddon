package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;

public class ExprPaginatedLimit extends SimplePropertyExpression<PaginatedGroupRecord, Number> {
    static {
        register(ExprPaginatedLimit.class, Number.class, "limit[s]", "paginatedgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "limit";
    }

    @Override
    public Number convert(PaginatedGroupRecord paginatedGroupRecord) {
        return paginatedGroupRecord.getLimit();
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
