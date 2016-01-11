package org.sanelib.eboss.api.converters;

import org.sanelib.eboss.api.dto.BaseDTO;
import org.sanelib.eboss.core.domain.view.DomainView;

public interface ViewToDtoConverter<U extends BaseDTO, T extends DomainView> {
    U convert(T domainView);
}
