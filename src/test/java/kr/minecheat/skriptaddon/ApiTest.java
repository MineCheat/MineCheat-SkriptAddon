package kr.minecheat.skriptaddon;

import kr.minecheat.skriptaddon.data.AccessToken;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecord;
import kr.minecheat.skriptaddon.data.PaginatedGroupRecordResponseData;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;

import static org.junit.Assert.*;

public class ApiTest {
    @Test
    public void QueryByName() throws IOException {
        AccessToken accessToken = ApiQuerier.authenticate("a38276b6-e389-4502-a665-cbe036ae9f5c", "XPLwUmX8VngOU6ldueKL6hYV9WNHD7L9");

        assertNotNull(accessToken);
        assertEquals("bearer", accessToken.getToken_type());

        PaginatedGroupRecordResponseData paginatedGroupRecord2 = ApiQuerier.queryByName(accessToken, 0, 20, "sdf");

        assertNotNull(paginatedGroupRecord2);
        assertEquals("SUCCESS", paginatedGroupRecord2.getStatus());
        PaginatedGroupRecord paginatedGroupRecord = paginatedGroupRecord2.getData();
        assertNotNull(paginatedGroupRecord);
        assertEquals(1, paginatedGroupRecord.getSearchType());
        assertEquals("sdf", paginatedGroupRecord.getSearch());
        assertEquals(0, paginatedGroupRecord.getPage());
        assertEquals(20, paginatedGroupRecord.getLimit());

        paginatedGroupRecord.getItems().forEach(gr -> {
            assertNotNull(gr.getGroup());
            assertNotNull(gr.getGroupId());
            assertNotNull(gr.getRecordId());
            assertNotNull(gr.getSevereness());
            assertNotNull(gr.getShortDescription());
            assertNotNull(gr.getWriter());
            assertNotNull(gr.getWritten());
            System.out.println(gr.getUsername() + " / " + gr.getUuid());
        });
    }
    @Test
    public void QueryByUUID() throws IOException {
        AccessToken accessToken = ApiQuerier.authenticate("a38276b6-e389-4502-a665-cbe036ae9f5c", "XPLwUmX8VngOU6ldueKL6hYV9WNHD7L9");

        assertNotNull(accessToken);
        assertEquals("bearer", accessToken.getToken_type());

        UUID uuid = UUID.fromString("a38276b6-e389-4502-a665-cbe036ae9f5c");

        PaginatedGroupRecordResponseData paginatedGroupRecord2 = ApiQuerier.queryByUUID(accessToken, 0, 20, uuid);

        assertNotNull(paginatedGroupRecord2);
        assertEquals("SUCCESS", paginatedGroupRecord2.getStatus());
        PaginatedGroupRecord paginatedGroupRecord = paginatedGroupRecord2.getData();
        assertNotNull(paginatedGroupRecord);
        assertEquals(2, paginatedGroupRecord.getSearchType());
        assertEquals(uuid.toString(), paginatedGroupRecord.getSearch());
        assertEquals(0, paginatedGroupRecord.getPage());
        assertEquals(20, paginatedGroupRecord.getLimit());

        paginatedGroupRecord.getItems().forEach(gr -> {
            assertNotNull(gr.getGroup());
            assertNotNull(gr.getGroupId());
            assertNotNull(gr.getRecordId());
            assertNotNull(gr.getSevereness());
            assertNotNull(gr.getShortDescription());
            assertNotNull(gr.getWriter());
            assertNotNull(gr.getWritten());
            System.out.println(gr.getUsername() + " / " + gr.getUuid());
        });
    }
}
