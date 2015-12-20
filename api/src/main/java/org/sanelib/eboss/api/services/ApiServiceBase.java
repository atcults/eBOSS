package org.sanelib.eboss.api.services;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.sanelib.eboss.api.dto.BaseDTO;
import org.sanelib.eboss.core.dao.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiServiceBase {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    UnitOfWork unitOfWork;

    protected String execute(BaseDTO dto, String processKey) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("dto", dto);
        String response = null;
        try {
            unitOfWork.begin();
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(processKey, variables);
            Map<String, Object> processedVariables = instance.getProcessVariables();
            if(processedVariables.containsKey("result")){
                response = processedVariables.get("result").toString();
            }
            System.out.println(instance.getId());
            unitOfWork.commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            unitOfWork.rollback();
        }

        return response;
    }

}
