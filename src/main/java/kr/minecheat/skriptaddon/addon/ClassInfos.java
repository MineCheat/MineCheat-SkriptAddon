package kr.minecheat.skriptaddon.addon;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;
import kr.minecheat.skriptaddon.data.*;

import java.io.NotSerializableException;
import java.io.StreamCorruptedException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ClassInfos {
    static {
        Classes.registerClass(new ClassInfo<>(AccessToken.class, "AccessToken")
                .user("accesstokens?")
                .name("AccessToken")
                .description("Represents AccessToken retrieved from MineCheat service")
                .defaultExpression(new EventValueExpression<AccessToken>(AccessToken.class))
                .parser(new Parser<AccessToken>() {

                    @Override
                    public String toString(AccessToken accessToken, int i) {
                        return toVariableNameString(accessToken);
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                    @Override
                    public String toVariableNameString(AccessToken accessToken) {
                        return "access_token:"+accessToken.getAccess_token()+",token_type:"+accessToken.getToken_type()+",scope:"+accessToken.getScope();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "access_token:[a-zA-Z0-9]+,token_type:.+,scope:.+";
                    }

                    @Override
                    public AccessToken parse(String s, ParseContext context) {
                        return null;
                    }
                })
                .serializer(new Serializer<AccessToken>() {
                    @Override
                    public Fields serialize(AccessToken accessToken) throws NotSerializableException {
                        Fields fields = new Fields();
                        fields.putPrimitive("access_token", accessToken.getAccess_token());
                        fields.putPrimitive("token_type", accessToken.getToken_type());
                        fields.putPrimitive("scope", accessToken.getScope());
                        return fields;
                    }


                    @Override
                    public AccessToken deserialize(Fields fields) throws StreamCorruptedException {
                        AccessToken accessToken = new AccessToken();
                        accessToken.setAccess_token(fields.getAndRemovePrimitive("access_token", String.class));
                        accessToken.setScope(fields.getAndRemovePrimitive("scope", String.class));
                        accessToken.setToken_type(fields.getAndRemovePrimitive("token_type", String.class));
                        return null;
                    }

                    @Override
                    public void deserialize(AccessToken raid, Fields fields) throws StreamCorruptedException, NotSerializableException {
                        assert false;
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return false;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }
                })
        );
        Classes.registerClass(new ClassInfo<>(User.class, "MineCheatUser")
                .user("minecheatusers?")
                .name("MineCheatUser")
                .description("Represents a User on MineCheat service")
                .defaultExpression(new EventValueExpression<User>(User.class))
                .parser(new Parser<User>() {
                    @Override
                    public String toString(User accessToken, int i) {
                        return toVariableNameString(accessToken);
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                    @Override
                    public String toVariableNameString(User user) {
                        return "id:"+user.getId()+",nickname:"+user.getNickname()+",minecraft:"+user.getMinecraft();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "id:[0-9]+,nickname:.+,minecraft:.+";
                    }

                    @Override
                    public User parse(String s, ParseContext context) {
                        return null;
                    }
                })
                .serializer(new Serializer<User>() {
                    @Override
                    public Fields serialize(User user) throws NotSerializableException {
                        Fields fields = new Fields();
                        fields.putPrimitive("id", user.getId());
                        fields.putPrimitive("nickname",user.getNickname());
                        fields.putPrimitive("public_email",user.getPublicized_email());
                        fields.putPrimitive("minecraft",user.getMinecraft()+"");
                        fields.putPrimitive("avatar", user.getAvatar());
                        return fields;
                    }

                    @Override
                    public User deserialize(Fields fields) throws StreamCorruptedException {
                        User user = new User();
                        user.setId(fields.getAndRemovePrimitive("id", Long.class));
                        user.setNickname(fields.getAndRemovePrimitive("nickname", String.class));
                        user.setPublicized_email(fields.getAndRemovePrimitive("public_email", String.class));
                        String minecraft = fields.getAndRemovePrimitive("minecraft", String.class);
                        user.setMinecraft("null".equals(minecraft) ? null : UUID.fromString(minecraft));
                        user.setAvatar(fields.getAndRemovePrimitive("avatar", String.class));
                        return null;
                    }

                    @Override
                    public void deserialize(User raid, Fields fields) throws StreamCorruptedException, NotSerializableException {
                        assert false;
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return false;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }
                })
        );
        Classes.registerClass(new ClassInfo<>(Group.class, "MineCheatGroup")
                .user("minecheatgroups?")
                .name("MineCheatGroup")
                .description("Represents a Group on MineCheat service")
                .defaultExpression(new EventValueExpression<Group>(Group.class))
                .parser(new Parser<Group>() {
                    @Override
                    public String toString(Group group, int i) {
                        return toVariableNameString(group);
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                    @Override
                    public String toVariableNameString(Group group) {
                        return "id:"+group.getId()+",name:"+group.getName()+",description:"+group.getDescription();
                    }

                    @Override
                    public Group parse(String s, ParseContext context) {
                        return null;
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "id:[0-9]+,name:.+,description:.+";
                    }
                })
                .serializer(new Serializer<Group>() {
                    @Override
                    public Fields serialize(Group group) throws NotSerializableException {
                        Fields fields = new Fields();
                        fields.putPrimitive("id", group.getId());
                        fields.putPrimitive("name", group.getName());
                        fields.putPrimitive("description", group.getDescription());
                        return fields;
                    }

                    @Override
                    public Group deserialize(Fields fields) throws StreamCorruptedException {
                        Group g = new Group();
                        g.setId(fields.getAndRemovePrimitive("id", Long.class));
                        g.setName(fields.getAndRemovePrimitive("name", String.class));
                        g.setDescription(fields.getAndRemovePrimitive("description", String.class));
                        return g;
                    }

                    @Override
                    public void deserialize(Group group, Fields fields) throws StreamCorruptedException, NotSerializableException {
                        assert false;
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return false;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }
                })
        );
        Classes.registerClass(new ClassInfo<>(GroupRecord.class, "MineCheatGroupRecord")
                .user("minecheatgrouprecords?")
                .name("MineCheatGroupRecord")
                .description("Represents a Record on a Group on MineCheat service")
                .defaultExpression(new EventValueExpression<GroupRecord>(GroupRecord.class))
                .parser(new Parser<GroupRecord>() {

                    @Override
                    public String toString(GroupRecord groupRecord, int i) {
                        return toVariableNameString(groupRecord);
                    }

                    @Override
                    public String toVariableNameString(GroupRecord groupRecord) {
                        return "groupId:"+groupRecord.getGroupId()+",recordId:"+groupRecord.getRecordId()+",username:"+groupRecord.getUsername()+",uuid:"+groupRecord.getUuid()+",shortDescription:"+groupRecord.getShortDescription()+",severeness:"+groupRecord.getSevereness();
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                    @Override
                    public String getVariableNamePattern() {
                        return "groupId:[0-9]+,recordId:[0-9]+,nickname:.+,uuid:.+,shortDescription:.+,severeness:[0-9]+";
                    }

                    @Override
                    public GroupRecord parse(String s, ParseContext context) {
                        return null;
                    }
                })
                .serializer(new Serializer<GroupRecord>() {
                    @Override
                    public Fields serialize(GroupRecord groupRecord) throws NotSerializableException {
                        Fields fields = new Fields();
                        fields.putObject("group",groupRecord.getGroup());
                        fields.putPrimitive("recordId",groupRecord.getRecordId());
                        fields.putPrimitive("username",groupRecord.getUsername());
                        fields.putPrimitive("uuid", groupRecord.getUuid()+"");
                        fields.putPrimitive("shortDescription", groupRecord.getShortDescription());
                        fields.putObject("writer", groupRecord.getWriter());
                        fields.putPrimitive("written", groupRecord.getWritten().getTime());
                        fields.putPrimitive("severeness", groupRecord.getSevereness());
                        return fields;
                    }

                    @Override
                    public GroupRecord deserialize(Fields fields) throws StreamCorruptedException {
                        GroupRecord groupRecord = new GroupRecord();
                        groupRecord.setGroup(fields.getAndRemoveObject("group", Group.class));
                        groupRecord.setGroupId(groupRecord.getGroup().getId());
                        groupRecord.setRecordId(fields.getAndRemovePrimitive("recordId", Long.class));
                        groupRecord.setUsername(fields.getAndRemovePrimitive("username", String.class));
                        String uuid = fields.getAndRemovePrimitive("uuid", String.class);
                        groupRecord.setUuid("null".equals(uuid) ? null : UUID.fromString(uuid));
                        groupRecord.setShortDescription(fields.getAndRemovePrimitive("shortDescription", String.class));
                        groupRecord.setWriter(fields.getAndRemoveObject("writer", User.class));
                        groupRecord.setWritten(new Date(fields.getAndRemovePrimitive("written", Long.class)));
                        groupRecord.setSevereness(fields.getAndRemovePrimitive("severeness", Integer.class));
                        return groupRecord;
                    }

                    @Override
                    public void deserialize(GroupRecord groupRecord, Fields fields) throws StreamCorruptedException, NotSerializableException {
                        assert false;
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return false;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }
                })
                .after("MineCheatGroup", "MineCheatUser")
        );
        Classes.registerClass(new ClassInfo<>(PaginatedGroupRecord.class, "PaginatedGroupRecords")
                .user("paginatedgrouprecords?")
                .name("PaginatedGroupRecord")
                .description("Represents a retrieved records from MineCheat service")
                .defaultExpression(new EventValueExpression<PaginatedGroupRecord>(PaginatedGroupRecord.class))
                .parser(new Parser<PaginatedGroupRecord>() {

                    @Override
                    public String toString(PaginatedGroupRecord groupRecord, int i) {
                        return toVariableNameString(groupRecord);
                    }

                    @Override
                    public String toVariableNameString(PaginatedGroupRecord groupRecord) {
                        return "page:"+groupRecord.getPage()+",limit:"+groupRecord.getLimit()+",totalPages:"+groupRecord.getTotalPages()+",items_size:"+groupRecord.getItems().size()+",search:"+groupRecord.getSearch();
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }
                    @Override
                    public String getVariableNamePattern() {
                        return "page:[0-9]+,limit:[0-9]+,totalPages:[0-9]+,items_size:[0-9]+,search:.+";
                    };
                    @Override
                    public PaginatedGroupRecord parse(String s, ParseContext context) {
                        return null;
                    }
                }).serializer(new Serializer<PaginatedGroupRecord>() {
                    @Override
                    public Fields serialize(PaginatedGroupRecord paginatedGroupRecord) throws NotSerializableException {
                        Fields fields = new Fields();
                        fields.putPrimitive("page", paginatedGroupRecord.getPage());
                        fields.putPrimitive("limit", paginatedGroupRecord.getLimit());
                        fields.putPrimitive("totalPages",paginatedGroupRecord.getTotalPages());
                        fields.putObject("items",paginatedGroupRecord.getItems());
                        fields.putPrimitive("search", paginatedGroupRecord.getSearch());
                        fields.putPrimitive("searchType", paginatedGroupRecord.getSearchType());
                        return fields;
                    }

                    public PaginatedGroupRecord deserialize(Fields fields) throws StreamCorruptedException {
                        PaginatedGroupRecord pgr = new PaginatedGroupRecord();
                        pgr.setPage(fields.getAndRemovePrimitive("page", Integer.class));
                        pgr.setLimit(fields.getAndRemovePrimitive("limit", Integer.class));
                        pgr.setTotalPages(fields.getAndRemovePrimitive("totalPages", Integer.class));
                        pgr.setItems(fields.getAndRemoveObject("items", List.class));
                        pgr.setSearch(fields.getAndRemovePrimitive("search", String.class));
                        pgr.setSearchType(fields.getAndRemovePrimitive("searchType", Integer.class));
                        return pgr;
                    }

                    @Override
                    public void deserialize(PaginatedGroupRecord paginatedGroupRecord, Fields fields) throws StreamCorruptedException, NotSerializableException {
                        assert false;
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return false;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }
                }).after("MineCheatGroupRecord")
        );
    }
}
