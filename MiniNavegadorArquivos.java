package Github;

import java.io.File;
import javax.swing.*;

public class MiniNavegadorArquivos {
    private File diretorioAtual;

    public MiniNavegadorArquivos() {
        diretorioAtual = new File(System.getProperty("user.home"));
        iniciarNavegador();
    }

    private void iniciarNavegador() {
        while (true) {
            String[] opcoes = {"Listar", "Entrar", "Voltar", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, 
                    "Navegador de Arquivos\nDiretório atual: " + diretorioAtual.getAbsolutePath(),
                    "Menu Principal", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    opcoes, 
                    opcoes[0]);

            switch (escolha) {
                case 0: 
                    listarConteudo();
                    break;
                case 1: 
                    entrarEmSubdiretorio();
                    break;
                case 2: 
                    voltarDiretorioPai();
                    break;
                case 3: 
                    JOptionPane.showMessageDialog(null, "Saindo do navegador.");
                    return;
                default:
                    break;
            }
        }
    }

    private void listarConteudo() {
        File[] arquivos = diretorioAtual.listFiles();
        if (arquivos != null && arquivos.length > 0) {
            StringBuilder lista = new StringBuilder("Conteúdo do diretório:\n");
            for (File arquivo : arquivos) {
                lista.append(arquivo.getName()).append(arquivo.isDirectory() ? " (Diretório)" : "").append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        } else {
            JOptionPane.showMessageDialog(null, "O diretório está vazio ou não é acessível.");
        }
    }

    private void entrarEmSubdiretorio() {
        String subdiretorio = JOptionPane.showInputDialog("Digite o nome do subdiretório para entrar:");
        if (subdiretorio != null) {
            File novoDiretorio = new File(diretorioAtual, subdiretorio);
            if (novoDiretorio.isDirectory()) {
                diretorioAtual = novoDiretorio;
            } else {
                JOptionPane.showMessageDialog(null, "O caminho especificado não é um diretório válido.");
            }
        }
    }

    private void voltarDiretorioPai() {
        if (diretorioAtual.getParentFile() != null) {
            diretorioAtual = diretorioAtual.getParentFile();
        } else {
            JOptionPane.showMessageDialog(null, "Você já está no diretório raiz.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MiniNavegadorArquivos::new);
    }
}
