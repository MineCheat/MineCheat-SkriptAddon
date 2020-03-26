package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.Group;
import kr.minecheat.skriptaddon.data.GroupRecord;

public class ExprRecordGroup extends SimplePropertyExpression<GroupRecord, Group> {
    static {
        register(ExprRecordGroup.class, Group.class,"group[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "group";
    }

    @Override
    public Group convert(GroupRecord group) {
        return group.getGroup();
    }

    @Override
    public Class<? extends Group> getReturnType() {
        return Group.class;
    }
}
