package org.sanelib.eboss.core.activities.client;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.dao.ClientRepository;
import org.sanelib.eboss.core.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddClientDelegate implements JavaDelegate {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Add Client called");

        AddClient command=(AddClient) execution.getVariable("command");

        Client entity=new Client();
        entity.setClientId(command.getClientId());
        entity.setClientSecret(command.getClientSecret());
        entity.setClientName(command.getClientName());
        entity.setDescription(command.getDescription());
        entity.setClientUrl(command.getClientUrl());
        entity.setClientType(command.getClientType());
        entity.setScope(command.getScope());
        entity.setRedirectUri(command.getRedirectUri());
        entity.setRegDate(command.getRegDate());

        clientRepository.save(entity);
        execution.setVariable("result", entity.getId());
    }
}
