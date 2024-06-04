import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumericSelectionScreen extends JFrame {

    public NumericSelectionScreen() {
        // Configurações da janela principal
        setTitle("Tela de Seleção Numérica");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Combobox para seleção numérica
        JLabel label = new JLabel("Selecione um número:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        Integer[] numbers = new Integer[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i;
        }

        JComboBox<Integer> comboBox = new JComboBox<>(numbers);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(comboBox, gbc);

        // Botão de confirmação
        JButton button = new JButton("Confirmar");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(button, gbc);

        // Rótulo para exibir o número selecionado
        JLabel resultLabel = new JLabel("");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        // Ação do botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedNumber = (int) comboBox.getSelectedItem();
                resultLabel.setText("Número selecionado: " + selectedNumber);
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
                new NumericSelectionScreen();
            }
        });
    }
}
