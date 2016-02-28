
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo extends JFrame  {
	  private JButton jbtController = new JButton("Show Controller");
	  private JButton jbtView = new JButton("Show View");	  
	  private ModelText model = new ModelText();

	  public Demo() {
	    setLayout(new FlowLayout());
	    add(jbtController);
	    add(jbtView);

	    jbtController.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        JFrame frame = new JFrame("Controller");
	        ControllerText controller = new ControllerText();
	        controller.setModel(model);
	        frame.add(controller);
	        frame.setSize(300, 150);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	      }
	    });

	    jbtView.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        JFrame frame = new JFrame("View");
	        ViewText view = new ViewText();
	        view.setModel(model);
	        frame.add(view);
	        frame.setSize(500, 200);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	      }
	    });
	  }

	  public static void main(String[] args) {
		  JFrame frame = new Demo();
		    frame.setTitle("MVCDemo");
		    frame.setSize(400, 100);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
	  }
	}
