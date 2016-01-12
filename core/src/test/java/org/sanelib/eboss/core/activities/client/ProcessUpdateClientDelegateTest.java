package org.sanelib.eboss.core.activities.client;

import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.activities.employee.ProcessUpdateEmployeeDelegate;
import org.sanelib.eboss.core.commands.client.UpdateClient;
import org.sanelib.eboss.core.commands.employee.UpdateEmployee;
import org.sanelib.eboss.core.dao.ClientRepository;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Client;
import org.sanelib.eboss.core.domain.entity.Employee;

public class ProcessUpdateClientDelegateTest {

    ClientRepository clientRepositoryMock;

    ProcessUpdateClientDelegate processUpdateClientDelegate;

    @Before
    public void setUp(){
        clientRepositoryMock = Mockito.mock(ClientRepository.class);
        processUpdateClientDelegate = new ProcessUpdateClientDelegate();
        processUpdateClientDelegate.clientRepository = clientRepositoryMock;
    }

    @Test
    public void testAddClientSuccessExecute() throws Exception {

        Mockito.doNothing().when(clientRepositoryMock).save(Mockito.isA(Client.class));

        UpdateClient updateClient = new UpdateClient();
        updateClient.setClientId("new123");
        updateClient.setClientSecret("NewSecret");
        updateClient.setClientName("NewWEB");
        updateClient.setDescription("NewDescription");
        updateClient.setClientUrl("NewUrl");
        updateClient.setClientType("NewType");
        updateClient.setScope("NewScope");
        updateClient.setRedirectUri("NewRedirect");
        updateClient.setRegistrationDate(DateHelper.fromDateString("2006/02/02"));

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(updateClient);

      }

}
