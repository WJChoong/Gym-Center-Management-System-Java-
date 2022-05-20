package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener{
	private Label lblTitle, lblUser, lblPass;
    private TextField txtUser, txtPass;
    private Button btnLogin, btnForget, btnRegister;
    private String username, password;
    
	public LoginPage() {
            setSize(600, 400);
            setLocation(500, 200);
            setTitle("APU Gym Management System");
            setLayout(new FlowLayout());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            internalGUI();
            btnLogin.addActionListener(this);
            btnForget.addActionListener(this);
            btnRegister.addActionListener(this);
		
            setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void internalGUI() {
		Panel pTitle = new Panel();
        Panel pUser = new Panel();
        Panel pPass = new Panel();
        Panel pButton = new Panel();
        
        pTitle.setPreferredSize(new Dimension(600, 50));
        pUser.setPreferredSize(new Dimension(600, 50));
        pPass.setPreferredSize(new Dimension(600, 50));
        pButton.setPreferredSize(new Dimension(600, 50));
        add(pTitle);
        add(pUser);
        add(pPass);
        add(pButton);
        
        lblTitle = new Label("User Login");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        pTitle.add(lblTitle); 
        
        lblUser = new Label("Username: ");
        txtUser = new TextField("", 20);
        pUser.add(lblUser); 
        pUser.add(txtUser);
        
        lblPass = new Label("Password: ");
        txtPass = new TextField("", 20);
        pPass.add(lblPass); 
        pPass.add(txtPass);
        
        btnRegister = new Button("Register");
        btnRegister.setFont(new Font("Verdana", Font.PLAIN, 15));
        pButton.add(btnRegister);
        btnLogin = new Button("Login");
        btnLogin.setFont(new Font("Verdana", Font.PLAIN, 15));
        pButton.add(btnLogin); 
        btnForget = new Button("Forget Password");
        btnForget.setFont(new Font("Verdana", Font.PLAIN, 15));
        pButton.add(btnForget); 
	}
}
