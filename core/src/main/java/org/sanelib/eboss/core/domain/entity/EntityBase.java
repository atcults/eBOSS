package org.sanelib.eboss.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBase implements DomainEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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

	protected final int getPersistedId() {
		if (id == 0L) {
			throw new IllegalStateException("Not persisted object of type:" + getClass());
		}
		return (int) id;
	}

	public final boolean isPersisted() {
		return id == 0L;
	}

	@Override
	public int hashCode() {
		return getPersistedId();
	}

	@Override
	public boolean equals(Object o) {
		return o != null && o.getClass() == getClass() && getPersistedId() == ((EntityBase) o).getPersistedId();
	}
}
