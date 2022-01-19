import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// DNI
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(43, 35, 46, 14);
		contentPane.add(lblNewLabel);

		// CP
		JLabel lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(43, 112, 79, 14);
		contentPane.add(lblCodigoPostal);

		// TEL
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(43, 184, 79, 14);
		contentPane.add(lblTelfono);

		// CONTROLADORES
		MiControl miControlDNI = new MiControl();
		miControlDNI.setAtributo("DNI");
		miControlDNI.setBounds(137, -2, 287, 65);
		contentPane.add(miControlDNI);

		MiControl miControlCP = new MiControl();
		miControlCP.setAtributo("CP");
		miControlCP.setBounds(137, 74, 287, 65);
		contentPane.add(miControlCP);

		MiControl miControlTEL = new MiControl();
		miControlTEL.setAtributo("TEL");
		miControlTEL.setBounds(137, 150, 287, 65);
		contentPane.add(miControlTEL);

		JLabel lblErrorFinal = new JLabel("");
		lblErrorFinal.setBounds(10, 238, 270, 14);
		contentPane.add(lblErrorFinal);

		// BOTONES

		JButton btFinal = new JButton("Siguiente");
		btFinal.setEnabled(false);
		btFinal.setBounds(319, 238, 89, 23);
		btFinal.isDisplayable();
		contentPane.add(btFinal);

		// EVENTO

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				if (miControlDNI.isCorrecto() && miControlCP.isCorrecto() && miControlTEL.isCorrecto()) {
					lblErrorFinal.setText("Todo esta bien");
					btFinal.setEnabled(true);
				} else {
					lblErrorFinal.setText(miControlCP.getMensaje() + miControlDNI.getMensaje() );
					btFinal.setEnabled(false);
				}
			}
		});

	}
}
