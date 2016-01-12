package org.sanelib.eboss.core.activities.user;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.user.UpdateUser;
import org.sanelib.eboss.core.dao.UserRepository;
import org.sanelib.eboss.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateUserDelegate implements JavaDelegate {

    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Update User called");

        UpdateUser updateUser = (UpdateUser) execution.getVariable("command");

        User user = userRepository.get(updateUser.getId());

        user.setUsername(updateUser.getUsername());
        user.setPassword(updateUser.getPassword());

        userRepository.update(user);

    }
}
