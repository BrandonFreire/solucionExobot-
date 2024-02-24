package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DACExobot extends SQLiteDataHelper{
    public ResultSet getAllExobot() throws Exception{
        String query = "SELECT IdExaBot, IdIABot, Nombre, Serie FROM Exobots";
        try {
            Connection conn = openConnection(); 
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new Exception(getClass()+"getMaxIdSexo",e);
        }
    }
}

