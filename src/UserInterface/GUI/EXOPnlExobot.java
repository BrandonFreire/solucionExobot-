package UserInterface.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BusinessLogic.ExobotBL;
import DataAccess.DTO.ExobotDTO;
import UserInterface.CustomerControl.EXOButton;
import UserInterface.CustomerControl.EXOLabel;
import UserInterface.CustomerControl.EXOTextBox;

public class EXOPnlExobot extends JPanel implements ActionListener{
    private Integer idExabot, idMaxExabot;
    private ExobotBL  exobotBL  = null;
    private ExobotDTO   exobot  = null;

    public EXOPnlExobot() throws Exception{
        setGridBagLayout();
        loadData();
        showData();
        showTable();

        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
        btnGuardar.addActionListener(this);

        // Otra forma de poner escuchadores
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   btnNuevoClick(e);   }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                btnEliminarClick(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }   
            }
        });
    }
    
    private void loadData() throws Exception {
        idExabot      = 1;
        exobotBL      = new ExobotBL();
        exobot        = exobotBL.getReadBy(idExabot);
        //idMaxExabot   = exobotBL.getMaxidExabot();
    }
    private void showData() {
        boolean exobotNull = (exobot == null);
        txtidExabot.setText((exobotNull) ? " " : exobot.getIdExaBot().toString());            
        txtNombre.setText((exobotNull) ? " " : exobot.getNombre());
        //lblTotalReg.setText(idExabot.toString() + " de " + idMaxExabot.toString());
    }
    private void btnNuevoClick(ActionEvent e) {
        exobot = null;
        showData();
    } 
    private void btnEliminarClick(ActionEvent e) throws Exception {
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea Eliminar?", "Eliminar...",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               
            if(!exobotBL.delete(exobot.getIdExaBot()))
                JOptionPane.showMessageDialog(this, "Error al eliminar...!", "ERROR", JOptionPane.OK_OPTION);

            loadData();
            showData();
            showTable();
        }
    }
    private void btnGuardarClick(ActionEvent e) throws  Exception {
        boolean exobotNull = (exobot == null);
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar?", (exobotNull)?"Agregar...": "Actualizar...", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          
            loadData();
            showData();
            showTable();
        }
    } 
    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Estado"};
        Object[][] data = new Object[exobotBL.getAll().size()][6];  
        int index = 0;
        for(ExobotDTO s : exobotBL.getAll()) {
            data[index][0] = s.getIdExaBot();
            data[index][1] = s.getIdIABot();
            data[index][2] = s.getIdArmaDerecha();
            data[index][3] = s.getIdArmaIzquierda();
            data[index][4] = s.getNombre();
            data[index][5] = s.getSerie();
            index++;
        }
        
        JTable table  = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        //table.setBorder(border);
        // pnlTabla.setBorder( BorderFactory.createTitledBorder(
        //                     BorderFactory.createEtchedBorder(), " exobot ", TitledBorder.CENTER, TitledBorder.TOP));
      
        pnlTabla.removeAll();
        pnlTabla.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        pnlTabla.add(scrollPane);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
            @Override
            public void valueChanged(ListSelectionEvent e) {
          
                int col = 0;
                int row = table.getSelectedRow();
                String stridExabot = table.getModel().getValueAt(row, col).toString();

                idExabot = Integer.parseInt(stridExabot);
                try {
                    exobot    = exobotBL.getReadBy(idExabot);
                    showData(); 
                } catch (Exception e1) { }  
                System.out.println("Tabla.Selected: " + stridExabot);
            }
        });
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            idExabot  = 1;
        if(e.getSource() == btnAnt  &&  (idExabot>1) )
            idExabot--;
        if(e.getSource() == btnSig  &&  (idExabot<idMaxExabot))
            idExabot++;
        if(e.getSource() == btnFin)
            idExabot = idMaxExabot;

    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private EXOLabel  
            lblTitulo  = new EXOLabel("exobot"          ),
            lblidExabot  = new EXOLabel("Codigo:      " ),
            lblNombre  = new EXOLabel("Descripción: " ),
            lblTotalReg= new EXOLabel("  0 de 0  "    );
    private EXOTextBox  
            txtidExabot  = new EXOTextBox (),
            txtNombre  = new EXOTextBox ();
    private EXOButton  
            btnIni     = new EXOButton(" |< "), 
            btnAnt     = new EXOButton(" << "),            
            btnSig     = new EXOButton(" >> "),
            btnFin     = new EXOButton(" >| ");
    private EXOButton
            btnNuevo   = new EXOButton("Nuevo"),            
            btnGuardar = new EXOButton("Guardar"),
            btnCancelar= new EXOButton("Cancelar"),
            btnEliminar= new EXOButton("Eliminar");
    private JPanel 
            pnlTabla   = new JPanel(),
            pnlBtnCRUD = new JPanel(new FlowLayout()),
            pnlBtnPage = new JPanel(new FlowLayout());
    private Border  
            line       = new LineBorder(Color.lightGray),
            margin     = new EmptyBorder(5, 5, 5, 5),
            border     = new CompoundBorder(line, margin);
    
/************************
 * Customize : Form
 ************************/ 
    public void setGridBagLayout(){
        //setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        txtidExabot.setEnabled(false);
        
        // Panel.Paginacion.Tabla
        pnlBtnPage.add(btnIni);       
        pnlBtnPage.add(btnAnt);  
        pnlBtnPage.add(new EXOLabel(" Page: [ "));      
        pnlBtnPage.add(lblTotalReg);        
        pnlBtnPage.add(new EXOLabel(" ] "));      
        pnlBtnPage.add(btnSig);
        pnlBtnPage.add(btnFin);

        // Panel.CRUD
        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(border);

        // GridBagConstraints.Separación entre componentes
        gbc.insets=new Insets(5,5,5,5);    
        
        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
        gbc.gridwidth=3;                   //| celdas a unir
        add(lblTitulo, gbc);               //| agrega el control

        gbc.gridy = 1;       gbc.gridx=0;   
        gbc.gridwidth=1;                     
        add(new JLabel("■ Sección de datos: "), gbc);                 

        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   //| celdas a unir
        gbc.ipady = 150;                   //| tamaño alto
        gbc.ipadx = 450;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        pnlTabla.add(new Label("Loading data..."));
        //pnlTabla.setBorder(border);
        add(pnlTabla, gbc);
        
        gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        gbc.ipadx = 1;
        
        gbc.gridy = 3;       gbc.gridx=0;   
        gbc.gridwidth=3;  
        add(pnlBtnPage, gbc);  

        gbc.gridy = 4;       gbc.gridx=0; 
        gbc.gridwidth=1;    
        add(new JLabel("■ Sección de registro: "), gbc);  

        gbc.gridy = 5;       gbc.gridx=0;     add(lblidExabot,  gbc);   
        gbc.gridy = 5;       gbc.gridx=1;     add(txtidExabot,  gbc);   

        gbc.gridy = 6;       gbc.gridx=0;     add(lblNombre, gbc);        
        gbc.gridy = 6;       gbc.gridx=1;     add(txtNombre, gbc);
        gbc.gridy = 6;       gbc.gridx=2;     add(new JLabel("*"), gbc);  

        gbc.gridy = 7;       gbc.gridx=0;
        gbc.gridwidth=3;
        gbc.insets    = new Insets(30,0,0,0); 
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);

    }

}
