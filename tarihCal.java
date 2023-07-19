import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class tarihCal extends JFrame implements ActionListener {
    JLabel date,yılLabel,ayLabel,günLabel,Sonuç;
    JTextField tfDate;
    JRadioButton ekle,çıkar;
    ButtonGroup group;
    JComboBox yıl,ay,gün;
    JMenu dosya,tür;
    JMenuBar menu;
    JMenuItem exitItem,Standart,programlayıcı,bilimsel,Sıcaklık,Uzunluk;

    JButton convert;

    Font myFont = new Font("Ariel",Font.BOLD,14);
    tarihCal(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,350);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Tarih Hesaplama");


        menu = new JMenuBar();
        dosya= new JMenu("Dosya");
        tür = new JMenu("Tür");
        exitItem = new JMenuItem("Çık");
        Standart = new JMenuItem("Standart");
        programlayıcı = new JMenuItem("Programlayıcı");
        bilimsel = new JMenuItem("Bilimsel");
        Sıcaklık = new JMenuItem("Sıcaklık");
        Uzunluk = new JMenuItem("Uzunluk");


        menu.add(dosya);
        menu.add(tür);
        dosya.add(exitItem);
        tür.add(Standart);
        tür.add(bilimsel);
        tür.add(programlayıcı);
        tür.add(Sıcaklık);
        tür.add(Uzunluk);

        Standart.addActionListener(this);
        programlayıcı.addActionListener(this);
        exitItem.addActionListener(this);
        Sıcaklık.addActionListener(this);
        Uzunluk.addActionListener(this);




        date = new JLabel("Tarih(GG/AA/YYYY):");
        date.setFont(myFont);
        date.setBounds(35,50,150,50);

        tfDate = new JTextField();
        tfDate.setBounds(175,63,200,25);

        ekle = new JRadioButton("Ekle");
        çıkar = new JRadioButton("Çıkar");
        ekle.setFocusable(false);
        çıkar.setFocusable(false);
        group = new ButtonGroup();
        group.add(ekle);
        group.add(çıkar);

        ekle.setBounds(45,100,50,50);
        çıkar.setBounds(110,100,60,50);

        yılLabel = new JLabel("Yıl");
        yılLabel.setBounds(45,150,50,25);


        yıl = new JComboBox();
        for(int i = 0;i<=999;i++){
            yıl.addItem(String.valueOf(i));
        }
        yıl.setSelectedItem(0);
        yıl.setBounds(45,170,50,25);

        ayLabel = new JLabel("Ay");
        ayLabel.setBounds(110,150,50,25);


        ay = new JComboBox();
        for(int i = 0;i<=999;i++){
            ay.addItem(String.valueOf(i));
        }
        ay.setSelectedItem(0);
        ay.setBounds(110,170,50,25);

        günLabel = new JLabel("Gün");
        günLabel.setBounds(175,150,50,25);


        gün = new JComboBox();
        for(int i = 0;i<=999;i++){
            gün.addItem(String.valueOf(i));
        }
        gün.setSelectedItem(0);
        gün.setBounds(175,170,50,25);


        convert = new JButton("Hesapla");
        convert.setFocusable(false);
        convert.setBounds(45,225,100,25);
        convert.addActionListener(this);

        Sonuç = new JLabel("Sonuç: ");
        Sonuç.setBounds(180,225,150,25);



        this.setJMenuBar(menu);
        this.add(date);
        this.add(tfDate);
        this.add(ekle);
        this.add(çıkar);
        this.add(yılLabel);
        this.add(yıl);
        this.add(ayLabel);
        this.add(ay);
        this.add(günLabel);
        this.add(gün);
        this.add(convert);
        this.add(Sonuç);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==convert){
            DateCalculet();
        }
        if(e.getSource()==Standart){
            this.dispose();
            new Calculator();
        }
        if(e.getSource()==programlayıcı){
            this.dispose();
            new BinaryCalculator();
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }
        if(e.getSource()==Sıcaklık){
            this.dispose();
            new Sıcaklık_Calculator();
        }
        if(e.getSource() == Uzunluk){
            this.dispose();
            new Uzunluk_Calculator();
        }
    }
    private void DateCalculet(){
        String tarih = tfDate.getText();
        Boolean operatör = ekle.isSelected();
        int years = Integer.parseInt(yıl.getSelectedItem().toString());
        int months = Integer.parseInt(ay.getSelectedItem().toString());
        int days = Integer.parseInt(gün.getSelectedItem().toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(tarih,formatter);
        LocalDate result;
        if(operatör){
            result = date1.plusYears(years).plusMonths(months).plusDays(days);
        }
        else{
            result = date1.minusYears(years).minusMonths(months).minusDays(days);
        }
        String result1 = result.format(formatter);
        Sonuç.setText(result1);
    }
}
