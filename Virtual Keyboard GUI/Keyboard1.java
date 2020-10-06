import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Dimension;

// BY CAMILA ALVES BARROS

public class Keyboard1 {

	private JFrame frame;
	JTextArea textArea;
	ArrayList<String> notPrintable = new ArrayList<String>(Arrays.asList("tab", "caps lock", "shift", 
			"enter","back", "▲", "◄", "▼","►"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Keyboard1 window = new Keyboard1();
					window.frame.setVisible(true);
					window.frame.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Keyboard1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(770, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel topLbl = new JLabel("Type your text below");
		topLbl.setBounds(6, 6, 758, 33);
		frame.getContentPane().add(topLbl);
		topLbl.setHorizontalAlignment(SwingConstants.LEFT);
		topLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		JPanel panelTop = new JPanel();
		panelTop.setBounds(6, 45, 758, 160); // TOP JPANEL CONFIGURATION
		frame.getContentPane().add(panelTop);
		panelTop.setLayout(null);

		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBounds(6, 8, 750, 145);
		panelTop.add(textArea);

		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout(FlowLayout.LEFT, -2, -2)); // BOTTOM JPANEL - KEYS CONFIGURATION
		panelBottom.setBounds(5, 217, 748, 200);
		frame.getContentPane().add(panelBottom);

		JPanel lastPanel = new JPanel();         // LAST PANEL
		lastPanel.setBounds(16, 414, 748, 59);
		lastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 4));
		frame.getContentPane().add(lastPanel);
		
		char[] firstRow = { '`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0','-','='};
		char[] secondRow = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\' };
		char[] thirdRow = { 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'' };
		char[] fourthRow = { 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/' };
		
		for (int i = 0; i < firstRow.length; i++) {   // FIRST ROW
			String c = Character.toString(firstRow[i]);
			JButton btn = new JButton(c);
			btn.setPreferredSize(new Dimension(50, 53));
			btn.addActionListener(new listenKeyMouse());
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(firstRow[i]);
			addKeyBinding(btn, c, keyCode);
			panelBottom.add(btn);
		}
		
		JButton backBtn = new JButton("back");     // BACK SPACE BTN
		addKeyBinding(backBtn, "", KeyEvent.VK_BACK_SPACE);
		backBtn.setPreferredSize(new Dimension(125, 53));
		panelBottom.add(backBtn);

		JButton tabBtn = new JButton("tab");     // TAB BTN
		addKeyBinding(tabBtn, "", KeyEvent.VK_TAB);
		tabBtn.setPreferredSize(new Dimension(120, 53));
		panelBottom.add(tabBtn);

		for (int i = 0; i < secondRow.length; i++) { // SECOND ROW
			String c = Character.toString(secondRow[i]);
			JButton btn = new JButton(c);
			btn.setPreferredSize(new Dimension(50, 53)); // REGULAR BUTTON SIZE
			btn.addActionListener(new listenKeyMouse());
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(secondRow[i]);
			addKeyBinding(btn, c, keyCode);
			panelBottom.add(btn);
		}

		JButton capsBtn = new JButton("caps lock"); // CAPS BTN
		addKeyBinding(capsBtn, "", KeyEvent.VK_CAPS_LOCK);
		capsBtn.setPreferredSize(new Dimension(120, 53));
		panelBottom.add(capsBtn);

		for (int i = 0; i < thirdRow.length; i++) { // THIRD ROW
			String c = Character.toString(thirdRow[i]);
			JButton btn = new JButton(c);
			btn.setPreferredSize(new Dimension(50, 53));
			btn.addActionListener(new listenKeyMouse());
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(thirdRow[i]);
			addKeyBinding(btn, c, keyCode);
			panelBottom.add(btn);
		}
		JButton enterBtn = new JButton("enter");      // ENTER BTN
		addKeyBinding(enterBtn, "enter", KeyEvent.VK_ENTER);
		enterBtn.setPreferredSize(new Dimension(100, 53));
		panelBottom.add(enterBtn);

		JButton shiftBtn = new JButton("shift"); // SHIFT BTN - GOES IN THE FORTH ROW
		addKeyBinding(shiftBtn, "shift", KeyEvent.VK_SHIFT);
		shiftBtn.setPreferredSize(new Dimension(134, 52));
		panelBottom.add(shiftBtn);

		for (int i = 0; i < fourthRow.length; i++) { // FOURTH ROW
			String c = Character.toString(fourthRow[i]);
			JButton btn = new JButton(c);
			btn.setPreferredSize(new Dimension(50, 52));
			btn.addActionListener(new listenKeyMouse());
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(fourthRow[i]);
			addKeyBinding(btn, c, keyCode);
			panelBottom.add(btn);
		}

		panelBottom.add(Box.createHorizontalStrut(50));  // GAP
		
		JButton upArrow = new JButton("▲"); // UP ARROW
		addKeyBinding(upArrow, "", KeyEvent.VK_UP);
		upArrow.setPreferredSize(new Dimension(50, 52));
		panelBottom.add(upArrow);

		JButton spaceBtn = new JButton(" ");       // SPACE BTN
		spaceBtn.setPreferredSize(new Dimension(400, 52));
		spaceBtn.setMargin(new Insets(0, 200, 0, 100));
		addKeyBinding(spaceBtn, "", KeyEvent.VK_SPACE);
		lastPanel.add(spaceBtn);
		
		lastPanel.add(Box.createHorizontalStrut(90));   // GAP
		
		JButton leftArrow = new JButton("◄");   // LEFT ARROW
		addKeyBinding(leftArrow, "", KeyEvent.VK_LEFT);
		leftArrow.setPreferredSize(new Dimension(50, 52));
		lastPanel.add(leftArrow);
		   
		JButton downArrow = new JButton("▼");     // DOWN ARROW
		addKeyBinding(downArrow, "", KeyEvent.VK_DOWN );
		downArrow.setPreferredSize(new Dimension(50, 52));
		lastPanel.add(downArrow);
		
		JButton rightArrow = new JButton("►");    // RIGHT ARROW
		addKeyBinding(rightArrow, "", KeyEvent.VK_RIGHT);
		rightArrow.setPreferredSize(new Dimension(50, 52));
		lastPanel.add(rightArrow);

	}

	private class listenKeyMouse implements ActionListener {   // MOUSE LISTENER FOR ALL KEYS

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			JButton b = null;
			if (obj instanceof JButton) {
				b = (JButton) obj;
			}
			textArea.append(b.getText());
		}
	}

	protected void addKeyBinding(JButton btn, String name, int virtualKey) {
		ActionMap am = btn.getActionMap();
		InputMap im = btn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		im.put(KeyStroke.getKeyStroke(virtualKey, 0, false), name + ".pressed");
		im.put(KeyStroke.getKeyStroke(virtualKey, 0, true), name + ".released");

		am.put(name + ".pressed", new KeyAction(btn, true));
		am.put(name + ".released", new KeyAction(btn, false));

	}

	private class KeyAction extends AbstractAction {

		private JButton btn;
		private boolean highlight;

		public KeyAction(JButton btn, boolean highlight) {
			this.btn = btn;
			this.highlight = highlight;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (highlight) {
				btn.getModel().setPressed(true);
				btn.setBackground(Color.RED);
				btn.setOpaque(true);
				String key = btn.getText();
				if (!notPrintable.contains(key)) {
					textArea.append(btn.getText());
				}
			} else {
				btn.getModel().setPressed(false);
				btn.setBackground(null);
				btn.setOpaque(false);
			}
		}
	}
}
