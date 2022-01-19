import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Label;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiControl extends JPanel {
	private JTextField txtText;
	private String Atributo;
	
	private boolean Correcto = false;
	public String Mensaje = ""; 


	public MiControl() {

		setLayout(null);

		JLabel lblError = new JLabel("");
		lblError.setBounds(165, 31, 177, 25);
		add(lblError);

		txtText = new JTextField();
		txtText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validarTodo(lblError);
			}
		});
		txtText.setBounds(32, 31, 99, 25);
		add(txtText);
		txtText.setColumns(10);

	}

	public String getAtributo() {
		return Atributo;
	}

	public void setAtributo(String atributo) {
		Atributo = atributo;
	}

	public boolean validar(String patern, String text) {
		Boolean valido = false;

		Pattern pat = Pattern.compile(patern);
		Matcher matcher = pat.matcher(text);
		if (matcher.matches()) {
			valido = true;
		}

		return valido;
	}

	public void validarTodo(JLabel lblError) {
		String patern;

		if (!txtText.getText().equals(null)) {
			switch (Atributo) {
			case "DNI":

				patern = "[0-9]{8}[A-Z]{1}";

				if (validar(patern, txtText.getText())) {
					lblError.setText("DNI válido");
					Correcto = true;
				} else {
					lblError.setText("DNI no válido");
					Correcto = false;
					Mensaje += "DNI no válido \n";
				}

				break;

			case "CP":

				patern = "[0-9]{5}";

				if (validar(patern, txtText.getText())) {
					lblError.setText("Codigo Postal válido");
					Correcto = true;
				} else {
					lblError.setText("Codigo Postal no válido");
					Correcto = false;
					Mensaje += "Codigo Postal no válido \n";
				}

				break;

			case "TEL":

				patern = "(\\+34|0034|34)?(6|7|9)[0-9]{8}";

				if (validar(patern, txtText.getText())) {
					lblError.setText("Teléfono válido");
					Correcto = true;
				} else {
					lblError.setText("Teléfono no válido");
					Correcto = false;
					Mensaje += "Teléfono no válido \n";
				}
				break;
			}
		} else {
			lblError.setText("Campo vacio");
		}


	}
	
	//DEVUELVE SI SE HA VALIDADO BIEN O NO UN COMPONENTE
	public boolean isCorrecto() {
		return Correcto;
	}

	public void setCorrecto(boolean correcto) {
		Correcto = correcto;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
	


}
