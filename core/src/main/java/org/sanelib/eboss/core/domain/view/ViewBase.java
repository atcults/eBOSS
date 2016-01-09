package org.sanelib.eboss.core.domain.view;

public abstract class ViewBase implements DomainView {

	private static final long serialVersionUID = 1L;

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
