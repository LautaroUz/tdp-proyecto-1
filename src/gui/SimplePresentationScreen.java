package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textFieldLU;
	private JTextField textFieldLN;
	private JTextField textFieldFN;
	private JTextField textFieldEM;
	private JTextField textFieldGH;
	private JLabel lblClock;
	private JLabel lblLU;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblMail;
	private JLabel lblGithub;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);

		init();
	}

	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		tabInformation.setLayout(null);
		
		textFieldLU = new JTextField();
		textFieldLU.setBackground(Color.WHITE);
		textFieldLU.setEditable(false);
		textFieldLU.setText(""+studentData.getId());
		textFieldLU.setBounds(110, 0, 310, 20);
		tabInformation.add(textFieldLU);
		textFieldLU.setColumns(10);
		
		textFieldLN = new JTextField();
		textFieldLN.setBackground(Color.WHITE);
		textFieldLN.setEditable(false);
		textFieldLN.setText(studentData.getLastName());
		textFieldLN.setBounds(110, 31, 310, 20);
		tabInformation.add(textFieldLN);
		textFieldLN.setColumns(10);
		
		textFieldFN = new JTextField();
		textFieldFN.setBackground(Color.WHITE);
		textFieldFN.setEditable(false);
		textFieldFN.setText(studentData.getFirstName());
		textFieldFN.setBounds(109, 64, 311, 20);
		tabInformation.add(textFieldFN);
		textFieldFN.setColumns(10);
		
		textFieldEM = new JTextField();
		textFieldEM.setBackground(Color.WHITE);
		textFieldEM.setEditable(false);
		textFieldEM.setText(studentData.getMail());
		textFieldEM.setBounds(109, 100, 311, 20);
		tabInformation.add(textFieldEM);
		textFieldEM.setColumns(10);
		
		textFieldGH = new JTextField();
		textFieldGH.setBackground(Color.WHITE);
		textFieldGH.setEditable(false);
		textFieldGH.setText(studentData.getGithubURL());
		textFieldGH.setBounds(110, 131, 310, 20);
		tabInformation.add(textFieldGH);
		textFieldGH.setColumns(10);
		
		lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLU.setBounds(10, 0, 90, 20);
		tabInformation.add(lblLU);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellido.setBounds(10, 31, 90, 20);
		tabInformation.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(10, 64, 90, 20);
		tabInformation.add(lblNombre);
		
		lblMail = new JLabel("E-Mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMail.setBounds(10, 100, 90, 20);
		tabInformation.add(lblMail);
		
		lblGithub = new JLabel("Github URL");
		lblGithub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGithub.setBounds(10, 131, 90, 20);
		tabInformation.add(lblGithub);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		Calendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH)+1;
		int year=cal.get(Calendar.YEAR);
		int min=cal.get(Calendar.MINUTE);
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		lblClock = new JLabel();
		contentPane.add(lblClock, BorderLayout.SOUTH);
		if(min<10)
			lblClock.setText("Esta ventana fue generada el "+day+"/"+month+"/"+year+" a las: "+hour+":0"+min);
		else
			lblClock.setText("Esta ventana fue generada el "+day+"/"+month+"/"+year+" a las: "+hour+":"+min);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/20220901_113315.png")));
		contentPane.add(lblFoto, BorderLayout.CENTER);
	}
}