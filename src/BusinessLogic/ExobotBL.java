package BusinessLogic;
import java.util.List;
import DataAccess.ExobotDAO;
import DataAccess.DTO.ExobotDTO;
/**
 * @author Ismael Freire
 * @date 24/02/2024
 * @version 1.0
 */
public class ExobotBL {
    private ExobotDTO exobotDTO;
    private ExobotDAO exobotDAO = new ExobotDAO();
    /**
     * constructor sin parametros
     */
    public ExobotBL() {}

    public ExobotDTO getReadBy(int IdExaBot) throws Exception{
        exobotDTO = exobotDAO.readBy(IdExaBot);
        return exobotDTO;
    }

    public List<ExobotDTO> getReadSections(int limit, int offset) throws Exception{
        // for (ExobotDTO exobotList : iterable) {
        // }
        return exobotDAO.readSections(limit, offset);
    }

    public boolean add(int IdIABot, int IdArmaIzquierda, int IdArmaDerecha, String Nombre, String Serie) throws Exception{
        exobotDTO = new ExobotDTO();
        // sexo.setNombre(nombre);
        exobotDTO.setIdIABot(IdIABot);
        exobotDTO.setIdArmaIzquierda(IdArmaIzquierda);
        exobotDTO.setIdArmaDerecha(IdArmaDerecha);
        exobotDTO.setNombre(Nombre);
        exobotDTO.setSerie(Serie);
        return exobotDAO.create(exobotDTO);
    }
    public boolean update(String Nombre, String Serie, int IdExaBot) throws Exception{
        exobotDTO = new ExobotDTO();
        exobotDTO.setNombre(Nombre);
        exobotDTO.setSerie(Serie);
        exobotDTO.setIdExaBot(IdExaBot);
        return exobotDAO.update(exobotDTO);
    }
    public boolean delete(int IdExobot) throws Exception{
        return exobotDAO.delete(IdExobot);
    }

    public Integer getMaxRow() throws Exception{
        return exobotDAO.getMaxRow();
    }
}
