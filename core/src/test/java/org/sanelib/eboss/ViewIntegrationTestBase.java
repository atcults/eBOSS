package org.sanelib.eboss;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.sanelib.eboss.common.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreTestMain.class)
public abstract class ViewIntegrationTestBase {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    DataSource dataSource;


    @Before
    public void setup() throws Exception {
        Locale.setDefault(new Locale(this.appProperties.getLocale()));
        cleanUp();
        executeBatch(getSetupQueries());
    }

    @After
    public void tearDown() throws Exception {
        cleanUp();
    }

    private void cleanUp() throws SQLException {
        List<String> deleteStatements = getTableNames().stream().map(this::getDeleteStatement).collect(Collectors.toList());
        this.executeBatch(deleteStatements);
    }

    protected void executeBatch(List<String> queries) throws SQLException {

        Connection connection = this.dataSource.getConnection();
        Statement statement = connection.createStatement();

        for (String query : queries) {
            statement.addBatch(query);
        }

        statement.executeBatch();

        statement.close();
        connection.close();
    }

    protected abstract List<String> getTableNames();

    protected abstract List<String> getSetupQueries();

    private String getDeleteStatement(String tableName){
        return String.format("delete from `eboss`.`%s`", tableName);
    }
}

