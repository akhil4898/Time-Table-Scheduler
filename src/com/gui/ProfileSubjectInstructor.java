package com.gui;

import com.data_structure.DBConnect;
import com.data_structure.DBConnect1;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ProfileSubjectInstructor extends javax.swing.JInternalFrame {

    public ProfileSubjectInstructor() {
        DBConnect.connect();
        DBConnect1.connect();
        initComponents();
        checkForSubjects();
    }

    public void checkForSubjects(){
        try {
            String selected = ""+subject.getSelectedItem();
            int a=1;

            PreparedStatement st;

            String sql="select sub_name from subject";
            st = DBConnect.con.prepareStatement(sql);

            DBConnect.rs = st.executeQuery();

            while(DBConnect.rs.next()){
                a=a+1;
            }
            sql="select sub_name from subject ORDER BY sub_name DESC";
            st = DBConnect.con.prepareStatement(sql);

            DBConnect.rs = st.executeQuery();
            String subjects[]= new String[a];

            while(DBConnect.rs.next()){
                a--;
                String sub_name = DBConnect.rs.getString("sub_name");
                subjects[a]=sub_name;
            }
            subjects[0]="-- Select Subject --";
            subject.setModel(new javax.swing.DefaultComboBoxModel(subjects));
            subject.setSelectedItem(selected);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        subject = new javax.swing.JComboBox();
        insert = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instructor_list = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 480));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 12, 92));
        jPanel2.setPreferredSize(new java.awt.Dimension(596, 488));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tiger Expert", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROFILE SUBJECT INSTRUCTORS PAGE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 495, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)), "Select Subject", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tempus Sans ITC", 1, 14), java.awt.Color.darkGray)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subject.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        subject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Select Subject --" }));
        subject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectItemStateChanged(evt);
            }
        });
        jPanel3.add(subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 220, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 420, 70));

        insert.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        insert.setText("Upload the Information");
        insert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 12, 92), 2));
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel1.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 260, 35));

        close.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        close.setText("Close");
        close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 12, 92), 2));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 80, 35));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)), "Select Instructors", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tempus Sans ITC", 1, 14), java.awt.Color.darkGray)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructor_list.setToolTipText("Hold ctrl then click to select multiple instructors");
        jScrollPane1.setViewportView(instructor_list);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 280, 220));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 420, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        this.dispose();
        this.hide();
    }//GEN-LAST:event_closeActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        if(subject.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this,"Please select a subject", "Issue", JOptionPane.OK_OPTION);
        }else if(instructor_list.getSelectedIndices().length == 0){
            JOptionPane.showMessageDialog(this,"Please choose the subject instructor(s)", "Issue", JOptionPane.OK_OPTION);
        }else{
            try{
                int confirm = JOptionPane.showConfirmDialog(this, "Upload subject instrutor(s)?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    DBConnect.con.setAutoCommit(false);
                    PreparedStatement st;
                    String sql = "select * from subject where sub_name = ?";
                    st = DBConnect.con.prepareStatement(sql);
                    st.setString(1, ""+subject.getSelectedItem());

                    DBConnect.rs = st.executeQuery();
                    DBConnect.rs.next();

                    int sub_id = DBConnect.rs.getInt("sub_id");

                    sql = "delete from subject_instructor where sub_id = ?";

                    st = DBConnect.con.prepareStatement(sql);
                    st.setInt(1, sub_id);

                    st.executeUpdate();

                    int[] selected = instructor_list.getSelectedIndices();
                    for(int i = 0; i < selected.length; i++){
                        int instructor_id = instructor_ids[selected[i]];

                        sql = "insert into subject_instructor (sub_id, instructor_id) values (?,?)";
                        st = DBConnect.con.prepareStatement(sql);
                        st.setInt(1, sub_id);
                        st.setInt(2, instructor_id);

                        st.executeUpdate();
                    }

                    DBConnect.con.commit();
                    JOptionPane.showMessageDialog(this, "Subject instructor(s) information has been saved","Success",JOptionPane.INFORMATION_MESSAGE);
                    ProfileSubjectInstructor reg = new ProfileSubjectInstructor();
                    MainMenu.desktop1.removeAll();
                    MainMenu.desktop1.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));
                    MainMenu.desktop1.setVisible(false);
                    MainMenu.desktop1.setVisible(true);
                    MainMenu.desktop1.setSelectedFrame(reg);
                }
            }catch(Exception ex){
                try{
                    DBConnect.con.rollback();
                }catch(Exception ex1){
                    ex1.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Trouble execution query", "Issue!", JOptionPane.OK_OPTION);
                }
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Trouble execution query", "Issue!", JOptionPane.OK_OPTION);
            }finally{
                try{
                    DBConnect.con.setAutoCommit(true);
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Trouble execution query", "Issue!", JOptionPane.OK_OPTION);
                }
            }
        }
    }//GEN-LAST:event_insertActionPerformed
    private String[] instructors;
    private int[] instructor_ids;
    private void subjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectItemStateChanged
        int[] selected = new int[0];
        if(subject.getSelectedIndex() == 0){
            instructor_list.setSelectedIndices(new int[0]);
        }else{
            try{
                PreparedStatement st;
                int counter = 0;

                String sql="select instructor_name from instructor";
                st = DBConnect.con.prepareStatement(sql);

                DBConnect.rs = st.executeQuery();

                while(DBConnect.rs.next()){
                    counter = counter + 1;
                }
                sql="select * from instructor ORDER BY instructor_name DESC";
                st = DBConnect.con.prepareStatement(sql);

                DBConnect.rs = st.executeQuery();
                instructors= new String[counter];
                selected = new int[counter];
                instructor_ids = new int[counter];

                for(int i = 0; i < selected.length; i++)
                    selected[i] = -1;

                while(DBConnect.rs.next()){
                    counter--;
                    String instructor_name = DBConnect.rs.getString("instructor_name");
                    instructors[counter]=instructor_name;
                    instructor_ids[counter] = DBConnect.rs.getInt("instructor_id");

                    PreparedStatement st1;
                    sql="select * from subject_instructor, subject where subject.sub_name = ? AND subject.sub_id = subject_instructor.sub_id AND instructor_id = ?";
                    st1 = DBConnect1.con.prepareStatement(sql);

                    st1.setString(1, ""+subject.getSelectedItem());
                    st1.setInt(2, DBConnect.rs.getInt("instructor_id"));

                    DBConnect1.rs = st1.executeQuery();
                    if(DBConnect1.rs.next()){
                        selected[counter] = counter;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            instructor_list.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = instructors;
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
        }

        instructor_list.setSelectedIndices(selected);
        this.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_subjectItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JComboBox subject;
    private javax.swing.JButton insert;
    private javax.swing.JList<String> instructor_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
