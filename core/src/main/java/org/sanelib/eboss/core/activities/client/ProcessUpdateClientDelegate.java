package org.sanelib.eboss.core.activities.client;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.client.UpdateClient;
import org.sanelib.eboss.core.dao.ClientRepository;
import org.sanelib.eboss.core.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateClientDelegate implements JavaDelegate {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Update Client called");

        UpdateClient updateClient = (UpdateClient) execution.getVariable("command");

        Client client = clientRepository.get(updateClient.getId());

        client.setClientId(updateClient.getClientId());
        client.setClientSecret(updateClient.getClientSecret());
        client.setClientName(updateClient.getClientName());
        client.setDescription(updateClient.getDescription());
        client.setClientUrl(updateClient.getClientUrl());
        client.setClientType(updateClient.getClientType());
        client.setScope(updateClient.getScope());
        client.setRedirectUri(updateClient.getRedirectUri());
        client.setRegdate(updateClient.getRegdate());

        clientRepository.update(client);
    }
}
