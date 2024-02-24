//import DataAccess.SexoDAO;
//import DataAccess.DTO.SexoDTO;

import DataAccess.ExobotDAO;
import DataAccess.DTO.ExobotDTO;

/**
 * @autor Ivonne Ayala
 * @autor David Morales
 * @date 12/02/2024
 * @version 10.0
 */

public class IAApp {
    public static void main(String[] args) throws Exception {
        // IFWhiterun ifWhiterun = new IFWhiterun();
        // ifWhiterun.crearCampoGuerra();
        // DACExobot ex = new DACExobot();
        // ResultSet rs = ex.getAllExobot();
        // while (rs.next()) {
        //     System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        // }
        // SexoDAO listDao = new SexoDAO();
        // for (SexoDTO sDto : listDao.readAll()) {
        //        //System.out.println(sDto.getNombre()+" "+sDto.getFechaCrea());
        //     System.out.println(sDto.toString());
        // }
        ExobotDTO exobotDTO = new ExobotDTO();
        exobotDTO.setIdIABot(1);
        exobotDTO.setIdArmaIzquierda(2);
        exobotDTO.setIdArmaDerecha(1);
        exobotDTO.setNombre("Serie-0000");
        exobotDTO.setSerie("Serie 0000");


        ExobotDAO exoDAO = new ExobotDAO();
        exoDAO.create(exobotDTO);
        // for (ExobotDTO eDTO : exoDAO.readSections(100, 1)) {
        //     System.out.println(eDTO.toString());
        // }
        // System.out.println(exoDAO.readBy(5).toString());
    }
}
