import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uzunluk_Calculator extends JFrame implements ActionListener {


    JMenu dosya,tür;
    JMenuBar menu;
    JMenuItem exitItem,Standart,programlayıcı,bilimsel,tarih,Sıcaklık;
    JButton[] numberButton = new JButton[10];
    JButton clr,delete,nokta,eşit,sıfır;
    JPanel panel;
    Font myFont = new Font("monospaced",Font.BOLD,30);
    JComboBox inputbox,outputbox;
    JTextField tfİnput,tfOutput;
    Uzunluk_Calculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Uzunluk Hesaplama");

        menu = new JMenuBar();
        dosya= new JMenu("Dosya");
        tür = new JMenu("Tür");
        exitItem = new JMenuItem("Çık");
        Standart = new JMenuItem("Standart");
        programlayıcı = new JMenuItem("Programlayıcı");
        bilimsel = new JMenuItem("Bilimsel");
        tarih = new JMenuItem("Tarih");
        Sıcaklık = new JMenuItem("Sıcaklık");


        menu.add(dosya);
        menu.add(tür);
        dosya.add(exitItem);
        tür.add(Standart);
        tür.add(bilimsel);
        tür.add(programlayıcı);
        tür.add(tarih);
        tür.add(Sıcaklık);


        tarih.addActionListener(this);
        Standart.addActionListener(this);
        bilimsel.addActionListener(this);
        programlayıcı.addActionListener(this);
        Sıcaklık.addActionListener(this);
        exitItem.addActionListener(this);

        tfİnput = new JTextField();
        tfİnput.setFont(myFont);
        tfİnput.setBounds(25,25,300,35);
        tfİnput.setEditable(false);

        inputbox = new JComboBox();
        inputbox.addItem("Milimetre");
        inputbox.addItem("Santimetre");
        inputbox.addItem("Metre");
        inputbox.addItem("Kilometre");
        inputbox.addItem("İnç");
        inputbox.addItem("Fut");
        inputbox.addItem("Yarda");
        inputbox.addItem("Mil");
        inputbox.setSelectedItem("Metre");
        inputbox.setBounds(25,65,100,25);

        tfOutput = new JTextField();
        tfOutput.setFont(myFont);
        tfOutput.setBounds(25,105,300,35);
        tfOutput.setEditable(false);

        outputbox = new JComboBox();
        outputbox.addItem("Milimetre");
        outputbox.addItem("Santimetre");
        outputbox.addItem("Metre");
        outputbox.addItem("Kilometre");
        outputbox.addItem("İnç");
        outputbox.addItem("Fut");
        outputbox.addItem("Yarda");
        outputbox.addItem("Mil");
        outputbox.setSelectedItem("İnç");
        outputbox.setBounds(25,150,100,25);

        for(int i = 1;i<10;i++){
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


        sıfır = new JButton("0");
        sıfır.setFocusable(false);
        sıfır.addActionListener(this);
        sıfır.setFont(myFont);
        sıfır.setBounds(152,435,97,46);


        nokta = new JButton(".");
        nokta.setFocusable(false);
        nokta.addActionListener(this);
        nokta.setFont(myFont);
        nokta.setBounds(254,435,97,46);

        eşit = new JButton("=");
        eşit.setFont(myFont);
        eşit.setFocusable(false);
        eşit.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(50,230,300,200);
        panel.setLayout(new GridLayout(4,3,5,5));

        panel.add(eşit);
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

        this.setJMenuBar(menu);
        this.add(tfİnput);
        this.add(inputbox);
        this.add(outputbox);
        this.add(tfOutput);
        this.add(panel);
        this.add(sıfır);
        this.add(nokta);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==eşit){
            convert();
        }

        if(e.getSource()==sıfır){
            String s = tfİnput.getText();
            tfİnput.setText(s+"0");
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
        if(e.getSource()==Sıcaklık){
            this.dispose();
            new Sıcaklık_Calculator();
        }
    }
    private void convert(){
        String sayı = tfİnput.getText();
        String conversionfrom = (String) inputbox.getSelectedItem();
        String conversionto = (String) outputbox.getSelectedItem();

        try{
            switch (conversionfrom){
                case "Milimetre":
                    convertfrommilimetre(sayı,conversionto);
                    break;
                case "Santimetre":
                    convertfromsantimetre(sayı,conversionto);
                    break;
                case "Metre":
                    convertfrommetre(sayı,conversionto);
                    break;
                case "Kilometre":
                    convertfromkilometre(sayı,conversionto);
                    break;
                case "İnç":
                    convertfrominç(sayı,conversionto);
                    break;
                case "Fut":
                    convertfromfut(sayı,conversionto);
                    break;
                case "Yarda":
                    convertfromyarda(sayı,conversionto);
                    break;
                case "Mil":
                    convertfrommil(sayı,conversionto);
                    break;


            }
        } catch (Exception e) {
            tfOutput.setText("Hatalı Giriş");
        }
    }
    private void convertfrommilimetre(String Milimetre,String conversionto){
        Double sayı = Double.parseDouble(Milimetre);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı;
                break;
            case "Santimetre":
                sonuç = sayı/10;
                break;
            case "Metre":
                sonuç = sayı/Math.pow(10,3);
                break;
            case "Kilometre":
                sonuç =sayı/Math.pow(10,6);
                break;
            case "İnç":
                sonuç = sayı/25.4;
                break;
            case "Fut":
                sonuç = sayı/304.8;
                break;
            case "Yarda":
                sonuç =sayı/914.4;
                break;
            case "Mil":
                sonuç = sayı/ 1609344;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }

    private void convertfromsantimetre(String Santimetre,String conversionto){
        Double sayı = Double.parseDouble(Santimetre);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı*10;
                break;
            case "Santimetre":
                sonuç = sayı;
                break;
            case "Metre":
                sonuç = sayı/Math.pow(10,2);
                break;
            case "Kilometre":
                sonuç =sayı/Math.pow(10,5);
                break;
            case "İnç":
                sonuç = sayı/2.54;
                break;
            case "Fut":
                sonuç = sayı/30.48;
                break;
            case "Yarda":
                sonuç =sayı/91.44;
                break;
            case "Mil":
                sonuç = sayı/ 160934.4;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfrommetre(String Metre,String conversionto){
        Double sayı = Double.parseDouble(Metre);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı;
                break;
            case "Santimetre":
                sonuç = sayı*1000;
                break;
            case "Metre":
                sonuç = sayı*100;
                break;
            case "Kilometre":
                sonuç =sayı/Math.pow(10,3);
                break;
            case "İnç":
                sonuç = sayı*39.37;
                break;
            case "Fut":
                sonuç = sayı*3.28;
                break;
            case "Yarda":
                sonuç =sayı*1.09;
                break;
            case "Mil":
                sonuç = sayı/ 1609.344;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfromkilometre(String Kilometre,String conversionto){
        Double sayı = Double.parseDouble(Kilometre);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı*1000000;
                break;
            case "Santimetre":
                sonuç = sayı*100000;
                break;
            case "Metre":
                sonuç = sayı*1000;
                break;
            case "Kilometre":
                sonuç =sayı;
                break;
            case "İnç":
                sonuç = sayı*39370.0787;
                break;
            case "Fut":
                sonuç = sayı*3280.8399;
                break;
            case "Yarda":
                sonuç =sayı*1093.6133;
                break;
            case "Mil":
                sonuç = sayı* 0.621371192;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfrominç(String Inch,String conversionto){
        Double sayı = Double.parseDouble(Inch);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı* 25.4;
                break;
            case "Santimetre":
                sonuç = sayı* 2.54;
                break;
            case "Metre":
                sonuç = sayı* 0.0254;
                break;
            case "Kilometre":
                sonuç =sayı* 0.0000254;
                break;
            case "İnç":
                sonuç = sayı;
                break;
            case "Fut":
                sonuç = sayı/ 12;
                break;
            case "Yarda":
                sonuç =sayı/ 36;
                break;
            case "Mil":
                sonuç = sayı/ 63360;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfromfut(String Fut,String conversionto){
        Double sayı = Double.parseDouble(Fut);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı* 304.8;
                break;
            case "Santimetre":
                sonuç = sayı* 30.48;
                break;
            case "Metre":
                sonuç = sayı* 0.3048;
                break;
            case "Kilometre":
                sonuç =sayı* 0.0003048;
                break;
            case "İnç":
                sonuç = sayı*12;
                break;
            case "Fut":
                sonuç = sayı;
                break;
            case "Yarda":
                sonuç =sayı/3;
                break;
            case "Mil":
                sonuç = sayı/5280;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfromyarda(String Yarda,String conversionto){
        Double sayı = Double.parseDouble(Yarda);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı* 914.4;
                break;
            case "Santimetre":
                sonuç = sayı* 91.44;
                break;
            case "Metre":
                sonuç = sayı* 0.9144;
                break;
            case "Kilometre":
                sonuç =sayı* 0.0009144;
                break;
            case "İnç":
                sonuç = sayı*36;
                break;
            case "Fut":
                sonuç = sayı*3;
                break;
            case "Yarda":
                sonuç =sayı;
                break;
            case "Mil":
                sonuç = sayı/1760;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
    private void convertfrommil(String Mil,String conversionto){
        Double sayı = Double.parseDouble(Mil);
        Double sonuç=0.0;
        switch(conversionto){
            case "Milimetre":
                sonuç =sayı* 25.4;
                break;
            case "Santimetre":
                sonuç = sayı* 2.54;
                break;
            case "Metre":
                sonuç = sayı* 0.0254;
                break;
            case "Kilometre":
                sonuç =sayı* 0.0000254;
                break;
            case "İnç":
                sonuç = sayı* 0.001;
                break;
            case "Fut":
                sonuç = sayı* 0.001 / 12;
                break;
            case "Yarda":
                sonuç =sayı* 0.001 / 36;
                break;
            case "Mil":
                sonuç = sayı;
                break;

        }
        tfOutput.setText(sonuç.toString());
    }
}
