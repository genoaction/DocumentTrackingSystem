package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.*;

import net.miginfocom.swing.MigLayout;

public class ReportPanel extends JPanel {

	private JTabbedPane tabbedPane;
	private JPanel createDocPanel, updateDocPanel;
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 420;
	static DTS_GUI frame; 
	/**
	 * Create the panel.
	 */
	public ReportPanel(DTS_GUI frame) {
		createLayout();
		ReportPanel.frame = frame;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
//		setVisible(true);
	}

	public void createLayout(){
		setBackground(new Color(255, 182, 193));
		setLayout(new MigLayout("", "[400px]", "[420px]"));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setFont(new Font("Cordia New", Font.PLAIN, 19));
		add(tabbedPane, "cell 0 0,grow");
		
		createDocPanel = new JPanel();
		createDocPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		createDocPanel.setBackground(new Color(255, 240, 245));
		tabbedPane.addTab("��§ҹ", null, createDocPanel, null);
		createDocPanel.setLayout(null);

	}
}
