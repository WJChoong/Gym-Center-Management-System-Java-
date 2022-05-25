package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import models.Data;

public class ManagerAccount extends JFrame implements ActionListener{
	private Button btn1, btn2, btn3, btn4, btn5, btn6;
	
    @Override
    public void actionPerformed(ActionEvent a) {
        try{
        	if(a.getSource() == btn6) {
        		LoginPage loginpage = new LoginPage();
        		setVisible(false);
				Data.user = null;
        	}else if(a.getSource() == btn5) {
        		StatisticalReport statisticalReport = new StatisticalReport();
        		statisticalReport.setVisible(true);
        		setVisible(false);
        	}else if(a.getSource() == btn4) {
        		PaymentFeedbackAnalysis paymentFeedbackAnalysis = new PaymentFeedbackAnalysis();
        		paymentFeedbackAnalysis.setVisible(true);
        		setVisible(false);
        	}else if(a.getSource() == btn3) {
        		System.out.println("Hello");
        		ManageAppointment manageAppointment = new ManageAppointment();
        		System.out.println("Hello");
        		manageAppointment.setVisible(true);
        		System.out.println("Hello");
        		setVisible(false);
        	}else if(a.getSource() == btn2) {
        		ManageCustomer manageCustomer = new ManageCustomer();
        		manageCustomer.setVisible(true);
        		setVisible(false);
        	}else if(a.getSource() == btn1){
        		ManageManagerTrainer manageTrainer = new ManageManagerTrainer();
        		manageTrainer.setVisible(true);
        		setVisible(false);
        	}
        }catch(Exception e){
        	
        }
    }

    public ManagerAccount() {
        setSize(600, 400);
        setLocation(500, 200);
        setTitle("APU Gym Management System");
        setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        internalGUI();
        btn6.addActionListener(this);
        btn5.addActionListener(this);
        btn4.addActionListener(this);
        btn3.addActionListener(this);
        btn2.addActionListener(this);
        btn1.addActionListener(this);

        setVisible(true);	
    }

    private void internalGUI() {
        Panel pTitle = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();
        Panel p5 = new Panel();
        Panel p6 = new Panel();
        Panel p7 = new Panel();
        Panel p8 = new Panel();
        Panel p9 = new Panel();

        Label lbl1 = new Label("Welcome, Manager");
        Label lbl2 = new Label("Please Select to Manage:");
        btn1 = new Button("Manager/Trainer Account");
        btn2 = new Button("Customer Account");
        btn3 = new Button("All Appointment");
        Label lbl6 = new Label("Other Functions");
        btn4 = new Button("Payment& Feedback Analysis");
        btn5 = new Button("Generate Statistical Report");
        btn6 = new Button("Exit");

        pTitle.setPreferredSize(new Dimension(500, 40));
        p2.setPreferredSize(new Dimension(600, 30));
        p3.setPreferredSize(new Dimension(600, 30));
        p4.setPreferredSize(new Dimension(600, 30));
        p5.setPreferredSize(new Dimension(600, 30));
        p6.setPreferredSize(new Dimension(600, 30));
        p7.setPreferredSize(new Dimension(600, 30));
        p8.setPreferredSize(new Dimension(600, 30));
        p9.setPreferredSize(new Dimension(600, 30));
        add(pTitle);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);
        add(p9);    

        pTitle.add(lbl1);
        p2.add(lbl2);
        p3.add(btn1);
        p4.add(btn2);
        p5.add(btn3);
        p6.add(lbl6);
        p7.add(btn4);
        p8.add(btn5);
        p9.add(btn6);
    }
}
