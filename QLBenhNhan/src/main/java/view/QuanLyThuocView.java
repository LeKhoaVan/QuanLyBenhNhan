package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuanLyThuocView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyThuocView frame = new QuanLyThuocView();
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
	public QuanLyThuocView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 795, 580);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenThuoc = new JLabel("T\u00EAn thu\u1ED1c: ");
		lblTenThuoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenThuoc.setBounds(203, 83, 86, 23);
		panel.add(lblTenThuoc);
		
		textField = new JTextField();
		textField.setBounds(354, 86, 195, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(203, 182, 89, 23);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("Xo\u00E1");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(336, 182, 89, 23);
		panel.add(btnXoa);
		
		JLabel lblHngDnS = new JLabel("H\u01B0\u1EDBng d\u1EABn s\u1EED d\u1EE5ng: ");
		lblHngDnS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHngDnS.setBounds(203, 117, 153, 23);
		panel.add(lblHngDnS);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(354, 120, 195, 51);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 775, 332);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 thu\u1ED1c", "T\u00EAn thu\u1ED1c", "H\u01B0\u1EDBng d\u1EABn"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n l\u00FD thu\u1ED1c");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(336, 31, 129, 41);
		panel.add(lblNewLabel);
		
		JButton btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(690, 205, 95, 23);
		panel.add(btnLamMoi);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(460, 182, 89, 23);
		panel.add(btnSua);
	}
}
