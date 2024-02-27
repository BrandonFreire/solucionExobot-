//import DataAccess.SexoDAO;
//import DataAccess.DTO.SexoDTO;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import BusinessLogic.ExobotBL;
import DataAccess.DTO.ExobotDTO;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

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
        // ExobotDTO exobotDTO = new ExobotDTO();
        // exobotDTO.setIdExaBot(1);
        // exobotDTO.setIdIABot(1);
        // exobotDTO.setIdArmaIzquierda(2);
        // exobotDTO.setIdArmaDerecha(1);
        // exobotDTO.setNombre("Exobot-001");
        // exobotDTO.setSerie("Serie E001");

        // ExobotDAO exoDAO = new ExobotDAO();
        //exoDAO.create(exobotDTO);
        //exoDAO.update(exobotDTO);
        // exoDAO.delete(1);
        // for (ExobotDTO eDTO : exoDAO.readSections(100, 1)) {
        //     System.out.println(eDTO.toString());
        // }
        // System.out.println(exoDAO.readBy(5).toString());
        // ExobotBL exobotBL = new ExobotBL();
        // // exobotBL.delete(1);
        // // exobotBL.add(1, 2, 1, "Ismael", "Serie 3000");
        // // exobotBL.delete(1002);
        // for (ExobotDTO s : exobotBL.getReadSections(20, 0)) {
        //     System.out.println(s.toString());
        // }

        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } 
    
       SplashScreenForm.show();
       MainForm frmMain = new MainForm("IABot");
    }
}
