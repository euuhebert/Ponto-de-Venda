package PDV;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Pdv {
	
	 private static boolean firstButtonClick = true;
	 private static double valorComDesconto = 0.0;

    public static void main(String[] args) {

        // Cria o objeto JFrame
        JFrame frame = new JFrame("PDV");
        JPanel panel = new JPanel();

        JLabel data = new JLabel("27/08/2023");
        JLabel caixa = new JLabel("CAIXA");
        JLabel totValor = new JLabel("Valor Total");
        JLabel desc = new JLabel("Desconto");
        JLabel totDesc = new JLabel("Total com Desconto");
        JLabel valorPago = new JLabel("Valor Pago");
        JLabel troco = new JLabel("Troco");

        JTextField input1 = new JTextField();
        JTextField input2 = new JTextField();
        JTextField input3 = new JTextField();
        JTextField input4 = new JTextField();
        JTextField input5 = new JTextField();

        //imagens
        ImageIcon iconCalc = new ImageIcon("C:\\Users\\heber\\Documents\\temp\\ws_ecplipse\\exercio\\src\\PDV\\calculator (2).png");
        ImageIcon iconClear = new ImageIcon("C:\\Users\\heber\\Documents\\temp\\ws_ecplipse\\exercio\\src\\PDV\\cleaning (2).png");
        JButton imageButton = new JButton(iconCalc);
        JButton imageButton2 = new JButton(iconClear);

        // Define o layout do painel como null para usar setBounds
        panel.setLayout(null);

        // Define as posições e dimensões usando setBounds para cada componente
        data.setBounds(10, 10, 100, 20);
        caixa.setBounds(150, 10, 100, 20);
        totValor.setBounds(50, 40, 100, 20);
        input1.setBounds(120, 40, 100, 20);
        desc.setBounds(50, 70, 100, 20);
        input2.setBounds(120, 70, 100, 20);
        totDesc.setBounds(5, 100, 150, 20);
        input3.setBounds(120, 100, 100, 20);
        valorPago.setBounds(50, 130, 100, 20);
        input4.setBounds(120, 130, 100, 20);
        troco.setBounds(50, 160, 100, 20);
        input5.setBounds(120, 160, 100, 20);
        imageButton.setBounds(250, 40, 70, 70);
        imageButton2.setBounds(250, 120, 70, 70);

        // Adiciona elementos ao painel
        panel.add(data);
        panel.add(caixa);
        panel.add(totValor);
        panel.add(input1);
        panel.add(desc);
        panel.add(input2);
        panel.add(totDesc);
        panel.add(input3);
        panel.add(valorPago);
        panel.add(input4);
        panel.add(troco);
        panel.add(input5);
        panel.add(imageButton);
        panel.add(imageButton2);
        
        //Eventos
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstButtonClick) {
                    try {
                        double valorTotal = Double.parseDouble(input1.getText());
                        double descontoPorcentagem = Double.parseDouble(input2.getText());

                        // Calcular o valor com desconto
                        valorComDesconto = valorTotal * (1 - descontoPorcentagem / 100);

                        // Exibir o valor com desconto no input3
                        input3.setText(String.format("%.2f", valorComDesconto));

                        firstButtonClick = false;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Insira valores numéricos válidos.");
                    }
                } else {
                    try {
                        double valorPago = Double.parseDouble(input4.getText());

                        if (valorPago >= valorComDesconto) {
                            double troco = valorPago - valorComDesconto;
                            input5.setText(String.format("%.2f", troco));
                        } else {
                            JOptionPane.showMessageDialog(frame, "Valor insuficiente!");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Insira um valor numérico válido para o pagamento.");
                    }
                }
            }
        });
        
        imageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpar todos os campos de input
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");
                input5.setText("");

                // Resetar as variáveis e ação do botão
                firstButtonClick = true;
                valorComDesconto = 0.0;
            }
        });
        
        

        // Adiciona o painel ao frame
        frame.getContentPane().add(panel);

        // Configurações do frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 150);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}