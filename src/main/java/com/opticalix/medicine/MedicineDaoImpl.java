package com.opticalix.medicine;

import com.opticalix.utils.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

/**
 * @author Felix on 29/03/2018
 */
public class MedicineDaoImpl {

    public  <T> List<T> query(Class<T> clazz, String querySQL, Object... args) throws SQLException {
        QueryRunner runner = new QueryRunner(DatabaseHelper.getDataSource());
        ResultSetHandler<List<T>> h = new BeanListHandler<T>(clazz);
        String format = String.format(Locale.getDefault(), querySQL, args);
        Logger.p("query by: %s", format);
        return runner.query(format, h);
    }

    public  <T> List<T> query(Class<T> clazz, String querySQL) throws SQLException {
        QueryRunner runner = new QueryRunner(DatabaseHelper.getDataSource());
        ResultSetHandler<List<T>> h = new BeanListHandler<T>(clazz);
        return runner.query(querySQL, h);
    }
}
