package diary;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ImageViewer extends JFrame {
	BufferedImage image;
	Main m = new Main();
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;

	public void setIcon(ImageIcon i) {
		this.jLabel1.setIcon(i);
	}

	public ImageViewer() {
		initComponents();
	}

	private void initComponents() {
		this.jLabel1 = new JLabel();
		this.jButton2 = new JButton();
		this.jButton1 = new JButton();

		setSize(new Dimension(600, 660));

		this.jLabel1.setHorizontalAlignment(0);
		this.jLabel1.setMaximumSize(new Dimension(600, 600));
		this.jLabel1.setPreferredSize(new Dimension(600, 600));

		this.jButton2.setText("Close");
		this.jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ImageViewer.this.jButton2ActionPerformed(evt);
			}
		});
		this.jButton1.setText("Delete this image");
		this.jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ImageViewer.this.jButton1ActionPerformed(evt);
			}
		});
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel1, -2, -1, -2))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(this.jButton1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
								.addComponent(this.jButton2).addContainerGap()));

		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addComponent(this.jLabel1, -2, 369, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jButton2).addComponent(this.jButton1))
										.addContainerGap()));

		pack();
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		setVisible(false);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		File index = new File(Main.path + "/" + Main.foldername);
		String[] entries = index.list();
		for (String s : entries) {
			File currentFile = new File(index.getPath(), s);
			currentFile.delete();
		}
		index.delete();
		setVisible(false);
	}
}
