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
