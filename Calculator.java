import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;

    JLabel label;
    JMenu dosya,tür;
    JMenuBar menu;
    JMenuItem exitItem,Standart,programlayıcı,bilimsel,tarih,Sıcaklık,Uzunluk;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;
    Font myFont = new Font("monospaced",Font.BOLD,30);


    double num1 = 0,num2 = 0,result = 0;
    char operator;

    Calculator(){
        frame = new JFrame("Hesap Makinesi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        




        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);


        menu = new JMenuBar();
        dosya= new JMenu("Dosya");
        tür = new JMenu("Tür");
        exitItem = new JMenuItem("Çık");
        Standart = new JMenuItem("Standart");
        programlayıcı = new JMenuItem("Programlayıcı");
        bilimsel = new JMenuItem("Bilimsel");
        tarih = new JMenuItem("Tarih Hesaplama");
        Sıcaklık = new JMenuItem("Sıcaklık");
        Uzunluk = new JMenuItem("Uzunluk");


        menu.add(dosya);
        menu.add(tür);
        dosya.add(exitItem);
        tür.add(programlayıcı);
        tür.add(bilimsel);
        tür.add(tarih);
        tür.add(Sıcaklık);
        tür.add(Uzunluk);
        programlayıcı.addActionListener(this);
        exitItem.addActionListener(this);
        tarih.addActionListener(this);
        Sıcaklık.addActionListener(this);
        Uzunluk.addActionListener(this);



        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("X");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i = 0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0;i<10;i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
            //numberButton[i].setForeground(Color.RED);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));


        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(divButton);
        panel.add(equButton);



        frame.setJMenuBar(menu);
        frame.add(panel);
        frame.add(delButton);
        frame.add(negButton);
        frame.add(clrButton);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(textField);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i<10;i++){
            if(e.getSource()== numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            switch (operator){
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;

        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==delButton){
            String string  = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *=-1;
            textField.setText(String.valueOf(temp));

            }

        if(e.getSource()==exitItem){
            System.exit(0);
        }
        if(e.getSource()==programlayıcı){
            frame.dispose();
            new BinaryCalculator().setVisible(true);

        }
        if(e.getSource()==tarih){
            frame.dispose();
            new tarihCal();
        }
        if(e.getSource()==Sıcaklık){
            frame.dispose();
            new Sıcaklık_Calculator();
        }
        if(e.getSource()==Uzunluk){
            frame.dispose();
            new Uzunluk_Calculator();
        }
        }
}

