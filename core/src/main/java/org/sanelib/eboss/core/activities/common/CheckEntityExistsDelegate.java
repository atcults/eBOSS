package org.sanelib.eboss.core.activities.common;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.dao.UnitOfWork;
import org.sanelib.eboss.core.exceptions.AppException;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckEntityExistsDelegate implements JavaDelegate {

    @Autowired
    UnitOfWork unitOfWork;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking id for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        if(!(command instanceof  ProcessCommandWithId)){
            throw new RuntimeException("Command is invalid. It should implement proper interface.");
        }

        Long id = ((ProcessCommandWithId) command).getId();

        if(this.unitOfWork.getCurrentSession().get(((ProcessCommandWithId) command).getRootEntityClass(), id) == null){
            processError.addError("common.field.notexist", "id", "domain.common.id", String.valueOf(id));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
