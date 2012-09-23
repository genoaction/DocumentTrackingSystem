package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DTS_GUI extends JFrame {
	int counter = 0;
	public JPanel rightPanel,leftPanel;
	private static final int FRAME_WIDTH = 660;
	private static final int FRAME_HEIGHT = 496;  
	private JLabel icon;

	/**
	 * Use for opening window.
	 */
	public DTS_GUI(){
		createView();
		createLayout();
		createController();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);	
		setVisible(true);
	}

	/**
	 * This method use for create view object.
	 */
	public void createView(){
		
		rightPanel = new JPanel();
		rightPanel.setBackground(new Color(255, 182, 193));
		rightPanel.setBounds(222, 11, 420, 440);
		
		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(204, 204, 255));
		leftPanel.setBounds(10, 92, 202, 359);
		leftPanel.setLayout(null);
		
		icon = new JLabel("");
		icon.setIcon(new ImageIcon("asset/iconDTS.gif"));
		icon.setBounds(10, 11, 202, 70);
//		getContentPane().add(icon);
	}

	/**
	 * This method use for create layout.
	 */
	public void createLayout(){
		getContentPane().setLayout(null);
		
		getContentPane().add(rightPanel);
//		getComponents();
//		rightPanel.add(new DocumentsPanel());
		
		getContentPane().add(leftPanel);

		rightPanel.add(new DocumentsPanel(this));
//		rightPanel.add(new SearchPanel());
		leftPanel.add(new MenuPanel(this));
		getContentPane().add(icon);
		
//		getComponents();
//		rightPanel.getRootPane().add(new DocumentsPanel(this));
	}

	/**
	 * Use for manage buttons on the window.
	 */
	private void createController() {
		addCloseWindowController();
	}

	/**
	 * This method use for close GUI window when click exit button on the frame.
	 */
	private void addCloseWindowController() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}


	public static void main(String[] args) {
		new DTS_GUI();
	}
}