package org.sanelib.eboss.core.service;

import org.sanelib.eboss.core.domain.view.DomainView;

import java.sql.SQLException;

public interface ViewMapper<T extends DomainView> {
    T map(final DataResultSet rs) throws SQLException;
}
