
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.PersonaCargoDTO;
import Framework.EXOException;

public class PersonaCargoDAO extends SQLiteDataHelper {

    public PersonaCargoDTO readBy(Integer id) throws Exception {
        PersonaCargoDTO personaCargoDTO = new PersonaCargoDTO();
        String query = "SELECT IdPersona, Nombre, IdCargo FROM Persona WHERE Estado = 'A' AND IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                personaCargoDTO = new PersonaCargoDTO(
                    rs.getInt("IdPersona"),
                    rs.getString("Nombre"),
                    rs.getInt("IdCargo")
                );
            }
        } catch (SQLException e) {
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return personaCargoDTO;
    }

    public List<PersonaCargoDTO> readSections(int limit, int offset) throws Exception {
        List<PersonaCargoDTO> list = new ArrayList<>();
        String query = "SELECT IdPersona, Nombre, IdCargo FROM Persona WHERE Estado = 'A' LIMIT ? OFFSET ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PersonaCargoDTO pcDTO = new PersonaCargoDTO(
                    rs.getInt("IdPersona"),
                    rs.getString("Nombre"),
                    rs.getInt("IdCargo")
                );
                list.add(pcDTO);
            }
        } catch (SQLException e) {
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return list;
    }

    public List<PersonaCargoDTO> readAll() throws Exception {
        List<PersonaCargoDTO> list = new ArrayList<>();
        String query = "SELECT IdPersona, Nombre, IdCargo FROM Persona WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PersonaCargoDTO pcDTO = new PersonaCargoDTO(
                    rs.getInt("IdPersona"),
                    rs.getString("Nombre"),
                    rs.getInt("IdCargo")
                );
                list.add(pcDTO);
            }
        } catch (SQLException e) {
            throw new EXOException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return list;
    }
}
