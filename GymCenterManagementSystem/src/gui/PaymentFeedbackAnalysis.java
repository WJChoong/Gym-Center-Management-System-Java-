/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.table.DefaultTableModel;

import models.Appointment;
import models.Auth;
import models.Data;
import models.User;

/**
 *
 * @author MJ Lee
 */
public class PaymentFeedbackAnalysis extends javax.swing.JFrame {
	
    /**
     * Creates new form PaymentFeedbackAnalysis
     * @throws IOException 
     */
    public PaymentFeedbackAnalysis() throws IOException {
        initComponents();
        addRowToJTable();
    }
    
    private HashMap<String, Integer> ListAnalysis() throws IOException
    {
        ArrayList<User> list = new ArrayList<User>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(Auth.class.getClassLoader().getResourceAsStream("user.txt")));
    	String data = null;
    	while((data=reader.readLine()) != null) {
    		String[] rawData = data.split(",") ;
    		if (rawData[3].equals("T")) {
    			User user = new User();
                user.setId(rawData[0]);
                user.setName(rawData[4]);
                user.setPosition(rawData[3]);
                user.setAge(rawData[5]);
                user.setGender(rawData[6]);
                user.setCountry(rawData[7]);
                user.setPassword(rawData[2]);
                user.setUsername(rawData[1]);
                list.add(user);
    		}
    	}
    	reader.close();
    	
    	HashMap<String, Integer> trainers = new HashMap<String, Integer>();
    	for (int i = 0; i < list.size(); i++) {
    		trainers.put(list.get(i).getId(), 0);
    	}
    	
    	reader = new BufferedReader(new InputStreamReader(Auth.class.getClassLoader().getResourceAsStream("appointment.txt")));
    	data = null;
    	while((data=reader.readLine()) != null) {
    		String[] rawData = data.split(",") ;
    		String date = LocalDate.now().toString();
    		String[] splittedDate = date.split("-");
    		String year = rawData[3].split("-")[0];
    		String month = rawData[3].split("-")[1];
    		if (splittedDate[0].equals(year) && splittedDate[1].equals(month)) {
    			int cost = Integer.parseInt(rawData[5]) * 10;
    			trainers.put(rawData[1], trainers.get(rawData[2]) + cost);
    		}
    		
    	}
    	reader.close();
        return trainers;
    }
    
    private void addRowToJTable() throws IOException
    {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        HashMap<String, Integer> list = ListAnalysis();
    	for (Entry<String, Integer> set :list.entrySet()) {
    		Object rowData[] = new Object[2];
    		rowData[0] = set.getKey();
    		rowData[1] = set.getValue();
    		model.addRow(rowData);
    	}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws IOException {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Payment & Feedback Analysis");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trainer ID", "Collected Payment (RM)", "Uncollected Payment (RM)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Payment Analysis");

        jLabel3.setText("Feedback Analysis");

        HashMap<String, Integer> feedbacks = new HashMap<String, Integer>();
        feedbacks.put("Yes", 0);
    	feedbacks.put("No", 0);
    	feedbacks.put("Bad", 0);
    	feedbacks.put("Normal", 0);
    	feedbacks.put("Good", 0);
    	feedbacks.put("Facility", 0);
    	feedbacks.put("Price", 0);
    	feedbacks.put("Others", 0);
    	feedbacks.put("None", 0);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Auth.class.getClassLoader().getResourceAsStream("appointment.txt")));
    	String data = null;
    	while((data=reader.readLine()) != null) {
    		String[] rawData = data.split(",") ;
    		String date = LocalDate.now().toString();
    		String[] splittedDate = date.split("-");
    		String year = rawData[1].split("-")[0];
    		String month = rawData[1].split("-")[1];
    		if (splittedDate[0].equals(year) && splittedDate[1].equals(month)) {
    			feedbacks.put(rawData[2], feedbacks.get(rawData[2]) + 1);
    			feedbacks.put(rawData[3], feedbacks.get(rawData[3]) + 1);
    			feedbacks.put(rawData[4], feedbacks.get(rawData[4]) + 1);
    		}
    	}
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Satisfied with Our Gym", feedbacks.get("Yes")},
                {"Unsatisfied with Our Gym", feedbacks.get("No")},
                {"Good Experiences", feedbacks.get("Bad")},
                {"Normal Experiences", feedbacks.get("Normal")},
                {"Bad Experiences", feedbacks.get("Good")},
                {"Want to Improve Facility", feedbacks.get("Facility")},
                {"Want to Improve Salary", feedbacks.get("Price")},
                {"Want to Improve Others", feedbacks.get("Others")},
                {"Nothing to Improve", feedbacks.get("None")}
            },
            new String [] {
                "Reviews", "Counts"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentFeedbackAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentFeedbackAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentFeedbackAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentFeedbackAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new PaymentFeedbackAnalysis().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
