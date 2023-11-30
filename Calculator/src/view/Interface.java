package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.EmptyStackException;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class Interface implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	 private StringBuilder expressao = new StringBuilder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Calculadora");
		frame.setIconImage(null);
		frame.setBounds(100, 100, 450, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_7.setBounds(56, 49, 56, 37);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("8");
		btnNewButton_8.setBounds(122, 49, 56, 37);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("9");
		btnNewButton_9.setBounds(188, 49, 56, 37);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.setBounds(56, 97, 56, 37);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.setBounds(122, 97, 56, 37);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setBounds(188, 97, 56, 37);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("3");
		btnNewButton_3.setBounds(188, 145, 56, 37);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.setBounds(122, 145, 56, 37);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBounds(56, 145, 56, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_0 = new JButton("0");
		btnNewButton_0.setBounds(56, 193, 122, 37);
		frame.getContentPane().add(btnNewButton_0);
		
		JButton btnNewButton_Virgula = new JButton(".");
		btnNewButton_Virgula.setBounds(188, 193, 56, 37);
		frame.getContentPane().add(btnNewButton_Virgula);
		
		JButton btnNewButton_Enter = new JButton("Enter");
		btnNewButton_Enter.setBounds(254, 193, 70, 37);
		frame.getContentPane().add(btnNewButton_Enter);
		
		JButton btnNewButton_Menos = new JButton("-");
		btnNewButton_Menos.setBounds(254, 145, 56, 37);
		frame.getContentPane().add(btnNewButton_Menos);
		
		JButton btnNewButton_Mais = new JButton("+");
		btnNewButton_Mais.setBounds(254, 97, 56, 37);
		frame.getContentPane().add(btnNewButton_Mais);
		
		JButton btnNewButton_Mult = new JButton("*");
		btnNewButton_Mult.setBounds(254, 49, 56, 37);
		frame.getContentPane().add(btnNewButton_Mult);
		
		JButton btnNewButton_Divisao = new JButton("/");
		btnNewButton_Divisao.setBounds(320, 49, 56, 37);
		frame.getContentPane().add(btnNewButton_Divisao);
		
		JButton btnNewButton_C = new JButton("C");
		btnNewButton_C.setBounds(320, 97, 56, 37);
		frame.getContentPane().add(btnNewButton_C);
		
		JButton btnNewButton_AC = new JButton("AC");
		btnNewButton_AC.setBounds(320, 145, 56, 37);
		frame.getContentPane().add(btnNewButton_AC);
		btnNewButton_1.addActionListener(this);
        btnNewButton_2.addActionListener(this);
        btnNewButton_3.addActionListener(this);
        btnNewButton_4.addActionListener(this);
        btnNewButton_5.addActionListener(this);
        btnNewButton_6.addActionListener(this);
        btnNewButton_7.addActionListener(this);
        btnNewButton_8.addActionListener(this);
        btnNewButton_9.addActionListener(this);
        btnNewButton_0.addActionListener(this);
        btnNewButton_Enter.addActionListener(this);
        btnNewButton_Virgula.addActionListener(this);
        btnNewButton_Mais.addActionListener(this);
        btnNewButton_Menos.addActionListener(this);
        btnNewButton_Mult.addActionListener(this);
        btnNewButton_Divisao.addActionListener(this);
        btnNewButton_AC.addActionListener(this);
        btnNewButton_C.addActionListener(this);
        
		
		textField = new JTextField();
		textField.setBounds(56, 11, 318, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        if ("0123456789".contains(buttonText)) {
            if (expressao.length() < 8 || expressao.toString().matches(".*[+\\-*/]\\s*$")) {
                expressao.append(buttonText);
                textField.setText(expressao.toString());
            } else if (expressao.toString().matches(".*[+\\-*/]\\s*[0-9]+\\s*$")) {
                expressao.append(buttonText);
                textField.setText(expressao.toString());
            }
        } else if (".".equals(buttonText)) {
            if (!expressao.toString().isEmpty() && !expressao.toString().matches(".*[.\\s]$") && expressao.length() < 8) {
                expressao.append(buttonText);
                textField.setText(expressao.toString());
            } else if (expressao.toString().isEmpty()) {
                expressao.append("0").append(buttonText);
                textField.setText(expressao.toString());
            }
        } else if ("+-*/".contains(buttonText)) {
            if (!expressao.toString().matches(".*[+\\-*/]\\s*$")) {
                expressao.append(" ").append(buttonText).append(" ");
                textField.setText(expressao.toString());
            }
        } else if ("Enter".equals(buttonText)) {
            if (!expressao.toString().isEmpty() && !expressao.toString().matches(".*[+\\-*/]\\s*$")) {
                try {
                    double resultado;

                    if (expressao.toString().contains("ERR")) {
                        textField.setText("ERR");
                        expressao.setLength(0);
                        return;
                    }

                    if (expressao.toString().contains("=")) {
                        String[] tokens = expressao.toString().split("=");
                        resultado = calcularResultado(tokens[0]);
                    } else {
                        resultado = calcularResultado(expressao.toString());
                    }

                    DecimalFormat df = new DecimalFormat("0.########"); // Formato para até 8 dígitos
                    String resultadoFormatado = df.format(resultado);

                    if (Double.isFinite(resultado)) {
                        textField.setText(resultadoFormatado);
                        expressao.setLength(0);
                        expressao.append(resultado);
                    } else {
                        textField.setText("ERR");
                        expressao.setLength(0);
                    }
                } catch (ArithmeticException ex) {
                    textField.setText("ERR");
                    expressao.setLength(0);
                }
            }
        } else if ("C".equals(buttonText)) {
            if (expressao.length() > 0) {
                expressao.deleteCharAt(expressao.length() - 1);
                textField.setText(expressao.toString());
            }
        } else if ("AC".equals(buttonText)) {
            expressao.setLength(0);
            textField.setText("0");
        }
	}


	
	private double calcularResultado(String expressao) {
		String[] tokens = expressao.split(" ");
	    Stack<Double> numeros = new Stack<>();
	    Stack<String> operadores = new Stack<>();

	    try {
	        for (String token : tokens) {
	            if (token.matches("[0-9]+(\\.[0-9]+)?")) {
	                // Se for um número
	                numeros.push(Double.parseDouble(token));
	            } else if ("+-*/".contains(token)) {
	                // Se for um operador
	                while (!operadores.isEmpty() && getPrecedencia(operadores.peek()) >= getPrecedencia(token)) {
	                    realizarOperacao(numeros, operadores);
	                }
	                operadores.push(token);
	            }
	        }

	        // Realiza as operações restantes
	        while (!operadores.isEmpty()) {
	            realizarOperacao(numeros, operadores);
	        }

	        // O resultado final estará no topo da pilha de números
	        return numeros.pop();
	    } catch (EmptyStackException e) {
	        // Tratamento para pilha vazia
	        return 0.0;
	    }
	
	}
	private void realizarOperacao(Stack<Double> numeros, Stack<String> operadores) {
	    double num2 = numeros.pop();
	    double num1 = numeros.pop();
	    String operador = operadores.pop();

	    switch (operador) {
	        case "+":
	            numeros.push(num1 + num2);
	            break;
	        case "-":
	            numeros.push(num1 - num2);
	            break;
	        case "*":
	            numeros.push(num1 * num2);
	            break;
	        case "/":
	            numeros.push(num1 / num2);
	            break;
	    }
	}
	private int getPrecedencia(String operador) {
	    switch (operador) {
	        case "+":
	        case "-":
	            return 1;
	        case "*":
	        case "/":
	            return 2;
	        default:
	            return 0;
	    }
	}
}
