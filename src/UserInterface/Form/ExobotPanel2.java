package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.PersonaBL;
import DataAccess.DTO.PersonaDTO;
import UserInterface.CustomerControl.EXOButton;
import UserInterface.CustomerControl.EXOLabel;
import UserInterface.CustomerControl.EXOTextBox;
import UserInterface.CustomerControl.IAStyle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExobotPanel2  extends JPanel implements ActionListener {
    private Integer idPersona = 0, idMaxPersona=0;
    private PersonaBL personaBL = null;
    private PersonaDTO persona = null;

    public ExobotPanel2() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
        
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        idPersona      = 1;
        personaBL      = new PersonaBL();
        persona        = personaBL.getByIdPersona(idPersona);
        idMaxPersona   = personaBL.getMaxRow();
    }

    private void showRow() {
        boolean personaNull = (persona == null);
        txtIdPersona.setText((personaNull) ? " " : persona.getIdPersona().toString());
        txtNombre.setText((personaNull) ? " " : persona.getNombre());
        lblTotalReg.setText(idPersona.toString() + " de " + idMaxPersona.toString());
    }

    private void btnEliminarClick() {
        try {
            if (IAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!personaBL.delete(persona.getIdPersona()))
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
            if(persona == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idPersona = 1;
        if (e.getSource() == btnRowAnt && (idPersona > 1))
            idPersona--;
        if (e.getSource() == btnRowSig && (idPersona < idMaxPersona))
            idPersona++;
        if (e.getSource() == btnRowFin)
            idPersona = idMaxPersona;
        try {
            persona    = personaBL.getByIdPersona(idPersona);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Fecha Creacion", "Estado"};
        Object[][] data = new Object[personaBL.getAll().size()][4];
        int index = 0;
        for (PersonaDTO s : personaBL.getAll()) {
            data[index][0] = s.getIdPersona();
            data[index][1] = s.getNombre();
            data[index][2] = s.getFechaCrea();
            data[index][3] = s.getEstado();
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
                    String strIdPersona = table.getModel().getValueAt(row, 0).toString();
                    idPersona = Integer.parseInt(strIdPersona);
                    try {
                        persona = personaBL.getByIdPersona(idPersona);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdPersona);
                }
            }
        });
    }

/************************
 * FormDesing : 
 ************************/ 
    private EXOLabel 
            lblTitulo   = new EXOLabel("PERSONA"),
            lblIdPersona   = new EXOLabel(" Codigo:      "),
            lblNombre   = new EXOLabel("*Descripción: "),
            //lblFechaCrea   = new EXOLabel("*FechaCrea: "),
            lblTotalReg = new EXOLabel(" 0 de 0 ");
    private EXOTextBox 
            txtIdPersona   = new EXOTextBox(),
            txtNombre   = new EXOTextBox();
            //txtFechaCrea = new  EXOTextBox();
    private EXOButton 
            btnPageIni  = new EXOButton(" |< "),
            btnPageAnt  = new EXOButton(" << "),
            btnPageSig  = new EXOButton(" >> "),
            btnPageFin  = new EXOButton(" >| "),

            btnRowIni   = new EXOButton(" |< "),
            btnRowAnt   = new EXOButton(" << "),
            btnRowSig   = new EXOButton(" >> "),
            btnRowFin   = new EXOButton(" >| "),

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
        //txtFechaCrea.setBorderLine();

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

        //pnlBtnCRUD.add(btnNuevo);
        //pnlBtnCRUD.add(btnGuardar);
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
        add(lblIdPersona, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdPersona, gbc);

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
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}