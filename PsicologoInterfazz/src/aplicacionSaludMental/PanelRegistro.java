package aplicacionSaludMental;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {
    private JTextField txtUsername;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;

    public PanelRegistro(JFrame parentFrame) {
        setLayout(new GridBagLayout()); // Cambiamos a GridBagLayout para centrar los componentes
        setPreferredSize(new Dimension(400, 300));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Alineación horizontal
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes

        JLabel lblUsername = new JLabel("Nombre de usuario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsername, gbc);

        txtUsername = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtUsername, gbc);

        JLabel lblEmail = new JLabel("Correo institucional:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblEmail, gbc);

        txtEmail = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtEmail, gbc);

        JLabel lblPassword = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblPassword, gbc);

        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtPassword, gbc);

        JLabel lblConfirmPassword = new JLabel("Repetir contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblConfirmPassword, gbc);

        txtConfirmPassword = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txtConfirmPassword, gbc);

        JButton btnCreateAccount = new JButton("Crear cuenta");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        btnCreateAccount.addActionListener(e -> {
            String username = txtUsername.getText();
            String email = txtEmail.getText();
            String password = new String(txtPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(parentFrame, "Todos los campos son obligatorios.");
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(parentFrame, "Las contraseñas no coinciden.");
                return;
            }

            if(AlmacenamientoUsuario.existeUsuario(username, email)){
                JOptionPane.showMessageDialog(parentFrame, "El usuario ya existe.");
                return;
            } else {
                AlmacenamientoUsuario.guardarUsuario(username, email, password);
                JOptionPane.showMessageDialog(parentFrame, "Cuenta creada para " + username + ".");
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new PanelPsicologo(parentFrame));
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        add(btnCreateAccount, gbc);
    }
}
