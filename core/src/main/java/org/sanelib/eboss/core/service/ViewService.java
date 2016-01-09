package org.sanelib.eboss.core.service;

import org.sanelib.eboss.core.domain.view.DomainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ViewService {

    @Autowired
    DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public <T extends DomainView> List<T> loadQuery(String query, ViewMapper mapper) {
        final List<T> list = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement()) {
            try (DataResultSet rs = new DataResultSet(stmt.executeQuery(query))) {
                while (rs.next()) {
                    list.add((T) mapper.map(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
