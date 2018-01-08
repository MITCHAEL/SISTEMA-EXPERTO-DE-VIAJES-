/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Clases.conexionMsql;
import static Principal.Reserva.txtNombre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jpl7.Query;

/**
 *
 * @author Adams
 */
public class TursUnsch extends javax.swing.JInternalFrame {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;

    /**
     * Creates new form TursUnsch
     */
    public TursUnsch() {
        initComponents();
        limpiar();
        DeshabilitadoTransporte();
        DeshabilitadoLugarTur();
        laNumpersonas.setEnabled(false);
        txtRecibidoPersonas.setEnabled(false);

    }

    void limpiar() {
        txnombre.setText("");
        txdni.setText("");
        txtelefono.setText("");
        txhabitacion.setText("");
    }

    public void DeshabilitadoTransporte() { //Deshabilita los items del panel transporte
        cmbVuelosCiudades.setEnabled(false);
        laVuelos.setEnabled(false);
        laTerreste.setEnabled(false);
        btnEscogerTransporte.setEnabled(false);
        cmbTerreste.setEnabled(false);
        rbtnTerreste.setEnabled(false);
        rbtnVuelo.setEnabled(false);
        btnSalirTransporte.setEnabled(false);
        cmbVuelosCiudades.removeAllItems();
    }

    public void HabilitadoTransporte() { //Habilita los items del panel transporte
        cmbVuelosCiudades.setEnabled(true);
        laVuelos.setEnabled(true);
        laTerreste.setEnabled(true);
        btnEscogerTransporte.setEnabled(true);
        cmbTerreste.setEnabled(true);
        rbtnTerreste.setEnabled(true);
        rbtnVuelo.setEnabled(true);
        btnSalirTransporte.setEnabled(true);
    }

    public void DeshabilitadoDepartamento() { // Deshabilita los items del panel Departamento
        btnBuscarDepartamento.setEnabled(false);
        laDepartamento.setEnabled(false);
        cmbDepartamento.setEnabled(false);

    }

    public void HabilitadoDepartamento() { // Habilita  los items del panel transporte
        btnBuscarDepartamento.setEnabled(true);
        laDepartamento.setEnabled(true);
        cmbDepartamento.setEnabled(true);

    }

    public void DeshabilitadoLugarTur() {
        laLugarTur.setEnabled(false);
        laEntradaLugarTur.setEnabled(false);
        //laNumPersonasLugarTur.setEnabled(false);
        cmbLugarTuristico.setEnabled(false);
        //txtContador2.setEnabled(false);
    }

    public void HabilitadoLugarTur() {
        laLugarTur.setEnabled(true);
        laEntradaLugarTur.setEnabled(true);
        //laNumPersonasLugarTur.setEnabled(true);
        cmbLugarTuristico.setEnabled(true);
        //txtContador2.setEnabled(true);
    }

    public void Conexion() {
        String Conection = "consult('trabajo.pl')";
        Query Result0 = new Query(Conection);

        if (Result0.hasSolution()) {
            System.out.println("Conectado a " + Conection);
        } else {
            System.out.println("No");
        }
    }

    public void precioLugarTuristico() {
        // consulta simple para brindar precio individual
        String departamento = (String) cmbDepartamento.getSelectedItem();

        String precioLugar = (String) cmbLugarTuristico.getSelectedItem();
        String consultaPrecio = "lugarturistico(" + precioLugar + "," + departamento + ",Y)";
        Query precio = new Query(consultaPrecio);
        txtPrecioPersonaLugarTuris.setText(precio.oneSolution().get("Y").toString());

    }

    public void consultarLugaresTuristicos() {
        //CONSULTA LUGAR TURISTICO
        String[] lugarturistico = new String[20]; //crea array para almacenar lugar turistico
        int b = 0;
        try {
            // varias consultas
            String departamento = (String) cmbDepartamento.getSelectedItem();
            java.util.HashMap salida;
            String consulta = "lugarturistico(X," + departamento + ",Y)";
            Query respuesta = new Query(consulta);

            while (respuesta.hasMoreSolutions()) {
                salida = (HashMap) respuesta.nextSolution();
                lugarturistico[b] = salida.get("X").toString();
                b++;
            }

            if (b != 0) {

                for (int i = 0; i <= b - 1; i++) {
                    cmbLugarTuristico.addItem(lugarturistico[i]);
                }

            } else {

            }

            b = 0;

        } catch (Exception e) {
        }
    }

    public void borrarComboLugarTur() {
        cmbLugarTuristico.removeAllItems();
    }

    public void borrarComboVuelos() {
        cmbVuelosCiudades.removeAllItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoVueloTerrestre = new javax.swing.ButtonGroup();
        GrupoHabitacion = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        paVuelo1 = new javax.swing.JPanel();
        btnBuscarDepartamento = new javax.swing.JButton();
        cmbDepartamento = new javax.swing.JComboBox();
        laDepartamento = new javax.swing.JLabel();
        txtRecibidoPersonas = new javax.swing.JLabel();
        laNumpersonas = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        paTransporte = new javax.swing.JPanel();
        rbtnVuelo = new javax.swing.JRadioButton();
        rbtnTerreste = new javax.swing.JRadioButton();
        cmbVuelosCiudades = new javax.swing.JComboBox();
        laVuelos = new javax.swing.JLabel();
        cmbTerreste = new javax.swing.JComboBox();
        laTerreste = new javax.swing.JLabel();
        btnEscogerTransporte = new javax.swing.JButton();
        btnSalirTransporte = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        txdni = new javax.swing.JTextField();
        txtelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txhabitacion = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jhabitacion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCostoAlimentacion = new javax.swing.JTextField();
        laEntradaLugarTur1 = new javax.swing.JLabel();
        btnAceptarAlimentacion = new javax.swing.JButton();
        checkAlmuerzo = new javax.swing.JCheckBox();
        checkCena = new javax.swing.JCheckBox();
        checkDesayuno = new javax.swing.JCheckBox();
        paLugarTuristico = new javax.swing.JPanel();
        laLugarTur = new javax.swing.JLabel();
        cmbLugarTuristico = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        laEntradaLugarTur = new javax.swing.JLabel();
        laPersonaPrecioLugarTur = new javax.swing.JLabel();
        txtPrecioPersonaLugarTuris = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtPrecioLT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("TURISMO UNSCH S.A.C");

        paVuelo1.setBackground(new java.awt.Color(204, 204, 255));
        paVuelo1.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento Destino"));

        btnBuscarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        btnBuscarDepartamento.setText("Buscar");
        btnBuscarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDepartamentoActionPerformed(evt);
            }
        });

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "amazonas", "ancash", "apurimac", "arequipa", "cajamarca", "cusco", "huancavelica", "huanuco", "ica", "junin", "'la libertad'", "lambayeque", "lima", "loreto", "'madre de dios'", "moquegua", "pasco", "piura", "puno", "'san martin'", "tacna", "tumbes", "ucayalli" }));
        cmbDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbDepartamentoMouseClicked(evt);
            }
        });
        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        laDepartamento.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laDepartamento.setText("Departamento:");

        laNumpersonas.setText("Numero de personas:");

        javax.swing.GroupLayout paVuelo1Layout = new javax.swing.GroupLayout(paVuelo1);
        paVuelo1.setLayout(paVuelo1Layout);
        paVuelo1Layout.setHorizontalGroup(
            paVuelo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paVuelo1Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(paVuelo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paVuelo1Layout.createSequentialGroup()
                        .addComponent(laDepartamento)
                        .addGap(57, 57, 57)
                        .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paVuelo1Layout.createSequentialGroup()
                        .addComponent(laNumpersonas)
                        .addGap(18, 18, 18)
                        .addComponent(txtRecibidoPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnBuscarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paVuelo1Layout.setVerticalGroup(
            paVuelo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paVuelo1Layout.createSequentialGroup()
                .addGroup(paVuelo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paVuelo1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(laDepartamento))
                    .addGroup(paVuelo1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(paVuelo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paVuelo1Layout.createSequentialGroup()
                        .addGroup(paVuelo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRecibidoPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laNumpersonas))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        GrupoVueloTerrestre.add(rbtnVuelo);
        rbtnVuelo.setText("Vuelo");
        rbtnVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVueloActionPerformed(evt);
            }
        });

        GrupoVueloTerrestre.add(rbtnTerreste);
        rbtnTerreste.setSelected(true);
        rbtnTerreste.setText("Terreste");
        rbtnTerreste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTerresteActionPerformed(evt);
            }
        });

        laVuelos.setText("Vuelos:");

        cmbTerreste.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bus" }));

        laTerreste.setText("Terreste:");

        btnEscogerTransporte.setText("AGREGAR");
        btnEscogerTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscogerTransporteActionPerformed(evt);
            }
        });

        btnSalirTransporte.setText("SALIR");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/airport.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bus.png"))); // NOI18N
        jLabel10.setText("jLabel9");

        javax.swing.GroupLayout paTransporteLayout = new javax.swing.GroupLayout(paTransporte);
        paTransporte.setLayout(paTransporteLayout);
        paTransporteLayout.setHorizontalGroup(
            paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paTransporteLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnVuelo)
                    .addGroup(paTransporteLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laVuelos)
                            .addComponent(laTerreste))))
                .addGap(57, 57, 57)
                .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbVuelosCiudades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paTransporteLayout.createSequentialGroup()
                        .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTerreste, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnTerreste)
                            .addComponent(btnEscogerTransporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(btnSalirTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(paTransporteLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paTransporteLayout.setVerticalGroup(
            paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paTransporteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnVuelo)
                    .addComponent(rbtnTerreste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVuelosCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laVuelos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTerreste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laTerreste))
                .addGap(18, 18, 18)
                .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscogerTransporte)
                    .addComponent(btnSalirTransporte))
                .addGap(27, 27, 27)
                .addGroup(paTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jTabbedPane3.addTab("Transporte", paTransporte);

        jLabel2.setText("Tipo de habitacion:");

        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cliente", "DNI", "Telefono", "Tipo", "N° de cuartos"
            }
        ));
        jScrollPane1.setViewportView(jTabla);

        jLabel3.setText("Cliente:");

        jLabel4.setText("DNI:");

        jLabel5.setText("Telefono:");

        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });

        txdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txdniActionPerformed(evt);
            }
        });

        txtelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelefonoActionPerformed(evt);
            }
        });

        jLabel6.setText("# de Habitaciones:");

        txhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txhabitacionActionPerformed(evt);
            }
        });

        jButton5.setText("Editar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Guardar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1485418687_users-9.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jhabitacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simple", "Doble", "Matrimonial" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jButton3)
                                .addGap(28, 28, 28)
                                .addComponent(jButton5)
                                .addGap(42, 42, 42)
                                .addComponent(jButton6))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jhabitacion, 0, 269, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel5))
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txdni, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txhabitacion, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Alojamiento", jPanel8);

        jLabel7.setText("Servicio:");

        jButton4.setText("Agregar");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dinner.png"))); // NOI18N

        txtCostoAlimentacion.setEnabled(false);
        txtCostoAlimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoAlimentacionActionPerformed(evt);
            }
        });

        laEntradaLugarTur1.setText("Costo:");

        btnAceptarAlimentacion.setText("Aceptar");
        btnAceptarAlimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarAlimentacionActionPerformed(evt);
            }
        });

        checkAlmuerzo.setText("Almuerzo");
        checkAlmuerzo.setToolTipText("");
        checkAlmuerzo.setActionCommand("almuerzo");

        checkCena.setText("Cena");
        checkCena.setToolTipText("");
        checkCena.setActionCommand("almuerzo");

        checkDesayuno.setText("Desayuno");
        checkDesayuno.setToolTipText("");
        checkDesayuno.setActionCommand("almuerzo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptarAlimentacion)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(206, 206, 206)
                            .addComponent(jButton4))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(checkAlmuerzo)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(checkDesayuno)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                        .addComponent(laEntradaLugarTur1)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtCostoAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(checkCena)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCostoAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laEntradaLugarTur1)
                    .addComponent(checkDesayuno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkAlmuerzo)
                .addGap(5, 5, 5)
                .addComponent(checkCena)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btnAceptarAlimentacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );

        jTabbedPane3.addTab("Alimentacion", jPanel2);

        laLugarTur.setText("Lugares turisticos:");

        cmbLugarTuristico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbLugarTuristicoMouseClicked(evt);
            }
        });
        cmbLugarTuristico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLugarTuristicoActionPerformed(evt);
            }
        });
        cmbLugarTuristico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbLugarTuristicoKeyPressed(evt);
            }
        });

        laEntradaLugarTur.setText("entrada+pasaje:");

        laPersonaPrecioLugarTur.setText("Precio por Persona:");

        txtPrecioPersonaLugarTuris.setEnabled(false);

        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtPrecioLT.setEnabled(false);
        txtPrecioLT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioLTActionPerformed(evt);
            }
        });

        jButton1.setText("ACEPTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/collafge.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(laPersonaPrecioLugarTur)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecioPersonaLugarTuris, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(laEntradaLugarTur)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPrecioLT, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioPersonaLugarTuris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laPersonaPrecioLugarTur)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laEntradaLugarTur)
                    .addComponent(txtPrecioLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paLugarTuristicoLayout = new javax.swing.GroupLayout(paLugarTuristico);
        paLugarTuristico.setLayout(paLugarTuristicoLayout);
        paLugarTuristicoLayout.setHorizontalGroup(
            paLugarTuristicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paLugarTuristicoLayout.createSequentialGroup()
                .addGroup(paLugarTuristicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paLugarTuristicoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(laLugarTur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbLugarTuristico, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paLugarTuristicoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(515, 515, 515))
        );
        paLugarTuristicoLayout.setVerticalGroup(
            paLugarTuristicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paLugarTuristicoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(paLugarTuristicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laLugarTur)
                    .addComponent(cmbLugarTuristico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Lugar Turistico", paLugarTuristico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paVuelo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paVuelo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDepartamentoActionPerformed
        // CONSULTA PARA VIAJE
        String[] ciudad = new String[20]; // creacion array para almacenamiento de las ciudades
        String departamento = (String) cmbDepartamento.getSelectedItem();
        java.util.HashMap salida;
        int a = 0;
        try {
            // varias consultas
            String consulta = "pertenece(X," + departamento + ")";
            Query respuesta = new Query(consulta);

            while (respuesta.hasMoreSolutions()) {
                salida = (HashMap) respuesta.nextSolution();
                ciudad[a] = salida.get("X").toString();
                a++;
            }

            if (a != 0) {
                DeshabilitadoDepartamento();
                borrarComboLugarTur();
                HabilitadoTransporte();
                consultarLugaresTuristicos();
                HabilitadoLugarTur();

            } else {
                HabilitadoTransporte();
                consultarLugaresTuristicos();
                HabilitadoLugarTur();
                cmbVuelosCiudades.setEnabled(false);
                rbtnVuelo.setEnabled(false);
            }

            for (int i = 0; i <= a - 1; i++) {
                cmbVuelosCiudades.addItem(ciudad[i]);
            }

            a = 0; // reinicia el array
            DeshabilitadoDepartamento();
        } catch (Exception e) {
            DeshabilitadoTransporte();
            JOptionPane.showMessageDialog(paTransporte, "Vuelva a buscar");
            HabilitadoDepartamento();
        }

        if (rbtnTerreste.isSelected()) {
            laVuelos.setEnabled(false);
            cmbVuelosCiudades.setEnabled(false);
            cmbTerreste.setEnabled(true);
            laTerreste.setEnabled(true);
        } else if (rbtnVuelo.isSelected()) {
            laVuelos.setEnabled(true);
            cmbVuelosCiudades.setEnabled(true);
            cmbTerreste.setEnabled(false);
            laTerreste.setEnabled(false);
        }

    }//GEN-LAST:event_btnBuscarDepartamentoActionPerformed

    private void cmbDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbDepartamentoMouseClicked

    }//GEN-LAST:event_cmbDepartamentoMouseClicked

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed

    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void btnEscogerTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscogerTransporteActionPerformed

        HabilitadoDepartamento();
        DeshabilitadoTransporte();
        borrarComboVuelos();
    }//GEN-LAST:event_btnEscogerTransporteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPrecioLTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioLTActionPerformed

    }//GEN-LAST:event_txtPrecioLTActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            //consulta simple para brindar precio final de lugar turistico
            String departamento = (String) cmbDepartamento.getSelectedItem();
            String numeroPersonas = txtRecibidoPersonas.getText();
            String lugar = (String) cmbLugarTuristico.getSelectedItem();

            String consultaPrecio = "preciolugarturistico(" + lugar + "," + departamento + "," + numeroPersonas + ",Y)";
            Query precio = new Query(consultaPrecio);
            String precioFinal = precio.oneSolution().get("Y").toString();
            txtPrecioLT.setText(precioFinal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(paTransporte, "Debe ingresar un numero");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbLugarTuristicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbLugarTuristicoKeyPressed

    }//GEN-LAST:event_cmbLugarTuristicoKeyPressed

    private void cmbLugarTuristicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLugarTuristicoActionPerformed
        precioLugarTuristico();
    }//GEN-LAST:event_cmbLugarTuristicoActionPerformed

    private void cmbLugarTuristicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbLugarTuristicoMouseClicked

    }//GEN-LAST:event_cmbLugarTuristicoMouseClicked

    private void txtCostoAlimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoAlimentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoAlimentacionActionPerformed

    private void btnAceptarAlimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarAlimentacionActionPerformed
        try {
            //consulta simple para brindar precio final de lugar turistico

            String numPersonas = txtRecibidoPersonas.getText();

            if (checkAlmuerzo.isSelected() && checkCena.isSelected() && checkCena.isSelected()) {
                //JOptionPane.showMessageDialog(paTransporte, "si");
                String consultaPrecio1 = "comidaxdia(almuerzo," + numPersonas + ",Y)";
                String consultaPrecio2 = "comidaxdia(desayuno," + numPersonas + ",Y)";
                String consultaPrecio3 = "comidaxdia(cena," + numPersonas + ",Y)";
                Query precio1 = new Query(consultaPrecio1);
                Query precio2 = new Query(consultaPrecio2);
                Query precio3 = new Query(consultaPrecio3);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();
                String precioFinal2 = precio2.oneSolution().get("Y").toString();
                String precioFinal3 = precio3.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int preciof2 = Integer.parseInt(precioFinal2);
                int preciof3 = Integer.parseInt(precioFinal3);
                int total = preciof1 + preciof2 + preciof3;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);

            } else if (checkAlmuerzo.isSelected() && checkCena.isSelected()) {
                String consultaPrecio1 = "comidaxdia(almuerzo," + numPersonas + ",Y)";
                String consultaPrecio2 = "comidaxdia(cena," + numPersonas + ",Y)";

                Query precio1 = new Query(consultaPrecio1);
                Query precio2 = new Query(consultaPrecio2);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();
                String precioFinal2 = precio2.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int preciof2 = Integer.parseInt(precioFinal2);

                int total = preciof1 + preciof2;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);

            } else if (checkAlmuerzo.isSelected() && checkDesayuno.isSelected()) {
                String consultaPrecio1 = "comidaxdia(almuerzo," + numPersonas + ",Y)";
                String consultaPrecio2 = "comidaxdia(desayuno," + numPersonas + ",Y)";

                Query precio1 = new Query(consultaPrecio1);
                Query precio2 = new Query(consultaPrecio2);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();
                String precioFinal2 = precio2.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int preciof2 = Integer.parseInt(precioFinal2);

                int total = preciof1 + preciof2;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);
            } else if (checkCena.isSelected() && checkDesayuno.isSelected()) {
                String consultaPrecio1 = "comidaxdia(cena," + numPersonas + ",Y)";
                String consultaPrecio2 = "comidaxdia(desayuno," + numPersonas + ",Y)";

                Query precio1 = new Query(consultaPrecio1);
                Query precio2 = new Query(consultaPrecio2);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();
                String precioFinal2 = precio2.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int preciof2 = Integer.parseInt(precioFinal2);
                int total = preciof1 + preciof2;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);
            } else if (checkCena.isSelected()) {
                String consultaPrecio1 = "comidaxdia(cena," + numPersonas + ",Y)";

                Query precio1 = new Query(consultaPrecio1);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int total = preciof1;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);
            } else if (checkDesayuno.isSelected()) {
                String consultaPrecio1 = "comidaxdia(desayuno," + numPersonas + ",Y)";

                Query precio1 = new Query(consultaPrecio1);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int total = preciof1;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);

            } else if (checkCena.isSelected()) {
                String consultaPrecio1 = "comidaxdia(cena," + numPersonas + ",Y)";

                Query precio1 = new Query(consultaPrecio1);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int total = preciof1;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);
            } else if (checkAlmuerzo.isSelected()) {
                String consultaPrecio1 = "comidaxdia(almuerzo," + numPersonas + ",Y)";

                Query precio1 = new Query(consultaPrecio1);

                String precioFinal1 = precio1.oneSolution().get("Y").toString();

                int preciof1 = Integer.parseInt(precioFinal1);
                int total = preciof1;
                String totalisimo = String.valueOf(total);
                txtCostoAlimentacion.setText(totalisimo);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(paTransporte, "Debe ingresar un numero");
        }
    }//GEN-LAST:event_btnAceptarAlimentacionActionPerformed

    private void rbtnTerresteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTerresteActionPerformed
        if (rbtnTerreste.isSelected()) {
            laVuelos.setEnabled(false);
            cmbVuelosCiudades.setEnabled(false);
            cmbTerreste.setEnabled(true);
            laTerreste.setEnabled(true);
        } else if (rbtnVuelo.isSelected()) {
            laVuelos.setEnabled(true);
            cmbVuelosCiudades.setEnabled(true);
            cmbTerreste.setEnabled(false);
            laTerreste.setEnabled(false);
        }
    }//GEN-LAST:event_rbtnTerresteActionPerformed

    private void rbtnVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVueloActionPerformed
        if (rbtnTerreste.isSelected()) {
            laVuelos.setEnabled(false);
            cmbVuelosCiudades.setEnabled(false);
            cmbTerreste.setEnabled(true);
            laTerreste.setEnabled(true);
        } else if (rbtnVuelo.isSelected()) {
            laVuelos.setEnabled(true);
            cmbVuelosCiudades.setEnabled(true);
            cmbTerreste.setEnabled(false);
            laTerreste.setEnabled(false);
        }
    }//GEN-LAST:event_rbtnVueloActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
        // TODO add your handling code here:
        txnombre.transferFocus();
    }//GEN-LAST:event_txnombreActionPerformed

    private void txdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdniActionPerformed
        // TODO add your handling code here:
        txdni.transferFocus();
    }//GEN-LAST:event_txdniActionPerformed

    private void txtelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelefonoActionPerformed
        // TODO add your handling code here:
        txtelefono.transferFocus();
    }//GEN-LAST:event_txtelefonoActionPerformed

    private void txhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txhabitacionActionPerformed
        // TODO add your handling code here:
        txhabitacion.transferFocus();
    }//GEN-LAST:event_txhabitacionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        conexionMsql cc = new conexionMsql();
        Connection cn = cc.conexion();
        String nom, tef, dni, hab;
        String sql = "";
        nom = txnombre.getText();
        tef = txtelefono.getText();
        dni = txdni.getText();
        hab = txhabitacion.getText();
        String tip = jhabitacion.getSelectedItem().toString();
        sql = "INSERT INTO alojamiento(cliente,dni,telefono,num_habitacion,tipo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, dni);
            pst.setString(3, tef);
            pst.setString(4, hab);
            pst.setString(5, tip);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, " Registro Guardado con Exito");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysqsl.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/trabajo","root","");
            ps = cn.prepareStatement("SELECT cliente, dni, telefono,num_habitacion, tipo FROM ALOJAMIENTO");
            rs = ps.executeQuery();
            rsm =rs.getMetaData();
            ArrayList<Object[]>data = new ArrayList<>();
            while(rs.next()){
                Object[] rows= new Object[rsm.getColumnCount()];
                for (int i=0; i<rows.length; i++){
                    rows[i]= rs.getObject(i++);
                }
                data.add(rows);
                
            }
            dtm = (DefaultTableModel)this.jTabla.getModel();
            for (int i=0;i<data.size();i++){
                dtm.addRow(data.get(i));
                                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoHabitacion;
    private javax.swing.ButtonGroup GrupoVueloTerrestre;
    private javax.swing.JButton btnAceptarAlimentacion;
    private javax.swing.JButton btnBuscarDepartamento;
    private javax.swing.JButton btnEscogerTransporte;
    private javax.swing.JButton btnSalirTransporte;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkAlmuerzo;
    private javax.swing.JCheckBox checkCena;
    private javax.swing.JCheckBox checkDesayuno;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbLugarTuristico;
    private javax.swing.JComboBox cmbTerreste;
    private javax.swing.JComboBox cmbVuelosCiudades;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTabla;
    private javax.swing.JComboBox jhabitacion;
    private javax.swing.JLabel laDepartamento;
    private javax.swing.JLabel laEntradaLugarTur;
    private javax.swing.JLabel laEntradaLugarTur1;
    private javax.swing.JLabel laLugarTur;
    private javax.swing.JLabel laNumpersonas;
    private javax.swing.JLabel laPersonaPrecioLugarTur;
    private javax.swing.JLabel laTerreste;
    private javax.swing.JLabel laVuelos;
    private javax.swing.JPanel paLugarTuristico;
    private javax.swing.JPanel paTransporte;
    private javax.swing.JPanel paVuelo1;
    private javax.swing.JRadioButton rbtnTerreste;
    private javax.swing.JRadioButton rbtnVuelo;
    private javax.swing.JTextField txdni;
    private javax.swing.JTextField txhabitacion;
    private javax.swing.JTextField txnombre;
    private javax.swing.JTextField txtCostoAlimentacion;
    private javax.swing.JTextField txtPrecioLT;
    private javax.swing.JTextField txtPrecioPersonaLugarTuris;
    public static javax.swing.JLabel txtRecibidoPersonas;
    private javax.swing.JTextField txtelefono;
    // End of variables declaration//GEN-END:variables
}
