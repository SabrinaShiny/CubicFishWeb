package classes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

import classes.FreshWaterResident.behaviour;
import classes.FreshWaterResident.nature;
import classes.Resident.region;

public class Gui extends JFrame implements MouseListener, ItemListener{
//Global Variables
	//window
	private ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("\\Skalar50.png"));
	private JMenuBar menuBar;
	private JMenu helpMenue;
	private JMenuItem loadItem;

	//panels
	private JPanel residentsPanel;
	private JPanel rightPanel;
	private JPanel selectPanel;
	private JPanel profilePanel;
	private JPanel viewPanel;
	private JPanel dataPanel;
	private PaintPanel aquariumPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private PaintPanel bottomPanel;
	private Border border = BorderFactory.createLineBorder(Color.white,1);

	//scrollbar
	private JScrollPane scrollResidents;
	private JScrollPane scrollSelect;
	private JScrollPane scrollProfile;

	//tools
	private JComboBox comboBox;
	private JButton[] sButtons;
	private JButton[] rButtons;
	private JLabel[] residentLabel;

	//profile of freshwater residents
	private JLabel head= new JLabel();
	private JTextArea headText = new JTextArea();
	private JTextArea sName = new JTextArea();
	private JTextArea origin = new JTextArea();
	private JTextArea age = new JTextArea();
	private JTextArea size = new JTextArea();
	private JTextArea group = new JTextArea();
	private JTextArea groupSize = new JTextArea();
	private JTextArea textRegion = new JTextArea();
	private JTextArea textDiet = new JTextArea();
	private JTextArea textNature = new JTextArea();
	private JTextArea textBehaviour = new JTextArea();
	private JTextArea liter = new JTextArea();
	private JTextArea height = new JTextArea();
	private JTextArea width = new JTextArea();
	private JTextArea c = new JTextArea();
	private JTextArea gh = new JTextArea();
	private JTextArea kh = new JTextArea();
	private JTextArea ph = new JTextArea();
	private JTextArea info = new JTextArea();

	//aquarium data
	private JTextArea aquariumHead = new JTextArea();
	private JTextArea lAquarium = new JTextArea();
	private JTextArea wAquarium = new JTextArea();
	private JTextArea hAquarium = new JTextArea();
	private JTextArea dAquarium = new JTextArea();
	private JTextArea cAquarium = new JTextArea();
	private JTextArea ghAquarium = new JTextArea();
	private JTextArea khAquarium = new JTextArea();
	private JTextArea phAquarium = new JTextArea();
	private JTextArea filter = new JTextArea();
	private JTextArea heater = new JTextArea();
	private JTextArea ground = new JTextArea();

	//commonly used
	private Component[] components;
	private Resident[] globalResidents;
	private Aquarium aquarium = new Aquarium();
	private int residentCount;
	private int i; //zähler

//Methods
	public void imageBuilder(Resident resident, JLabel label, int size) {
		//sets a label image for a specific resident
		if (size == 20) {
			//works in jar file?
			File file = new File("res\\"+resident.getName()+"200.png");
			if (file.exists()) {
				ImageIcon img20 = new ImageIcon(getClass().getClassLoader().getResource("\\"+resident.getName()+"200.png"));
				label.setIcon(img20);
			}
			else {
				ImageIcon img20 = new ImageIcon(getClass().getClassLoader().getResource("\\"+"Skalar200.png"));
				label.setIcon(img20);
			}
		}

		if (size == 15) {
			File file = new File("res\\"+resident.getName()+"150.png");
			if (file.exists()) {
				ImageIcon img15 = new ImageIcon(getClass().getClassLoader().getResource("\\"+resident.getName()+"150.png"));
				label.setIcon(img15);
			}
			else {
				ImageIcon img15 = new ImageIcon(getClass().getClassLoader().getResource("\\"+"Skalar150.png"));
				label.setIcon(img15);
			}
		}

		if (size == 10) {
			File file = new File("res\\"+resident.getName()+"100.png");
			if (file.exists()) {
				ImageIcon img10 = new ImageIcon(getClass().getClassLoader().getResource("\\"+resident.getName()+"100.png"));
				label.setIcon(img10);
			}
			else {
				ImageIcon img10 = new ImageIcon(getClass().getClassLoader().getResource("\\"+"Skalar100.png"));
				label.setIcon(img10);
			}
		}
	}

	public void imageBuilder(Resident resident, JButton button, int size) {
		//sets a button image for a specific resident
		if (size == 20) {
			File file = new File("res\\"+resident.getName()+"200.png");
			if (file.exists()) {
				ImageIcon img20 = new ImageIcon(getClass().getClassLoader().getResource("\\"+resident.getName()+"200.png"));
				button.setIcon(img20);
			}
			else {
				ImageIcon img20 = new ImageIcon(getClass().getClassLoader().getResource("\\"+"Skalar200.png"));
				button.setIcon(img20);
			}
		}

		if (size == 15) {
			File file = new File("res\\"+resident.getName()+"150.png");
			if (file.exists()) {
				ImageIcon img15 = new ImageIcon(getClass().getClassLoader().getResource("\\"+resident.getName()+"150.png"));
				button.setIcon(img15);
			}
			else {
				ImageIcon img15 = new ImageIcon(getClass().getClassLoader().getResource("\\"+"Skalar150.png"));
				button.setIcon(img15);
			}
		}
		if (size == 10) {
			File file = new File("res\\"+resident.getName()+"100.png");
			if (file.exists()) {
				ImageIcon img10 = new ImageIcon(getClass().getClassLoader().getResource("\\"+resident.getName()+"100.png"));
				button.setIcon(img10);
			}
			else {
				ImageIcon img10 = new ImageIcon(getClass().getClassLoader().getResource("\\"+"Skalar100.png"));
				button.setIcon(img10);
			}
		}
	}

	public void comboboxSort(JButton jButton, int pick) {
		//sets visibility only for a specific group of residents true
		if (pick==0) {
			jButton.setVisible(true);
		}

		if (pick==1) {
			if (!globalResidents[i].getGroup().equals("Buntbarsche")) {
				jButton.setVisible(false);
			}
			else {
				jButton.setVisible(true);
			}
		}

		if (pick==2) {
			if (!globalResidents[i].getGroup().equals("Salmler")) {
				jButton.setVisible(false);
			}
			else {
				jButton.setVisible(true);
			}
		}

		if (pick==3) {
			if (!globalResidents[i].getGroup().equals("Lebendgebärende Zahnkarpfen")) {
				jButton.setVisible(false);
			}
			else {
				jButton.setVisible(true);
			}
		}

		if (pick==4) {
			if (!globalResidents[i].getGroup().equals("Welse")) {
				jButton.setVisible(false);
			}
			else {
				jButton.setVisible(true);
			}
		}

		if (pick==5) {
			if (!globalResidents[i].getGroup().equals("Buntbarsche")&& !globalResidents[i].getGroup().equals("Salmler")
				&& !globalResidents[i].getGroup().equals("Lebendgebärende Zahnkarpfen")&&
				!globalResidents[i].getGroup().equals("Welse")) {
				jButton.setVisible(true);
			}
			else {
				jButton.setVisible(false);
			}
		}
	}

	public void buttonBuilder(JButton button) {
		//sets button properties
		button.addMouseListener(this);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.DARK_GRAY);
		button.setBorderPainted(false);
		button.setFocusable(false);
	}

	public void panelHeight(JPanel panel,int width) {
		//calculates panel height
		int panelHeight = 0;
		Component[] components= panel.getComponents();
		for (Component component : components) {
			if (component.isVisible()) {
				panelHeight = panelHeight + component.getHeight();
			}
		}
		panel.setPreferredSize(new Dimension(width, panelHeight +100));
	}

	public void panelWidth(JPanel panel) {
		//calculates panel width
		int panelWidth = 0;
		components= panel.getComponents();
		for (Component component : components) {
			if (component.isVisible()) {
				panelWidth = panelWidth + component.getHeight();
			}
		}
		panel.setPreferredSize(new Dimension(panelWidth+200, 200));
	}

	public void labelBuilder(JLabel label) {
		//sets label properties
		label.setVisible(true);
		label.setForeground(Color.white);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		label.setPreferredSize(new Dimension(250,50));
	}

	public int rowCalc(String content, JPanel panel) {
		//calculates height of rows for textarea in dataPanel
		int rows;
		if (panel == dataPanel) {
			int count = 1;
			while (content.contains("\n")) {
				count++;
				content= content.substring(content.indexOf("\n")+1);
			}
			//rows*height+gap height
			rows = count*25+30;
		}

		//calculates height of rows for textarea in profilePanel
		else {
			//please check (content != null)
			//(length / space + puffer)* height of text
			rows = ((content.length()/27) +3)*23;
		}

		return rows;
	}

	public void textBuilder(JTextArea textArea, String content, JPanel panel) {
		//sets properties for textAreas of each panel
		textArea.setVisible(false);
		if (panel == profilePanel) {
			if (content != null) {
				textArea.setVisible(true);
				textArea.setPreferredSize(new Dimension(240, rowCalc(content, profilePanel)));
				panel.add(textArea);
			}
			textArea.setFont(new Font("Arial",Font.PLAIN,20));
		}

		if (panel == dataPanel) {
			if (content != null) {
				textArea.setVisible(true);
				textArea.setPreferredSize(new Dimension(150, rowCalc(content, dataPanel)));
				panel.add(textArea);
			}
			textArea.setFont(new Font("Arial",Font.PLAIN,18));
		}

		textArea.setText(content);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFocusable(false);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.white);
		textArea.setEditable(false);

		//Verhindern, dass caret springt
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
	}

	public void aquariumData() {
		//creates content for dataPanel
		dataPanel.add(aquariumHead);
		aquariumHead.setText("Aquarium Daten");
		aquariumHead.setFont(new Font("MV Boli",Font.PLAIN,25));
		aquariumHead.setLineWrap(true);
		aquariumHead.setWrapStyleWord(true);
		aquariumHead.setBackground(Color.DARK_GRAY);
		aquariumHead.setForeground(Color.white);
		aquariumHead.setPreferredSize(new Dimension(150,130));
		aquariumHead.setEditable(false);
		aquariumHead.setFocusable(false);

		textBuilder(lAquarium, "Liter: "+String.format("%1.0f",aquarium.getLiter()), dataPanel);
		textBuilder(wAquarium, "Länge: "+String.format("%1.2f",aquarium.getAWidth()), dataPanel);
		textBuilder(hAquarium, "Höhe: "+String.format("%1.2f",aquarium.getAHeight()), dataPanel);
		textBuilder(dAquarium, "Tiefe: "+String.format("%1.2f",aquarium.getADepth()), dataPanel);
		textBuilder(cAquarium, "C°: "+String.format("%1.0f",aquarium.getCMin())+"-"+String.format("%1.0f",aquarium.getCMax()), dataPanel);
		textBuilder(ghAquarium, "GH: "+String.format("%1.1f",aquarium.getGhMin())+"-"+String.format("%1.1f",aquarium.getGhMax()), dataPanel);
		textBuilder(khAquarium, "KH: "+String.format("%1.1f",aquarium.getKhMin())+"-"+String.format("%1.1f",aquarium.getKhMax()), dataPanel);
		textBuilder(phAquarium, "pH: "+String.format("%1.1f",aquarium.getPhMin())+"-"+String.format("%1.1f",aquarium.getPhMax()), dataPanel);
		textBuilder(filter, aquarium.getFilter().getType()+"\n"+ "Fördermenge: "+ String.format("%1.0f",aquarium.getFilter().getOutput()), dataPanel);
		textBuilder(heater, aquarium.getHeater().getType()+"\n"+ "Watt: "+ String.format("%1.0f",aquarium.getHeater().getWatt()), dataPanel);
		Double nanDouble = aquarium.getGround().getLiter();
		if (nanDouble.isNaN()) {
			textBuilder(ground, "Ground: "+aquarium.getGround().getType()+"\n"+
			"Höhe: "+ String.format("%1.0f",aquarium.getGround().getHeight())+"\n"+"Liter: "+ String.format("%1.0f",0.0), dataPanel);
		}
		else {
			textBuilder(ground, "Ground: "+aquarium.getGround().getType()+"\n"+
			"Höhe: "+ String.format("%1.0f",aquarium.getGround().getHeight())+"\n"+"Liter: "+ String.format("%1.0f",aquarium.getGround().getLiter()), dataPanel);
		}

	}

	public void profile(Resident resident) {
		//creates content for profilePanel
		if (resident instanceof FreshWaterResident) {
			FreshWaterResident resident2;
			resident2= (FreshWaterResident) resident;

			int rows2 = ((resident2.getName().length()/21) +2)*25;
			headText.setText(resident2.getName());
			headText.setFont(new Font("MV Boli",Font.PLAIN,25));
			headText.setLineWrap(true);
			headText.setWrapStyleWord(true);
			headText.setBackground(Color.DARK_GRAY);
			headText.setForeground(Color.white);
			headText.setPreferredSize(new Dimension(250,rows2));
			headText.setEditable(false);
			headText.setFocusable(false);
			DefaultCaret caret = (DefaultCaret) headText.getCaret();
			caret.setUpdatePolicy(Rectangle2D.OUT_TOP);

			head.setHorizontalAlignment(SwingConstants.CENTER);
			imageBuilder(resident2, head, 20);
			head.setVisible(true);
			head.setPreferredSize(new Dimension(250,250));
			profilePanel.add(headText);
			profilePanel.add(head);

			textBuilder(sName,resident2.getSName(),profilePanel);
			textBuilder(origin,resident2.getOrigin(),profilePanel);
			textBuilder(group,"Gruppe: "+resident2.getGroup(),profilePanel);
			textBuilder(liter,"Liter: min. "+String.format("%1.0f",resident2.getLiter()),profilePanel);
			textBuilder(c,"C°: "+String.format("%1.0f",resident2.getCMin())+"-"+String.format("%1.0f",resident2.getCMax()),profilePanel);

			if (resident2.getGhMax()!=0) {
				textBuilder(gh,"GH: "+String.format("%1.1f",resident2.getGhMin())+"-"+String.format("%1.1f",resident2.getGhMax()),profilePanel);
			}
			else {
				if (resident2.getGhMin()==0) {
					textBuilder(gh,"GH: "+String.format("%1.1f",resident2.getGhMin()),profilePanel);
				}

				if (resident2.getGhMin()!=0) {
					textBuilder(gh,"GH: "+String.format("%1.1f",resident2.getGhMin())+"+",profilePanel);
				}
			}

			if (resident2.getKhMax()!=0) {
				textBuilder(kh,"KH: "+String.format("%1.1f",resident2.getKhMin())+"-"+String.format("%1.1f",resident2.getKhMax()),profilePanel);
			}
			else {
				if (resident2.getKhMin()==0) {
					textBuilder(kh,"KH: "+String.format("%1.1f",resident2.getKhMin()),profilePanel);
				}

				if (resident2.getKhMin()!=0) {
					textBuilder(kh,"KH: "+String.format("%1.1f",resident2.getKhMin())+"+",profilePanel);
				}
			}

			if (resident2.getPhMax()!=0) {
				textBuilder(ph,"pH: "+String.format("%1.1f",resident2.getPhMin())+"-"+String.format("%1.1f",resident2.getPhMax()),profilePanel);
			}
			else {
				if (resident2.getKhMin()==0) {
					textBuilder(ph,"pH: "+String.format("%1.1f",resident2.getPhMin()),profilePanel);
				}

				if (resident2.getKhMin()!=0) {
					textBuilder(ph,"pH: "+String.format("%1.1f",resident2.getPhMin())+"+",profilePanel);
				}
			}

			textBuilder(width,"Beckenlänge: "+String.format("%1.2f",resident2.getAWidth()),profilePanel);
			textBuilder(height,"Beckenhöhe: "+String.format("%1.2f",resident2.getAHeight()),profilePanel);

			if (resident2.getARegion()==region.allOver) {
				textBuilder(textRegion,"Beckenregion: "+"überall",profilePanel);
			}

			if (resident2.getARegion()==region.top) {
				textBuilder(textRegion,"Beckenregion: "+"oben",profilePanel);
			}

			if (resident2.getARegion()==region.bottom) {
				textBuilder(textRegion,"Beckenregion: "+"unten",profilePanel);
			}

			if (resident2.getARegion()==region.middle) {
				textBuilder(textRegion,"Beckenregion: "+"mitte",profilePanel);
			}

			if (resident2.getGroupSMax()!=0) {
				textBuilder(groupSize,"Gruppengröße: "+ resident2.getGroupSMin()+"-"+resident2.getGroupSMax(),profilePanel);
			}
			else {
				if (resident2.getKhMin()==0) {
					textBuilder(groupSize,"Gruppengröße: "+ resident2.getGroupSMin(),profilePanel);
				}

				if (resident2.getKhMin()!=0) {
					textBuilder(groupSize,"Gruppengröße: "+ resident2.getGroupSMin()+"+",profilePanel);
				}
			}

			if (resident2.getSizeMax()!=0) {
				textBuilder(size,"Größe: "+String.format("%1.0f",resident2.getSizeMin())+"-"+String.format("%1.0f",resident2.getSizeMax())+" cm",profilePanel);
			}

			textBuilder(age,"Alter: "+resident2.getAge(),profilePanel);

			if (resident2.getDiet2()!= null) {
				textBuilder(textDiet,"Ernärung: "+resident2.getDiet()+", "+resident2.getDiet2(),profilePanel);
			}
			else {
				textBuilder(textDiet,"Ernärung: "+resident2.getDiet(),profilePanel);
			}

			if (resident2.getNature()== nature.aggressive) {
				textBuilder(textNature,"Wesen: "+"aggressiv",profilePanel);
			}

			if (resident2.getNature()== nature.neutral) {
				textBuilder(textNature,"Wesen: "+"neutral",profilePanel);
			}

			if (resident2.getNature()== nature.peaceful) {
				textBuilder(textNature,"Wesen: "+"friedlich",profilePanel);
			}

			if (resident2.getNature()== nature.sensitive) {
				textBuilder(textNature,"Wesen: "+"empfindlich",profilePanel);
			}

			if (resident2.getNature()== nature.shy) {
				textBuilder(textNature,"Wesen: "+"scheu",profilePanel);
			}

			if (resident2.getBehaviour()== behaviour.aktive) {
				textBuilder(textBehaviour,"Verhalten: "+"aktiv",profilePanel);
			}

			if (resident2.getBehaviour()== behaviour.calm) {
				textBuilder(textBehaviour,"Verhalten: "+"ruhig",profilePanel);
			}

			if (resident2.getBehaviour()== behaviour.normal) {
				textBuilder(textBehaviour,"Verhalten: "+"normal",profilePanel);
			}
			textBuilder(info, resident2.getInfo(),profilePanel);
		}
	}

	public Gui(Resident[] resident) {
		//setting window properties
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(1700,1000);
		this.setLayout(new BorderLayout(2,2));
		this.setLocationRelativeTo(null);

		globalResidents = resident;
		residentCount = resident.length;

		//menu
		menuBar = new JMenuBar();
		loadItem = new JMenuItem("pdf aufrufen");
		loadItem.addMouseListener(this);
		helpMenue = new JMenu("  Hilfe");

		helpMenue.setForeground(Color.lightGray);
		helpMenue.setFont(new Font("Arial",Font.PLAIN,20));
		helpMenue.add(loadItem);

		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.add(helpMenue);
		menuBar.setPreferredSize(new Dimension(0,40));

		//panels
		residentsPanel = new JPanel();
		rightPanel = new JPanel();
		profilePanel = new JPanel();
		viewPanel = new JPanel();
		selectPanel = new JPanel();
		dataPanel = new JPanel();
		topPanel = new JPanel();
		middlePanel = new JPanel();
		bottomPanel = new PaintPanel("ground");
		aquariumPanel = new PaintPanel("water");

		residentsPanel.setBackground(Color.darkGray);
		rightPanel.setBackground(Color.DARK_GRAY);
		profilePanel.setBackground(Color.DARK_GRAY);
		viewPanel.setBackground(Color.darkGray);
		selectPanel.setBackground(Color.LIGHT_GRAY);

		viewPanel.setPreferredSize(new Dimension(100, 100));
		dataPanel.setPreferredSize(new Dimension(200, 1000));
		topPanel.setPreferredSize(new Dimension(100, 300));
		middlePanel.setPreferredSize(new Dimension(100, 300));
		bottomPanel.setPreferredSize(new Dimension(100, 300));
		selectPanel.setPreferredSize(new Dimension(200, 50));
		residentsPanel.setPreferredSize(new Dimension(200, 200));


	//buildup
		//selection area
		rightPanel.setLayout(new FlowLayout());
		scrollSelect = new JScrollPane(rightPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			//selection drop down
			String[] residentGroup = {"Alle", "Buntbarsche", "Salmler", "Lebendgebärende Zahnkarpfen", "Welse", "Andere"};
			comboBox = new JComboBox(residentGroup);
			comboBox.setPreferredSize(new Dimension(170,20));
			comboBox.addItemListener(this);

			rightPanel.add(comboBox);

		//create buttons for selection area
		i=0;
		sButtons= new JButton[residentCount];
		for (Resident resident2 : resident) {
			sButtons[i]= new JButton();
			sButtons[i].setPreferredSize(new Dimension(200,200));
			imageBuilder(resident2, sButtons[i], 15);
			sButtons[i].setText(resident2.getName());
			buttonBuilder(sButtons[i]);
			rightPanel.add(sButtons[i]);
			i++;
		}
			//sets panel hight based on button count
			int hoehe = 207*sButtons.length;
			rightPanel.setPreferredSize(new Dimension(200, hoehe));

		//area of selected residents
		residentsPanel.setLayout(new GridBagLayout());
		scrollResidents = new JScrollPane(residentsPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollResidents.setBorder(border);

		//create buttons for selected residents
		i=0;
		rButtons= new JButton[residentCount];
		for (Resident resident2 : resident) {
			rButtons[i] = new JButton(resident2.getName());
			rButtons[i].setPreferredSize(new Dimension(200,200));
			imageBuilder(resident2, rButtons[i], 15);
			buttonBuilder(rButtons[i]);
			residentsPanel.add(rButtons[i]);
			rButtons[i].setVisible(false);
			i++;
		}

		//build view area
		viewPanel.setLayout(new BorderLayout());
		dataPanel.setLayout(new FlowLayout());
		topPanel.setLayout(new GridBagLayout());
		middlePanel.setLayout(new GridBagLayout());
		bottomPanel.setLayout(new GridBagLayout());

		dataPanel.setBorder(border);
		aquariumData();

		viewPanel.setBackground(Color.DARK_GRAY);
		aquariumPanel.setBackground(Color.DARK_GRAY);
		dataPanel.setBackground(Color.DARK_GRAY);
		topPanel.setBackground(Color.gray);
		topPanel.setOpaque(false);
		middlePanel.setOpaque(false);
		bottomPanel.setOpaque(false);

		viewPanel.add(dataPanel, BorderLayout.EAST);
		viewPanel.add(aquariumPanel, BorderLayout.CENTER);

		aquariumPanel.setLayout(new GridLayout(4,0));
		aquariumPanel.add(topPanel);
		aquariumPanel.add(middlePanel);
		aquariumPanel.add(bottomPanel);
		aquariumPanel.add(scrollResidents);

		//add resident labels to visual representation of an aquarium
		i=0;
		residentLabel = new JLabel[residentCount];
		for (Resident resident2 : globalResidents) {
			residentLabel[i]= new JLabel(resident2.getName()+" ");
			imageBuilder(resident2, residentLabel[i], 10);
			residentLabel[i].setForeground(Color.white);
			residentLabel[i].setVerticalTextPosition(SwingConstants.BOTTOM);
			residentLabel[i].setHorizontalTextPosition(SwingConstants.CENTER);
			residentLabel[i].setVisible(false);
			if (resident2.getARegion()==region.top) {
				topPanel.add(residentLabel[i]);
			}
			if (resident2.getARegion()==region.middle) {
				middlePanel.add(residentLabel[i]);
			}
			if (resident2.getARegion()==region.bottom) {
				bottomPanel.add(residentLabel[i]);
			}
			if (resident2.getARegion()==region.allOver) {
				middlePanel.add(residentLabel[i]);
				residentLabel[i].setText(resident2.getName()+" überall ");
			}
			i++;
		}

		//profile
		profilePanel.setLayout(new FlowLayout());
		scrollProfile = new JScrollPane(profilePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelHeight(profilePanel,300);

		//frame
		this.setTitle("CubicFish");
		this.setIconImage(logo.getImage());
		this.setJMenuBar(menuBar);
		this.add(scrollSelect,BorderLayout.EAST);
		this.add(scrollProfile,BorderLayout.WEST);
		this.add(viewPanel,BorderLayout.CENTER);
		this.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//selecting buttons
		i=0;
		for (JButton jButton : sButtons) {
			if (e.getSource()== jButton) {
				if (e.getClickCount() == 1 && !e.isConsumed()) {
					e.consume();
					//show resident profile and set new height
					profile(globalResidents[i]);
					panelHeight(profilePanel,300);
				}

				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					if(globalResidents[i].isCompatible()) {
					rButtons[i].setVisible(true);
					residentLabel[i].setVisible(true);
					//add resident to aquarium
					aquarium.addResident(globalResidents[i]);
					}
				 }
			}
			i++;
		}

		//resident buttons
		i=0;
		for (JButton jButton : rButtons) {
			if (e.getSource()== jButton) {
				if (e.getClickCount() == 1 && !e.isConsumed()) {
					e.consume();
					//show resident profile and set new height
					profile(globalResidents[i]);
					panelHeight(profilePanel,300);
				}

				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					jButton.setVisible(false);
					residentLabel[i].setVisible(false);
					sButtons[i].setEnabled(true);
					//remove resident
					aquarium.removeResident(globalResidents[i]);
				}
			}
			i++;
		}

		//see if it's dummy data and check if residents are still compatible
		i=0;
		if (!aquarium.isDummys()) {
			//change button background if not compatible
			for (Resident resident :globalResidents) {
				resident.check(aquarium);
				if (!resident.isCompatible()) {
					sButtons[i].setBackground(new Color(120,120,120));
				}

				if (resident.isCompatible()) {
					sButtons[i].setBackground(Color.DARK_GRAY);
				}
				i++;
			}
		}

		//reset if it's dummy data
		else {
			for (Resident resident :globalResidents) {
				//auf vgb true zurücksetzen
				resident.check(aquarium);
				sButtons[i].setBackground(Color.DARK_GRAY);
				i++;
			}

		}
		//show new data and change width of residentPanel
		aquariumData();
		panelWidth(residentsPanel);

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource()== loadItem) {
			if(Desktop.isDesktopSupported()) {
				   Desktop desk = Desktop.getDesktop();

				   //opens PDF-file
				   try {
					desk.open(new File("Anleitung.pdf"));
				   }
				   catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				   }
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		//extra method for combobox selections
		i=0;
		if (e.getSource()== comboBox) {
			int y=comboBox.getSelectedIndex();
			for (JButton jButton : sButtons) {
				comboboxSort(jButton, y);
				i++;
			}
			panelHeight(rightPanel,200);
		}
	}
}
