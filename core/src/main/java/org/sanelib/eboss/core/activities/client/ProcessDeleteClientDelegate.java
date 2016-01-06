package org.sanelib.eboss.core.activities.client;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.client.DeleteClient;
import org.sanelib.eboss.core.dao.ClientRepository;
import org.sanelib.eboss.core.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteClientDelegate implements JavaDelegate {

    @Autowired
    ClientRepository clientRepository;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Client Delete called");

        DeleteClient deleteClient = (DeleteClient) execution.getVariable("command");
        Client client = this.clientRepository.load(deleteClient.getId());
        clientRepository.remove(client);
    }
}
