package inputTest;

public class TestInput {
	private static void show() {
		var keypad = new Keypad();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				show();
			}
		});
	}

}
