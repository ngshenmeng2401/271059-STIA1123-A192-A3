package Assignment2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NDDbutton implements ActionListener{

    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private JRadioButton rb5;
    private JRadioButton rb6;
    private JRadioButton rb7;
    private JTextField textField;
    private double weight,charge1;
    private String packtype;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()){
            packtype="Document";
        }if (rb2.isSelected()){
            packtype="Parcel";
        }
        String text = textField.getText();
        weight= Double.parseDouble(text);
        if (rb3.isSelected()){
            if (weight <= 2000) {
                if (weight <= 2000) {
                    charge1 = 4.90 + (weight - 500) / 250 * 0.80;
                }
                if (weight <= 500) {
                    charge1 = 4.90;
                }
            }if (weight > 2000) {
                if (weight <= 2500) {
                    charge1 = 10.50;
                }
                if (weight > 2500) {
                    charge1 = 10.50 + (weight - 2500) / 500 * 0.50;
                }
            }

        }if (rb4.isSelected()){
            if (weight <= 2000) {
                if (weight <= 2000) {
                    charge1 = 5.40 + (weight - 500) / 250 * 1.00;
                }
                if (weight <= 500) {
                    charge1 = 5.40;
                }
            }
            if (weight > 2000) {
                if (weight <= 2500) {
                    charge1 = 16.00;
                }
                if (weight > 2500) {
                    charge1 = 16.00 + (weight - 2500) / 500 * 2.00;
                }
            }

        }if (rb5.isSelected()){
            if (weight <= 2000) {
                if (weight <= 2000) {
                    charge1 = 6.90 + (weight - 500) / 250 * 1.50;
                }
                if (weight <= 500) {
                    charge1 = 6.90;
                }
            }
            if (weight > 2000) {
                if (weight <= 2500) {
                    charge1 = 21.00;
                }
                if (weight > 2500) {
                    charge1 = 21.00 + (weight - 2500) / 500 * 3.00;
                }
            }

        }if (rb6.isSelected()){
            if (weight <= 2000) {
                if (weight <= 2000) {
                    charge1 = 7.40 + (weight - 500) / 250 * 1.50;
                }
                if (weight <= 500) {
                    charge1 = 7.40;
                }
            }
            if (weight > 2000) {
                if (weight <= 2500) {
                    charge1 = 26.00;
                }
                if (weight > 2500) {
                    charge1 = 26.00 + (weight - 2500) / 500 * 3.50;
                }
            }

        }if (rb7.isSelected()){
            if (weight <= 2000) {
                if (weight <= 2000) {
                    charge1 = 7.90 + (weight - 500) / 250 * 2.00;
                }
                if (weight <= 500) {
                    charge1 = 7.90;
                }
            }
            if (weight > 2000) {
                if (weight <= 2500) {
                    charge1 = 31.00;
                }
                if (weight > 2500) {
                    charge1 = 31.00 + (weight - 2500) / 500 * 4.00;
                }
            }
        }

    }

    public double getCharge1() {
        return charge1;
    }
}
