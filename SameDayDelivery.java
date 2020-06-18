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

public class SameDayDelivery extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JButton button1,button2;
    private JTextField textField;
    private JRadioButton rb1,rb2;
    private String packtype;

    public SameDayDelivery() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });

        setTitle("Same Day Delivery");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        setSize(800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JLabel label1 = new JLabel("Town Type:");
        label1.setBounds(20, 170, 150, 25);
        rb1 = new JRadioButton("Local");
        rb1.setBounds(150, 170, 100, 25);
        rb2 = new JRadioButton("Cross");
        rb2.setBounds(250, 170, 100, 25);
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        contentPane.add(label1);
        contentPane.add(rb1);
        contentPane.add(rb2);

        textField = new JTextField();
        textField.setBounds(150, 230, 165, 25);
        textField.setBackground(Color.white);
        contentPane.add(textField);
        panel.setBackground(Color.white);

        JLabel label2 = new JLabel("Weight:");
        label2.setBounds(20, 230, 100, 25);
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
        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            public Component prepareRenderer(TableCellRenderer r, int row, int column) {
                Component c = super.prepareRenderer(r, row, column);
                if (row % 4 == 0)
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
        defaulttablemodel.setColumnIdentifiers(new Object[]{"Weight", "", "Local Town", "", "", "Cross Town", ""});
        defaulttablemodel.addRow(new Object[]{"", "Domestic Charge", "Surcharge", "Total", "Domestic Charge", "Surcharge", "Total"});
        defaulttablemodel.addRow(new Object[]{"Below 500gm", "4.90", "6.00", "10.90", "5.40", "7.50", "12.90"});
        defaulttablemodel.addRow(new Object[]{"500gm-750gm", "5.70", "6.00", "11.70", "6.40", "7.50", "13.90"});
        defaulttablemodel.addRow(new Object[]{"750gm-1kg", "6.50", "6.00", "12.50", "7.40", "7.50", "14.90"});

        JTableHeader tb = table.getTableHeader();
        tb.setBackground(Color.orange);

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
