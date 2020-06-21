package Assignment2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Receipt extends JFrame implements ActionListener {

    static NextDayDelivery delivery1 = new NextDayDelivery();
    static SameDayDelivery delivery2 = new SameDayDelivery();
    static PrepaidBoxEnvelope delivery3 = new PrepaidBoxEnvelope();
    static PosEkspress delivery4 = new PosEkspress();

    JButton button2;
    JLabel name,address,contactNo,nextdaydelivery,samedaydelivery, prepaidboxenvelope, posekspress, totalprice;
    JLabel label1,label2,label3,label4,label5,label6;
    JLabel line1,line2,line3;
    JTextField text1,text2,text3;

    private static double charge1=delivery1.getCharge1();
    private static double charge2=delivery2.getCharge2();
    private static double charge3=delivery3.getCharge3();
    private static double charge4=delivery4.getCharge4();

    public Receipt(){

        getContentPane().setLayout(null);
        setTitle("Receipt");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        name = new JLabel("Name: ");
        address = new JLabel("Address: ");
        contactNo = new JLabel("Contact No: ");


        nextdaydelivery = new JLabel("Next-Day Delivery:");
        samedaydelivery = new JLabel("Same-Day Delivery:");
        prepaidboxenvelope = new JLabel("Prepaid Box Envelope:");
        posekspress = new JLabel("Pos Ekspress:");
        totalprice = new JLabel("Total Price:");

        line1= new JLabel("-----------------------------------------------------------");
        line2= new JLabel("-----------------------------------------------------------");
        line3= new JLabel("-----------------------------------------------------------");

        text1= new JTextField(30);
        text2= new JTextField(30);
        text3= new JTextField(30);

        label1= new JLabel("Your Bill:");
        label2= new JLabel();
        label3= new JLabel();
        label4= new JLabel();
        label5= new JLabel();
        label6= new JLabel();

        //Set Location & Size
        name.setBounds(50, 50, 200, 20);
        address.setBounds(50, 80, 200, 20);
        contactNo.setBounds(50, 110, 200, 20);

        nextdaydelivery.setBounds(50, 220, 200, 20);
        samedaydelivery.setBounds(50, 250, 200, 20);
        prepaidboxenvelope.setBounds(50, 280, 200, 20);
        posekspress.setBounds(50, 310, 200, 20);
        totalprice.setBounds(50,350,200,20);

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

        char[] list1= new char[40];
        char[] list2= new char[40];
        char[] list3= new char[40];
        char[] list4= new char[40];

        File file1 = new File("NDD.txt");
        File file2 = new File("SDD.txt");
        File file3 = new File("PBE.txt");
        File file4 = new File("PE.txt");

        try {
            FileReader fr1 = new FileReader(file1);
            FileReader fr2 = new FileReader(file2);
            FileReader fr3 = new FileReader(file3);
            FileReader fr4 = new FileReader(file4);
            fr1.read(list1);
            fr2.read(list2);
            fr3.read(list3);
            fr4.read(list4);
            fr1.close();
            fr2.close();
            fr3.close();
            fr4.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        //Convert Double to String
//        String amount1 = Double.toString(charge1);
//        String amount2 = Double.toString(charge2);
//        String amount3 = Double.toString(charge3);
//        String amount4 = Double.toString(charge4);
        double totalprice=charge1+charge2+charge3+charge4;
//        String amount5 = Double.toString(totalprice);

        label2.setText(String.valueOf(list1));
        label3.setText(String.valueOf(list2));
        label4.setText(String.valueOf(list3));
        label5.setText(String.valueOf(list4));

        System.out.println(list2);

        //Add object
        add(name);
        add(address);
        add(contactNo);
        add(nextdaydelivery);
        add(samedaydelivery);
        add(prepaidboxenvelope);
        add(posekspress);
        add(this.totalprice);

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

        delivery1.setVisible(false);
        delivery2.setVisible(false);
        delivery3.setVisible(false);
        delivery4.setVisible(false);

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
