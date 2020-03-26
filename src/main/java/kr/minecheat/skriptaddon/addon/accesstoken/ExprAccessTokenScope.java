package kr.minecheat.skriptaddon.addon.accesstoken;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.AccessToken;

public class ExprAccessTokenScope extends SimplePropertyExpression<AccessToken, String> {
    static {
        register(ExprAccessTokenScope.class, String.class,"scope[s]", "accesstokens");
    }

    @Override
    protected String getPropertyName() {
        return "scope";
    }

    @Override
    public String convert(AccessToken group) {
        return group.getScope();
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
