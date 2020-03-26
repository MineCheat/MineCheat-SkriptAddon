package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.GroupRecord;

public class ExprRecordSevereness extends SimplePropertyExpression<GroupRecord, Number> {
    static {
        register(ExprRecordSevereness.class, Number.class,"severeness[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "severeness";
    }

    @Override
    public Number convert(GroupRecord group) {
        return group.getSevereness();
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
