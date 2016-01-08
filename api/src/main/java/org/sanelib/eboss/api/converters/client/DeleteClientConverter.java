package org.sanelib.eboss.api.converters.client;

import org.sanelib.eboss.api.converters.ConverterHelper;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.DeleteClient;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientConverter implements DtoToCommandConverter<ClientDTO>{


    @Override
    public ProcessCommand convert(ClientDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        DeleteClient command=new DeleteClient();
        ConverterHelper.checkIdRequired(dto, command, processError);

        return command;

    }
}
