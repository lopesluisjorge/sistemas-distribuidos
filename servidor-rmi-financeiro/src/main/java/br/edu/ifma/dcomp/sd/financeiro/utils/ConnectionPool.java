package br.edu.ifma.dcomp.sd.financeiro.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionPool {

    private DataSource dataSource;

    public ConnectionPool() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        String url = "jdbc:mysql://localhost/financeiro?useSSL=false";

        mysqlDataSource.setURL(url);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("toor");

        this.dataSource = mysqlDataSource;
    }

    public Connection getConexao() throws SQLException {
        Connection conexao = dataSource.getConnection();

        return conexao;
    }

}
