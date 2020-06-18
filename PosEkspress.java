package Assignment2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PosEkspress extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JButton button1,button2;
    private JTextField textField;

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


        textField = new JTextField();
        textField.setBounds(150, 200, 165, 25);
        textField.setBackground(Color.white);
        contentPane.add(textField);
        panel.setBackground(Color.white);

        JLabel label = new JLabel("Weight:");
        label.setBounds(20, 200, 100, 25);
        contentPane.add(label);

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
        if (e.getSource()==button1){

            JOptionPane.showMessageDialog(this, "Data Saved");

        }if (e.getSource()==button2){
            new MainMenu();
            setVisible(false);
        }
    }
}
