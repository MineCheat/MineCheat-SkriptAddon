package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.AccessToken;

public class ExprAccessToken extends SimplePropertyExpression<AccessToken, String> {
    static {
        register(ExprAccessToken.class, String.class,"[access]token[s]", "accesstokens");
    }

    @Override
    protected String getPropertyName() {
        return "token";
    }

    @Override
    public String convert(AccessToken group) {
        return group.getAccess_token() ;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
