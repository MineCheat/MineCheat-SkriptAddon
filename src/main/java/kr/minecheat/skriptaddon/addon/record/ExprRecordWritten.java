package kr.minecheat.skriptaddon.addon.record;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.Group;
import kr.minecheat.skriptaddon.data.GroupRecord;

import java.util.Date;

public class ExprRecordWritten extends SimplePropertyExpression<GroupRecord, Date> {
    static {
        register(ExprRecordWritten.class, Date.class,"written[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "written";
    }

    @Override
    public Date convert(GroupRecord group) {
        return group.getWritten();
    }

    @Override
    public Class<? extends Date> getReturnType() {
        return Date.class;
    }
}
