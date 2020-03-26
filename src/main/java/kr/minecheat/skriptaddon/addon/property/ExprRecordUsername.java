package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.GroupRecord;

public class ExprRecordUsername extends SimplePropertyExpression<GroupRecord, String> {
    static {
        register(ExprRecordUsername.class, String.class,"username[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "username";
    }

    @Override
    public String convert(GroupRecord group) {
        return group.getUsername();
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
