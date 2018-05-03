package diary;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Position;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;
import org.jdesktop.swingx.JXDatePicker;

public class Main extends JFrame {
	FontEditor fe = new FontEditor();
	JButton but;
	JTextField fam;
	JTextField sty;
	JSpinner size;
	boolean fs;
	Date date = new Date();
	int year = this.date.getYear() - 100;
	int month = this.date.getMonth() + 1;
	int dat = this.date.getDate();
	int dayOfWeek = this.date.getDay();
	int hour = this.date.getHours();
	public static String path = System.getProperty("user.home") + "/Documents/Diary";
	public String filename1 = this.dat + "-" + this.month + "-" + this.year + ".diary";
	public String filename2;
	public static String foldername;
	public String filename = "outputTemp.rtf";
	File x;
	File xx;
	File a = new File(path);
	String themeColor;
	int height;
	int width;
	double dWidth;
	double dHeight;
	ImageIcon newIcon;
	Image img;
	private JComboBox<String> cColor;
	private JXDatePicker dp1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JLabel jLabel1;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenu jMenu3;
	private JMenu jMenu4;
	private JMenu jMenu5;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem8;
	private JMenuItem jMenuItem9;
	private JScrollPane jScrollPane2;
	private JLabel labelGreeting;
	private JLabel labelStatus;
	private JTextPane ta1;

	void colorChanger(String a) {
		switch (a) {
		case "Black":
			getContentPane().setBackground(Color.BLACK);
			this.jLabel1.setBackground(Color.BLACK);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Blue":
			getContentPane().setBackground(Color.BLUE);
			this.jLabel1.setBackground(Color.BLUE);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Cyan":
			getContentPane().setBackground(Color.CYAN);
			this.jLabel1.setBackground(Color.CYAN);
			this.labelGreeting.setForeground(Color.black);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Dark Gray":
			getContentPane().setBackground(Color.DARK_GRAY);
			this.jLabel1.setBackground(Color.DARK_GRAY);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Gray":
			getContentPane().setBackground(Color.GRAY);
			this.jLabel1.setBackground(Color.GRAY);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Green":
			getContentPane().setBackground(Color.GREEN);
			this.jLabel1.setBackground(Color.GREEN);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Light Gray":
			getContentPane().setBackground(Color.LIGHT_GRAY);
			this.jLabel1.setBackground(Color.LIGHT_GRAY);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Magenta":
			getContentPane().setBackground(Color.MAGENTA);
			this.jLabel1.setBackground(Color.MAGENTA);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Orange":
			getContentPane().setBackground(Color.ORANGE);
			this.jLabel1.setBackground(Color.ORANGE);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Pink":
			getContentPane().setBackground(Color.PINK);
			this.jLabel1.setBackground(Color.PINK);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "Red":
			getContentPane().setBackground(Color.RED);
			this.jLabel1.setBackground(Color.RED);
			this.labelGreeting.setForeground(Color.white);
			this.jLabel1.setForeground(Color.white);
			break;
		case "White":
			getContentPane().setBackground(Color.WHITE);
			this.jLabel1.setBackground(Color.WHITE);
			this.labelGreeting.setForeground(Color.black);
			this.jLabel1.setForeground(Color.black);
			break;
		case "Yellow":
			getContentPane().setBackground(Color.YELLOW);
			this.jLabel1.setBackground(Color.YELLOW);
			this.labelGreeting.setForeground(Color.black);
			this.jLabel1.setForeground(Color.black);
		}
	}

	public Main() {
		initComponents();

		this.filename2 = (this.dat + "-" + this.month + "-" + this.year + ".diarydata");
		foldername = this.dat + "-" + this.month + "-" + this.year;
		this.x = new File(path + "/" + foldername + "/" + this.filename2);
		this.xx = new File(path + "/" + foldername);
		try {
			FileInputStream fis1 = new FileInputStream(path + "/" + "theme.data");
			FileOutputStream fos1 = new FileOutputStream(path + "/" + "theme1.txt");
			decrypt("SteveMann", fis1, fos1);
			fis1.close();
			fos1.close();
		} catch (FileNotFoundException localFileNotFoundException1) {
		} catch (Throwable localThrowable) {
		}
		try {
			FileInputStream fis1 = new FileInputStream(path + "/" + "theme1.txt");
			FileOutputStream fos1 = new FileOutputStream(path + "/" + "theme2.txt");
			decrypt("SteveMann", fis1, fos1);
			fis1.close();
			fos1.close();
		} catch (FileNotFoundException localFileNotFoundException2) {
		} catch (Throwable localThrowable1) {
		}
		try {
			FileInputStream fis1 = new FileInputStream(path + "/" + "theme2.txt");
			FileOutputStream fos1 = new FileOutputStream(path + "/" + "theme.txt");
			decrypt("SteveMann", fis1, fos1);
			fis1.close();
			fos1.close();
		} catch (FileNotFoundException e) {
			if (this.fs) {
			}
		} catch (Throwable localThrowable2) {
		}
		try {
			Scanner scan = new Scanner(new FileReader(path + "/" + "theme.txt"));
			while (scan.hasNext()) {
				this.themeColor = scan.nextLine();
			}
			scan.close();
		} catch (FileNotFoundException localFileNotFoundException3) {
		}
		new File(path + "/" + "theme.txt").delete();
		new File(path + "/" + "theme1.txt").delete();
		new File(path + "/" + "theme2.txt").delete();

		this.cColor.setSelectedItem(this.themeColor);
		colorChanger(this.themeColor);
		if ((this.hour >= 0) && (this.hour < 12)) {
			this.labelGreeting.setText("Good Morning, " + Diary.userName);
		} else if ((this.hour >= 12) && (this.hour < 16)) {
			this.labelGreeting.setText("Good Afternoon, " + Diary.userName);
		} else if ((this.hour >= 16) && (this.hour < 23)) {
			this.labelGreeting.setText("Good Evening, " + Diary.userName);
		} else {
			this.labelGreeting.setText(Diary.userName);
		}
		this.labelStatus.setText("");
		this.fs = true;

		this.ta1.setEditorKit(new HTMLEditorKit());
		this.ta1.setContentType("text/richtext");

		this.but = this.fe.getButton();
		this.fam = this.fe.getFamily();
		this.sty = this.fe.getStyle();
		this.size = this.fe.getSpSize();

		this.but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = Main.this.ta1.getSelectedText();

				int cursorPosition = Main.this.ta1.getCaretPosition();
				String family = Main.this.fam.getText();
				String sstyle = Main.this.sty.getText();
				String siz = Main.this.size.getValue().toString();

				StyleContext context = new StyleContext();

				Style style = context.addStyle("Style", null);

				style.addAttribute(StyleConstants.FontFamily, family);
				switch (sstyle) {
				case "Regular":
					style.addAttribute(StyleConstants.Bold, Boolean.valueOf(false));
					style.addAttribute(StyleConstants.Italic, Boolean.valueOf(false));
					break;
				case "Bold":
					style.addAttribute(StyleConstants.Bold, Boolean.valueOf(true));
					break;
				case "Italic":
					style.addAttribute(StyleConstants.Italic, Boolean.valueOf(true));
					break;
				case "Bold Italic":
					style.addAttribute(StyleConstants.Bold, Boolean.valueOf(true));
					style.addAttribute(StyleConstants.Italic, Boolean.valueOf(true));
				}
				style.addAttribute(StyleConstants.FontSize, Integer.valueOf(Integer.parseInt(siz)));

				Main.this.ta1.setCharacterAttributes(style, true);

				Main.this.fe.setVisible(false);
				Main.this.getFocusTA();
			}
		});
		tripleDecrypt();

		this.ta1.setText("");
		readFile();
	}

	void tripleEncrypt() {
		try {
			FileInputStream fis = new FileInputStream(path + "/" + this.filename);
			FileOutputStream fos = new FileOutputStream(path + "/" + "en1.rtf");
			encrypt(Diary.userKey, fis, fos);
			fis.close();
			fos.close();
		} catch (Throwable localThrowable1) {
		}
		try {
			FileInputStream fis = new FileInputStream(path + "/" + "en1.rtf");
			FileOutputStream fos = new FileOutputStream(path + "/" + "en2.rtf");
			encrypt(Diary.userKey, fis, fos);
			fis.close();
			fos.close();
		} catch (Throwable localThrowable2) {
		}
		try {
			FileInputStream fis = new FileInputStream(path + "/" + "en2.rtf");
			FileOutputStream fos = new FileOutputStream(path + "/" + this.filename1);
			encrypt(Diary.userKey, fis, fos);
			fis.close();
			fos.close();

			this.labelStatus.setText("Saved.");
			new JLabelCleaner(5, this.labelStatus).startCountdownFromNow();
		} catch (Throwable e) {
			this.labelStatus.setText("Error.");
			new JLabelCleaner(5, this.labelStatus).startCountdownFromNow();
		}
		new File(path + "/" + this.filename).delete();
		new File(path + "/" + "en2.rtf").delete();
		new File(path + "/" + "en1.rtf").delete();
	}

	void tripleDecrypt() {
		Date inputdate = new Date();
		inputdate = this.dp1.getDate();

		Calendar instance = Calendar.getInstance();
		int year1 = inputdate.getYear() - 100;
		int dat1 = inputdate.getDate();
		int month1 = inputdate.getMonth() + 1;

		String inputfilename = dat1 + "-" + month1 + "-" + year1 + ".diary";
		try {
			FileInputStream fis1 = new FileInputStream(path + "/" + inputfilename);
			FileOutputStream fos1 = new FileOutputStream(path + "/" + "iTemp1.rtf");
			decrypt(Diary.userKey, fis1, fos1);
			fis1.close();
			fos1.close();
		} catch (FileNotFoundException localFileNotFoundException1) {
		} catch (Throwable localThrowable1) {
		}
		try {
			FileInputStream fis1 = new FileInputStream(path + "/" + "iTemp1.rtf");
			FileOutputStream fos1 = new FileOutputStream(path + "/" + "iTemp2.rtf");
			decrypt(Diary.userKey, fis1, fos1);
			fis1.close();
			fos1.close();
			this.labelStatus.setText("Opened Successfully.");
			new JLabelCleaner(5, this.labelStatus).startCountdownFromNow();
		} catch (FileNotFoundException localFileNotFoundException2) {
		} catch (Throwable localThrowable2) {
		}
		try {
			FileInputStream fis1 = new FileInputStream(path + "/" + "iTemp2.rtf");
			FileOutputStream fos1 = new FileOutputStream(path + "/" + "iTemp.rtf");
			decrypt(Diary.userKey, fis1, fos1);
			fis1.close();
			fos1.close();
			this.labelStatus.setText("Opened Successfully.");
			new JLabelCleaner(5, this.labelStatus).startCountdownFromNow();
		} catch (FileNotFoundException e) {
			if (!this.fs) {
				this.labelStatus.setText("Error: File Not Found");
				new JLabelCleaner(5, this.labelStatus).startCountdownFromNow();
			}
		} catch (Throwable e) {
			this.labelStatus.setText("Read Error.");
			new JLabelCleaner(5, this.labelStatus).startCountdownFromNow();
		}
	}

	void getFocusTA() {
		this.ta1.requestFocus();
	}

	public void readFile() {
		RTFEditorKit rtf = new RTFEditorKit();

		this.ta1.setEditorKit(rtf);
		try {
			InputStream in = new FileInputStream(path + "/" + "iTemp.rtf");

			StyledDocument dd = new DefaultStyledDocument();
			rtf.read(in, dd, 0);
			this.ta1.setDocument(dd);
			in.close();
		} catch (FileNotFoundException localFileNotFoundException) {
		} catch (IOException localIOException) {
		} catch (BadLocationException localBadLocationException) {
		}
		new File(path + "/" + "iTemp.rtf").delete();
		new File(path + "/" + "iTemp1.rtf").delete();
		new File(path + "/" + "iTemp2.rtf").delete();
	}

	public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, 1, is, os);
	}

	public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, 2, is, os);
	}

	public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		if (mode == 1) {
			cipher.init(1, desKey);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == 2) {
			cipher.init(2, desKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}
	}

	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}

	private void initComponents() {
		this.jMenu4 = new JMenu();
		this.jButton2 = new JButton();
		this.jButton3 = new JButton();
		this.jButton4 = new JButton();
		this.dp1 = new JXDatePicker();
		this.jLabel1 = new JLabel();
		this.jButton1 = new JButton();
		this.jScrollPane2 = new JScrollPane();
		this.ta1 = new JTextPane();
		this.labelStatus = new JLabel();
		this.labelGreeting = new JLabel();
		this.cColor = new JComboBox();
		this.jButton5 = new JButton();
		this.jMenuBar1 = new JMenuBar();
		this.jMenu1 = new JMenu();
		this.jMenuItem1 = new JMenuItem();
		this.jMenuItem8 = new JMenuItem();
		this.jMenuItem2 = new JMenuItem();
		this.jMenu2 = new JMenu();
		this.jMenuItem6 = new JMenuItem();
		this.jMenu3 = new JMenu();
		this.jMenuItem3 = new JMenuItem();
		this.jMenu5 = new JMenu();
		this.jMenuItem5 = new JMenuItem();
		this.jMenuItem4 = new JMenuItem();
		this.jMenuItem9 = new JMenuItem();
		this.jMenuItem7 = new JMenuItem();

		this.jMenu4.setText("jMenu4");

		setDefaultCloseOperation(3);
		setTitle("Diary©");
		setBackground(new Color(255, 0, 15));
		setResizable(false);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				Main.this.formMouseClicked(evt);
			}
		});
		this.jButton2.setText("Save");
		this.jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jButton2ActionPerformed(evt);
			}
		});
		this.jButton3.setText("Exit");
		this.jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jButton3ActionPerformed(evt);
			}
		});
		this.jButton4.setText("LogOut");
		this.jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jButton4ActionPerformed(evt);
			}
		});
		this.dp1.setDate(this.date);
		this.dp1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Main.this.dp1PropertyChange(evt);
			}
		});
		this.jLabel1.setBackground(new Color(255, 0, 0));
		this.jLabel1.setFont(new Font("Showcard Gothic", 1, 48));
		this.jLabel1.setForeground(new Color(255, 255, 255));
		this.jLabel1.setHorizontalAlignment(0);
		this.jLabel1.setText("Diary");
		this.jLabel1.setOpaque(true);

		this.jButton1.setText("About");
		this.jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jButton1ActionPerformed(evt);
			}
		});
		this.jScrollPane2.setViewportView(this.ta1);

		this.labelStatus.setText("jLabel2");

		this.labelGreeting.setText("jLabel2");

		this.cColor.setModel(new DefaultComboBoxModel(new String[] { "Black", "Blue", "Cyan", "Dark Gray", "Gray",
				"Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" }));
		this.cColor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				Main.this.cColorItemStateChanged(evt);
			}
		});
		this.jButton5.setText("Image of the Day");
		this.jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jButton5ActionPerformed(evt);
			}
		});
		this.jMenu1.setText("File");

		this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(83, 2));
		this.jMenuItem1.setText("Save");
		this.jMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem1ActionPerformed(evt);
			}
		});
		this.jMenu1.add(this.jMenuItem1);

		this.jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(76, 2));
		this.jMenuItem8.setText("Log Out");
		this.jMenuItem8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem8ActionPerformed(evt);
			}
		});
		this.jMenu1.add(this.jMenuItem8);

		this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(69, 2));
		this.jMenuItem2.setText("Exit");
		this.jMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem2ActionPerformed(evt);
			}
		});
		this.jMenu1.add(this.jMenuItem2);

		this.jMenuBar1.add(this.jMenu1);

		this.jMenu2.setText("Edit");

		this.jMenuItem6.setAccelerator(KeyStroke.getKeyStroke(70, 2));
		this.jMenuItem6.setText("Format");
		this.jMenuItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem6ActionPerformed(evt);
			}
		});
		this.jMenu2.add(this.jMenuItem6);

		this.jMenuBar1.add(this.jMenu2);

		this.jMenu3.setText("Options");

		this.jMenuItem3.setText("Change Password");
		this.jMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem3ActionPerformed(evt);
			}
		});
		this.jMenu3.add(this.jMenuItem3);

		this.jMenuBar1.add(this.jMenu3);

		this.jMenu5.setText("Help");

		this.jMenuItem5.setText("ChangeLog");
		this.jMenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem5ActionPerformed(evt);
			}
		});
		this.jMenu5.add(this.jMenuItem5);

		this.jMenuItem4.setText("Contributors");
		this.jMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem4ActionPerformed(evt);
			}
		});
		this.jMenu5.add(this.jMenuItem4);

		this.jMenuItem9.setText("Contact");
		this.jMenuItem9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem9ActionPerformed(evt);
			}
		});
		this.jMenu5.add(this.jMenuItem9);

		this.jMenuItem7.setText("About");
		this.jMenuItem7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.this.jMenuItem7ActionPerformed(evt);
			}
		});
		this.jMenu5.add(this.jMenuItem7);

		this.jMenuBar1.add(this.jMenu5);

		setJMenuBar(this.jMenuBar1);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.jLabel1, -1, -1, 32767)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.cColor, -2, -1, -2)
						.addGap(40, 40, 40).addComponent(this.labelStatus)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton5)
						.addContainerGap())
				.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane2).addContainerGap())
						.addGroup(layout.createSequentialGroup().addComponent(this.jButton4)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, 32767)
								.addComponent(this.dp1, -2, -1, -2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3)
								.addGap(7, 7, 7))))
				.addGroup(layout.createSequentialGroup().addGap(162, 162, 162).addComponent(this.labelGreeting)
						.addContainerGap(-1, 32767)));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addComponent(this.jLabel1)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.labelGreeting)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 273, -2)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.labelStatus)
						.addComponent(this.cColor, -2, -1, -2).addComponent(this.jButton5))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2)
								.addComponent(this.jButton4).addComponent(this.dp1, -2, -1, -2)
								.addComponent(this.jButton1))
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(this.jButton3).addContainerGap()))));

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		if (!this.a.exists()) {
			this.a.mkdirs();
		}
		StyledDocument docc = this.ta1.getStyledDocument();
		RTFEditorKit kitt = new RTFEditorKit();
		try {
			BufferedOutputStream outt = new BufferedOutputStream(new FileOutputStream(path + "/" + this.filename));

			kitt.write(outt, docc, docc.getStartPosition().getOffset(), docc.getLength());
			outt.flush();
			outt.close();
		} catch (FileNotFoundException localFileNotFoundException) {
		} catch (IOException localIOException) {
		} catch (BadLocationException localBadLocationException) {
		}
		tripleEncrypt();
	}

	private void dp1PropertyChange(PropertyChangeEvent evt) {
		this.fs = false;
		tripleDecrypt();

		this.ta1.setText("");
		readFile();
		new File(path + "/iTemp.rtf").delete();
		new File(path + "/iTemp1.rtf").delete();
		new File(path + "/iTemp2.rtf").delete();

		Date inputdate = new Date();
		inputdate = this.dp1.getDate();

		Calendar instance = Calendar.getInstance();
		int year1 = inputdate.getYear() - 100;
		int dat1 = inputdate.getDate();
		int month1 = inputdate.getMonth() + 1;

		this.filename2 = (dat1 + "-" + month1 + "-" + year1 + ".diarydata");
		foldername = dat1 + "-" + month1 + "-" + year1;
		this.x = new File(path + "/" + foldername + "/" + this.filename2);
		this.xx = new File(path + "/" + foldername);
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path + "/" + "theme.txt"));

			out.write(this.themeColor);

			out.close();
		} catch (Exception localException) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "theme.txt");
			FileOutputStream fos = new FileOutputStream(path + "/" + "theme1.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "theme1.data");
			FileOutputStream fos = new FileOutputStream(path + "/" + "theme2.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable1) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "theme2.data");
			FileOutputStream fos = new FileOutputStream(path + "/" + "theme.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable2) {
		}
		new File(path + "/" + "theme.txt").delete();
		new File(path + "/" + "theme1.data").delete();
		new File(path + "/" + "theme2.data").delete();

		System.exit(0);
	}

	private void jButton4ActionPerformed(ActionEvent evt) {
		Login login = new Login();
		login.setVisible(true);
		setVisible(false);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this,
				"Diary© Version 3.0\n\nCopyright© 2015-2016 Steve Mann\n\nDiary is free software: you can redistribute it and/or modify\nit under the terms of the GNU General Public License as published by\nthe Free Software Foundation, either version 3 of the License, or\nat your option) any later version.\n\nDiary is distributed in the hope that it will be useful,\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\nGNU General Public License for more details.\n\nYou should have received a copy of the GNU General Public License\nalong with this program.  If not, see <http://www.gnu.org/licenses/>.");
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {
		if (!this.a.exists()) {
			this.a.mkdirs();
		}
		StyledDocument docc = this.ta1.getStyledDocument();
		RTFEditorKit kitt = new RTFEditorKit();
		try {
			BufferedOutputStream outt = new BufferedOutputStream(new FileOutputStream(path + "/" + this.filename));

			kitt.write(outt, docc, docc.getStartPosition().getOffset(), docc.getLength());
			outt.flush();
			outt.close();
		} catch (FileNotFoundException localFileNotFoundException) {
		} catch (IOException localIOException) {
		} catch (BadLocationException localBadLocationException) {
		}
		tripleEncrypt();
	}

	private void jMenuItem3ActionPerformed(ActionEvent evt) {
		ChangePassword cp = new ChangePassword();
		cp.setVisible(true);
		cp.setDefaultCloseOperation(2);
	}

	private void jMenuItem6ActionPerformed(ActionEvent evt) {
		this.fe.setVisible(true);
		this.fe.setDefaultCloseOperation(2);
	}

	private void jMenuItem7ActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this,
				"Diary© Version 4.0\n\nCopyright© 2015-2016 Steve Mann\n\nDiary is free software: you can redistribute it and/or modify\nit under the terms of the GNU General Public License as published by\nthe Free Software Foundation, either version 3 of the License, or\nat your option) any later version.\n\nDiary is distributed in the hope that it will be useful,\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\nGNU General Public License for more details.\n\nYou should have received a copy of the GNU General Public License\nalong with this program.  If not, see <http://www.gnu.org/licenses/>.");
	}

	private void jMenuItem4ActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this,
				"This program is made by Steve Mann.\nAlthough, it was the help of some good friends that made this Diary© a reality.\nTheir ideas helped me to make this more user-friendly and their help motivated me to keep working.\n\nSome of the names are:\n1.Vaishali Dahiya\n2.Mukul Sehrawat\n3.Mohammad Talha Ansari\n4.Garima Bangar\n5.Antara Sharma\n\nThank You all and please don't mind if I missed your name. Just tell me that I missed it.\nAnd....\nKeep Helping.");
	}

	private void jMenuItem5ActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this,
				"ChangeLog for Diary© version 4.0 is:\n1.Image of the day to keep visual memories safe and encypted.\n2.Theme Changer.\n3.Better look and feel.\n4.Gets previously selected theme at startup.\n5.Performance and bug fixes.\n\nChangeLog for Diary© version 3.0 is:\n1.Updated Core code.\n2.New Triple-DES Encryption Mechanism\n3.Status Label.\n4.Time-Wise Greetings on login.\n5.Performance Moderations.\n6.Bug Fixes.\n\nChangeLog for Diary© version 2.0 is:\n1.New Menus.\n2.Text Formatting options included.\n3.About, Contributors and ChangeLog dialogs included.\n4.Optimised for complete cross-platform use.\n5.Option to change password.\n6.Copyright and GNU GPL v3 License for Distribution.\n7.Shortcuts to save, exit and format.\n8.New Format Options with core Microsoft Fonts\n9.Performance Fixes.\n10.Better DES Encryption Mechanism.");
	}

	private void jMenuItem8ActionPerformed(ActionEvent evt) {
		Login login = new Login();
		login.setVisible(true);
		setVisible(false);
	}

	private void formMouseClicked(MouseEvent evt) {
		requestFocus();
	}

	private void jMenuItem2ActionPerformed(ActionEvent evt) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path + "/" + "theme.txt"));

			out.write(this.themeColor);

			out.close();
		} catch (Exception localException) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "theme.txt");
			FileOutputStream fos = new FileOutputStream(path + "/" + "theme1.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "theme1.data");
			FileOutputStream fos = new FileOutputStream(path + "/" + "theme2.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable1) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "theme2.data");
			FileOutputStream fos = new FileOutputStream(path + "/" + "theme.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable2) {
		}
		new File(path + "/" + "theme.txt").delete();
		new File(path + "/" + "theme1.data").delete();
		new File(path + "/" + "theme2.data").delete();

		System.exit(0);
	}

	private void jMenuItem9ActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this,
				"You can contact the developer directly by mailing at:\nstevemann2705@gmail.com\n\nTwitter: @stevemann2705\n               @mackmannblog\n\nFollow, Like, Share.");
	}

	private void cColorItemStateChanged(ItemEvent evt) {
		try {
			this.themeColor = this.cColor.getSelectedItem().toString();
		} catch (NullPointerException e) {
			this.themeColor = "Red";
		}
		try {
			colorChanger(this.cColor.getSelectedItem().toString());
		} catch (NullPointerException e) {
			colorChanger("Red");
		}
	}

	private void jButton5ActionPerformed(ActionEvent evt) {
		if (!this.x.exists()) {
			int option = JOptionPane.showConfirmDialog(this, "No Image found. Do you want to add image now?");
			if (option == 0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));

				chooser.setFileFilter(new FileFilter() {
					public boolean accept(File f) {
						return (f.getName().toLowerCase().endsWith(".jpg")) || (f.isDirectory());
					}

					public String getDescription() {
						return "JPG Images";
					}
				});
				int r = chooser.showOpenDialog(this);
				if (r == 0) {
					this.xx.mkdirs();
					String imagePath = chooser.getSelectedFile().getAbsolutePath();

					FileEncryption fe = new FileEncryption();
					fe.encrypt(imagePath, path + "/" + foldername + "/" + this.filename2);
					JOptionPane.showMessageDialog(this, "Image Encrypted Successfully.");
					this.labelStatus.setText("Image Encrypted");
					new JLabelCleaner(5, this.labelStatus).startCountdownFromNow();
				}
			}
		} else {
			FileEncryption e = new FileEncryption();

			e.decrypt(path + "/" + foldername + "/" + this.filename2, path + "/" + foldername + "/imageTemp.jpg");

			ImageIcon ii = new ImageIcon(path + "/" + foldername + "/imageTemp.jpg");
			this.img = ii.getImage();

			this.height = this.img.getHeight(ii.getImageObserver());
			this.width = this.img.getWidth(ii.getImageObserver());

			double max = 600.0D;

			this.dWidth = 0.0D;
			this.dHeight = 0.0D;
			if (this.width == this.height) {
				this.dWidth = max;
				this.dHeight = max;
			} else if (this.width > this.height) {
				this.dWidth = max;
				this.dHeight = (this.height / this.width * max);
			} else {
				this.dHeight = max;
				this.dWidth = (this.width / this.height * max);
			}
			Image newimg = this.img.getScaledInstance((int) this.dWidth, (int) this.dHeight, 4);
			this.newIcon = new ImageIcon(newimg);

			ImageViewer imageViewer = new ImageViewer();
			imageViewer.setVisible(true);
			imageViewer.setIcon(this.newIcon);

			new File(path + "/" + foldername + "/imageTemp.jpg").delete();
		}
	}

	public double getH() {
		return this.dHeight;
	}

	public double getW() {
		return this.dWidth;
	}

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
