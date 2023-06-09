package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SimpleGUI extends JFrame{
        private JButton button = new JButton("Press");
        public static JTextField input = new JTextField("", 5);
        private JLabel label = new JLabel("Input");
        private JRadioButton radio1 = new JRadioButton("Select This");
        private JRadioButton radio2 = new JRadioButton("Select That");
        private JCheckBox check = new JCheckBox("Check", false);

        public SimpleGUI(){
            super("Simple Example");
            this.setBounds(100, 500, 300, 100);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container container = this.getContentPane();
            container.setLayout(new GridLayout(3,2,2,2));
            container.add(label);
            container.add(input);

            ButtonGroup group = new ButtonGroup();
            group.add(radio1);
            group.add(radio2);
            container.add(radio1);
            radio2.setSelected(true);
            container.add(radio2);
            container.add(check);
            button.addActionListener(new ButtonEventListener());
            container.add(button);
        }
}

class ButtonEventListener implements ActionListener{
    public void actionPerformed (ActionEvent e){
        String message = "Button was pressed\n";
        message +="Text is \n";  // input.getText() + "\n";
        message += "Checkbox is " ;//+ ((check.isSelected()) ? "checked":"unchecked");
        JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
    }
}


 /*   public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }*/