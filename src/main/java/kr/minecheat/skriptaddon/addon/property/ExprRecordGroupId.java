package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.GroupRecord;

public class ExprRecordGroupId extends SimplePropertyExpression<GroupRecord, Number> {
    static {
        register(ExprRecordGroupId.class, Number.class,"groupid[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "groupid";
    }

    @Override
    public Number convert(GroupRecord group) {
        return group.getGroupId();
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
