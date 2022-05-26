package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import models.Data;

public class TrainerAccount  extends JFrame implements ActionListener{
	private Button btnExit, btn3, btn2, btn1;
	
	@Override
	public void actionPerformed(ActionEvent a) {
		try{	
			if (a.getSource() == btnExit){
				LoginPage loginpage = new LoginPage();
				Data.user = null;
				setVisible(false);
			}else if(a.getSource() == btn1) {
				UpdateProfile profile = new UpdateProfile();
				profile.setVisible(true);
				setVisible(false);
			}else if(a.getSource() == btn2) {
				ManageIndividualAppointment manageAppointment = new ManageIndividualAppointment();
				manageAppointment.setVisible(true);
				setVisible(false);
			}else if(a.getSource() == btn3) {
				CollectPaymentGiveFeedback paymentFeedback = new CollectPaymentGiveFeedback();
        		paymentFeedback.setVisible(true);
        		setVisible(false);
			}
		}catch(Exception e) {
			
		}
	}
	
	public TrainerAccount() {
		setSize(600, 400);
		setLocation(500, 200);
		setTitle("APU Gym Management System");
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		internalGUI();
		btnExit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		setVisible(true);
	}
	
	private void internalGUI() {
		Panel pTitle = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();
        Panel p5 = new Panel();
        Panel p6 = new Panel();
        
        Label lbl1 = new Label("Welcome, Trainer");
        Label lbl2 = new Label("You are Authorized to:");
        btn1 = new Button("Update Individual Profile");
        btn2 = new Button("Manage Individual Appointment");
        btn3 = new Button("Collect Payment & Give Feedback");
        btnExit = new Button("Exit");
        
        pTitle.setPreferredSize(new Dimension(500, 40));
        p2.setPreferredSize(new Dimension(600, 40));
        p3.setPreferredSize(new Dimension(600, 50));
        p4.setPreferredSize(new Dimension(600, 50));
        p5.setPreferredSize(new Dimension(600, 50));
        p6.setPreferredSize(new Dimension(600, 50));
        add(pTitle);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        
        pTitle.add(lbl1);
        p2.add(lbl2);
        p3.add(btn1);
        p4.add(btn2);
        p5.add(btn3);
        p6.add(btnExit);
	}
}
