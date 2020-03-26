package kr.minecheat.skriptaddon.addon.record;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.Group;
import kr.minecheat.skriptaddon.data.GroupRecord;
import kr.minecheat.skriptaddon.data.User;

public class ExprRecordWriter extends SimplePropertyExpression<GroupRecord, User> {
    static {
        register(ExprRecordWriter.class, User.class,"writer[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "writer";
    }

    @Override
    public User convert(GroupRecord group) {
        return group.getWriter();
    }

    @Override
    public Class<? extends User> getReturnType() {
        return User.class;
    }
}
