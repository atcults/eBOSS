package org.sanelib.eboss.core.activities.user;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.user.DeleteUser;
import org.sanelib.eboss.core.dao.UserRepository;
import org.sanelib.eboss.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteUserDelegate implements JavaDelegate {

    @Autowired
    UserRepository userRepository;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process User Delete called");

        DeleteUser deleteUser = (DeleteUser) execution.getVariable("command");
        User user = this.userRepository.load(deleteUser.getId());

        userRepository.remove(user);
    }
}
