package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.Group;

public class ExprGroupId extends SimplePropertyExpression<Group, Number> {
    static {
        register(ExprGroupId.class, Number.class,"id[s]", "minecheatgroups");
    }

    @Override
    protected String getPropertyName() {
        return "id";
    }

    @Override
    public Number convert(Group group) {
        return group.getId() ;
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
