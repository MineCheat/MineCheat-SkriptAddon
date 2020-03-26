package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.Skript;
import ch.njol.skript.expressions.base.PropertyExpression;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import kr.minecheat.skriptaddon.addon.ExprRequestNickname;
import kr.minecheat.skriptaddon.data.GroupRecord;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;

public class ExprPaginatedRecords extends SimpleExpression<GroupRecord> {

    static {
        Skript.registerExpression(ExprPaginatedRecords.class, GroupRecord.class, ExpressionType.COMBINED,
                "records of %paginatedgrouprecords%", "%paginatedgrouprecords%'[s] records");
    }

    private Expression<PaginatedGroupRecord> paginatedGroupRecords;


    @Override
    protected GroupRecord[] get(Event event) {
        List<GroupRecord> records = new ArrayList<>();
        PaginatedGroupRecord[] records2 = paginatedGroupRecords.getAll(event);
        for (PaginatedGroupRecord paginatedGroupRecord:records2) {
            records.addAll(paginatedGroupRecord.getItems());
        }
        return records.toArray(new GroupRecord[0]);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public Class<? extends GroupRecord> getReturnType() {
        return GroupRecord.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "records of paginated group record" + paginatedGroupRecords.toString(event, b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.paginatedGroupRecords = (Expression<PaginatedGroupRecord>) expressions[0];
        return true;
    }
}
