package DataAccess;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.ExobotDTO;
import Framework.EXOException;
/**
 * @author Ismael Freire
 * @date 24/02/2024
 * @version 2.0
 */

public class ExobotDAO extends SQLiteDataHelper implements IDAO<ExobotDTO> {

    @Override
    public ExobotDTO readBy(Integer id) throws Exception {
        ExobotDTO exobotDTO = new ExobotDTO();
        String query = "SELECT IdIABot"
                + ", IdArmaIzquierda"
                + ", IdArmaDerecha"
                + ", Nombre"
                + ", Serie FROM"
                + " Exobots WHERE Estado = 'A' AND IdExaBot = " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                exobotDTO = new ExobotDTO(rs.getInt(1) // IdSexo
                        , rs.getInt(2) // Nombre
                        , rs.getInt(3) // Estado
                        , rs.getString(4) // FechaCrea
                        , rs.getString(5)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return exobotDTO;
    }

    public List<ExobotDTO> readSections(int limit, int offset) throws Exception {
        List<ExobotDTO> list = new ArrayList<>();
        String query = "SELECT IdIABot, IdArmaIzquierda, IdArmaDerecha, Nombre, Serie FROM Exobots WHERE Estado = 'A' LIMIT ? OFFSET ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            // pstmt.executeUpdate();
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
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()"); // new Exception(getClass() + "getMaxIdSexo");
        }
        return list;
    }

    @Override
    public boolean create(ExobotDTO entity) throws Exception {
        String query = "INSERT INTO Exobots (IdIABot, IdArmaIzquierda, IdArmaDerecha, Nombre, Serie) VALUES (?,?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdIABot());
            pstmt.setInt(2, entity.getIdArmaIzquierda());
            pstmt.setInt(3, entity.getIdArmaDerecha());
            pstmt.setString(4, entity.getNombre());
            pstmt.setString(5, entity.getSerie());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()"); // new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(ExobotDTO entity) throws Exception {
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // LocalDateTime now = LocalDateTime.now();
        // pstmt.setString(2, dtf.format(now).toString());
        String query = "UPDATE Exobots SET Nombre = ?, Serie = ? WHERE IdExaBot = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getSerie());
            pstmt.setInt(3, entity.getIdExaBot());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()"); // new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Exobots SET Estado = ? WHERE IdExaBot = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement   pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()"); //ew PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public List<ExobotDTO> readAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Exobots "
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
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return 0;
    }
}
