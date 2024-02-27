package BusinessLogic;

import java.util.List;

import DataAccess.ExobotDAO;
import DataAccess.DTO.ExobotDTO;

public class ExobotBL {
    private ExobotDTO exobot;
    private ExobotDAO sDAO = new ExobotDAO();

    public ExobotBL(){}

    public List<ExobotDTO> getAll() throws Exception{
        return sDAO.readAll();
    }
    public ExobotDTO getByIdSexo(int idSexo) throws Exception{
        exobot = sDAO.readBy(idSexo);
        return exobot;
    }
    public boolean create(ExobotDTO sexoDTO) throws Exception{   
        return sDAO.create(sexoDTO);
    }
    public boolean update(ExobotDTO sexoDTO) throws Exception{
        return sDAO.update(sexoDTO);
    }
    public boolean delete(int idSexo) throws Exception{
        return sDAO.delete(idSexo);
    }
    public Integer getMaxRow() throws Exception{
        return sDAO.getMaxRow();
    }
}
