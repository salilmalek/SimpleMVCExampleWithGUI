
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewText extends JPanel {
	private ModelText model; 
	public void setModel(ModelText newModel) {
		model = newModel;

		if (model != null)
			model.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
			});
	}

	public ModelText getModel() {
		return model;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (model != null) {		
			g.setColor(model.getColor());
			g.setFont(new Font(model.getText(), Font.PLAIN, model.getSize()));	
			g.drawString(model.getText(), (getWidth()/2)-30, getHeight()/2);
		}
	}
}
