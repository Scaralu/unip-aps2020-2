package view;

import sort.BubbleSort;
import sort.InsertionSort;
import sort.QuickSort;
import utils.GeradorDeNumeros;
import utils.Print;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ordenador implements ActionListener {
    private static JPanel aps;
    private static JFrame sortingFrame;

    JTextArea bubbleSortResult = new JTextArea();
    JTextArea insertSortResult = new JTextArea();
    JTextArea quickSortResult = new JTextArea();

    public Ordenador() {
        setConfig();
    }

    public void setConfig() {
        aps = new JPanel();

        sortingFrame = new JFrame("METODO DE ORDENACAO - APS 2020/2");

        sortingFrame.setSize(1100, 600);
        sortingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sortingFrame.add(aps);
        sortingFrame.setLayout(null);
        sortingFrame.setResizable(false);
        sortingFrame.setVisible(true);

        bubbleSortResult.setBounds(200, 35, 800, 40);
        sortingFrame.add(bubbleSortResult);
        bubbleSortResult.setEditable(false);

        Button bubbleSortButton = new Button("Bubble Sort");
        bubbleSortButton.setActionCommand("bubbleSort");
        bubbleSortButton.setBounds(15, 45, 150 , 25);
        bubbleSortButton.addActionListener(this);
        sortingFrame.add(bubbleSortButton);

        insertSortResult.setBounds(200, 90, 800, 40);
        sortingFrame.add(insertSortResult);
        insertSortResult.setEditable(false);

        Button insertionSortButton = new Button("Insertion Sort");
        insertionSortButton.setActionCommand("insertionSort");
        insertionSortButton.setBounds(15, 100, 150, 25);
        insertionSortButton.addActionListener(this);
        sortingFrame.add(insertionSortButton);

        quickSortResult.setBounds(200, 145, 800, 40);
        sortingFrame.add(quickSortResult);
        quickSortResult.setEditable(false);

        Button quickSortButton = new Button("Quick Sort");
        quickSortButton.setActionCommand("quickSort");
        quickSortButton.setBounds(15, 155, 150, 25);
        quickSortButton.addActionListener(this);
        sortingFrame.add(quickSortButton);


        Button sair = new Button("Sair");
        sair.setActionCommand("sair");
        sair.setBounds(950, 500, 90, 25);
        sair.addActionListener(this);
        sortingFrame.add(sair);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        List<Integer> arrayNum = GeradorDeNumeros.randomNumberList(100);
        if (actionEvent.getActionCommand() == "bubbleSort") {
            this.bubbleSort(arrayNum);
        } else if (actionEvent.getActionCommand() == "insertionSort") {
            this.insertionSortView(arrayNum);
        } else if (actionEvent.getActionCommand() == "quickSort") {
            this.quickSortView(arrayNum);
        } else {
            System.exit(0);
        }
    }

    public void bubbleSort(List<Integer> arrayNum) {
        long start = System.nanoTime();
        BubbleSort.sort(arrayNum);
        long elapsed = System.nanoTime() - start;

        bubbleSortResult.setText(Print.array(arrayNum));

        Label lb01 = new Label("Tempo de execucao - Bubble: ");
        lb01.setBounds(15, 200, 193, 30);
        sortingFrame.add(lb01);

        Label lb02 = new Label(elapsed + " ns ");
        lb02.setBounds(220, 200, 200, 30);
        sortingFrame.add(lb02);
    }

    private void insertionSortView(List<Integer> arrayNum) {
        long start = System.nanoTime();
        InsertionSort.sort(arrayNum);
        long elapsed = System.nanoTime() - start;

        insertSortResult.setText(Print.array(arrayNum));

        Label lb01 = new Label("Tempo de execucao - Insert:");
        lb01.setBounds(15, 250, 193, 30);
        sortingFrame.add(lb01);

        Label lb02 = new Label(elapsed + " ns ");
        lb02.setBounds(220, 250, 200, 30);
        sortingFrame.add(lb02);
    }

    private void quickSortView(List<Integer> arrayNum) {
        long start = System.nanoTime();
        QuickSort.sort(arrayNum, 0, (arrayNum.size() - 1));
        long elapsed = System.nanoTime() - start;

        quickSortResult.setText(Print.array(arrayNum));

        Label lb01 = new Label("Tempo de execucao - Quick:");
        lb01.setBounds(15, 300, 193, 30);
        sortingFrame.add(lb01);

        Label lb02 = new Label(elapsed + " ns ");
        lb02.setBounds(220, 300, 200, 30);
        sortingFrame.add(lb02);
    }

    public static void main(String[] args) {
        Ordenador ordenador = new Ordenador();
    }

}

