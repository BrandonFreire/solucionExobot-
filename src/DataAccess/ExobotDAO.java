package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.ExobotDTO;

public class ExobotDAO extends SQLiteDataHelper implements IDAO<ExobotDTO>{
    @Override
    public ExobotDTO readBy(Integer id) throws Exception {
        ExobotDTO oS = new ExobotDTO();
        String query =" SELECT IdExaBot  " 
                     +" ,IdIABot        " 
                     +" ,IdArmaDerecha "
                     +" ,IdArmaIzquierda " 
                     +" ,Nombre " 
                     +" ,Serie " 
                     +" ,Estado " 
                     +" FROM    Exobot   "
                     +" WHERE   Estado ='A' AND IdExaBot =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new ExobotDTO(rs.getInt(1)           // IdSexo
                                ,rs.getInt(2)        // Nombre             
                                ,rs.getInt(3)        // Estado         
                                ,rs.getInt(4)        // FechaCrea      
                                ,rs.getString(5)
                                ,rs.getString(6)     // FechaModifica
                                ,rs.getString(7));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<ExobotDTO> readAll() throws Exception {
        List <ExobotDTO> lst = new ArrayList<>();
        String query =" SELECT IdExaBot  " 
                     +" ,IdIABot        " 
                     +" ,IdArmaDerecha "
                     +" ,IdArmaIzquierda " 
                     +" ,Nombre " 
                     +" ,Serie " 
                     +" ,Estado " 
                     +" FROM    Exobot   "
                     +" WHERE   Estado ='A'";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                ExobotDTO s = new ExobotDTO(rs.getInt(1)           // IdSexo
                                            ,rs.getInt(2)        // Nombre             
                                            ,rs.getInt(3)        // Estado         
                                            ,rs.getInt(4)        // FechaCrea      
                                            ,rs.getString(5)
                                            ,rs.getString(6)     // FechaModifica
                                            ,rs.getString(7));      // FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(ExobotDTO entity) throws Exception {
        String query = " INSERT INTO Exobot (IdIABot, IdArmaDerecha, IdArmaIzquierda, Nombre, Serie) VALUES (?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdIABot());
            pstmt.setInt(2, entity.getIdAramaDerecha());
            pstmt.setInt(1, entity.getIdAramaIzquierda());
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(1, entity.getSerie());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(ExobotDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Exobot SET Nombre = ?, FechaModifica = ? WHERE IdExaBot = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdExaBot());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Exobot SET Estado = ? WHERE IdExaBot = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Exobot "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }

}
