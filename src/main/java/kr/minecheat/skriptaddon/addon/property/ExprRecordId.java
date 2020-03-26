package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.GroupRecord;

public class ExprRecordId extends SimplePropertyExpression<GroupRecord, Number> {
    static {
        register(ExprRecordId.class, Number.class,"[record]id[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "id";
    }

    @Override
    public Number convert(GroupRecord group) {
        return group.getRecordId();
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
