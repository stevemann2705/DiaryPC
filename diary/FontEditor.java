package diary;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FontEditor extends JFrame {
	private JButton bSave;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JList<String> lFamily;
	private JList<String> lSize;
	private JList<String> lStyle;
	private JTextField tfFamily;
	private JSpinner tfSize;
	private JTextField tfStyle;

	public FontEditor() {
		initComponents();
		init();
	}

	void init() {
		DefaultListModel lm = new DefaultListModel();
		lm.addElement("Andale");
		lm.addElement("Arial");
		lm.addElement("Arial Black");
		lm.addElement("Comic Sans MS");
		lm.addElement("Courier New");
		lm.addElement("Georgia");
		lm.addElement("Impact");
		lm.addElement("Times New Roman");
		lm.addElement("Trebuchet MS");
		lm.addElement("Verdana");
		lm.addElement("Webdings");

		this.lFamily.setModel(lm);

		DefaultListModel lm1 = new DefaultListModel();
		lm1.addElement("Regular");
		lm1.addElement("Italic");
		lm1.addElement("Bold");
		lm1.addElement("Bold Italic");

		this.lStyle.setModel(lm1);
		this.lStyle.setSelectedIndex(0);

		DefaultListModel lm2 = new DefaultListModel();
		for (int i = 10; i <= 72; i += 2) {
			lm2.addElement(Integer.toString(i));
		}
		this.lSize.setModel(lm2);
	}

	private void initComponents() {
		this.jLabel1 = new JLabel();
		this.tfFamily = new JTextField();
		this.jScrollPane1 = new JScrollPane();
		this.lFamily = new JList();
		this.jLabel2 = new JLabel();
		this.tfStyle = new JTextField();
		this.jScrollPane2 = new JScrollPane();
		this.lStyle = new JList();
		this.jLabel3 = new JLabel();
		this.tfSize = new JSpinner();
		this.jScrollPane3 = new JScrollPane();
		this.lSize = new JList();
		this.bSave = new JButton();

		setDefaultCloseOperation(3);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				FontEditor.this.formKeyPressed(evt);
			}
		});
		this.jLabel1.setText("Family:");

		this.tfFamily.setEditable(false);

		this.lFamily.setSelectionMode(0);
		this.lFamily.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				FontEditor.this.lFamilyKeyPressed(evt);
			}
		});
		this.lFamily.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				FontEditor.this.lFamilyValueChanged(evt);
			}
		});
		this.jScrollPane1.setViewportView(this.lFamily);

		this.jLabel2.setText("Style:");

		this.lStyle.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				FontEditor.this.lStyleKeyPressed(evt);
			}
		});
		this.lStyle.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				FontEditor.this.lStyleValueChanged(evt);
			}
		});
		this.jScrollPane2.setViewportView(this.lStyle);

		this.jLabel3.setText("Size:");

		this.tfSize.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				FontEditor.this.tfSizeStateChanged(evt);
			}
		});
		this.lSize.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				FontEditor.this.lSizeKeyPressed(evt);
			}
		});
		this.lSize.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				FontEditor.this.lSizeValueChanged(evt);
			}
		});
		this.jScrollPane3.setViewportView(this.lSize);

		this.bSave.setText("Save");
		this.bSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				FontEditor.this.bSaveActionPerformed(evt);
			}
		});
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel1)
						.addComponent(this.tfFamily, -1, 125, 32767).addComponent(this.jScrollPane1, -2, 0, 32767))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel2)
								.addGap(76, 76, 76).addComponent(this.jLabel3))
						.addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 101, -2)
										.addGap(18, 18, 18).addComponent(this.jScrollPane3, -2, 0, 32767))
								.addGroup(layout.createSequentialGroup().addComponent(this.tfStyle, -2, 101, -2)
										.addGap(18, 18, 18).addComponent(this.tfSize, -2, 92, -2)))))
				.addContainerGap(-1, 32767))
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767)
						.addComponent(this.bSave).addContainerGap()));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1)
								.addComponent(this.jLabel2).addComponent(this.jLabel3))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.tfFamily, -2, -1, -2).addComponent(this.tfStyle, -2, -1, -2)
								.addComponent(this.tfSize, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(this.jScrollPane1).addComponent(this.jScrollPane2)
								.addComponent(this.jScrollPane3, -1, 234, 32767))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addComponent(this.bSave)
						.addContainerGap()));

		pack();
	}

	private void lFamilyValueChanged(ListSelectionEvent evt) {
		this.tfFamily.setText((String) this.lFamily.getSelectedValue());
	}

	private void lStyleValueChanged(ListSelectionEvent evt) {
		this.tfStyle.setText((String) this.lStyle.getSelectedValue());
	}

	private void lSizeValueChanged(ListSelectionEvent evt) {
		this.tfSize.setValue(Integer.valueOf(Integer.parseInt((String) this.lSize.getSelectedValue())));
	}

	private void tfSizeStateChanged(ChangeEvent evt) {
		this.lSize.setSelectedValue(this.tfSize.getValue(), true);
	}

	private void bSaveActionPerformed(ActionEvent evt) {
	}

	private void formKeyPressed(KeyEvent evt) {
		int a = 10;
		if (a == evt.getKeyCode()) {
			this.bSave.doClick();
		}
	}

	private void lSizeKeyPressed(KeyEvent evt) {
		int a = 10;
		if (a == evt.getKeyCode()) {
			this.bSave.doClick();
		}
	}

	private void lStyleKeyPressed(KeyEvent evt) {
		int a = 10;
		if (a == evt.getKeyCode()) {
			this.bSave.doClick();
		}
	}

	private void lFamilyKeyPressed(KeyEvent evt) {
		int a = 10;
		if (a == evt.getKeyCode()) {
			this.bSave.doClick();
		}
	}

	JTextField getFamily() {
		return this.tfFamily;
	}

	JTextField getStyle() {
		return this.tfStyle;
	}

	JSpinner getSpSize() {
		return this.tfSize;
	}

	JButton getButton() {
		return this.bSave;
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
			Logger.getLogger(FontEditor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(FontEditor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FontEditor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(FontEditor.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FontEditor().setVisible(true);
			}
		});
	}
}
