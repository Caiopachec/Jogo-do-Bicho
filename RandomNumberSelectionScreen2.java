import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumberSelectionScreen2 extends JFrame {

    private JLabel resultLabel;
    private Random random;

    public RandomNumberSelectionScreen2() {
        // Configurações da janela principal
        setTitle("Tela de Seleção Numérica Aleatória");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa o gerador de números aleatórios
        random = new Random();

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Botão para gerar número aleatório
        JButton button = new JButton("Gerar Número Aleatório");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(button, gbc);

        // Rótulo para exibir o número selecionado
        resultLabel = new JLabel("Número selecionado: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        // Ação do botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomNumber = random.nextInt(100); // Gera um número aleatório entre 0 e 99
                resultLabel.setText("Número selecionado: " + randomNumber);
            }
        });

        // Adiciona o painel à janela principal
        add(panel);

        // Exibe a janela
        setVisible(true);
    }

    public static void main(String[] args) {
        // Executa a aplicação
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RandomNumberSelectionScreen2();
            }
        });
    }
}
