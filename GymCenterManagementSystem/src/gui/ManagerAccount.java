package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class ManagerAccount extends JFrame implements ActionListener{
	
    @Override
    public void actionPerformed(ActionEvent a) {
        try{
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
        Button btn1 = new Button("Manager/Trainer Account");
        Button btn2 = new Button("Customer Account");
        Button btn3 = new Button("All Appointment");
        Label lbl6 = new Label("Other Functions");
        Button btn4 = new Button("Payment& Feedback Analysis");
        Button btn5 = new Button("Generate Statistical Report");
        Button btn6 = new Button("Exit");

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
