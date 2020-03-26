package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.GroupRecord;

public class ExprRecordShortDescription extends SimplePropertyExpression<GroupRecord, String> {
    static {
        register(ExprRecordShortDescription.class, String.class,"shortdescription[s]", "minecheatgrouprecords");
    }

    @Override
    protected String getPropertyName() {
        return "shortdescription";
    }

    @Override
    public String convert(GroupRecord group) {
        return group.getShortDescription();
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
