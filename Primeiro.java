import javax.swing.JOptionPane; 
public class Primeiro 
{ 
    public static void main(String[] args) 
    { 
        String n1 = JOptionPane.showInputDialog( "Digite um número inteiro: "); 
        String n2 = JOptionPane.showInputDialog( "Digite mais um número inteiro: ");
        try {
            int nnum = Integer.parseInt(n1);
            int nndo = Integer.parseInt(n2);
            int som = nnum + nndo;
            JOptionPane.showMessageDialog(null, "A soma é " + som, "Soma de dois inteiros", JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números inteiros.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}