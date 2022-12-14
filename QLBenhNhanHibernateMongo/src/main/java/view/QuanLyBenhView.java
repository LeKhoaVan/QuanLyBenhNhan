package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constant.CrudStatus;
import entity.Benh;
import service.BenhService;
import service.impl.BenhServiceImpl;



public class QuanLyBenhView extends JPanel implements ActionListener,MouseListener {
	
	

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btnLamMoi;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private DefaultTableModel dtf;
	
	private BenhService benhService = new BenhServiceImpl();

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
		
		btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(210, 148, 89, 23);
		panel.add(btnThem);
		
		btnXoa = new JButton("Xo\u00E1");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(344, 148, 89, 23);
		panel.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 763, 332);
		panel.add(scrollPane);
		
		String[] header= {"M?? B???nh","T??n B???nh"};
		
        dtf=new DefaultTableModel(header,0);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null},
//				{null, null},
//			},
//			new String[] {
//				"M\u00E3 b\u1EC7nh", "T\u00EAn b\u1EC7nh"
//			}
//		));
		table = new JTable(dtf);
		scrollPane.setViewportView(table);
		
		JLabel lblQunLBnh = new JLabel("Qu\u1EA3n l\u00FD b\u1EC7nh");
		lblQunLBnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQunLBnh.setBounds(320, 46, 129, 41);
		panel.add(lblQunLBnh);
		
		btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(678, 165, 95, 23);
		panel.add(btnLamMoi);
		
		btnSua = new JButton("S\u1EEDa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(474, 148, 89, 23);
		panel.add(btnSua);
		
		table.addMouseListener(this);
		docLenTBL();
		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	public void docLenTBL() {
		for(Benh benh : benhService.findAll()) {
			Object [] ob = {benh.getId(),benh.getTenBenh()};
			dtf.addRow(ob);
		}
	}
	
	public void deleteTBL() {
		DefaultTableModel df=(DefaultTableModel) table.getModel();
    	df.getDataVector().removeAllElements();
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			String ten=textField.getText();
			
			Benh benh = new Benh();
			benh.setTenBenh(ten);
			
			if(benhService.createBenh(benh)) {
				JOptionPane.showMessageDialog(this,"Th??m th??nh c??ng");
				textField.setText("");
				table.setSelectionMode(0);
				deleteTBL();
				docLenTBL();
			}
			else
				JOptionPane.showMessageDialog(this,"T??n b???nh ???? t???n t???i");		
		}
		else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			
			String id=dtf.getValueAt(row, 0).toString();
			System.out.println(id);
			
			if(benhService.deleteById(id) == CrudStatus.SUCCESS) {
				JOptionPane.showMessageDialog(this,"X??a th??nh c??ng");
				textField.setText("");
				deleteTBL();
				docLenTBL();
			}
			else
				JOptionPane.showMessageDialog(this,"T??n b???nh kh??ng t???n t???i");		
		}
		else if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			String id=dtf.getValueAt(row, 0).toString();
			
			String updateName = textField.getText();
			
			Benh benh = new Benh();
			benh.setId(id);
			benh.setTenBenh(updateName);
			if(benhService.updateBenh(benh)) {
				JOptionPane.showMessageDialog(this,"C???p nh???t th??nh c??ng");
				textField.setText("");
				table.setSelectionMode(row);
				deleteTBL();
				docLenTBL();
			}
			else
				JOptionPane.showMessageDialog(this,"C???p nh???t th???t b???i!! T??n b???nh kh??ng t???n t???i");		
		
		}
		else if(o.equals(btnLamMoi)){
			textField.setText("");
			deleteTBL();
			docLenTBL();
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		int row= table.getSelectedRow();
		textField.setText(dtf.getValueAt(row, 1).toString());
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}