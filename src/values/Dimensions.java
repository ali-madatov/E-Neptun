package values;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Dimensions {
	public static Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width+10,
			Toolkit.getDefaultToolkit().getScreenSize().height-30);
}
