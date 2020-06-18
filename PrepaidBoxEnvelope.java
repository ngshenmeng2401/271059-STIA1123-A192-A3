package Assignment2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrepaidBoxEnvelope extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JButton button1,button2;
    private JTextField textField;

    public PrepaidBoxEnvelope() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });

        setTitle("Prepaid Box & Envelope");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(100, 100, 450, 200);
        setSize(900, 400);
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
        defaulttablemodel.setColumnIdentifiers(new Object[]{"Jenis", "Envelope S", "Envelope M", "Prepaid Box S", "Prepaid Box M", "Prepaid Box L"});
        defaulttablemodel.addRow(new Object[]{"Saiz", "280mm*220mm", "380mm*320mm", "340mm*250mm*80mm", "340mm*250mm*150mm", "380mm*320mm*200mm"});
        defaulttablemodel.addRow(new Object[]{"Berat Max ", "500g", "1kg", "2kg", "5kg", "10kg"});
        defaulttablemodel.addRow(new Object[]{"Harge(RM)", "7.31", "10.49", "13.78", "21.20", "31.80"});

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
