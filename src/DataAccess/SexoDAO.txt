package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.SexoDTO;

public class SexoDAO extends SQLiteDataHelper implements IDAO<SexoDTO> {

    @Override
    public boolean create(SexoDTO entity) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<SexoDTO> readAll() throws Exception {
        List<SexoDTO> list = new ArrayList<>();
        String query = 
                      "SELECT IdIFSexo"
                    +" ,Nombre"
                    +" ,Estado"
                    +" ,FechaCrea"
                    +" ,FechaModifica" 
                    +" FROM Sexo"
                    +" WHERE Estado ='A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SexoDTO sDto = new SexoDTO(rs.getInt(1)     //IdIFSexo;       
                                        , rs.getString(2)                   //Nombre;
                                        , rs.getString(3)                   //Estado;
                                        , rs.getString(4)                   //FechaCrea;
                                        , rs.getString(5));                 //FechaModifica;
                list.add(sDto);
            }
        } catch (SQLException e) {
            throw e; //new Exception(getClass() + "getMaxIdSexo");
        }
        return list;
    }

    @Override
    public SexoDTO readBy(Integer id) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(SexoDTO entity) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
