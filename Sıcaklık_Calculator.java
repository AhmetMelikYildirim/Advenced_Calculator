import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sıcaklık_Calculator extends JFrame implements ActionListener {
    JMenu dosya,tür;
    JMenuBar menu;
    JMenuItem exitItem,Standart,programlayıcı,bilimsel,tarih,Uzunluk;
    JButton[] numberButton = new JButton[10];
    JButton clr,delete,nokta,artıeksi,boş;
    JPanel panel;
    Font myFont = new Font("monospaced",Font.BOLD,30);
    JComboBox inputbox,outputbox;
    JTextField tfİnput,tfOutput;
    Sıcaklık_Calculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sıcaklık Hesaplama");


        menu = new JMenuBar();
        dosya= new JMenu("Dosya");
        tür = new JMenu("Tür");
        exitItem = new JMenuItem("Çık");
        Standart = new JMenuItem("Standart");
        programlayıcı = new JMenuItem("Programlayıcı");
        bilimsel = new JMenuItem("Bilimsel");
        tarih = new JMenuItem("Tarih");
        Uzunluk = new JMenuItem("Uzunluk");


        menu.add(dosya);
        menu.add(tür);
        dosya.add(exitItem);
        tür.add(Standart);
        tür.add(bilimsel);
        tür.add(programlayıcı);
        tür.add(tarih);
        tür.add(Uzunluk);


        tarih.addActionListener(this);
        Standart.addActionListener(this);
        bilimsel.addActionListener(this);
        programlayıcı.addActionListener(this);
        Uzunluk.addActionListener(this);
        exitItem.addActionListener(this);


        tfİnput = new JTextField();
        tfİnput.setFont(myFont);
        tfİnput.setBounds(25,25,300,35);
        tfİnput.setEditable(false);

        inputbox = new JComboBox();
        inputbox.addItem("Celsius");
        inputbox.addItem("Fahrenheit");
        inputbox.addItem("Kelvin");
        inputbox.setSelectedItem("Celsius");
        inputbox.setBounds(25,65,75,25);


        tfOutput = new JTextField();
        tfOutput.setFont(myFont);
        tfOutput.setBounds(25,105,300,35);
        tfOutput.setEditable(false);

        outputbox = new JComboBox();
        outputbox.addItem("Celsius");
        outputbox.addItem("Fahrenheit");
        outputbox.addItem("Kelvin");
        outputbox.setSelectedItem("Fahrenheit");
        outputbox.setBounds(25,150,75,25);



        for(int i = 0;i<10;i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
            numberButton[i].setFont(myFont);
        }

        clr = new JButton("CE");
        clr.setFocusable(false);
        clr.addActionListener(this);
        clr.setFont(myFont);

        delete = new JButton("<--");
        delete.setFocusable(false);
        delete.addActionListener(this);
        delete.setFont(myFont);

        artıeksi = new JButton("+/-");
        artıeksi.setFocusable(false);
        artıeksi.addActionListener(this);
        artıeksi.setFont(myFont);

        nokta = new JButton(".");
        nokta.setFocusable(false);
        nokta.addActionListener(this);
        nokta.setFont(myFont);

        boş = new JButton("=");
        boş.setFont(myFont);
        boş.setFocusable(false);
        boş.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(50,250,300,200);
        panel.setLayout(new GridLayout(5,3,5,5));



        panel.add(boş);
        panel.add(clr);
        panel.add(delete);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(artıeksi);
        panel.add(numberButton[0]);
        panel.add(nokta);





        this.setJMenuBar(menu);
        this.add(tfİnput);
        this.add(inputbox);
        this.add(tfOutput);
        this.add(outputbox);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boş){
                convert();
            }
        for(int i = 0;i<10;i++){
            if(e.getSource()== numberButton[i]){
                tfİnput.setText(tfİnput.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==clr){
            tfİnput.setText("");
        }
        if(e.getSource()==delete){
            String string  = tfİnput.getText();
            tfİnput.setText("");
            for(int i=0;i<string.length()-1;i++){
                tfİnput.setText(tfİnput.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==artıeksi){
            double temp = Double.parseDouble(tfİnput.getText());
            temp *=-1;
            tfİnput.setText(String.valueOf(temp));

        }
        if(e.getSource() == nokta){
            tfİnput.setText(tfİnput.getText().concat("."));
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }
        if(e.getSource()==programlayıcı){
            this.dispose();
            new BinaryCalculator().setVisible(true);

        }
        if(e.getSource()==tarih){
            this.dispose();
            new tarihCal();
        }
        if(e.getSource()==Standart){
            this.dispose();
            new Calculator();
        }
        if(e.getSource()==Uzunluk){
            this.dispose();
            new Uzunluk_Calculator();
        }
    }
    private void convert(){
        String sayı = tfİnput.getText();
        String conversionfrom = (String) inputbox.getSelectedItem();
        String conversionto = (String) outputbox.getSelectedItem();

        try{
            switch (conversionfrom){
                case "Fahrenheit":
                    convertfromfahrenheit(sayı,conversionto);
                    break;
                case "Kelvin":
                    convertfromkelvin(sayı,conversionto);
                    break;
                case "Celsius":
                    convertfromcelsius(sayı,conversionto);
                    break;

            }
        } catch (Exception e) {
            tfOutput.setText("Hatalı Giriş");
        }
    }
    private void convertfromfahrenheit(String Fahrenheit,String conversionto){
        Double sayı = Double.parseDouble(Fahrenheit);
        Double sonuç=0.0;
        switch(conversionto){
            case "Fahrenheit":
                sonuç =sayı;
                break;
            case "Celsius":
                sonuç = (sayı-32)*5/9;
                break;
            case "Kelvin":
                sonuç = (sayı+459.67)*5/9;
                break;
        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfromkelvin(String Kelvin,String conversionto){
        Double sayı = Double.parseDouble(Kelvin);
        Double sonuç = 0.0;
        switch (conversionto){
            case "Kelvin":
                sonuç = sayı;
                break;
            case "Celsius":
                sonuç = (sayı-273.15);
                break;
            case "Fahrenheit":
                sonuç = (sayı-273.5)*9/5+32;
                break;
        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfromcelsius(String Celsius,String conversionto){
        Double sayı = Double.parseDouble(Celsius);
        Double sonuç = 0.0;
        switch (conversionto){
            case "Celsius":
                sonuç = sayı;
                break;
            case "Fahrenheit":
                sonuç = (sayı*9/5)+32;
                break;
            case "Kelvin":
                sonuç = (sayı-273.15);
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
}
