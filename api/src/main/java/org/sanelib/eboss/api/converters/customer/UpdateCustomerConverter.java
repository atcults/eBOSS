package org.sanelib.eboss.api.converters.customer;

import org.sanelib.eboss.api.converters.ConverterHelper;
import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.common.utils.ReflectionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerConverter extends AddCustomerConverter {

    @Override
    public ProcessCommand convert(CustomerDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddCustomer addCustomer = (AddCustomer) super.convert(dto, processError);

        UpdateCustomer updateCustomer = new UpdateCustomer();
        ReflectionHelper.copy(addCustomer, updateCustomer);

        ConverterHelper.checkIdRequired(dto, updateCustomer, processError);

        return updateCustomer;
    }
}

