import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JComboBox;

public class Frame {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblAnswer;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		lblName.setBounds(43, 128, 141, 73);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		textField.setBounds(187, 128, 434, 76);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnClickMeWhen = new JButton("Click me when ready");
		btnClickMeWhen.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		btnClickMeWhen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					lblAnswer.setText("Bitte Namen eingeben!");
				}else {
					lblAnswer.setText("Hallo " + textField.getText() + "!");
				}
			}
		});
		btnClickMeWhen.setBounds(187, 300, 434, 131);
		frame.getContentPane().add(btnClickMeWhen);
		
		lblAnswer = new JLabel("\r\n");
		lblAnswer.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 40));
		lblAnswer.setBounds(95, 34, 547, 46);
		frame.getContentPane().add(lblAnswer);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				lblAnswer.setText("");
			}
		});
		btnClear.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		btnClear.setBounds(21, 300, 145, 131);
		frame.getContentPane().add(btnClear);
		
		JSlider slider = new JSlider();
		slider.setBounds(187, 206, 434, 97);
		frame.getContentPane().add(slider);
	}
}
