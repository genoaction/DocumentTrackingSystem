package view;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {

	private JPanel menuPanel;
	private JButton manageDocButton, searchButton;
	private static final int FRAME_WIDTH = 202;
	private static final int FRAME_HEIGHT = 359;
	static DTS_GUI frame; 
	private JButton reportButton;
	private JButton btnFuckButton;
	
	/**
	 * Create the panel.
	 */
	public MenuPanel(DTS_GUI frame) {
		createView();
		createLayout();
		submitController();
		MenuPanel.frame = frame;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
//		setVisible(true);
	}

	public void createView() {
		
		setBackground(new Color(204, 204, 255));
		setLayout(new CardLayout(0, 0));
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(204, 204, 255));
		menuPanel.setLayout(null);
		
		manageDocButton = new JButton("เพิ่มเอกสารใหม่");
		manageDocButton.setForeground(Color.BLACK);
		manageDocButton.setFont(new Font("Cordia New", Font.PLAIN, 21));
		manageDocButton.setBounds(38, 51, 126, 33);
		
		searchButton = new JButton("ค้นหา");
		searchButton.setForeground(Color.BLACK);
		searchButton.setFont(new Font("Cordia New", Font.PLAIN, 21));
		searchButton.setBounds(38, 102, 126, 33);
		
	}

	public void createLayout() {
		
		add(menuPanel, "name_28532585254389");
		
		menuPanel.add(manageDocButton);
		
		menuPanel.add(searchButton);
		
		btnFuckButton = new JButton("fuck button");
		btnFuckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// fuck here
			}
		});
		btnFuckButton.setBounds(42, 157, 122, 33);
		menuPanel.add(btnFuckButton);
		
//		reportButton = new JButton("�ʴ���§ҹ");
//		reportButton.setForeground(Color.BLACK);
//		reportButton.setFont(new Font("Cordia New", Font.PLAIN, 21));
//		reportButton.setBounds(38, 153, 126, 33);
//		menuPanel.add(reportButton);
		
	}
	private void submitController(){
		
		manageDocButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.rightPanel.getComponent(frame.counter++).setVisible(false);
				frame.rightPanel.add(new DocumentsPanel(frame));
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.rightPanel.getComponent(frame.counter++).setVisible(false);
				frame.rightPanel.add(new SearchPanel(frame));
			}
		});
		
//		reportButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.rightPanel.getComponent(frame.counter++).setVisible(false);
//				frame.rightPanel.add(new ReportPanel(frame));
//			}
//		});
	}
	
}
