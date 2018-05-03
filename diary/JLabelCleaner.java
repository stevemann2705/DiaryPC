package diary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

class JLabelCleaner {
	private JLabel label;
	private int waitSeconds;

	public JLabelCleaner(int waitSeconds, JLabel label) {
		this.label = label;
		this.waitSeconds = waitSeconds;
	}

	public void startCountdownFromNow() {
		Timer timer = new Timer(this.waitSeconds * 1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabelCleaner.this.label.setText("");
			}
		});
		timer.start();
	}
}
