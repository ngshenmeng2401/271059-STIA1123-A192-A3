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

public class NextDayDelivery extends JFrame implements ActionListener {


    private JPanel contentPane;
    private JTable table;
    private JRadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    private JTextField textField2;
    private JButton button1, button2;
    private int quantity;
    private static double weight, charge, charge1;
    private static ArrayList ItemList1 = new ArrayList();

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

        rb3.addActionListener(this);
        rb4.addActionListener(this);
        rb5.addActionListener(this);
        rb6.addActionListener(this);
        rb7.addActionListener(this);

        textField2 = new JTextField();
        textField2.setBounds(150, 300, 165, 25);
        textField2.setBackground(Color.white);
        contentPane.add(textField2);
        panel.setBackground(Color.white);

        JLabel label3 = new JLabel("Weight:");
        label3.setBounds(20, 300, 100, 25);
        contentPane.add(label3);

        textField2 = new JTextField();
        textField2.setBounds(150, 330, 165, 25);
        textField2.setBackground(Color.white);
        contentPane.add(textField2);
        panel.setBackground(Color.white);

        JLabel label4 = new JLabel("Quantity:");
        label4.setBounds(20, 330, 100, 25);
        contentPane.add(label4);

        button1 = new JButton("Save");
        button1.setBounds(40, 370, 100, 25);
        contentPane.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Main Menu");
        button2.setBounds(600, 370, 100, 25);
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

        try {
            if (e.getSource() == button1) {

                String text1 = textField2.getText();
                String text2 = textField2.getText();
                weight = Double.parseDouble(text1);
                quantity = Integer.parseInt(text2);

                if (rb3.isSelected()) {
                    if (weight <= 2000) {
                        if (weight <= 2000) {
                            charge = 4.90 + (weight - 500) / 250 * 0.80;
                        }
                        if (weight <= 500) {
                            charge = 4.90;
                        }
                    }
                    if (weight > 2000) {
                        if (weight <= 2500) {
                            charge = 10.50;
                        }
                        if (weight > 2500) {
                            charge = 10.50 + (weight - 2500) / 500 * 0.50;
                        }
                    }

                }
                if (rb4.isSelected()) {
                    if (weight <= 2000) {
                        if (weight <= 2000) {
                            charge = 5.40 + (weight - 500) / 250 * 1.00;
                        }
                        if (weight <= 500) {
                            charge = 5.40;
                        }
                    }
                    if (weight > 2000) {
                        if (weight <= 2500) {
                            charge = 16.00;
                        }
                        if (weight > 2500) {
                            charge = 16.00 + (weight - 2500) / 500 * 2.00;
                        }
                    }

                }
                if (rb5.isSelected()) {
                    if (weight <= 2000) {
                        if (weight <= 2000) {
                            charge = 6.90 + (weight - 500) / 250 * 1.50;
                        }
                        if (weight <= 500) {
                            charge = 6.90;
                        }
                    }
                    if (weight > 2000) {
                        if (weight <= 2500) {
                            charge = 21.00;
                        }
                        if (weight > 2500) {
                            charge = 21.00 + (weight - 2500) / 500 * 3.00;
                        }
                    }

                }
                if (rb6.isSelected()) {
                    if (weight <= 2000) {
                        if (weight <= 2000) {
                            charge = 7.40 + (weight - 500) / 250 * 1.50;
                        }
                        if (weight <= 500) {
                            charge = 7.40;
                        }
                    }
                    if (weight > 2000) {
                        if (weight <= 2500) {
                            charge = 26.00;
                        }
                        if (weight > 2500) {
                            charge = 26.00 + (weight - 2500) / 500 * 3.50;
                        }
                    }

                }
                if (rb7.isSelected()) {
                    if (weight <= 2000) {
                        if (weight <= 2000) {
                            charge = 7.90 + (weight - 500) / 250 * 2.00;
                        }
                        if (weight <= 500) {
                            charge = 7.90;
                        }
                    }
                    if (weight > 2000) {
                        if (weight <= 2500) {
                            charge = 31.00;
                        }
                        if (weight > 2500) {
                            charge = 31.00 + (weight - 2500) / 500 * 4.00;
                        }
                    }
                }
                charge1 = charge * quantity;

                JOptionPane.showMessageDialog(this, "Data Saved");

                ItemList1.add(quantity);
                ItemList1.add(weight);
                ItemList1.add(charge1);

                File file1 = new File("NDD.txt");
                try {
                    file1.createNewFile();
                    FileWriter fw = new FileWriter(file1);
                    fw.write(String.valueOf(ItemList1));
                    fw.flush();
                    fw.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(this, "Please select radio button and key in data!!!");

        }
        if (e.getSource() == button2) {
            new MainMenu();
            setVisible(false);
        }
    }

    public double getCharge1() {
        return charge1;
    }

}
