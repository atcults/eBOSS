package org.sanelib.eboss.core.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.sanelib.eboss.core.domain.entity.IEntity;

public interface IRepository<T extends IEntity> {

	Session getSession();

	List<T> loadAll();

	T load(long id);

	T get(long id);

	void save(T entity);

	void update(T entity);

	void saveOrUpdate(T entity);

	T merge(T entity);

	void remove(T entity);

	List<T> executeQueryInHibernate(final String queryString, final String[] paramValues);

	List<T> executeQueryInHibernate(final String queryString, final String[] paramValues, final Class<T> returnType);

	List<T> executeQueryInHibernate(final String queryString, final String[] paramValues, final String[] resultColumnNames);

	List<T> executeQueryInHibernate(final String queryString, final String[] paramValues, final String[] resultColumnNames,
			final Class<T> returnType);

	List<T> executeQueryObject(final String queryString, Class clazz);

	List<T> executeQueryObject(final DetachedCriteria detachedCriteria, Class clazz);

	int executeUpdate(final String queryString, final String[] paramValues);

	T getSafeSingleEntityByColumnAndValue(final String columnName, final Object columnValue);

	T getSafeSingleEntityByColumnAndValue(final String[] columnNames, final Object[] columnValues);

	List<T> findByColumnAndValue(final String columnName, final Object columnValue);

	List<T> findByColumnAndValue(final String columnName, final Object columnValue, final int offset, final int size);

	List<T> findByColumnAndValue(final String[] columnNames, final Object[] columnValues);

	List<T> findByColumnAndValue(final String[] columnNames, final Object[] columnValues, final int offset, final int size);

	List<T> findColumnAndValueByOrder(final String[] columnNames, final Object[] columnValues, final String orderColumnName,
			final boolean isLikeFlag, String orderType);

	List<T> findColumnAndValueByOrderPagination(final String[] columnNames, final Object[] columnValues, final String orderColumnName,
			final boolean isLikeFlag, final String orderType, final int offset, final int size);

	List<String> getListString(final String query);

	List getListString(final DetachedCriteria deCriteria);

	List<T> findByCriteria(final DetachedCriteria criteria);
}
