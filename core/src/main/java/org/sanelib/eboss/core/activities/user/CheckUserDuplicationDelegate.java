package org.sanelib.eboss.core.activities.user;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.user.AddUser;
import org.sanelib.eboss.core.commands.user.UpdateUser;
import org.sanelib.eboss.core.dao.UserRepository;
import org.sanelib.eboss.core.domain.entity.User;
import org.sanelib.eboss.core.exceptions.AppException;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CheckUserDuplicationDelegate implements JavaDelegate {

    @Autowired
    UserRepository userRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Checking User for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        Long existingUserId = (command instanceof UpdateUser) ? ((UpdateUser) command).getId() : null;

        //Username duplication check
        String userName = ((AddUser) command).getUsername();

        List<User> users = userRepository.findByColumnAndValue("username", userName);

        if(!users.isEmpty() && !Objects.equals(existingUserId, users.get(0).getId())){
            processError.addError("common.field.duplicate" , "username" , "domain.user.username" , userName);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
