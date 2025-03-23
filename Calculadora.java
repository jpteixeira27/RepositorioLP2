import javax.swing.JOptionPane;

public class Calculadora {
    public static void main(String[] args) {
        String n1 = JOptionPane.showInputDialog("Essa é uma calculadora que realiza operções com 2 números!!\n\n Digite os números e depois escolha a operação:\n\n Digite o primeiro número inteiro:");
        String n2 = JOptionPane.showInputDialog("Digite o segundo número inteiro:");
        
        try {
            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);

           
            String operacao = JOptionPane.showInputDialog(
                "Escolha a operação:\n" +
                "1 - Soma\n" +
                "2 - Subtração\n" +
                "3 - Multiplicação\n" +
                "4 - Divisão"
            );

            String resultado;

            switch (operacao) {
                case "1":
                    resultado = "A soma é: " + (num1 + num2);
                    break;
                case "2":
                    resultado = "A subtração é: " + (num1 - num2);
                    break;
                case "3":
                    resultado = "A multiplicação é: " + (num1 * num2);
                    break;
                case "4":
                    if (num2 != 0) {
                        resultado = "A divisão é: " + (num1 / (double)num2); 
                    } else {
                        resultado = "Não é possível dividir por zero.";
                    }
                    break;
                default:
                    resultado = "Operação inválida.";
            }

            JOptionPane.showMessageDialog(null, resultado, "Resultado da Operação", JOptionPane.PLAIN_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números inteiros.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
