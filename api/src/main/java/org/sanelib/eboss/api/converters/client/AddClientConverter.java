package org.sanelib.eboss.api.converters.client;


import com.google.common.base.Strings;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.exceptions.ProcessError;

public class AddClientConverter implements DtoToCommandConverter<ClientDTO> {

    @Override
    public ProcessCommand convert(ClientDTO dto, ProcessError processError) {

        AddClient command= new AddClient();

        if(Strings.isNullOrEmpty(dto.getClient_secret())){
            processError.addError("common.field.required", "client_secret", "domain.customer.client_name");

        }else{
            command.setClient_secret(dto.getClient_secret());
        }

        if(Strings.isNullOrEmpty(dto.getClient_name())){
            processError.addError("common.field.required", "client_name", "domain.customer.client_name");

        }else{
            command.setClient_name(dto.getClient_name());
        }

        command.setDescription(dto.getDescription());

        if(Strings.isNullOrEmpty(dto.getClient_url())){
            processError.addError("common.field.required", "client_url", "domain.customer.client_url");

        }else{
            command.setClient_url(dto.getClient_url());
        }

        if(Strings.isNullOrEmpty(dto.getClient_type())){
            processError.addError("common.field.required", "client_type", "domain.customer.client_type");

        }else{
            command.setClient_type(dto.getClient_type());
        }

        command.setScope(dto.getScope());
        command.setRedirect_uri(dto.getRedirect_uri());

        if(Strings.isNullOrEmpty(dto.getRegdate())){
            processError.addError("common.field.required", "regdate", "domain.customer.regdate");

        }else{
            command.setRegdate(DateHelper.fromDateString((dto.getRegdate())));
        }

        return command;
    }
}
