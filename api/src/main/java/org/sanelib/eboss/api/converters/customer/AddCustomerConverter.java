package org.sanelib.eboss.api.converters.customer;


import com.google.common.base.Strings;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.customer.CustomerDTO;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.sanelib.eboss.core.commands.customer.AddCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddCustomerConverter implements DtoToCommandConverter<CustomerDTO> {

    @Autowired
    ProcessError processError;

    @Override
    public ProcessCommand convert(CustomerDTO dto) {

        AddCustomer command=new AddCustomer();

        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "name", "domain.customer.name");

        }else{
            command.setName(dto.getName());
        }

        command.setContactPersonName(dto.getContactPersonName());
        command.setAddress(dto.getAddress());

        if(Strings.isNullOrEmpty(dto.getCountry())){
            processError.addError("common.field.required","country","domain.customer.country");
        }else {
            command.setCountry(dto.getCountry());
        }

        if (Strings.isNullOrEmpty(dto.getPhone())) {
            processError.addError("common.field.required","phone","domain.customer.phone");
        }else if(!RegularExpressionHelper.checkPhoneFormat(dto.getPhone())) {
            processError.addError("common.field.pattern", "phone", "domain.customer.phone", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setPhone(dto.getPhone());
        }

        if (Strings.isNullOrEmpty(dto.getEmail())){
            processError.addError("common.field.required","email","domain.customer.email");
        }else if(!RegularExpressionHelper.checkEmailFormat(dto.getEmail())) {
            processError.addError("common.field.pattern", "email", "domain.customer.email", RegularExpressionHelper.EMAIL_FORMAT_EXAMPLE);
        } else {
            command.setEmail(dto.getEmail());
        }

        if(!RegularExpressionHelper.checkPhoneFormat(dto.getFax())) {
            processError.addError("common.field.pattern", "fax", "domain.customer.fax", RegularExpressionHelper.PHONE_FORMAT_EXAMPLE);
        } else {
            command.setFax(dto.getFax());
        }
        command.setWebsite(dto.getWebsite());
        command.setNotes(dto.getNotes());
        return command;
    }
}
