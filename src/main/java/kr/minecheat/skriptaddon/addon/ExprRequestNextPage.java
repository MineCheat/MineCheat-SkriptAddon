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
import java.util.UUID;

public class ExprRequestNextPage extends SimpleExpression<PaginatedGroupRecord> {

    static {
        Skript.registerExpression(ExprRequestNextPage.class, PaginatedGroupRecord.class, ExpressionType.COMBINED,
                "retrieve next MineCheat records with accessToken %accesstoken% and paginatedGroupRecord %paginatedgrouprecord%");
    }

    private Expression<AccessToken> accessToken;
    private Expression<PaginatedGroupRecord> previousRecords;


    @Override
    protected PaginatedGroupRecord[] get(Event event) {
        AccessToken accessToken = this.accessToken.getSingle(event);
        PaginatedGroupRecord[] prevs = this.previousRecords.getAll(event);
        List<PaginatedGroupRecord> pgrs = new ArrayList<>();
        for (PaginatedGroupRecord prev: prevs) {
            try {
                if (prev.getSearchType() == 1) {
                    PaginatedGroupRecordResponseData pgr = ApiQuerier.queryByName(accessToken, prev.getPage() + 1, prev.getLimit(), prev.getSearch());
                    if (pgr.getStatus().equals("SUCCESS"))
                        pgrs.add(pgr.getData());
                } else if (prev.getSearchType() == 2) {
                    PaginatedGroupRecordResponseData pgr = ApiQuerier.queryByUUID(accessToken, prev.getPage() + 1, prev.getLimit(), UUID.fromString(prev.getSearch()));
                    if (pgr.getStatus().equals("SUCCESS"))
                        pgrs.add(pgr.getData());
                }
            } catch (Exception e) {
                e.printStackTrace();
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
        return "MineCheat Record Request expression with accessToken "+accessToken.toString(event,b)+" and previous record "+previousRecords.toString(event, b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        accessToken = (Expression<AccessToken>) expressions[0];
        previousRecords = (Expression<PaginatedGroupRecord>) expressions[1];
        return true;
    }
}
