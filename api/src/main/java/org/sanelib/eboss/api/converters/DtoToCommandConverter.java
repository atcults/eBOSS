package org.sanelib.eboss.api.converters;

import org.sanelib.eboss.api.dto.BaseDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.exceptions.ProcessError;

public interface DtoToCommandConverter<T extends BaseDTO> {
    ProcessCommand convert(T dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException;
}
