package homework;

import javax.swing.*;

public class JavaMemoInfo extends JDialog {

    private JavaMemo jm;
    private JButton jbtnClose;

    public JavaMemoInfo(JavaMemo jm) {
        super(jm, "메모장", true);

        setLayout(null);

        ImageIcon ii = new ImageIcon("homework/RYU.JPG");
        JLabel jlblimg = new JLabel(ii);
        add(jlblimg).setBounds(40,40,50,50);


        setBounds(100, 100, 500, 500);
        setVisible(true);

    }//JavaMemoInfo


    public JButton getJbtnClose() {

        return null;
    }
}
