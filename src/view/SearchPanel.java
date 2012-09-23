package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.handler.MessageContext.Scope;

public class SearchPanel extends JPanel {

	private JTabbedPane tabbedPane;
	private JPanel createDocPanel, updateDocPanel;
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 420;
	static DTS_GUI frame; 
	
	private JLabel docIDUpLabel, dateUpLabel, timeUpLabel, SRNameLabel;
	private JTextField docIDUpField, timeUpField;
	private JRadioButton receiveRadioButton, sendRadioButton;
	private JButton addDateUpButton, cancelUpButton, saveUpButton;
	private JTextField searchField;
	private JLabel searchLabel, searchByLabel, typeDocLabel;
	private JComboBox searchByComboBox, typeDocComboBox;
	private JTable table;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public SearchPanel(DTS_GUI frame) {
		createView();
		createLayout();
		submitController();
		SearchPanel.frame = frame;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//		setVisible(true);
	}

	public void createView() {
		
		setBackground(new Color(255, 182, 193));
		setLayout(new MigLayout("", "[400px]", "[420px]"));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setFont(new Font("Cordia New", Font.PLAIN, 19));
		
		createDocPanel = new JPanel();
		createDocPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		createDocPanel.setBackground(new Color(255, 240, 245));
		createDocPanel.setLayout(null);
		
		searchLabel = new JLabel("\u0E04\u0E49\u0E19\u0E2B\u0E32");
		searchLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		searchLabel.setBounds(10, 13, 39, 17);
//		createDocPanel.add(searchLabel);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		searchField.setColumns(10);
		searchField.setBounds(48, 11, 107, 20);
//		createDocPanel.add(searchField);
		
		searchByLabel = new JLabel("\u0E42\u0E14\u0E22");
		searchByLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		searchByLabel.setBounds(160, 13, 28, 17);
//		createDocPanel.add(searchByLabel);
		
		searchByComboBox = new JComboBox();
		searchByComboBox.setFont(new Font("Cordia New", Font.PLAIN, 19));
		searchByComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0E23\u0E2B\u0E31\u0E2A\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23", "\u0E2A\u0E48\u0E27\u0E19\u0E23\u0E32\u0E0A\u0E01\u0E32\u0E23", "\u0E40\u0E25\u0E02\u0E17\u0E35\u0E48\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23", "\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48", "\u0E1C\u0E39\u0E49\u0E23\u0E31\u0E1A", "\u0E0A\u0E37\u0E48\u0E2D\u0E40\u0E23\u0E37\u0E48\u0E2D\u0E07"}));
		searchByComboBox.setBounds(185, 11, 89, 20);
//		createDocPanel.add(searchByComboBox);
		
		typeDocComboBox = new JComboBox();
		typeDocComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0E17\u0E31\u0E49\u0E07\u0E2B\u0E21\u0E14", "\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23\u0E40\u0E02\u0E49\u0E32", "\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23\u0E2D\u0E2D\u0E01"}));
		typeDocComboBox.setFont(new Font("Cordia New", Font.PLAIN, 20));
		typeDocComboBox.setBounds(308, 11, 75, 20);
//		createDocPanel.add(typeDocComboBox);
		
		typeDocLabel = new JLabel("\u0E0A\u0E19\u0E34\u0E14");
		typeDocLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		typeDocLabel.setBounds(280, 13, 28, 17);
//		createDocPanel.add(typeDocLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBounds(13, 49, 370, 324);
//		createDocPanel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Cordia New", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0E23\u0E2B\u0E31\u0E2A\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23", "\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14", "Link"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(188);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);

		scrollPane.setViewportView(table);
		scrollPane.setFont(new Font("Cordia New", Font.PLAIN, 20));

	}

	public void createLayout(){
		
		add(tabbedPane, "cell 0 0,grow");

		tabbedPane.addTab("ค้นหา", null, createDocPanel, null);
		createDocPanel.add(searchLabel);
		createDocPanel.add(searchField);
		createDocPanel.add(searchByLabel);
		createDocPanel.add(searchByComboBox);
		createDocPanel.add(typeDocComboBox);
		createDocPanel.add(typeDocLabel);
		createDocPanel.add(scrollPane);
		
		tabbedPane.addTab("อัพเดทสถานะ", null, updateDocPanel, null);
		updateDocPanel.add(docIDUpLabel);
		updateDocPanel.add(docIDUpField);
		updateDocPanel.add(sendRadioButton);
		updateDocPanel.add(receiveRadioButton);
		updateDocPanel.add(docInOutChoice);
		updateDocPanel.add(SRNameLabel);
		updateDocPanel.add(dateUpLabel);
		updateDocPanel.add(timeUpLabel);
		updateDocPanel.add(timeUpField);
		updateDocPanel.add(addDateUpButton);
		updateDocPanel.add(saveUpButton);
		updateDocPanel.add(cancelUpButton);
		updateDocPanel.add(dateUpField);
		updateDocPanel.add(SRNameComboBox);

	}

	private void submitController() {

	}
}
