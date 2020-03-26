package kr.minecheat.skriptaddon.addon;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import kr.minecheat.skriptaddon.ApiQuerier;
import kr.minecheat.skriptaddon.data.AccessToken;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecordResponseData;
import org.bukkit.event.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExprRequestNickname extends SimpleExpression<PaginatedGroupRecord> {

    static {
        Skript.registerExpression(ExprRequestNickname.class, PaginatedGroupRecord.class, ExpressionType.COMBINED,
                "retrieve MineCheat records with accessToken %accesstoken% and nickname %string% and page %number% limit %number%");
    }

    private Expression<AccessToken> accessToken;
    private Expression<String> nickname;
    private Expression<Number> page;
    private Expression<Number> limit;


    @Override
    protected PaginatedGroupRecord[] get(Event event) {
        AccessToken accessToken = this.accessToken.getSingle(event);
        int page = this.page.getSingle(event).intValue();
        int limit = this.limit.getSingle(event).intValue();
        String[] names = this.nickname.getAll(event);
        List<PaginatedGroupRecord> pgrs = new ArrayList<>();
        for (String name: names) {
            try {
                PaginatedGroupRecordResponseData pgr = ApiQuerier.queryByName(accessToken, page, limit, name);
                if (pgr.getStatus().equals("SUCCESS"))
                    pgrs.add(pgr.getData());
            } catch (IOException e) {
                e.printStackTrace();;
            }
        }
        return pgrs.toArray(new PaginatedGroupRecord[0]);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public Class<? extends PaginatedGroupRecord> getReturnType() {
        return PaginatedGroupRecord.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "MineCheat Record Request expression with accessToken "+accessToken.toString(event,b)+" and nickname "+nickname.toString(event, b)+" and page "+page.toString(event,b)+" limit "+limit.toString(event,b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        accessToken = (Expression<AccessToken>) expressions[0];
        nickname = (Expression<String>) expressions[1];
        page = (Expression<Number>) expressions[2];
        limit = (Expression<Number>) expressions[3];
        return true;
    }
}
