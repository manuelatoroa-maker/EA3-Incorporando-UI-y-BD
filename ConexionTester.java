package vista;

import conexion.ConexionBD;

import javax.swing.*;
import java.awt.*;

public class ConexionTester extends JFrame {

    private JTextField txtUrl;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnProbar;
    private JTextArea txtResultado;

    public ConexionTester() {

        setTitle("Probador de conexión JDBC");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        crearInterfaz();

        setVisible(true);
    }

    private void crearInterfaz() {

        JPanel panelformulario =
                new JPanel(
                        new GridLayout(3,2,5,5)
                );

        panelformulario.add(
                new JLabel("URL:")
        );

        txtUrl = new JTextField();
        panelformulario.add(txtUrl);

        panelformulario.add(
                new JLabel("Usuario:")
        );

        txtUsuario = new JTextField();
        panelformulario.add(txtUsuario);

        panelformulario.add(
                new JLabel("Contraseña:")
        );

        txtPassword =
                new JPasswordField();

        panelformulario.add(txtPassword);

        btnProbar =
                new JButton(
                        "Probar Conexión"
                );

        txtResultado =
                new JTextArea();

        txtResultado.setEditable(false);

        JScrollPane scroll =
                new JScrollPane(
                        txtResultado
                );

        btnProbar.addActionListener(
                e -> probarConexion()
        );

        add(
                panelformulario,
                BorderLayout.NORTH
        );

        add(
                btnProbar,
                BorderLayout.CENTER
        );

        add(
                scroll,
                BorderLayout.SOUTH
        );
    }

    private void probarConexion() {

        String url =
                txtUrl.getText();

        String usuario =
                txtUsuario.getText();

        String password =
                new String(
                        txtPassword.getPassword()
                );

        ConexionBD conexion =
                new ConexionBD();

        String resultado =
                conexion.probarConexion(
                        url,
                        usuario,
                        password
                );

        txtResultado.setText(resultado);
    }
}
