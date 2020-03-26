package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.GroupRecord;

public class ExprRecordUUID extends SimplePropertyExpression<GroupRecord, String> {
    static {
        register(ExprRecordUUID.class, String.class,"uuid[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "uuid";
    }

    @Override
    public String convert(GroupRecord group) {
        return group.getUuid() == null ? "" : group.getUuid().toString();
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
