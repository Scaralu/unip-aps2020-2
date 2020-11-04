import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BubbleSort implements ActionListener {
	private static JPanel aps;
	private static JFrame ordenadorBubble;
	JTextArea resultado = new JTextArea();
	String[] Resultado = new String[40];
	int[] numeros = new int[40];

	public BubbleSort() {
		setConfig();
	}

	public void setConfig() {
		aps = new JPanel();
		ordenadorBubble = new JFrame("M�TODO BUBBLE SORT PARA ORDENA��O DE N�MEROS");
		ordenadorBubble.setSize(1100, 200);
		ordenadorBubble.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ordenadorBubble.add(aps);
		ordenadorBubble.setLayout(null);
		ordenadorBubble.setResizable(false);
		ordenadorBubble.setVisible(true);

		resultado.setBounds(150, 35, 800, 40);
		ordenadorBubble.add(resultado);
		resultado.setEditable(false);

		Button ordenar = new Button("Iniciar");
		ordenar.setActionCommand("ordenar");
		ordenar.setBounds(15, 35, 90, 25);
		ordenar.addActionListener(this);
		ordenadorBubble.add(ordenar);

		Button sair = new Button("Sair");
		sair.setActionCommand("sair");
		sair.setBounds(950, 120, 90, 25);
		sair.addActionListener(this);
		ordenadorBubble.add(sair);

		for (int i = 0; i < this.numeros.length; i++) {
			this.numeros[i] = (int) (Math.random() * 100);
		}
		for (int p = 0; p < numeros.length; p++) {
			if (p % 40 == 0) {
				resultado.append("\n");
			}
			Resultado[p] = "" + this.numeros[p] + " ";
			resultado.append(" " + Resultado[p]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "ordenar") {
			try {
				this.ordenar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (arg0.getActionCommand() == "sair") {
			System.exit(0);
		}
	}

	public void ordenar() throws Exception {
		long tempoInicial = System.currentTimeMillis();
		resultado.setText("");
		int n = this.numeros.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (this.numeros[j] > this.numeros[j + 1]) {
					int temp = this.numeros[j];
					this.numeros[j] = this.numeros[j + 1];
					this.numeros[j + 1] = temp;
				}
		for (int x = 0; x < n; ++x) {
			if (x % 40 == 0) {
				resultado.append("\n");
			}
			Resultado[x] = "" + this.numeros[x] + " ";
			resultado.append(" " + Resultado[x]);
		}
		long tempoFinal = System.currentTimeMillis();
		double tempoExecucao = (tempoFinal - tempoInicial) / 1000d;
		Label lb01 = new Label("Tempo de execu�ao:");
		lb01.setBounds(15, 100, 120, 30);
		ordenadorBubble.add(lb01);
		Label lb02 = new Label(Double.toString(tempoExecucao) + " milisegundos ");
		lb02.setBounds(150, 100, 200, 30);
		ordenadorBubble.add(lb02);

	}

	public static void main(String[] args) {
		BubbleSort ordenadorBubble = new BubbleSort();

	}

}
