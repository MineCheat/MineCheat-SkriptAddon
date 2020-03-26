package kr.minecheat.skriptaddon.addon;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import kr.minecheat.skriptaddon.ApiQuerier;
import kr.minecheat.skriptaddon.data.AccessToken;
import org.bukkit.event.Event;

import java.io.IOException;

public class ExprAccessToken extends SimpleExpression<AccessToken> {

    static {
        Skript.registerExpression(ExprAccessToken.class, AccessToken.class, ExpressionType.COMBINED, "retrieve MineCheat AccessToken with clientId %string% and clientSecret %string%");
    }


    private Expression<String> clientId;
    private Expression<String> clientSecret;

    @Override
    protected AccessToken[] get(Event event) {

        String clientId = this.clientId.getSingle(event);
        String clientSecret = this.clientSecret.getSingle(event);
        try {
            return new AccessToken[]{ApiQuerier.authenticate(clientId, clientSecret)};
        } catch (IOException e) {
            e.printStackTrace();
            return new AccessToken[0];
        }
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends AccessToken> getReturnType() {
        return AccessToken.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "MineCheat AccessToken expression with clientId expr: "+clientId.toString(event, b)+" and clientSecret expr: "+clientSecret.toString(event, b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        clientId = (Expression<String>) expressions[0];
        clientSecret = (Expression<String>) expressions[1];
        return true;
    }
}
