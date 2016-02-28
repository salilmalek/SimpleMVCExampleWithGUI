

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ModelText {
	private String text = "YOUR STUDENT ID #";
	private int size = 12;
	private Color color;

	private ArrayList<ActionListener> actionListenerList;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "text"));
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "size"));
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,"color"));
	}

	public synchronized void addActionListener(ActionListener l) {
		if (actionListenerList == null)
			actionListenerList = new ArrayList<ActionListener>();
			actionListenerList.add(l);
	}

	public synchronized void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l))
			actionListenerList.remove(l);
	}

	private void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;

		synchronized (this) {
			if (actionListenerList == null)
				return;
			list = (ArrayList<ActionListener>) (actionListenerList.clone());
		}

		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}
}
