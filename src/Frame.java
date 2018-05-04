import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Frame {

	private JFrame frame;
	private JTextField tf_commandText;
	private JLabel tf_currentTask;
	private JTextArea tf_taskList;
	private JLabel lblAnswer;
	private JButton btnClear;

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
		frame = new JFrame("Mouz");
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Command:");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblName.setBounds(43, 50, 200, 35);
		frame.getContentPane().add(lblName);
		
		tf_commandText = new JTextField();
		tf_commandText.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		tf_commandText.setBounds(287, 50, 434, 35);
		frame.getContentPane().add(tf_commandText);
		tf_commandText.setColumns(10);
		
		JButton btnClickMeWhen = new JButton("Run Command");
		btnClickMeWhen.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnClickMeWhen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_commandText.getText().isEmpty()) {
					lblAnswer.setText("-help For more Information");
				}else {
					lblAnswer.setText("> " + tf_commandText.getText());
				}
			}
		});
		btnClickMeWhen.setBounds(287, 90, 434, 35);
		frame.getContentPane().add(btnClickMeWhen);
		
		lblAnswer = new JLabel("\r\n");
		lblAnswer.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblAnswer.setBounds(95, 10, 547, 35);
		frame.getContentPane().add(lblAnswer);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_commandText.setText("");
				lblAnswer.setText("");
			}
		});
		btnClear.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnClear.setBounds(43, 90, 145, 35);
		frame.getContentPane().add(btnClear);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblDuration.setBounds(43, 130, 434, 35);
		frame.getContentPane().add(lblDuration);
		
		JSlider slider = new JSlider();
		slider.setBounds(287, 130, 434, 35);
		frame.getContentPane().add(slider);
		
		tf_currentTask = new JLabel("\r\n");
		tf_currentTask.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		tf_currentTask.setBounds(43, 170, 745, 35);
		frame.getContentPane().add(tf_currentTask);
		
		tf_taskList = new JTextArea();
		tf_taskList.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		tf_taskList.setBounds(43, 210, 714, 550);
		
		frame.getContentPane().add(tf_taskList);
		
		/* TODO Das funktioniert irgendwie noch nicht ...
		JScrollPane scroll = new JScrollPane (tf_taskList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scroll);
		*/
		
		frame.setVisible(true);
	}
	
	public void setCurrentTask(String task) {
		tf_currentTask.setText("## Focus: " + task + " ##");
	}
	
	public void setTaskList(String taskList) {
		tf_taskList.setText("Tasks: " + taskList);
	}
}
