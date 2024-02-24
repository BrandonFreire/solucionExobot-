package DataAccess;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.ExobotDTO;

public class ExobotDAO extends SQLiteDataHelper implements IDAO<ExobotDTO> {

    @Override
    public ExobotDTO readBy(Integer id) throws Exception {
        ExobotDTO exobotDTO = new ExobotDTO();
        String query ="SELECT IdIABot"
                    +", IdArmaIzquierda"
                    +", IdArmaDerecha"
                    +", Nombre"
                    +", Serie FROM"
                    +" Exobots WHERE IdExaBot = "  + id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                exobotDTO = new ExobotDTO(rs.getInt(1)          // IdSexo
                                ,rs.getInt(2)                // Nombre             
                                ,rs.getInt(3)                // Estado         
                                ,rs.getString(4)                // FechaCrea      
                                ,rs.getString(5));              // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return exobotDTO;
    }

    public List<ExobotDTO> readSections(int limit, int offset) throws Exception {
        List<ExobotDTO> list = new ArrayList<>();
        String query = "SELECT IdIABot, IdArmaIzquierda, IdArmaDerecha, Nombre, Serie FROM Exobots LIMIT ? OFFSET ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ExobotDTO eDTO = new ExobotDTO(rs.getInt(1) // IdIFSexo;
                                            , rs.getInt(2) // Nombre;
                                            , rs.getInt(3) // Estado;
                                            , rs.getString(4) // FechaCrea;
                                            , rs.getString(5)); // FechaModifica;
                list.add(eDTO);
            }
        } catch (SQLException e) {
            throw e; // new Exception(getClass() + "getMaxIdSexo");
        }
        return list;
    }

    @Override
    public boolean create(ExobotDTO entity) throws Exception {
        String query = "INSERT INTO Exobots (IdIABot, IdArmaIzquierda, IdArmaDerecha, Nombre, Serie) VALUES (?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdIABot());
            pstmt.setInt(2, entity.getIdArmaIzquierda());
            pstmt.setInt(3, entity.getIdArmaDerecha());
            pstmt.setString(4, entity.getNombre());
            pstmt.setString(5, entity.getSerie());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(ExobotDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ExobotDTO> readAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }
}
