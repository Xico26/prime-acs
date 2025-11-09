package io.github.xico26;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {
    public final Controller controller;
    JTextField driverIdField = new JTextField(20);
    JTextField discordIdField = new JTextField(20);
    JButton button = new JButton("Submit");
    JButton button2 = new JButton("Print");
    JComboBox typeBox = new JComboBox(new String[] {"AW Issued", "LOA", "Removed", "Left"});

    public UI () {
        Controller controller = new Controller();
        this.controller = controller;
    }

    public void run () {
        JFrame frame = new JFrame();


        JLabel label = new JLabel("Driver ID");
        label.setBounds(150, 80, 200, 20);
        frame.add(label);

        driverIdField.setBounds(150, 100, 200, 50);
        frame.add(driverIdField);

        JLabel label2 = new JLabel("Discord URL");
        label2.setBounds(150, 180, 200, 20);
        frame.add(label2);

        discordIdField.setBounds(150, 200, 200, 50);
        frame.add(discordIdField);

        typeBox.setBounds(150, 250, 200, 50);
        frame.add(typeBox);


        button.setBounds(150, 300, 200, 50);
        button.addActionListener(this);
        frame.add(button);

        button2.setBounds(150, 400, 200, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.printAll();
            }
        });
        frame.add(button2);

        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String driverId = driverIdField.getText();
        String discordId = discordIdField.getText();
        int option = typeBox.getSelectedIndex();

        controller.addLine(driverId, discordId, option);
    }
}
