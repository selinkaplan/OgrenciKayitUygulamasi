
import javax.swing.SwingUtilities

class Main {
  static void main(String[] args) {
    SwingUtilities.invokeLater {
      Forms.Anasayfa anasayfa = new Forms.Anasayfa()
      anasayfa.showForm()
    }
  }
}
