package UserInterface.CustomerControl;

import javax.swing.*;

import java.awt.*;

public class EXOLabelText extends JPanel{
    private EXOLabel    lblEtiqueta = new EXOLabel();
    private EXOTextBox  txtContenido= new EXOTextBox();

    public EXOLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            IAStyle.FONT_SMALL, 
                                            IAStyle.COLOR_FONT_LIGHT, 
                                            IAStyle.ALIGNMENT_LEFT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
