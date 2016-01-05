package org.sanelib.eboss.api.converters.customer;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.common.utils.ReflectionHelper;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.sanelib.eboss.core.commands.customer.UpdateCustomer;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerConverter extends AddCustomerConverter {

    @Override
    public ProcessCommand convert(CustomerDTO dto, ProcessError processErr) throws NoSuchFieldException, IllegalAccessException {
        AddCustomer addCustomer = (AddCustomer) super.convert(dto, processErr);

        UpdateCustomer updateCustomer = new UpdateCustomer();
        ReflectionHelper.copy(addCustomer, updateCustomer);

        if(Strings.isNullOrEmpty(dto.getId())){
            processErr.addError("common.field.required", "id", "domain.customer.id");
        }
        else if(!RegularExpressionHelper.checkIdFormat(dto.getId())){
            processErr.addError("common.field.pattern", "id", "domain.customer.id", RegularExpressionHelper.ID_FORMAT);
        } else {
            updateCustomer.setId(Integer.parseInt(dto.getId()));
        }

        return updateCustomer;
    }

}
