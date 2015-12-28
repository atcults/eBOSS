package org.sanelib.eboss.api.services;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.BaseDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.dao.UnitOfWork;
import org.sanelib.eboss.core.exceptions.AppException;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiServiceBase {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    UnitOfWork unitOfWork;

    @Autowired
    ApplicationContext ctx;

    @Autowired
    ProcessError processError;

    @SuppressWarnings("unchecked")
    protected String execute(BaseDTO dto, String processKey) throws Exception {

        String response = null;

        try {
            String converterName = processKey + "Converter";

            DtoToCommandConverter converter = (DtoToCommandConverter) ctx.getBean(converterName);

            ProcessCommand command = converter.convert(dto);

            if(!processError.isValid()){
                throw new AppException(processError);
            }

            Map<String, Object> variables = new HashMap<>();
            variables.put("command", command);

            String processName = processKey + "Process";

            unitOfWork.begin();
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(processName, variables);
            Map<String, VariableInstanceEntity> variableInstances = ((ExecutionEntity) instance).getVariableInstances();
            if(variableInstances.containsKey("result")){
                response = variableInstances.get("result").getValue().toString();
            }
            System.out.println(instance.getId());
            unitOfWork.commit();
        } catch (Exception exception){
            unitOfWork.rollback();
            throw exception;
        }

        return response;
    }

}
