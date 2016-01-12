package org.sanelib.eboss.api.converters.client;

import org.sanelib.eboss.api.converters.ConverterHelper;
import org.sanelib.eboss.api.dto.client.ClientDTO;
import org.sanelib.eboss.common.utils.ReflectionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.client.AddClient;
import org.sanelib.eboss.core.commands.client.UpdateClient;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientConverter extends AddClientConverter {

    @Override
    public ProcessCommand convert(ClientDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

        AddClient addClient = (AddClient) super.convert(dto, processError);

        UpdateClient updateClient = new UpdateClient();
        ReflectionHelper.copy(addClient, updateClient);

        ConverterHelper.checkIdRequired(dto, updateClient, processError);

        return updateClient;
    }
}
