package de.tu_bs.cs.isf.deltatalk;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ChatWindow extends JFrame {
	private JTextPane inputTextPane;
	private JTextPane outputTextPane;
	private JButton sendButton;

	public ChatWindow() {
		super();
		this.setVisible(true);

		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		setupGUI(c);

		this.setSize(new Dimension(400, 750));
	}

	private void setupGUI(GridBagConstraints c) {
		setupTextPanes(c);
		setupButtons(c);
	}

	private void setupButtons(GridBagConstraints c) {
		sendButton = new JButton();
		sendButton.setVisible(true);
		sendButton.setText("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		this.getContentPane().add(sendButton, c);
	}

	private void setupTextPanes(GridBagConstraints c) {
		outputTextPane = new JTextPane();
		outputTextPane.setVisible(true);
		outputTextPane.setEditable(false);

		JScrollPane outputTextScroll = new JScrollPane(outputTextPane);
		outputTextScroll.setPreferredSize(new Dimension(380, 450));

		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 0;
		this.getContentPane().add(outputTextScroll, c);

		inputTextPane = new JTextPane();
		inputTextPane.setVisible(true);

		JScrollPane inputTextScroll = new JScrollPane(inputTextPane);
		inputTextScroll.setPreferredSize(new Dimension(380, 150));
		
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 1;
		this.getContentPane().add(inputTextScroll, c);
	}

	private void sendMessage() {
		if(inputTextPane.getText().equals(""))
			return;
		
		outputTextPane.setText(outputTextPane.getText() + inputTextPane.getText() + "\n");
		inputTextPane.setText("");
	}
}
