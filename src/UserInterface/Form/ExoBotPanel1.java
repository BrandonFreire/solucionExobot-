package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.ExobotBL;
import DataAccess.DTO.ExobotDTO;
import UserInterface.CustomerControl.EXOButton;
import UserInterface.CustomerControl.EXOLabel;
import UserInterface.CustomerControl.EXOTextBox;
import UserInterface.CustomerControl.IAStyle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExoBotPanel1  extends JPanel implements ActionListener {
    private Integer idExobot = 0, idMaxExobot=0;
    private ExobotBL exobotBL = null;
    private ExobotDTO exobot = null;
    

    public ExoBotPanel1() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> btnNuevoClick());
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        idExobot      = 1;
        exobotBL      = new ExobotBL();
        exobot        = exobotBL.getByIdExobot(idExobot);
        idMaxExobot   = exobotBL.getMaxRow();
    }

    private void showRow() {
        boolean ExobotNull = (exobot == null);
        txtIdExobot.setText((ExobotNull) ? " " : exobot.getIdExaBot().toString());
        
        txtNombre.setText((ExobotNull) ? " " : exobot.getNombre());
        txtIdArmaDer.setText((ExobotNull) ? " " : Integer.toString(exobot.getIdAramaDerecha()));
        txtIdArmaIzq.setText((ExobotNull) ? " " : Integer.toString(exobot.getIdAramaIzquierda()));
        txtSerie.setText((ExobotNull) ? " " : exobot.getSerie());
        lblTotalReg.setText(idExobot.toString() + " de " + idMaxExobot.toString());
    }

    

    private void btnNuevoClick() {
        exobot = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean ExobotNull = (exobot == null);
        // String buttonText = ((JButton) e.getSource()).getText();
        try {
            if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((ExobotNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (ExobotNull)
                    exobot = new ExobotDTO(1,1,Integer.parseInt(txtIdArmaIzq.getText()), Integer.parseInt(txtIdArmaDer.getText()), txtNombre.getText(), txtSerie.getText(), "A");
                else
                    exobot.setNombre(txtNombre.getText());
    
                if(!((ExobotNull) ? exobotBL.create(exobot) : exobotBL.update(exobot)))
                    IAStyle.showMsgError("Error al guardar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (IAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!exobotBL.delete(exobot.getIdExaBot()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(exobot == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idExobot = 1;
        if (e.getSource() == btnRowAnt && (idExobot > 1))
            idExobot--;
        if (e.getSource() == btnRowSig && (idExobot < idMaxExobot))
            idExobot++;
        if (e.getSource() == btnRowFin)
            idExobot = idMaxExobot;
        try {
            exobot    = exobotBL.getByIdExobot(idExobot);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"IdExaBot", "getIdIABot", "IdArmaDerecha", "IdArmaIzquierda", "Nombre", "Serie"};
        Object[][] data = new Object[exobotBL.getAll().size()][6];
        int index = 0;
        for (ExobotDTO s : exobotBL.getAll()) {
            data[index][0] = s.getIdExaBot();
            data[index][1] = s.getIdIABot();
            data[index][2] = s.getIdAramaDerecha();
            data[index][3] = s.getIdAramaIzquierda();
            data[index][4] = s.getNombre();
            data[index][5] = s.getSerie();

            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strIdSexo = table.getModel().getValueAt(row, 0).toString();
                    idExobot = Integer.parseInt(strIdSexo);
                    try {
                        exobot = exobotBL.getByIdExobot(idExobot);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdSexo);
                }
            }
        });
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private EXOLabel 
            lblTitulo   = new EXOLabel("EXOBOT"),
            lblIdSexo   = new EXOLabel(" Codigo:      "),
            lblNombre   = new EXOLabel("*Descripción: "),
            lblIdArmaDer   = new EXOLabel("Arma Derecha: "),
            lblIdArmaIzq   = new EXOLabel("*Arma Izquierda: "),
            lblSerie   = new EXOLabel("*Serie: "),
            lblTotalReg = new EXOLabel(" 0 de 0 ");
    private EXOTextBox 
            txtIdExobot    = new EXOTextBox(),
            txtNombre      = new EXOTextBox(),
            txtIdArmaIzq   = new EXOTextBox(),
            txtIdArmaDer   = new EXOTextBox(),
            txtSerie       = new EXOTextBox();
    private EXOButton 
            btnPageIni  = new EXOButton(" |< "),
            btnPageAnt  = new EXOButton(" << "),
            btnPageSig  = new EXOButton(" >> "),
            btnPageFin  = new EXOButton(" >| "),

            btnRowIni   = new EXOButton(" |< "),
            btnRowAnt   = new EXOButton(" << "),
            btnRowSig   = new EXOButton(" >> "),
            btnRowFin   = new EXOButton(" >| "),

            btnNuevo    = new EXOButton("Nuevo"),
            btnGuardar  = new EXOButton("Guardar"),
            btnCancelar = new EXOButton("Cancelar"),
            btnEliminar = new EXOButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtNombre.setBorderLine();
        txtIdArmaIzq.setBorderLine();
        txtIdArmaDer.setBorderLine();
        txtSerie.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new EXOLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new EXOLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdSexo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);
        gbc.gridy = 7;
        gbc.gridx = 0;
        add(lblIdArmaIzq, gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtIdArmaIzq, gbc);
        gbc.gridy = 8;
        gbc.gridx = 0;
        add(lblIdArmaDer, gbc);
        gbc.gridy = 8;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtIdArmaDer, gbc);
        gbc.gridy = 9;
        gbc.gridx = 0;
        add(lblSerie, gbc);
        gbc.gridy = 9;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtSerie, gbc);

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 10;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}