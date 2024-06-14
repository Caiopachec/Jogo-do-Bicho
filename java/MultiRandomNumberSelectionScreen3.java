import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MultiRandomNumberSelectionScreen3 extends JFrame {

    private JLabel resultLabel1;
    private JLabel resultLabel2;
    private JLabel resultLabel3;
    private Random random;

    public MultiRandomNumberSelectionScreen3() {
        // Configurações da janela principal
        setTitle("Tela de Sorteio de Números Aleatórios");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa o gerador de números aleatórios
        random = new Random();

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Botão para gerar números aleatórios
        JButton button = new JButton("Sortear Números");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(button, gbc);

        // Rótulos para exibir os números sorteados
        resultLabel1 = new JLabel("Número 1: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(resultLabel1, gbc);

        resultLabel2 = new JLabel("Número 2: ");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(resultLabel2, gbc);

        resultLabel3 = new JLabel("Número 3: ");
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(resultLabel3, gbc);

        // Ação do botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Integer> randomNumbers = new HashSet<>();
                while (randomNumbers.size() < 3) {
                    int randomNumber = random.nextInt(100); // Gera um número aleatório entre 0 e 99
                    randomNumbers.add(randomNumber);
                }
                Integer[] numbers = randomNumbers.toArray(new Integer[3]);
                resultLabel1.setText("Número 1: " + numbers[0]);
                resultLabel2.setText("Número 2: " + numbers[1]);
                resultLabel3.setText("Número 3: " + numbers[2]);
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
                new MultiRandomNumberSelectionScreen3();
            }
        });
    }
}
