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
import DataAccess.DTO.PersonaDTO;

public class PersonaDAO extends SQLiteDataHelper implements IDAO<PersonaDTO>{
    @Override
    public PersonaDTO readBy(Integer id) throws Exception {
        PersonaDTO oS = new PersonaDTO();
        String query =" SELECT IdPersona  " 
                     +" ,Nombre        " 
                     +" ,Estado        " 
                     +" ,FechaCrea     " 
                     +" ,FechaMod "
                     +" FROM    Persona   "
                     +" WHERE   Estado ='A' AND IdPersona =   "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new PersonaDTO(rs.getInt(1)           // IdSexo
                                ,rs.getString(2)        // Nombre             
                                ,rs.getString(3)        // Estado         
                                ,rs.getString(4)        // FechaCrea      
                                ,rs.getString(5));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<PersonaDTO> readAll() throws Exception {
        List <PersonaDTO> lst = new ArrayList<>();
        String query =" SELECT IdPersona  " 
                     +" ,Nombre        " 
                     +" ,Estado        " 
                     +" ,FechaCrea     " 
                     +" ,FechaMod "
                     +" FROM    Persona   "
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                PersonaDTO s = new PersonaDTO( rs.getInt(1)     // IdSexo
                                        ,rs.getString(2)  // Nombre             
                                        ,rs.getString(3)  // Estado         
                                        ,rs.getString(4)  // FechaCrea      
                                        ,rs.getString(5));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    public boolean create(PersonaDTO entity) throws Exception {
        String query = " INSERT INTO Persona (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Persona SET Nombre = ?, FechaMod = ? WHERE IdPersona = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdPersona());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e ;//new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Persona SET Estado = ? WHERE IdPersona = ?";
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
        String query =" SELECT COUNT(*) TotalReg FROM Persona "
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
            throw e ; //new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
