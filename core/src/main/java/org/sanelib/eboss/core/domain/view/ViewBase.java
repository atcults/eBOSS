package org.sanelib.eboss.core.domain.view;

public abstract class ViewBase implements DomainView {

	private static final long serialVersionUID = 1L;

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (this.id != 0 && this.id != id) {
			throw new IllegalStateException("The ID must not be changed after it is set.");
		}
		this.id = id;
	}
}
