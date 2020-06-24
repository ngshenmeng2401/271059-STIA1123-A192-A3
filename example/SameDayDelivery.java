package my.example;

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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SameDayDelivery extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTable table;
    private JButton button1, button2;
    private JTextField textField1, textField2;
    private JRadioButton rb8, rb9;
    private int quantity;
    private static double weight, charge2, domestic_charge, surcharge;
    private static ArrayList ItemList2 = new ArrayList();

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
        rb8 = new JRadioButton("Local");
        rb8.setBounds(150, 170, 100, 25);
        rb9 = new JRadioButton("Cross");
        rb9.setBounds(250, 170, 100, 25);
        ButtonGroup group = new ButtonGroup();
        group.add(rb8);
        group.add(rb9);
        contentPane.add(label1);
        contentPane.add(rb8);
        contentPane.add(rb9);

        textField1 = new JTextField();
        textField1.setBounds(150, 230, 165, 25);
        textField1.setBackground(Color.white);
        contentPane.add(textField1);
        panel.setBackground(Color.white);

        JLabel label2 = new JLabel("Weight:");
        label2.setBounds(20, 230, 100, 25);
        contentPane.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(150, 270, 165, 25);
        textField2.setBackground(Color.white);
        contentPane.add(textField2);
        panel.setBackground(Color.white);

        JLabel label3 = new JLabel("Quantity:");
        label3.setBounds(20, 270, 120, 25);
        contentPane.add(label3);

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

        try {
            if (e.getSource() == button1) {

                String text1 = textField1.getText();
                String text2 = textField2.getText();
                weight = Double.parseDouble(text1);
                quantity = Integer.parseInt(text2);

                if (rb8.isSelected()) {
                    if (weight <= 500) {
                        domestic_charge = 4.90;
                        surcharge = 6.00;
                    }
                    if (weight > 500 && weight <= 750) {
                        domestic_charge = 5.70;
                        surcharge = 6.00;
                    }
                    if (weight > 750 && weight <= 1000) {
                        domestic_charge = 6.50;
                        surcharge = 6.00;
                    }
                }
                if (rb9.isSelected()) {
                    if (weight <= 500) {
                        domestic_charge = 5.40;
                        surcharge = 7.50;
                    }
                    if (weight > 500 && weight <= 750) {
                        domestic_charge = 6.40;
                        surcharge = 7.50;
                    }
                    if (weight > 750 && weight <= 1000) {
                        domestic_charge = 7.40;
                        surcharge = 7.50;
                    }
                }

                JOptionPane.showMessageDialog(this, "Data Saved");

                ItemList2.add(quantity);
                ItemList2.add(weight);
                ItemList2.add(charge2);

                File file2 = new File("SDD.txt");
                try {
                    file2.createNewFile();
                    FileWriter fw = new FileWriter(file2);
                    fw.write(String.valueOf(ItemList2));
                    fw.flush();
                    fw.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                charge2 = (domestic_charge + surcharge) * quantity;
            }
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(this, "Please select radio button and key in data!!!");

        }
        if (e.getSource() == button2) {
            new MainMenu();
            setVisible(false);
        }
    }

    public double getCharge2() {
        return charge2;
    }
}
