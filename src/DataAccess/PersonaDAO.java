package DataAccess;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.PersonaDTO;
/**
 * @author Ismael Freire
 * @date 24/02/2024
 * @version 2.0
 */

public class PersonaDAO extends SQLiteDataHelper implements IDAO<PersonaDTO> {

    @Override
    public PersonaDTO readBy(Integer id) throws Exception {
        PersonaDTO personaDTO = new PersonaDTO();
        String query = "SELECT IdPersona"
                + ", Nombre"
                + ", IdCargo"
                + ", FROM"
                + " Persona WHERE Estado = 'A' AND IdPersona = " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                personaDTO = new PersonaDTO(rs.getInt(1) // IdPersona
                        , rs.getString(2) // Nombre
                        , rs.getInt(3)); // Estado
            }
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return personaDTO;
    }

    public List<PersonaDTO> readSections(int limit, int offset) throws Exception {
        List<PersonaDTO> list = new ArrayList<>();
        String query = "SELECT IdPersona, Nombre, IdCargo FROM Persona WHERE Estado = 'A' LIMIT ? OFFSET ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            // pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PersonaDTO pDTO = new PersonaDTO(rs.getInt(1) // IdIFSexo;
                        , rs.getString(2) // Nombre;
                        , rs.getInt(3)); // Estado
                list.add(pDTO);
            }
        } catch (SQLException e) {
            throw e; // new Exception(getClass() + "getMaxIdSexo");
        }
        return list;
    }

    @Override
    public boolean create(PersonaDTO entity) throws Exception {
        String query = "INSERT INTO Persona (Nombre, IdCargo) VALUES (?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getIdCargo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        String query = "UPDATE Exobots SET Nombre = ?, IdCargo = ?, FechaMod = ? WHERE IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getIdCargo());
            pstmt.setInt(3, entity.getIdPersona());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Persona SET Estado = ? WHERE IdPersona = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement   pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //ew PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public List<PersonaDTO> readAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

}

