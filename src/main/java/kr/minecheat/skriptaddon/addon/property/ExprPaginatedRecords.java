package kr.minecheat.skriptaddon.addon.property;

import ch.njol.skript.expressions.base.PropertyExpression;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import kr.minecheat.skriptaddon.data.GroupRecord;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;

public class ExprPaginatedRecords extends PropertyExpression<PaginatedGroupRecord, GroupRecord> {
    static {
        register(ExprPaginatedRecords.class, GroupRecord.class, "records", "paginatedgrouprecords");
    }

    @Override
    public Class<? extends GroupRecord> getReturnType() {
        return GroupRecord.class;
    }

    @Override
    protected GroupRecord[] get(Event event, PaginatedGroupRecord[] paginatedGroupRecords) {
        List<GroupRecord> records = new ArrayList<>();
        for (PaginatedGroupRecord paginatedGroupRecord:paginatedGroupRecords) {
            records.addAll(paginatedGroupRecord.getItems());
        }
        return records.toArray(new GroupRecord[0]);
    }


    @SuppressWarnings({"unchecked", "null"})
    @Override
    public boolean init(final Expression<?>[] exprs, final int matchedPattern, final Kleenean isDelayed, final SkriptParser.ParseResult parseResult) {
        setExpr((Expression<? extends PaginatedGroupRecord>) exprs[0]);
        return true;
    }

    @Override
    public String toString(final Event e, final boolean debug) {
        return "the records of " + getExpr().toString(e, debug);
    }

}
