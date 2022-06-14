package inputTest;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Keypad extends javax.swing.JFrame implements ActionListener, KeyListener {
	
	public Keypad() {
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		var pane = getContentPane();
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		value = new JTextField(12);
		value.setEditable(false);
		pane.add(value);

		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bd = new JButton(".");
		bb = new JButton("<");
		be = new JButton("Enter");
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bd.addActionListener(this);
		bb.addActionListener(this);
		be.addActionListener(this);
		
		b0.addKeyListener(this);
		b1.addKeyListener(this);
		b2.addKeyListener(this);
		b3.addKeyListener(this);
		b4.addKeyListener(this);
		b5.addKeyListener(this);
		b6.addKeyListener(this);
		b7.addKeyListener(this);
		b8.addKeyListener(this);
		b9.addKeyListener(this);
		bd.addKeyListener(this);
		bb.addKeyListener(this);
		be.addKeyListener(this);

		pane.add(b7);
		pane.add(b8);
		pane.add(b9);

		pane.add(b4);
		pane.add(b5);
		pane.add(b6);

		pane.add(b1);
		pane.add(b2);
		pane.add(b3);

		pane.add(b0);
		pane.add(bd);
		pane.add(bb);
		
		pane.add(be);
		
		pane.addKeyListener(this);
		
		setSize(180, 210);
		setVisible(true);
		
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	}

	
	String getValue() {
		return value.getText();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		action(e.getActionCommand());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			action("Enter");
		} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			action("<");
		} else if ("0123456789.".contains(""+e.getKeyChar())) {
			action(""+e.getKeyChar());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	private void action(String label) {
		var n = value.getText();
		
		if (label.contentEquals(".")) {
			if (!n.contains(".")) {
				n += label;
				bd.setEnabled(false);
			}
		} else if (label == "<") {
			if (n == null || n.length() == 0) {
				n = "";
			} else {
				n = n.substring(0, n.length() - 1);
			}
			
			if (!n.contains(".")) {
				bd.setEnabled(true);
			}
		} else if (label == "Enter") {
			setVisible(false);
			JOptionPane.showMessageDialog(null, n, "Value", JOptionPane.INFORMATION_MESSAGE);
		} else {
			n += label;
		}
		value.setText(n);
	}
	
	private JTextField value; 
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bd, bb, be;
}
