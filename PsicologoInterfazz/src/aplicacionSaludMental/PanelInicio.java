package aplicacionSaludMental;

import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel {
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public PanelInicio(JFrame parentFrame) {
        setLayout(new GridBagLayout()); // Cambiamos a GridBagLayout para centrar los elementos
        setPreferredSize(new Dimension(400, 300));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Alineación horizontal
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre los componentes

        JLabel lblUsername = new JLabel("Usuario o correo:");
        gbc.gridx = 0; // Columna
        gbc.gridy = 0; // Fila
        gbc.gridwidth = 1;
        add(lblUsername, gbc);

        txtUsername = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtUsername, gbc);

        JLabel lblPassword = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblPassword, gbc);

        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtPassword, gbc);

        JButton btnLogin = new JButton("Ingresar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword());

            if (AlmacenamientoUsuario.usuarioCorrecto(username, password)) {
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new PanelPsicologo(parentFrame));
                parentFrame.revalidate();
                parentFrame.repaint();
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Usuario o contraseña incorrectos.");
            }
        });
        add(btnLogin, gbc);

        JButton btnRegister = new JButton("Registrarse");
        gbc.gridx = 1;
        gbc.gridy = 2;
        btnRegister.addActionListener(e -> {
            parentFrame.getContentPane().removeAll();
            parentFrame.getContentPane().add(new PanelRegistro(parentFrame));
            parentFrame.revalidate();
            parentFrame.repaint();
        });
        add(btnRegister, gbc);
    }
}
