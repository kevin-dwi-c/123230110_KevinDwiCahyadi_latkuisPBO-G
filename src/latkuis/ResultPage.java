
package latkuis;

import javax.swing.JOptionPane;

public class ResultPage{
     public void showResult(Mahasiswa mhs){
        JOptionPane.showMessageDialog(null, mhs.getInfo(), "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
