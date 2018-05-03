package diary;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Setup extends JFrame {
	String pass;
	String key;
	String name;

	public Setup() {
		initComponents();
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
		this.jLabel1 = new JLabel();
		this.jLabel2 = new JLabel();
		this.tfPass = new JTextField();
		this.tfKey = new JTextField();
		this.jButton1 = new JButton();
		this.jLabel3 = new JLabel();
		this.jLabel4 = new JLabel();
		this.jLabel5 = new JLabel();
		this.jLabel6 = new JLabel();
		this.jLabel7 = new JLabel();
		this.jLabel8 = new JLabel();
		this.jLabel9 = new JLabel();
		this.tfName = new JTextField();

		setDefaultCloseOperation(3);
		setTitle("Setting Up");
		setResizable(false);

		this.jLabel1.setText("Password:");

		this.jLabel2.setText("Key:");

		this.tfKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Setup.this.tfKeyActionPerformed(evt);
			}
		});
		this.jButton1.setText("Save");
		this.jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Setup.this.jButton1ActionPerformed(evt);
			}
		});
		this.jLabel3.setBackground(new Color(255, 0, 0));
		this.jLabel3.setFont(new Font("Showcard Gothic", 1, 48));
		this.jLabel3.setForeground(new Color(255, 255, 255));
		this.jLabel3.setHorizontalAlignment(0);
		this.jLabel3.setText("Diary");
		this.jLabel3.setOpaque(true);

		this.jLabel4.setText("Thank You for choosing Diary© by Steve Mann.");

		this.jLabel5
				.setText("This is the first use by this user on this PC. Therefore, we need to set up a few things");

		this.jLabel6.setText("You need to enter the password that you will be using to login.");

		this.jLabel7.setText("Next, you need to enter the key. This key will be used for encryption purposes.");

		this.jLabel8
				.setText("If you have the log files of the diary, then make sure you enter the same key used there");

		this.jLabel9.setText("Please Enter your Name:");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.jLabel3, -1, -1, 32767)
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(138, 138, 138).addComponent(this.jLabel4))
						.addGroup(layout.createSequentialGroup().addGap(93, 93, 93).addComponent(this.jLabel9)
								.addGap(31, 31, 31).addComponent(this.tfName, -2, 145, -2))
						.addGroup(layout.createSequentialGroup().addGap(79, 79, 79).addComponent(this.jLabel6)))
						.addGap(0, 0, 32767))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jButton1).addGap(45,
								45, 45))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, 32767)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(147, 147, 147)
														.addComponent(this.jLabel1).addGap(37, 37, 37)
														.addComponent(this.tfPass, -2, 145, -2).addContainerGap())
												.addGroup(GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup().addComponent(this.jLabel2)
																.addGap(45, 45, 45)
																.addComponent(this.tfKey, -2, 145, -2).addGap(6, 6, 6)))
										.addGroup(layout.createSequentialGroup().addComponent(this.jLabel7).addGap(56,
												56, 56))))
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jLabel5, -1, 612, 32767).addGroup(
										layout.createSequentialGroup().addComponent(this.jLabel8).addGap(0, 0, 32767)))
						.addContainerGap()));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addComponent(this.jLabel3, -2, 86, -2)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel4)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5, -2, 14, -2)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9)
						.addComponent(this.tfName, -2, -1, -2))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel6).addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(this.tfPass, -2, -1, -2).addComponent(this.jLabel1))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel7)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel8).addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(this.tfKey, -2, -1, -2).addComponent(this.jLabel2))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1)
				.addContainerGap(22, 32767)));

		pack();
		setLocationRelativeTo(null);
	}

	static String path = System.getProperty("user.home") + "/Documents/Diary";
	static File a = new File(path + "/" + "settings.data");
	static File aa = new File(path);
	private JButton jButton1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JTextField tfKey;
	private JTextField tfName;
	private JTextField tfPass;

	private void jButton1ActionPerformed(ActionEvent evt) {
		if (!a.exists()) {
			aa.mkdirs();
		}
		this.pass = this.tfPass.getText();
		this.key = this.tfKey.getText();
		this.name = this.tfName.getText();
		if (this.key.length() < 8) {
			JOptionPane.showMessageDialog(null, "The key must be at least 8 charachters long.\nPlease try again.");
			return;
		}
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path + "/" + "settingsTemp.rtf"));

			out.write(this.pass);
			out.newLine();
			out.append(this.key);
			out.newLine();
			out.append(this.name);
			out.close();
		} catch (Exception localException) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "settingsTemp.rtf");
			FileOutputStream fos = new FileOutputStream(path + "/" + "settings1.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "settings1.data");
			FileOutputStream fos = new FileOutputStream(path + "/" + "settings2.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable1) {
		}
		try {
			String key = "SteveMann";

			FileInputStream fis = new FileInputStream(path + "/" + "settings2.data");
			FileOutputStream fos = new FileOutputStream(path + "/" + "settings.data");
			encrypt(key, fis, fos);
		} catch (Throwable localThrowable2) {
		}
		new File(path + "/" + "settingsTemp.rtf").delete();
		new File(path + "/" + "settings1.data").delete();
		new File(path + "/" + "settings2.data").delete();
		JOptionPane.showMessageDialog(null,
				"The settings are saved for you in Documents/Diary/setting.data\nPlease note down the password. You can change it later by going to Options->Change Password\nPassword: "
						+ this.pass);

		JOptionPane.showMessageDialog(null,
				"For security reasons, we need to restart the app. This is a natural process. Just start the app again.\nThank You for using Personal Diary. (made by Steve Mann)");
		System.exit(0);
	}

	private void tfKeyActionPerformed(ActionEvent evt) {
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
			Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Setup().setVisible(true);
			}
		});
	}
}
