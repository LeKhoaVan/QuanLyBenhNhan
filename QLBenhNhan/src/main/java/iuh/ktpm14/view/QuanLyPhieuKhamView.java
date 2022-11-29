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
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class QuanLyPhieuKhamView extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyPhieuKhamView frame = new QuanLyPhieuKhamView();
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
	public QuanLyPhieuKhamView() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 810);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new EmptyBorder(5,5,5,5));

		//setContentPane(contentPane);
		add(contentPane);
		//contentPane.setLayout(null);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 785, 536);
		//contentPane.add(panel);
		add(panel);
		
		JLabel lblTnBnhNhn = new JLabel("T\u00EAn b\u1EC7nh nh\u00E2n: ");
		lblTnBnhNhn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnBnhNhn.setBounds(125, 80, 118, 23);
		panel.add(lblTnBnhNhn);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(239, 80, 179, 25);
		panel.add(textField);
		
		JButton btnXutPhiuKhm = new JButton("Xu\u1EA5t toa thu\u1ED1c");
		btnXutPhiuKhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXutPhiuKhm.setBounds(549, 80, 197, 23);
		panel.add(btnXutPhiuKhm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Phi\u1EBFu kh\u00E1m b\u1EC7nh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 261, 765, 269);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"M\u00E3 b\u1EC7nh nh\u00E2n", "T\u00EAn b\u1EC7nh nh\u00E2n", "Tri\u1EC7u ch\u1EE9ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(78);
		table.getColumnModel().getColumn(0).setMinWidth(78);
		table.getColumnModel().getColumn(1).setPreferredWidth(106);
		scrollPane.setViewportView(table);
		
		JLabel lblQunLBnh_1 = new JLabel("Qu\u1EA3n l\u00FD phi\u1EBFu kh\u00E1m b\u1EC7nh");
		lblQunLBnh_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQunLBnh_1.setBounds(294, 28, 245, 41);
		panel.add(lblQunLBnh_1);
		
		JButton btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(680, 227, 95, 23);
		panel.add(btnLamMoi);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(549, 114, 197, 23);
		panel.add(btnSua);
		
		JLabel lblTriuChng = new JLabel("Tri\u1EC7u ch\u1EE9ng:");
		lblTriuChng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTriuChng.setBounds(125, 148, 118, 23);
		panel.add(lblTriuChng);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 148, 276, 57);
		panel.add(textField_1);
		
		JLabel lblTui = new JLabel("Tu\u1ED5i:");
		lblTui.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTui.setBounds(428, 80, 38, 23);
		panel.add(lblTui);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(469, 80, 46, 25);
		panel.add(textField_2);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoi.setBounds(125, 114, 118, 23);
		panel.add(lblSinThoi);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(239, 114, 276, 25);
		panel.add(textField_3);
	}

}
