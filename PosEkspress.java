package Assignment2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class PosEkspress extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JButton button1,button2;
    private JTextField textField5, textField6;
    private static double charge4,price,weight;
    private int quantity;

    public PosEkspress() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });

        setTitle("Pos Ekspress");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        setSize(800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);


        textField5 = new JTextField();
        textField5.setBounds(150, 200, 165, 25);
        textField5.setBackground(Color.white);
        contentPane.add(textField5);
        panel.setBackground(Color.white);

        textField6 = new JTextField();
        textField6.setBounds(150, 240, 165, 25);
        textField6.setBackground(Color.white);
        contentPane.add(textField6);
        panel.setBackground(Color.white);

        JLabel label1 = new JLabel("Weight:");
        label1.setBounds(20, 200, 100, 25);
        contentPane.add(label1);

        JLabel label2 = new JLabel("Quantity:");
        label2.setBounds(20, 240, 100, 25);
        contentPane.add(label2);

        button1 = new JButton("Save");
        button1.setBounds(40, 300, 100, 25);
        button2 = new JButton("Main Menu");
        button2.setBounds(600, 300, 100, 25);

        contentPane.add(button1);
        contentPane.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(table);

    }

    protected void do_this_windowActivated(WindowEvent e) {

        DefaultTableModel defaulttablemodel = (DefaultTableModel) table.getModel();
        defaulttablemodel.setRowCount(0);
        defaulttablemodel.setColumnIdentifiers(new Object[]{"Jenis", "LG", "LE(C5)", "LD(B4)", "LK"});
        defaulttablemodel.addRow(new Object[]{"Saiz", "220mm*110mm", "229mm*162mm", "353mm*250mm", "340mm*250mm"});
        defaulttablemodel.addRow(new Object[]{"Berat Max (gm)", "100", "250", "500", "1000"});
        defaulttablemodel.addRow(new Object[]{"Ketebalan Max", "3mm", "5mm", "10mm", "25mm"});
        defaulttablemodel.addRow(new Object[]{"Harge(RM)", "3.18", "3.71", "4.77", "7.42"});

        table.setRowHeight(30);
        table.setModel(defaulttablemodel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if (e.getSource()==button1){

                String text1 = textField5.getText();
                weight= Double.parseDouble(text1);
                String text2 = textField6.getText();
                quantity=Integer.parseInt(text2);

                if(weight<=100){
                    price=3.18;
                }if(weight>100&&weight<=250){
                    price=3.71;
                }if(weight>250&&weight<=500){
                    price=4.77;
                }if(weight>500&&weight<=1000){
                    price=7.42;
                }

                charge4=price*quantity;
                JOptionPane.showMessageDialog(this, "Data Saved");

            }
        }catch (NumberFormatException e1){
            JOptionPane.showMessageDialog(this, "Please key in data!!!");

        }
        if (e.getSource()==button2){
            new MainMenu();
            setVisible(false);
        }
    }

    public double getCharge4() {
        return charge4;
    }
}
