package org.sanelib.eboss.core.activities.client;


import org.junit.Test;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.client.DeleteClient;
import org.sanelib.eboss.core.domain.entity.Client;

import static org.junit.Assert.assertNull;

public class DeleteClientProcessTest extends EntityIntegrationTestBase {

    @Test
    public void addClientProcessTest() throws Throwable {

        Client client = new Client();
        client.setClientId("123");
        client.setClientSecret("secret");
        client.setClientName("WEB");
        client.setDescription("Description");
        client.setClientUrl("url");
        client.setClientType("type");
        client.setScope("Scope");
        client.setRedirectUri("redirect");
        client.setRegdate(DateHelper.fromDateString("2005/04/01"));

        persist(client);

        DeleteClient deleteClient = new DeleteClient();
        deleteClient.setId(client.getId());

        String result = execute(deleteClient, ActivitiProcessConstants.Admin.DELETE_CLIENT);
        assertNull(result);

        Client deletedClient = fetch(Client.class,client.getId());
        assertNull(deletedClient);
    }

}
