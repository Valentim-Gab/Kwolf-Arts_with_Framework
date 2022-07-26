package ufsm.csi.kwolf_arts2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDBPostgres {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/kwolf_arts";
    private static final String USER = "postgres";
    private static final String SENHA = "1234";

    public Connection getConexao(){
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
