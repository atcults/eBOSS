package org.sanelib.eboss.api.converters.customer;

import org.sanelib.eboss.api.converters.ConverterHelper;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.customer.DeleteCustomer;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerConverter implements DtoToCommandConverter<CustomerDTO> {
    public ProcessCommand convert(CustomerDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        DeleteCustomer command=new DeleteCustomer();
        ConverterHelper.checkIdRequired(dto, command, processError);

        return command;
    }
}

