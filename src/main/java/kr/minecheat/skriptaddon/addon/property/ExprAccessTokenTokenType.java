package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import kr.minecheat.skriptaddon.data.AccessToken;

public class ExprAccessTokenTokenType extends SimplePropertyExpression<AccessToken, String> {
    static {
        register(ExprAccessTokenTokenType.class, String.class,"[token]type[s]", "accesstokens");
    }

    @Override
    protected String getPropertyName() {
        return "type";
    }

    @Override
    public String convert(AccessToken group) {
        return group.getToken_type() ;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }
}
