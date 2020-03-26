package kr.minecheat.skriptaddon.addon.user;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.User;

public class ExprUserAvatar extends SimplePropertyExpression<User, String> {
    static {
        register(ExprUserAvatar.class, String.class,"avatar[s] [file[s][name[s]]]", "minecheatusers");
    }

    @Override
    protected String getPropertyName() {
        return "avatar";
    }

    @Override
    public String convert(User user) {
        return user.getAvatar() ;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
