package kr.minecheat.skriptaddon.addon.user;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.User;

public class ExprUserEmail extends SimplePropertyExpression<User, String> {
    static {
        register(ExprUserEmail.class, String.class,"public email[s]", "minecheatusers");
    }

    @Override
    protected String getPropertyName() {
        return "public email";
    }

    @Override
    public String convert(User user) {
        return user.getPublicized_email() == null ? "non-public" : user.getPublicized_email() ;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
