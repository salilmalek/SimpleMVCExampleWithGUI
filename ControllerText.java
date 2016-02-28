
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ControllerText extends JPanel {
	private ModelText model;
	String[] colors={"Black","Blue","Red"};
	//Color[] colors = {Color.black, Color.blue, Color.red };

	private JSpinner jFont = new JSpinner(new SpinnerNumberModel(12, 12, 48,12));
	private JTextField jText = new JTextField();
	private JComboBox jBox = new JComboBox(colors);

	
	public ControllerText() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 3));
		panel1.add(new JLabel("Text"));
		panel1.add(new JLabel("Color"));
		panel1.add(new JLabel("Size"));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 3));
		panel2.add(jText);
		panel2.add(jBox);
		panel2.add(jFont);

		setLayout(new BorderLayout());
		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);

		jText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model != null) 
					model.setText(jText.getText());
			}
		});
		jBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model != null) 
				{
					Color color=Color.black;
					int i=jBox.getSelectedIndex();
					if(i==0)
						color=Color.black;
					else if(i==1)
						color=Color.blue;
					else if(i==2)
						color=Color.red;
					model.setColor(color);
				}	
			}
		});
		jFont.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (model != null) 
					model.setSize((Integer)jFont.getValue());
			}});
	}
	public void setModel(ModelText newModel) {
		model = newModel;
	}
	public ModelText getModel() {
		return model;
	}
}
