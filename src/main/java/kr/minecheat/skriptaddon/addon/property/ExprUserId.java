package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.User;

public class ExprUserId extends SimplePropertyExpression<User, Number> {
    static {
        register(ExprUserId.class, Number.class,"id[s]", "minecheatusers");
    }

    @Override
    protected String getPropertyName() {
        return "id";
    }

    @Override
    public Number convert(User user) {
        return user.getId();
    }

    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }
}
