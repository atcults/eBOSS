package org.sanelib.eboss.core.activities.client;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.dao.ClientRepository;
import org.sanelib.eboss.core.domain.entity.Client;

public class ProcessAddClientDelegateTest {

    ClientRepository clientRepositoryMock;

    ProcessAddClientDelegate processAddClientDelegate;

    @Before
    public void setUp(){
        clientRepositoryMock= Mockito.mock(ClientRepository.class);
        processAddClientDelegate=new ProcessAddClientDelegate();
        processAddClientDelegate.clientRepository=clientRepositoryMock;
    }

    @Test
    public void testAddClientSuccessExecute() throws Exception{

        Mockito.doNothing().when(clientRepositoryMock).save(Mockito.isA(Client.class));

        AddClient addClientCommand = new AddClient();
        addClientCommand.setClientId("123");
        addClientCommand.setClientSecret("");
        addClientCommand.setClientName("Name");
        addClientCommand.setDescription("New Client");
        addClientCommand.setClientUrl("url");
        addClientCommand.setClientType("type");
        addClientCommand.setScope("");
        addClientCommand.setRedirectUri("");
        addClientCommand.setRegistrationDate(DateHelper.fromDateString("2007/02/01"));


        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(addClientCommand);

        processAddClientDelegate.execute(execution);

        Mockito.verify(execution).setVariable("result", 0L);
    }

}
