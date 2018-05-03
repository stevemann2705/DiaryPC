package diary;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends JFrame {
	private JButton jButton1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPasswordField pf1;

	public Login() {
		initComponents();
	}

	private void initComponents() {
		this.jLabel1 = new JLabel();
		this.pf1 = new JPasswordField();
		this.jLabel2 = new JLabel();
		this.jButton1 = new JButton();
		this.jLabel3 = new JLabel();

		setDefaultCloseOperation(3);
		setTitle("Login");
		setResizable(false);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				Login.this.formKeyPressed(evt);
			}
		});
		this.jLabel1.setText("PASSWORD");

		this.pf1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				Login.this.pf1KeyPressed(evt);
			}
		});
		this.jLabel2.setFont(new Font("Arial Black", 1, 18));
		this.jLabel2.setForeground(new Color(255, 153, 51));
		this.jLabel2.setHorizontalAlignment(0);
		this.jLabel2.setText("Personal Diary");

		this.jButton1.setText("Login");
		this.jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Login.this.jButton1ActionPerformed(evt);
			}
		});
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2, -1, -1,
								32767))
						.addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(this.jLabel3, -1, -1, 32767)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(this.jButton1))
								.addGroup(layout.createSequentialGroup().addComponent(this.jLabel1)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, 32767)
										.addComponent(this.pf1, -2, 142, -2)))))
				.addContainerGap()));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addComponent(this.jLabel2, -1, 67, 32767)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.pf1, -2, -1, -2).addComponent(this.jLabel1))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jButton1, GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING))
						.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		char[] pass = this.pf1.getPassword();
		String pas = new String(pass);
		if (Diary.password.equals(pas)) {
			Main main = new Main();
			main.setVisible(true);
			setVisible(false);
		} else {
			this.jLabel3.setText("Incorrect Password. Try Again.");
		}
	}

	private void formKeyPressed(KeyEvent evt) {
	}

	private void pf1KeyPressed(KeyEvent evt) {
		int a = 10;
		if (a == evt.getKeyCode()) {
			char[] pass = this.pf1.getPassword();
			String pas = new String(pass);
			if (Diary.password.equals(pas)) {
				Main main = new Main();
				main.setVisible(true);
				setVisible(false);
			} else {
				this.jLabel3.setText("Incorrect Password. Try Again.");
			}
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
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}
}
