package DataAccess;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
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
