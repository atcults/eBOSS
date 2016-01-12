package org.sanelib.eboss.api.converters.client;


import com.google.common.base.Strings;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddClientConverter implements DtoToCommandConverter<ClientDTO> {

    @Override
    public ProcessCommand convert(ClientDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddClient command= new AddClient();

        if(Strings.isNullOrEmpty(dto.getClientId())){
            processError.addError("common.field.required", "clientId", "domain.client.clientId");

        }else{
            command.setClientId(dto.getClientId());
        }

        if(Strings.isNullOrEmpty(dto.getClientSecret())){
            processError.addError("common.field.required", "clientSecret", "domain.client.clientSecret");

        }else{
            command.setClientSecret(dto.getClientSecret());
        }

        if(Strings.isNullOrEmpty(dto.getClientName())){
            processError.addError("common.field.required", "clientName", "domain.client.clientName");

        }else{
            command.setClientName(dto.getClientName());
        }

        command.setDescription(dto.getDescription());

        if(Strings.isNullOrEmpty(dto.getClientUrl())){
            processError.addError("common.field.required", "clientUrl", "domain.client.clientUrl");

        }else{
            command.setClientUrl(dto.getClientUrl());
        }

        if(Strings.isNullOrEmpty(dto.getClientType())){
            processError.addError("common.field.required", "clientType", "domain.client.clientType");

        }else{
            command.setClientType(dto.getClientType());
        }

        command.setScope(dto.getScope());
        command.setRedirectUri(dto.getRedirectUri());

        if(Strings.isNullOrEmpty(dto.getRegistrationDate())){
            processError.addError("common.field.required", "registrationDate", "domain.client.registrationDate");

        }else{
            command.setRegistrationDate(DateHelper.fromDateString((dto.getRegistrationDate())));
        }

        return command;
    }
}
