package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.SexoBL;
import DataAccess.DTO.SexoDTO;
import UserInterface.IAStyle;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SexoPanel  extends JPanel implements ActionListener {
    private Integer idSexo = 0, idMaxSexo=0;
    private SexoBL sexoBL = null;
    private SexoDTO sexo = null;

    public SexoPanel() {
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
        idSexo      = 1;
        sexoBL      = new SexoBL();
        sexo        = sexoBL.getByIdSexo(idSexo);
        idMaxSexo   = sexoBL.getMaxRow();
    }

    private void showRow() {
        boolean sexoNull = (sexo == null);
        txtIdSexo.setText((sexoNull) ? " " : sexo.getIdSexo().toString());
        txtNombre.setText((sexoNull) ? " " : sexo.getNombre());
        lblTotalReg.setText(idSexo.toString() + " de " + idMaxSexo.toString());
    }

    private void btnNuevoClick() {
        sexo = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean sexoNull = (sexo == null);
        // String buttonText = ((JButton) e.getSource()).getText();
        try {
            if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((sexoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (sexoNull)
                    sexo = new SexoDTO(txtNombre.getText());
                else
                    sexo.setNombre(txtNombre.getText());
    
                if(!((sexoNull) ? sexoBL.create(sexo) : sexoBL.update(sexo)))
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

                if (!sexoBL.delete(sexo.getIdSexo()))
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
            if(sexo == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idSexo = 1;
        if (e.getSource() == btnRowAnt && (idSexo > 1))
            idSexo--;
        if (e.getSource() == btnRowSig && (idSexo < idMaxSexo))
            idSexo++;
        if (e.getSource() == btnRowFin)
            idSexo = idMaxSexo;
        try {
            sexo    = sexoBL.getByIdSexo(idSexo);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Estado"};
        Object[][] data = new Object[sexoBL.getAll().size()][3];
        int index = 0;
        for (SexoDTO s : sexoBL.getAll()) {
            data[index][0] = s.getIdSexo();
            data[index][1] = s.getNombre();
            data[index][2] = s.getEstado();
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
                    idSexo = Integer.parseInt(strIdSexo);
                    try {
                        sexo = sexoBL.getByIdSexo(idSexo);
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
    private PatLabel 
            lblTitulo   = new PatLabel("SEXO"),
            lblIdSexo   = new PatLabel(" Codigo:      "),
            lblNombre   = new PatLabel("*Descripción: "),
            lblTotalReg = new PatLabel(" 0 de 0 ");
    private PatTextBox 
            txtIdSexo   = new PatTextBox(),
            txtNombre   = new PatTextBox();
    private PatButton 
            btnPageIni  = new PatButton(" |< "),
            btnPageAnt  = new PatButton(" << "),
            btnPageSig  = new PatButton(" >> "),
            btnPageFin  = new PatButton(" >| "),

            btnRowIni   = new PatButton(" |< "),
            btnRowAnt   = new PatButton(" << "),
            btnRowSig   = new PatButton(" >> "),
            btnRowFin   = new PatButton(" >| "),

            btnNuevo    = new PatButton("Nuevo"),
            btnGuardar  = new PatButton("Guardar"),
            btnCancelar = new PatButton("Cancelar"),
            btnEliminar = new PatButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdSexo.setEnabled(false);
        txtIdSexo.setBorderLine();
        txtNombre.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new PatLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new PatLabel(" ) "));
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
        add(txtIdSexo, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}