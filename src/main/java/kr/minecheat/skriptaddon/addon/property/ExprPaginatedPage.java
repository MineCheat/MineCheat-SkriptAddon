package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;

public class ExprPaginatedPage extends SimplePropertyExpression<PaginatedGroupRecord, Number> {
    static {
        register(ExprPaginatedPage.class, Number.class, "page[s]", "paginatedgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "page";
    }

    @Override
    public Number convert(PaginatedGroupRecord paginatedGroupRecord) {
        return paginatedGroupRecord.getPage();
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
