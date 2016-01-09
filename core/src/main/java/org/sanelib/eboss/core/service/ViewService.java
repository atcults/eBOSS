package org.sanelib.eboss.core.service;

import org.sanelib.eboss.core.domain.view.DomainView;

import java.util.List;

public interface ViewService<T extends DomainView> {

	List<T> loadAll();

	T load(long id);

	T get(long id);
}
