import DataAccess.SexoDAO;
import DataAccess.DTO.SexoDTO;

/**
 * @autor Ivonne Ayala
 * @autor David Morales
 * @date 12/02/2024
 * @version 10.0
 */

public class IAApp {
    public static void main(String[] args) throws Exception {
        IFWhiterun ifWhiterun = new IFWhiterun();
        ifWhiterun.crearCampoGuerra();
        // DACExobot ex = new DACExobot();
        // ResultSet rs = ex.getAllExobot();
        // while (rs.next()) {
        //     System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        // }
        // SexoDAO listDao = new SexoDAO();
        // for (SexoDTO sDto : listDao.readAll()) {
        //       //System.out.println(sDto.getNombre()+" "+sDto.getFechaCrea());
        //     System.out.println(sDto.toString());
        // }
    }
}
