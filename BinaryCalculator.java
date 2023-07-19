import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryCalculator extends JFrame implements ActionListener {
        JLabel input,output,From,to;
        JTextField inputtext,outuputtext;
        JComboBox inputbox,outputbox;
        JButton Calculate;
        JMenu dosya,tür;
        JMenuBar menu;
        JMenuItem exitItem,Standart,programlayıcı,bilimsel,tarih,Uzunluk,Sıcaklık;
        Font myFont = null;
        

    BinaryCalculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Programlayıcı");



        myFont = new Font("Ariel",Font.BOLD,12);

        menu = new JMenuBar();
        dosya= new JMenu("Dosya");
        tür = new JMenu("Tür");
        exitItem = new JMenuItem("Çık");
        Standart = new JMenuItem("Standart");
        programlayıcı = new JMenuItem("Programlayıcı");
        bilimsel = new JMenuItem("Bilimsel");
        tarih = new JMenuItem("Tarih Hesaplama");
        Uzunluk = new JMenuItem("Uzunluk");
        Sıcaklık = new JMenuItem("Sıcaklık");



        menu.add(dosya);
        menu.add(tür);
        dosya.add(exitItem);
        tür.add(Standart);
        tür.add(bilimsel);
        tür.add(tarih);
        tür.add(Sıcaklık);
        tür.add(Uzunluk);

        exitItem.addActionListener(this);
        Standart.addActionListener(this);
        tarih.addActionListener(this);
        Sıcaklık.addActionListener(this);
        Uzunluk.addActionListener(this);

        input = new JLabel("Input Number:");
        input.setFont(myFont);
        input.setBounds(75,72,100,50);

        inputtext = new JTextField();
        inputtext.setBounds(170,85,200,25);

        From = new JLabel("From:");
        From.setBounds(75,112,50,50);

        inputbox = new JComboBox<String>();
        inputbox.addItem("Binary");
        inputbox.addItem("Octal");
        inputbox.addItem("Decimal");
        inputbox.addItem("Hexadecimal");
        inputbox.setSelectedItem("Binary");
        inputbox.setBounds(170,125,80,25);

        to = new JLabel("To:");
        to.setBounds(75,152,50,50);



        outputbox = new JComboBox<String>();
        outputbox.addItem("Binary");
        outputbox.addItem("Octal");
        outputbox.addItem("Decimal");
        outputbox.addItem("Hexadecimal");
        outputbox.setSelectedItem("Decimal");
        outputbox.setBounds(170,165,80,25);

        output = new JLabel("Output Number:");
        output.setBounds(75,192,100,50);

        outuputtext = new JTextField();
        outuputtext.setBounds(170,205,200,25);
        outuputtext.setEditable(false);

        Calculate = new JButton("Convert");
        Calculate.setBounds(170,250,100,35);
        Calculate.setFocusable(false);
        Calculate.addActionListener(this);





        this.setJMenuBar(menu);
        this.add(input);
        this.add(inputtext);
        this.add(From);
        this.add(inputbox);
        this.add(to);
        this.add(outputbox);
        this.add(output);
        this.add(outuputtext);
        this.add(Calculate);
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Standart){
            this.dispose();
            new Calculator();
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }
        if(e.getSource()==Calculate){
            convertNumber();
        }
        if(e.getSource()==tarih){
            this.dispose();
            new tarihCal();
        }
        if(e.getSource()==Sıcaklık){
            this.dispose();
            new Sıcaklık_Calculator();
        }
        if(e.getSource()==Uzunluk){
            this.dispose();
            new Uzunluk_Calculator();
        }
    }
    private void convertNumber(){
        String sayı = inputtext.getText();
        String conversionFrom = (String) inputbox.getSelectedItem();
        String conversionTo = (String) outputbox.getSelectedItem();

        try{
            switch (conversionFrom){
                case "Decimal":
                    convertFromDecimal(sayı,conversionTo);
                    break;
                case "Binary":
                    convertFromBinary(sayı,conversionTo);
                    break;
                case "Octal":
                    convertFromOctal(sayı,conversionTo);
                    break;
                case "Hexadecimal":
                    convertFromHexadecimal(sayı,conversionTo);
                    break;
            }
        }catch (NumberFormatException e){
            outuputtext.setText("Hatalı Giriş");
        }
    }

    private void convertFromDecimal(String decimal, String conversionTo) {
        int sayı = Integer.parseInt(decimal);
        String Sonuç = "";
        switch (conversionTo) {
            case "Decimal":
                Sonuç = decimal;
                break;
            case "Binary":
                Sonuç = Integer.toBinaryString(sayı);
                break;
            case "Octal":
                Sonuç = Integer.toOctalString(sayı);
                break;
            case "Hexadecimal":
                Sonuç = Integer.toHexString(sayı).toUpperCase();
                break;
        }
        outuputtext.setText("Sonuç: " + Sonuç);
    }
    private void convertFromBinary(String binary, String conversionTo) {
        int sayı = Integer.parseInt(binary, 2);
        String Sonuç = "";
        switch (conversionTo) {
            case "Decimal":
                Sonuç = Integer.toString(sayı);
                break;
            case "Binary":
                Sonuç = binary;
                break;
            case "Octal":
                Sonuç = Integer.toOctalString(sayı);
                break;
            case "Hexadecimal":
                Sonuç = Integer.toHexString(sayı).toUpperCase();
                break;
        }
        outuputtext.setText("Sonuç: " + Sonuç);
    }
    private void convertFromOctal(String octal, String conversionTo) {
        int sayı = Integer.parseInt(octal, 8);
        String Sonuç = "";
        switch (conversionTo) {
            case "Decimal":
                Sonuç = Integer.toString(sayı);
                break;
            case "Binary":
                Sonuç = Integer.toBinaryString(sayı);
                break;
            case "Octal":
                Sonuç = octal;
                break;
            case "Hexadecimal":
                Sonuç = Integer.toHexString(sayı).toUpperCase();
                break;
        }
        outuputtext.setText("Sonuç: " + Sonuç);
    }
    private void convertFromHexadecimal(String hexadecimal, String conversionTo) {
        int sayı = Integer.parseInt(hexadecimal, 16);
        String Sonuç = "";
        switch (conversionTo) {
            case "Decimal":
                Sonuç = Integer.toString(sayı);
                break;
            case "Binary":
                Sonuç = Integer.toBinaryString(sayı);
                break;
            case "Octal":
                Sonuç = Integer.toOctalString(sayı);
                break;
            case "Hexadecimal":
                Sonuç = hexadecimal.toUpperCase();
                break;
        }
        outuputtext.setText("Sonuç: " + Sonuç);
    }

}
