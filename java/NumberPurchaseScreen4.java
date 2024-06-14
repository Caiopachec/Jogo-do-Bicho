import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NumberPurchaseScreen4 extends JFrame {

    private JComboBox<Integer> comboBox;
    private JButton addButton;
    private JButton purchaseButton;
    private JLabel totalLabel;
    private List<Integer> selectedNumbers;

    private static final int NUMBER_PRICE = 1; // Valor em centavos

    public NumberPurchaseScreen4() {
        // Configurações da janela principal
        setTitle("Tela de Compra de Números");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        selectedNumbers = new ArrayList<>();

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Combobox para selecionar número
        JLabel label = new JLabel("Selecione um número:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        Integer[] numbers = new Integer[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i;
        }

        comboBox = new JComboBox<>(numbers);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(comboBox, gbc);

        // Botão para adicionar número à compra
        addButton = new JButton("Adicionar Número");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(addButton, gbc);

        // Botão para confirmar a compra
        purchaseButton = new JButton("Comprar");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(purchaseButton, gbc);

        // Rótulo para exibir o valor total da compra
        totalLabel = new JLabel("Total: R$ 0.00");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(totalLabel, gbc);

        // Ação do botão adicionar
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedNumber = (int) comboBox.getSelectedItem();
                if (!selectedNumbers.contains(selectedNumber)) {
                    selectedNumbers.add(selectedNumber);
                    updateTotal();
                } else {
                    JOptionPane.showMessageDialog(panel, "Número já adicionado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Ação do botão comprar
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!selectedNumbers.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    selectedNumbers.clear();
                    updateTotal();
                } else {
                    JOptionPane.showMessageDialog(panel, "Nenhum número selecionado para compra!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adiciona o painel à janela principal
        add(panel);

        // Exibe a janela
        setVisible(true);
    }

    private void updateTotal() {
        double total = selectedNumbers.size() * NUMBER_PRICE / 100.0;
        totalLabel.setText(String.format("Total: R$ %.2f", total));
    }

    public static void main(String[] args) {
        // Executa a aplicação
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberPurchaseScreen4();
            }
        });
    }
}
