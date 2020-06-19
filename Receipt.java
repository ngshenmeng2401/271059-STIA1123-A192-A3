package Assignment2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receipt extends JFrame implements ActionListener {

    NDDbutton ndd = new NDDbutton();
    NextDayDelivery delivery1 = new NextDayDelivery();

    private JButton button2;
    JLabel name,address,contactNo,NextDayDelivery,SameDayDelivery,PrepaidBoxEnvelope,PosEkspress,TotalPrice;
    JLabel label1,label2,label3,label4,label5,label6;
    JLabel line1,line2,line3;
    JTextField text1,text2,text3;
    JButton button1;
//    private double charge1=ndd.getCharge1();
    private double charge1=delivery1.getCharge1();

//    public static void main(String[] args) {
//        new Receipt();
//    }

    public Receipt(){

        getContentPane().setLayout(null);
        setTitle("Receipt");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        name = new JLabel("Name: ");
        address = new JLabel("Address: ");
        contactNo = new JLabel("Contact No: ");


        NextDayDelivery= new JLabel("Next-Day Delivery:");
        SameDayDelivery= new JLabel("Same-Day Delivery:");
        PrepaidBoxEnvelope= new JLabel("Prepaid Box Envelope:");
        PosEkspress = new JLabel("Pos Ekspress:");
        TotalPrice = new JLabel("Total Price:");

        line1= new JLabel("-----------------------------------------------------------");
        line2= new JLabel("-----------------------------------------------------------");
        line3= new JLabel("-----------------------------------------------------------");

        text1= new JTextField(30);
        text2= new JTextField(30);
        text3= new JTextField(30);

        label1= new JLabel("Your Bill:");
        label2= new JLabel("0");
        label3= new JLabel("0");
        label4= new JLabel("0");
        label5= new JLabel("0");
        label6= new JLabel("0");

        //Set Location & Size
        name.setBounds(50, 50, 200, 20);
        address.setBounds(50, 80, 200, 20);
        contactNo.setBounds(50, 110, 200, 20);

        NextDayDelivery.setBounds(50, 220, 200, 20);
        SameDayDelivery.setBounds(50, 250, 200, 20);
        PrepaidBoxEnvelope.setBounds(50, 280, 200, 20);
        PosEkspress.setBounds(50, 310, 200, 20);
        TotalPrice.setBounds(50,350,200,20);

        line1.setBounds(50,200,400,10);
        line2.setBounds(50,330,400,10);
        line3.setBounds(50,370,400,10);

        text1.setBounds(200, 50, 200, 20);
        text2.setBounds(200, 80, 200, 20);
        text3.setBounds(200, 110, 200, 20);

        label1.setBounds(50,180,200,20);
        label2.setBounds(200, 220, 200, 20);
        label3.setBounds(200, 250, 200, 20);
        label4.setBounds(200, 280, 200, 20);
        label5.setBounds(200, 310, 200, 20);
        label6.setBounds(200, 350, 200, 20);

        String amount1 = Double.toString(charge1);
        label2.setText((amount1));


        add(name);
        add(address);
        add(contactNo);
        add(NextDayDelivery);
        add(SameDayDelivery);
        add(PrepaidBoxEnvelope);
        add(PosEkspress);
        add(TotalPrice);

        add(line1);
        add(line2);
        add(line3);

        add(text1);
        add(text2);
        add(text3);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);

        button2 = new JButton("Main Menu");
        button2.setBounds(600, 450, 100, 25);
        add(button2);
        button2.addActionListener(this);

        setVisible(true);
        setSize(800,600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button2){
            new MainMenu();
            setVisible(false);
        }
    }
}
