package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.User;

public class ExprUserNickName extends SimplePropertyExpression<User, String> {
    static {
        register(ExprUserNickName.class, String.class,"nickname[s]", "minecheatusers");
    }

    @Override
    protected String getPropertyName() {
        return "nickname";
    }

    @Override
    public String convert(User user) {
        return user.getNickname();
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
