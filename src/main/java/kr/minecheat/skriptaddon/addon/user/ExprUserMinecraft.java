package kr.minecheat.skriptaddon.addon.user;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.User;

public class ExprUserMinecraft extends SimplePropertyExpression<User, String> {
    static {
        register(ExprUserMinecraft.class, String.class,"minecraft[s] [uuid[s]]", "minecheatusers");
    }

    @Override
    protected String getPropertyName() {
        return "minecraft";
    }

    @Override
    public String convert(User user) {
        return user.getMinecraft() == null ? "not integrated" : user.getMinecraft().toString() ;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
