package iuh.ktpm14.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuanLyBenhView extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyBenhView frame = new QuanLyBenhView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyBenhView() {
		
		setBounds(100, 100, 900, 550);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));

		
		//contentPane.setLayout(null);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 783, 542);
		//contentPane.add(panel);
		add(panel);
		
		JLabel lblTenBenh = new JLabel("T\u00EAn b\u1EC7nh: ");
		lblTenBenh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenBenh.setBounds(210, 98, 86, 23);
		panel.add(lblTenBenh);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(344, 98, 219, 23);
		panel.add(textField);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(210, 148, 89, 23);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("Xo\u00E1");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(344, 148, 89, 23);
		panel.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 763, 332);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"M\u00E3 b\u1EC7nh", "T\u00EAn b\u1EC7nh"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblQunLBnh = new JLabel("Qu\u1EA3n l\u00FD b\u1EC7nh");
		lblQunLBnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQunLBnh.setBounds(320, 46, 129, 41);
		panel.add(lblQunLBnh);
		
		JButton btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(678, 165, 95, 23);
		panel.add(btnLamMoi);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(474, 148, 89, 23);
		panel.add(btnSua);
	}

}
