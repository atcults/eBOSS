package org.sanelib.eboss.core.activities.client;


import org.junit.Test;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.domain.entity.Client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class AddClientProcessTest extends EntityIntegrationTestBase {

    @Test
    public void addClientProcessTest() throws Throwable {

        AddClient addClient = new AddClient();
        addClient.setClientId("123");
        addClient.setClientSecret("secret");
        addClient.setClientName("WEB");
        addClient.setDescription("Description");
        addClient.setClientUrl("url");
        addClient.setClientType("type");
        addClient.setScope("Scope");
        addClient.setRedirectUri("redirect");
        addClient.setRegistrationDate(DateHelper.fromDateString("2005/04/01"));

        String result = execute(addClient, ActivitiProcessConstants.Admin.ADD_CLIENT);

        assertNotNull(result);
        assertTrue(RegularExpressionHelper.checkIdFormat(result));

        Long id = Long.parseLong(result);

        Client client = fetch(Client.class, id);

        assertNotNull(client);

        assertEquals(addClient.getClientSecret(), client.getClientSecret());
        assertEquals(addClient.getClientName(),client.getClientName());
        assertEquals(addClient.getDescription(),client.getDescription());
        assertEquals(addClient.getClientUrl(),client.getClientUrl());
        assertEquals(addClient.getClientType(),client.getClientType());
        assertEquals(addClient.getScope(),client.getScope());
        assertEquals(addClient.getRedirectUri(),client.getRedirectUri());
        assertEquals(addClient.getRegistrationDate(), client.getRegistrationDate());

    }

}
