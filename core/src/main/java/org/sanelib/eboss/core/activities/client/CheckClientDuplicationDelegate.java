package org.sanelib.eboss.core.activities.client;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckClientDuplicationDelegate implements JavaDelegate {

    @Autowired
    ClientRepository clientRepository;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking client for duplication");

    }
}
