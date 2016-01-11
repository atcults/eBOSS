package org.sanelib.eboss.core.service;

import org.sanelib.eboss.core.domain.view.DomainView;

import java.util.List;

public abstract class ViewServiceBase {
    protected abstract List<String> getStatements();
    public abstract <T extends DomainView> List<T> getAll() throws Throwable;
}
