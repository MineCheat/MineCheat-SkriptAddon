package kr.minecheat.skriptaddon.addon.group;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.Group;

public class ExprGroupDescription extends SimplePropertyExpression<Group, String> {
    static {
        register(ExprGroupDescription.class, String.class,"description[s]", "minecheatgroups");
    }

    @Override
    protected String getPropertyName() {
        return "description";
    }

    @Override
    public String convert(Group group) {
        return group.getDescription() ;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
