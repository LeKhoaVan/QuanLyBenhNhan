package view;

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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuanLyToaThuocView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyToaThuocView frame = new QuanLyToaThuocView();
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
	public QuanLyToaThuocView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 798, 652);
		contentPane.add(panel);
		
		JLabel lblNgyLpToa = new JLabel("Ng\u00E0y l\u1EADp toa thu\u1ED1c:");
		lblNgyLpToa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgyLpToa.setBounds(166, 82, 143, 23);
		panel.add(lblNgyLpToa);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(319, 80, 179, 25);
		panel.add(textField);
		
		JButton btnXutPhiuKhm = new JButton("Xu\u1EA5t phi\u1EBFu");
		btnXutPhiuKhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXutPhiuKhm.setBounds(549, 80, 197, 23);
		panel.add(btnXutPhiuKhm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(10, 261, 420, 380);
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
		
		JLabel lblQunLBnh_1 = new JLabel("Qu\u1EA3n l\u00FD toa thu\u1ED1c");
		lblQunLBnh_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQunLBnh_1.setBounds(315, 28, 163, 41);
		panel.add(lblQunLBnh_1);
		
		JButton btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(10, 82, 95, 23);
		panel.add(btnLamMoi);
		
		JList list = new JList();
		list.setBorder(new TitledBorder(null, "Thu\u1ED1c \u0111\u01B0\u1EE3c ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBounds(532, 261, 256, 380);
		panel.add(list);
		
		JButton btnNewButton = new JButton("Th\u00EAm >>");
		btnNewButton.setBounds(433, 359, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<< Xo\u00E1 ");
		btnNewButton_1.setBounds(433, 404, 89, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 116, 778, 133);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"S\u1ED1 phi\u1EBFu kh\u00E1m b\u1EC7nh", "T\u00EAn b\u1EC7nh", "Ng\u00E0y l\u1EADp toa thu\u1ED1c"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(112);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(114);
		scrollPane_1.setViewportView(table_1);
	}
}
