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
    JButton button2 = new JButton("Print All");
    JComboBox typeBox = new JComboBox(new String[] {"AW Issued", "LOA", "Removed", "Left"});
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    public UI () {
        Controller controller = new Controller();
        this.controller = controller;
    }

    public void run () {
        JFrame frame = new JFrame();


        JLabel label = new JLabel("Driver ID");
        label.setBounds(150, 50, 200, 20);
        frame.add(label);

        driverIdField.setBounds(150, 70, 200, 50);
        frame.add(driverIdField);

        JLabel label2 = new JLabel("Discord ID/URL");
        label2.setBounds(150, 130, 200, 20);
        frame.add(label2);

        discordIdField.setBounds(150, 150, 200, 50);
        frame.add(discordIdField);

        typeBox.setBounds(150, 210, 200, 50);
        frame.add(typeBox);


        button.setBounds(150, 270, 200, 50);
        button.addActionListener(this);
        frame.add(button);

        button2.setBounds(150, 330, 200, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = controller.printAll();

                textArea.setText(res);
            }
        });
        frame.add(button2);

        JLabel label3 = new JLabel("Output");
        label3.setBounds(10, 390, 480, 20);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label3);

        scrollPane.setBounds(10, 410, 480, 100);
        frame.add(scrollPane);

        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String driverId = driverIdField.getText();
        String discordId = discordIdField.getText();
        int option = typeBox.getSelectedIndex();

        String line = controller.addLine(driverId, discordId, option);

        textArea.setText(line);
    }
}
