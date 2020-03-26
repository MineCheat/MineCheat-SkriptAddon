package kr.minecheat.skriptaddon.addon.group;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.Group;

public class ExprGroupName extends SimplePropertyExpression<Group, String> {
    static {
        register(ExprGroupName.class, String.class,"name[s]", "minecheatgroups");
    }

    @Override
    protected String getPropertyName() {
        return "name";
    }

    @Override
    public String convert(Group group) {
        return group.getName() ;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
