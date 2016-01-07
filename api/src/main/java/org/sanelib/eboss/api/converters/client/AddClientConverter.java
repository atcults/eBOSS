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
    public ProcessCommand convert(ClientDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddClient command= new AddClient();

        if(Strings.isNullOrEmpty(dto.getClientId())){
            processError.addError("common.field.required", "client_id", "domain.customer.client_id");

        }else{
            command.setClientId(dto.getClientId());
        }

        if(Strings.isNullOrEmpty(dto.getClientSecret())){
            processError.addError("common.field.required", "client_secret", "domain.customer.client_secret");

        }else{
            command.setClientSecret(dto.getClientSecret());
        }

        if(Strings.isNullOrEmpty(dto.getClientName())){
            processError.addError("common.field.required", "client_name", "domain.customer.client_name");

        }else{
            command.setClientName(dto.getClientName());
        }

        command.setDescription(dto.getDescription());

        if(Strings.isNullOrEmpty(dto.getClientUrl())){
            processError.addError("common.field.required", "client_url", "domain.customer.client_url");

        }else{
            command.setClientUrl(dto.getClientUrl());
        }

        if(Strings.isNullOrEmpty(dto.getClientType())){
            processError.addError("common.field.required", "client_type", "domain.customer.client_type");

        }else{
            command.setClientType(dto.getClientType());
        }

        command.setScope(dto.getScope());
        command.setRedirectUri(dto.getRedirectUri());

        if(Strings.isNullOrEmpty(dto.getRegdate())){
            processError.addError("common.field.required", "regdate", "domain.customer.regdate");

        }else{
            command.setRegdate(DateHelper.fromDateString((dto.getRegdate())));
        }

        return command;
    }
}
