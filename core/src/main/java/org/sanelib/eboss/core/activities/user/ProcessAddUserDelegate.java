package org.sanelib.eboss.core.activities.user;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.user.AddUser;
import org.sanelib.eboss.core.dao.UserRepository;
import org.sanelib.eboss.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddUserDelegate implements JavaDelegate {

    @Autowired
    UserRepository userRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add User called");

        AddUser command = (AddUser) execution.getVariable("command");

        User entity = new User();

        entity.setUsername(command.getUsername());
        entity.setPassword(command.getPassword());

        userRepository.save(entity);

        execution.setVariable("result", entity.getId());
	}
}
