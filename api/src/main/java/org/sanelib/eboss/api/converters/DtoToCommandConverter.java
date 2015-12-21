package org.sanelib.eboss.api.converters;

import org.sanelib.eboss.api.dto.BaseDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;

public interface DtoToCommandConverter<T extends BaseDTO> {
    ProcessCommand convert(T dto);
}
