package org.sanelib.eboss.core.activities.client;


import org.junit.Test;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.client.UpdateClient;
import org.sanelib.eboss.core.domain.entity.Client;


import static org.junit.Assert.*;

public class UpdateClientProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testUpdateClientProcessTest() throws Throwable {

        Client client = new Client();
        client.setClientId("123");
        client.setClientSecret("secret");
        client.setClientName("WEB");
        client.setDescription("Description");
        client.setClientUrl("url");
        client.setClientType("type");
        client.setScope("Scope");
        client.setRedirectUri("redirect");
        client.setRegistrationDate(DateHelper.fromDateString("2005/04/01"));

        persist(client);

        UpdateClient updateClient = new UpdateClient();
        updateClient.setId(client.getId());
        updateClient.setClientId("new123");
        updateClient.setClientSecret("NewSecret");
        updateClient.setClientName("NewWEB");
        updateClient.setDescription("NewDescription");
        updateClient.setClientUrl("NewUrl");
        updateClient.setClientType("NewType");
        updateClient.setScope("NewScope");
        updateClient.setRedirectUri("NewRedirect");
        updateClient.setRegistrationDate(DateHelper.fromDateString("2006/02/02"));

        String result = execute(updateClient, ActivitiProcessConstants.Admin.UPDATE_CLIENT);

        assertNull(result);

        assertNotNull(updateClient);

        assertEquals("new123", updateClient.getClientId());
        assertEquals("NewSecret",updateClient.getClientSecret());
        assertEquals("NewWEB",updateClient.getClientName());
        assertEquals("NewDescription",updateClient.getDescription());
        assertEquals("NewUrl",updateClient.getClientUrl());
        assertEquals("NewType",updateClient.getClientType());
        assertEquals("NewScope",updateClient.getScope());
        assertEquals("NewRedirect",updateClient.getRedirectUri());
        assertEquals("2006/02/02",DateHelper.toDateString(updateClient.getRegistrationDate()));


    }

}
