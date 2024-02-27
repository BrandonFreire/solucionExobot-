package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.CustomerControl.EXOButton;
import UserInterface.CustomerControl.IAStyle;

public class MenuPanel extends JPanel {
    public  EXOButton   
            btnHome     = new EXOButton("Home"),
            btnLogin    = new EXOButton("Login"),
            btnSexo     = new EXOButton("Sexo"),
            btnLocalidad= new EXOButton("Localidad"),
            btnTest     = new EXOButton("btnTest");

    public MenuPanel(){
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight())); 

        // add-logo
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add-botones
        add(btnHome);
        add(btnLogin);
        add(btnSexo);
        add(btnLocalidad);
        add(btnTest);

        // add-copyright
        add(new JLabel("\u00A9 2024 pat_mic"));
    }
}
