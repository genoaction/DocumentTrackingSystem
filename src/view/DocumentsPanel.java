package view;

import javax.swing.JPanel;


import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.*;
import javax.swing.text.AbstractDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Date;
import java.util.Locale;
import java.util.Observer;

public class DocumentsPanel extends JPanel {

	private JTabbedPane tabbedPane;
	private JPanel createDocPanel, updateDocPanel;
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 420;
	static DTS_GUI frame;  
	
	private JLabel docIDLabel, orgLabel, docNOLabel, dateLabel, subjLabel, toLabel, copLabel;
	private JTextField docIDField, orgField, docNOField, subjField, toField, copField;
	private JButton copButton,saveButton, delAllButton, addDateButton;
	private ObservingTextField dateDocField;
	private JFileChooser fileChooser;
	
	private JLabel docIDUpLabel, dateUpLabel, timeUpLabel, SRNameLabel;
	private JTextField docIDUpField, timeUpField;
	private JRadioButton receiveRadioButton, sendRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox docInOutChoice, SRNameComboBox;
	private JButton addDateUpButton, cancelUpButton, saveUpButton;
	private ObservingTextField dateUpField;


	public DocumentsPanel(DTS_GUI frame) {
		createView();
		createLayout();
		buttonController();
		DocumentsPanel.frame = frame;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//		setVisible(true);
	}

	public void createView(){
		setBackground(new Color(255, 182, 193));
		setLayout(new MigLayout("", "[400px]", "[420px]"));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setFont(new Font("Cordia New", Font.PLAIN, 19));

		createDocPanel = new JPanel();
		createDocPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		createDocPanel.setBackground(new Color(255, 240, 245));
		createDocPanel.setLayout(null);

		updateDocPanel = new JPanel();
		updateDocPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		updateDocPanel.setBackground(new Color(255, 240, 245));
		updateDocPanel.setLayout(null);
		
		createDocTabView();
		createUpdateTabView();
	
	}
	
	public void createDocTabView(){
		
		docIDLabel = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23");
		docIDLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		docIDLabel.setBounds(10, 13, 70, 17);

		docIDField = new JTextField();
		docIDField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		docIDField.setBounds(90, 11, 120, 20);
		docIDField.setColumns(10);
		docIDField.setDocument(new FixedTextField());

		orgLabel = new JLabel("\u0E2A\u0E48\u0E27\u0E19\u0E23\u0E32\u0E0A\u0E01\u0E32\u0E23");
		orgLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		orgLabel.setBounds(10, 46, 70, 17);

		orgField = new JTextField();
		orgField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		orgField.setColumns(10);
		orgField.setBounds(90, 46, 270, 20);

		docNOLabel = new JLabel("\u0E40\u0E25\u0E02\u0E17\u0E35\u0E48\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23");
		docNOLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		docNOLabel.setBounds(10, 76, 70, 22);

		docNOField = new JTextField();
		docNOField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		docNOField.setColumns(10);
		docNOField.setBounds(90, 79, 120, 20);

		dateLabel = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48");
		dateLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		dateLabel.setBounds(10, 109, 38, 24);

		subjLabel = new JLabel("\u0E40\u0E23\u0E37\u0E48\u0E2D\u0E07");
		subjLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		subjLabel.setBounds(10, 144, 38, 20);

		subjField = new JTextField();
		subjField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		subjField.setColumns(10);
		subjField.setBounds(55, 146, 155, 20);

		toLabel = new JLabel("\u0E1C\u0E39\u0E49\u0E23\u0E31\u0E1A");
		toLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		toLabel.setBounds(10, 176, 38, 24);

		toField = new JTextField();
		toField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		toField.setColumns(10);
		toField.setBounds(55, 180, 155, 20);

		copLabel = new JLabel("\u0E2A\u0E33\u0E40\u0E19\u0E32");
		copLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		copLabel.setBounds(10, 214, 38, 17);

		copField = new JTextField();
		copField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		copField.setColumns(10);
		copField.setBounds(55, 214, 251, 20);

		copButton = new JButton("\u0E41\u0E19\u0E1A");
		copButton.setFont(new Font("Cordia New", Font.PLAIN, 19));
		copButton.setBounds(316, 213, 57, 23);

		saveButton = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		saveButton.setFont(new Font("Cordia New", Font.PLAIN, 19));
		saveButton.setBounds(52, 250, 70, 23);

		delAllButton = new JButton("\u0E25\u0E49\u0E32\u0E07");
		delAllButton.setFont(new Font("Cordia New", Font.PLAIN, 19));
		delAllButton.setBounds(132, 250, 57, 23);

		addDateButton = new JButton("\u0E40\u0E25\u0E37\u0E2D\u0E01\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48");
		addDateButton.setFont(new Font("Cordia New", Font.PLAIN, 19));
		addDateButton.setBounds(125, 111, 85, 23);

		dateDocField = new ObservingTextField();
		dateDocField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		dateDocField.setBounds(55, 113, 62, 20);
		dateDocField.setColumns(10);
		
	}
	
	public void createUpdateTabView(){
		
		docIDUpLabel = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E40\u0E2D\u0E01\u0E2A\u0E32\u0E23");
		docIDUpLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		docIDUpLabel.setBounds(10, 13, 70, 17);
		//		createDocPanel.add(docIDLabel);

		docIDUpField = new JTextField();
		docIDUpField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		docIDUpField.setBounds(90, 11, 120, 20);
		docIDUpField.setColumns(10);
		docIDUpField.setDocument(new FixedTextField());
//		createDocPanel.add(docIDField);

		sendRadioButton = new JRadioButton("\u0E2A\u0E48\u0E07");
		sendRadioButton.setSelected(true);
		buttonGroup.add(sendRadioButton);
		sendRadioButton.setFont(new Font("Cordia New", Font.PLAIN, 20));
		sendRadioButton.setBackground(new Color(255, 240, 245));
		sendRadioButton.setBounds(12, 43, 39, 23);
//		updateDocPanel.add(sendRadioButton);
		
		receiveRadioButton = new JRadioButton("\u0E23\u0E31\u0E1A");
		buttonGroup.add(receiveRadioButton);
		receiveRadioButton.setFont(new Font("Cordia New", Font.PLAIN, 20));
		receiveRadioButton.setBackground(new Color(255, 240, 245));
		receiveRadioButton.setBounds(58, 43, 46, 23);
//		updateDocPanel.add(receiveRadioButton);
		
		docInOutChoice = new JComboBox();
		docInOutChoice.setFont(new Font("Cordia New", Font.PLAIN, 20));
		docInOutChoice.setBounds(113, 44, 133, 20);
		docInOutChoice.addItem("�͡�������");
		docInOutChoice.addItem("�͡�����¹͡");
		docInOutChoice.setSelectedItem("�͡�������");
//		updateDocPanel.add(docInOutChoice);
		
		SRNameLabel = new JLabel("\u0E1C\u0E39\u0E49\u0E23\u0E31\u0E1A/\u0E1C\u0E39\u0E49\u0E2A\u0E48\u0E07");
		SRNameLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		SRNameLabel.setBounds(10, 76, 56, 23);
//		updateDocPanel.add(SRNameField);
		
		dateUpLabel = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48");
		dateUpLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		dateUpLabel.setBounds(10, 111, 32, 23);
//		updateDocPanel.add(dateUpField);
		
		dateUpField = new ObservingTextField();
		dateUpField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		dateUpField.setColumns(10);
		dateUpField.setBounds(46, 112, 62, 20);
//		updateDocPanel.add(dateUpField);
		
		timeUpLabel = new JLabel("\u0E40\u0E27\u0E25\u0E32");
		timeUpLabel.setFont(new Font("Cordia New", Font.PLAIN, 20));
		timeUpLabel.setBounds(10, 144, 32, 23);
//		updateDocPanel.add(timeUpLabel);
		
		timeUpField = new JTextField();
		timeUpField.setFont(new Font("Cordia New", Font.PLAIN, 20));
		timeUpField.setColumns(10);
		timeUpField.setBounds(46, 147, 120, 20);
//		updateDocPanel.add(timeUpField);
		
		addDateUpButton = new JButton("\u0E40\u0E25\u0E37\u0E2D\u0E01\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48");
		addDateUpButton.setFont(new Font("Cordia New", Font.PLAIN, 19));
		addDateUpButton.setBounds(114, 111, 85, 23);
//		updateDocPanel.add(addDateUpButton);
		
		saveUpButton = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		saveUpButton.setFont(new Font("Cordia New", Font.PLAIN, 19));
		saveUpButton.setBounds(44, 178, 70, 23);
//		updateDocPanel.add(saveUpButton);
		
		cancelUpButton = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		cancelUpButton.setFont(new Font("Cordia New", Font.PLAIN, 19));
		cancelUpButton.setBounds(124, 178, 75, 23);
//		updateDocPanel.add(cancelUpButton);
		
		SRNameComboBox = new JComboBox();
		SRNameComboBox.setFont(new Font("Cordia New", Font.PLAIN, 20));
		SRNameComboBox.setBounds(72, 77, 174, 20);
//		updateDocPanel.add(SRNameComboBox);
		
	}

	public void createLayout(){
		add(tabbedPane, "cell 0 0,grow");

		tabbedPane.addTab("เอกสาร", null, createDocPanel, null);
		createDocPanel.add(docIDLabel);
		createDocPanel.add(docIDField);
		createDocPanel.add(orgLabel);
		createDocPanel.add(orgField);
		createDocPanel.add(docNOLabel);
		createDocPanel.add(docNOField);
		createDocPanel.add(dateLabel);
		createDocPanel.add(subjLabel);
		createDocPanel.add(subjField);
		createDocPanel.add(toLabel);
		createDocPanel.add(toField);
		createDocPanel.add(copLabel);
		createDocPanel.add(copField);
		createDocPanel.add(copButton);
		createDocPanel.add(saveButton);
		createDocPanel.add(delAllButton);
		createDocPanel.add(dateDocField);
		createDocPanel.add(addDateButton);

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

	private void buttonController(){

		addDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDate(dateDocField);
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		delAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				docIDField.setText(null); 
				orgField.setText(null); 
				docNOField.setText(null);
				subjField.setText(null);
				toField.setText(null);
				copField.setText(null);
				dateDocField.setText(null);
			}
		});
		
		addDateUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDate(dateUpField);
			}
		});
		
		cancelUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.rightPanel.getComponent(frame.counter++).setVisible(false);
				frame.rightPanel.add(new DocumentsPanel(frame));
			}
		});
		
		saveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		copButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileChooser = new JFileChooser();
				int retval = fileChooser.showOpenDialog(DocumentsPanel.this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					copField.setText(file.getAbsolutePath());
				}
			}
		});
	}

	private void addDate(ObservingTextField dateField){
		String lang = null;
		final Locale locale = getLocale(lang);
		DatePicker dp = new DatePicker(dateField, locale);
		Date selectedDate = dp.parseDate(dateField.getText());
		dp.setSelectedDate(selectedDate);
		dp.start(dateField);
	}
	
	private Locale getLocale(String loc){
		if(loc != null && loc.length()>0)
			return new Locale(loc);
		else
			return Locale.US;
	}
}
