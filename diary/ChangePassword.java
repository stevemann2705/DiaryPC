package diary;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

// To the people who are excited to have found this code, and are willing to work on this,
// I already feel sorry for you. You have no idea what you're getting yourself into. Consider this a warning.

public class ChangePassword extends JFrame {
	String pass;
	String key;
	String name;
	private JButton btnCheck;
	private JButton btnChangePassword;
	private JLabel labelOldPassword;
	private JLabel labelTitle;
	private JLabel labelNewPassword;
	private JLabel labelConfirmPassword;
	private JPasswordField tfOldPassword;
	private JTextField tfNewPassword;
	private JTextField tfConfirmPassword;

	public ChangePassword() {
		initComponents();
	}

	private void initComponents() {
		this.labelTitle = new JLabel();
		this.labelOldPassword = new JLabel();
		this.btnCheck = new JButton();
		this.tfOldPassword = new JPasswordField();
		this.labelNewPassword = new JLabel();
		this.tfNewPassword = new JTextField();
		this.labelConfirmPassword = new JLabel();
		this.tfConfirmPassword = new JTextField();
		this.btnChangePassword = new JButton();

		setDefaultCloseOperation(3);
		
		this.tfNewPassword.setEnabled(false);
		this.tfConfirmPassword.setEnabled(false);
		this.btnChangePassword.setEnabled(false);

		this.labelTitle.setFont(new Font("Arial Black", 1, 18));
		this.labelTitle.setForeground(new Color(255, 153, 51));
		this.labelTitle.setHorizontalAlignment(0);
		this.labelTitle.setText("Personal Diary");

		this.labelOldPassword.setText("Old Pasword");

		this.btnCheck.setText("Check");
		this.btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ChangePassword.this.btnCheckActionPerformed(evt);
			}
		});
		this.tfOldPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				ChangePassword.this.tfOldPasswordKeyPressed(evt);
			}
		});
		this.labelNewPassword.setText("New Password");

		this.labelConfirmPassword.setText("Confirm Password");

		this.tfConfirmPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				ChangePassword.this.tfConfirmPasswordKeyPressed(evt);
			}
		});
		this.btnChangePassword.setText("Change Password");
		this.btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ChangePassword.this.btnChangePasswordActionPerformed(evt);
			}
		});
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.labelTitle, -1, -1, 32767)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(117, 117, 117).addComponent(this.btnCheck))
								.addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.labelOldPassword)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.tfOldPassword, -2, 152, -2))
								.addGroup(layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(this.labelConfirmPassword).addComponent(this.labelNewPassword))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.tfNewPassword).addComponent(this.tfConfirmPassword))))
						.addGap(28, 28, 28))
				.addGroup(layout.createSequentialGroup().addGap(69, 69, 69).addComponent(this.btnChangePassword).addContainerGap(-1,
						32767)));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(this.labelTitle, -2, 62, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.labelOldPassword)
								.addComponent(this.tfOldPassword, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnCheck)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.labelNewPassword)
								.addComponent(this.tfNewPassword, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.labelConfirmPassword)
								.addComponent(this.tfConfirmPassword, -2, -1, -2))
						.addGap(18, 18, 18).addComponent(this.btnChangePassword).addGap(0, 33, 32767)));

		pack();
	}

	private void btnCheckActionPerformed(ActionEvent evt) {
		char[] charPassword = this.tfOldPassword.getPassword();
		String password = new String(charPassword);
		if (Diary.password.equals(password)) {
			this.tfNewPassword.setEnabled(true);
			this.tfConfirmPassword.setEnabled(true);
			this.btnChangePassword.setEnabled(true);
			this.tfOldPassword.setEnabled(false);
			this.btnCheck.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this, "Incorrect Password. Try Again.");
		}
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

	private void btnChangePasswordActionPerformed(ActionEvent evt) {
		String pas = this.tfNewPassword.getText();
		String pa = this.tfConfirmPassword.getText();
		if (pa.equals(pas)) {
			this.pass = pa;
			this.key = Diary.userKey;
			this.name = Diary.userName;
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(Setup.path + "/" + "settingsTemp.rtf"));

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

				FileInputStream fis = new FileInputStream(Setup.path + "/" + "settingsTemp.rtf");
				FileOutputStream fos = new FileOutputStream(Setup.path + "/" + "settings1.data");
				encrypt(key, fis, fos);
			} catch (Throwable localThrowable) {
			}
			try {
				String key = "SteveMann";

				FileInputStream fis = new FileInputStream(Setup.path + "/" + "settings1.data");
				FileOutputStream fos = new FileOutputStream(Setup.path + "/" + "settings2.data");
				encrypt(key, fis, fos);
			} catch (Throwable localThrowable1) {
			}
			try {
				String key = "SteveMann";

				FileInputStream fis = new FileInputStream(Setup.path + "/" + "settings2.data");
				FileOutputStream fos = new FileOutputStream(Setup.path + "/" + "settings.data");
				encrypt(key, fis, fos);
			} catch (Throwable localThrowable2) {
			}
			new File(Setup.path + "/" + "settingsTemp.rtf").delete();
			new File(Setup.path + "/" + "settings1.data").delete();
			new File(Setup.path + "/" + "settings2.data").delete();
			JOptionPane.showMessageDialog(null,
					"The settings are saved for you in Documents/Diary/setting.data\nPlease note down the password. You can change it later by going to Options->Change Password\nPassword: "
							+ this.pass);

			JOptionPane.showMessageDialog(null,
					"For security reasons, we need to restart the app. This is a natural process. Just start the app again.\nThank You for using Personal Diary. (made by Steve Mann)");
			System.exit(0);
		} else {
			JOptionPane.showMessageDialog(this, "Passwords don't match. Please check the password entered");
		}
	}

	private void tfOldPasswordKeyPressed(KeyEvent evt) {
		int a = 10;
		if (a == evt.getKeyCode()) {
			this.btnCheck.doClick();
		}
	}

	private void tfConfirmPasswordKeyPressed(KeyEvent evt) {
		int a = 10;
		if (a == evt.getKeyCode()) {
			this.btnChangePassword.doClick();
		}
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
			Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChangePassword().setVisible(true);
			}
		});
	}
}