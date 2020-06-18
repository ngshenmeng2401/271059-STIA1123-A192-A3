package Assignment2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NextDayDelivery extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private static JRadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7;
    private JTextField textField;
    private JButton button1,button2;

    public NextDayDelivery() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });

        setTitle("Next Day Delivery");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        setSize(800, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JLabel label1 = new JLabel("Package Type:");
        label1.setBounds(20, 220, 130, 25);
        rb1 = new JRadioButton("Document");
        rb1.setBounds(150, 220, 100, 25);
        rb2 = new JRadioButton("Parcel");
        rb2.setBounds(270, 220, 100, 25);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(rb1);
        group1.add(rb2);
        contentPane.add(label1);
        contentPane.add(rb1);
        contentPane.add(rb2);

        JLabel label2 = new JLabel("Zone:");
        label2.setBounds(20, 260, 165, 25);
        rb3 = new JRadioButton("1");
        rb3.setBounds(150, 260, 50, 25);
        rb4 = new JRadioButton("2");
        rb4.setBounds(200, 260, 50, 25);
        rb5 = new JRadioButton("3");
        rb5.setBounds(250, 260, 50, 25);
        rb6 = new JRadioButton("4");
        rb6.setBounds(300, 260, 50, 25);
        rb7 = new JRadioButton("5");
        rb7.setBounds(350, 260, 50, 25);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(rb3);
        group2.add(rb4);
        group2.add(rb5);
        group2.add(rb6);
        group2.add(rb7);
        contentPane.add(label2);
        contentPane.add(rb3);
        contentPane.add(rb4);
        contentPane.add(rb5);
        contentPane.add(rb6);
        contentPane.add(rb7);

        rb1.addActionListener(this);

        textField = new JTextField();
        textField.setBounds(150, 310, 165, 25);
        textField.setBackground(Color.white);
        contentPane.add(textField);
        panel.setBackground(Color.white);

        JLabel label3 = new JLabel("Weight:");
        label3.setBounds(20, 310, 100, 25);
        contentPane.add(label3);

        button1 = new JButton("Save");
        button1.setBounds(40, 350, 100, 25);
        contentPane.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Main Menu");
        button2.setBounds(600, 350, 100, 25);
        contentPane.add(button2);
        button2.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            public Component prepareRenderer(TableCellRenderer r, int row, int column) {
                Component c = super.prepareRenderer(r, row, column);
                if (row % 6 == 0)
                    c.setBackground(Color.GRAY);
                else if (row % 2 == 0)
                    c.setBackground(Color.WHITE);
                else
                    c.setBackground(Color.LIGHT_GRAY);
                return c;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(table);
    }

    protected void do_this_windowActivated(WindowEvent e) {

        DefaultTableModel defaulttablemodel = (DefaultTableModel) table.getModel();
        defaulttablemodel.setRowCount(0);
        defaulttablemodel.setColumnIdentifiers(new Object[]{"", "Document", "(Below 2kg)", "Parcel", "(above 2kg)",});
        defaulttablemodel.addRow(new Object[]{"", "First 500gm", "Subsequent 250gm", "2.001-2.5kg", "Subsequent 250gm"});
        defaulttablemodel.addRow(new Object[]{"Zone 1", "4.90", "0.80", "10.50", "0.50"});
        defaulttablemodel.addRow(new Object[]{"Zone 2", "5.40", "1.00", "16.00", "2.00"});
        defaulttablemodel.addRow(new Object[]{"Zone 3", "6.90", "1.50", "21.00", "3.00"});
        defaulttablemodel.addRow(new Object[]{"Zone 4", "7.40", "1.50", "26.00", "3.50"});
        defaulttablemodel.addRow(new Object[]{"Zone 5", "7.90", "2.00", "31.00", "4.00"});

        JTableHeader tb = table.getTableHeader();
        tb.setBackground(Color.orange);

        table.setRowHeight(30);
        table.setModel(defaulttablemodel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){

//            new NDDbutton();
            JOptionPane.showMessageDialog(this, "Data Saved");

        }if (e.getSource()==button2){
            new MainMenu();
            setVisible(false);
        }

    }
}