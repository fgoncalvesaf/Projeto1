package pkg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel{

	private JPanel panel1, panel2;
	private int count = 0;
	private int width = 0, height = 0;
	private JLabel[] label, num;
	private JButton[] button;
	private JTextField text2, text3, text4, text5, text6, text7;
	
	public Panel(int width, int height){
		
		this.width = width;
		this.height = height;
		
		panel1 = new JPanel(new GridLayout(8,4));
		panel2 = new JPanel();
		
		this.setSize(width, height);
		this.setLayout(new BorderLayout());
		
		label = new JLabel[16];
		for(int i=0; i<16; i++)
			label[i] = new JLabel();
		
		num = new JLabel[10];
		for(int i=0; i<10; i++)
			num[i] = new JLabel();
		
		button = new JButton[3];
		button[0] = new JButton("Novo Mes");
		button[0].addActionListener(new ButtonListener());
		button[1] = new JButton("New Job");
		button[1].addActionListener(new ButtonListener());
		button[2] = new JButton("Atualizar");
		button[2].addActionListener(new ButtonListener());
		
		text2 = new JTextField("0");
		text3 = new JTextField("0");
		text4 = new JTextField("0");
		text5 = new JTextField("0");
		text6 = new JTextField("0");
		text7 = new JTextField("0");
		
		label[0].setText("Dinheiro acumulado total ");
		panel1.add(label[0]);
		num[0].setText("0");
		panel1.add(num[0]);
		
		label[1].setText("Meses de salário recebidos ");
		panel1.add(label[1]);
		num[9].setText("0");
		panel1.add(num[9]);
		
		label[2].setText("Fundo 10% acumulado ");
		panel1.add(label[2]);
		num[1].setText("0");
		panel1.add(num[1]);
		
		label[3].setText("Acumulado no emprego atual ");
		panel1.add(label[3]);
		num[2].setText("0");
		panel1.add(num[2]);
		
		label[4].setText("Fundo 5% acumulado ");
		panel1.add(label[4]);
		num[3].setText("0");
		panel1.add(num[3]);
		
		label[5].setText("Acumulado ate last job ");
		panel1.add(label[5]);
		panel1.add(text2);
		
		label[6].setText("Fundo total acumulado ");
		panel1.add(label[6]);
		num[4].setText("0");
		panel1.add(num[4]);
		
		label[7].setText("10% acumulado anterior ");
		panel1.add(label[7]);
		panel1.add(text3);
		
		label[8].setText("Saldo bancário total ");
		panel1.add(label[8]);
		panel1.add(text4);
		
		label[9].setText("5% acumulado anterior ");
		panel1.add(label[9]);
		panel1.add(text5);
		
		label[10].setText("Salário Atual ");
		panel1.add(label[10]);
		panel1.add(text6);
		
		label[11].setText("10% TOTAL ");
		panel1.add(label[11]);
		num[5].setText("0");
		panel1.add(num[5]);
		
		label[12].setText("Gastos do mes ");
		panel1.add(label[12]);
		panel1.add(text7);
		
		label[13].setText("5% TOTAL ");
		panel1.add(label[13]);
		num[6].setText("0");
		panel1.add(num[6]);
		
		label[14].setText("Fundo para Compras ");
		panel1.add(label[14]);
		num[7].setText("0");
		panel1.add(num[7]);
		
		label[15].setText("Funto total somado ");
		panel1.add(label[15]);
		num[8].setText("0");
		panel1.add(num[8]);
		
		panel2.add(button[0]);
		panel2.add(button[2]);
		panel2.add(button[1]);
		
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
	    	
	    	Object e = event.getSource();
	    	
	    	if(e == button[0]){
	    		count++;
	    		num[9].setText(String.valueOf(count));	//novo mes
	    	}
	    	
	    	if(e == button[2]){ //botao atualizar
	    		num[2].setText(String.valueOf(Integer.parseInt(text6.getText()) * Integer.parseInt(num[9].getText()))); //acumulado emprego atual
	    		num[0].setText(String.valueOf(Integer.parseInt(text2.getText()) + Integer.parseInt(num[2].getText()))); //dinheiro acumulado total
	    		num[1].setText(String.valueOf(Integer.parseInt(num[0].getText())/10)); //fundo 10% acumulado
	    		num[3].setText(String.valueOf(Integer.parseInt(num[0].getText())/20)); //fundo 5% acumulado
	    		num[4].setText(String.valueOf(Integer.parseInt(num[1].getText()) + Integer.parseInt(num[3].getText()))); //fundo total acumulado
	    		num[5].setText(String.valueOf(Integer.parseInt(num[1].getText()) + Integer.parseInt(text3.getText()))); //10% Total
	    		num[6].setText(String.valueOf(Integer.parseInt(num[3].getText()) + Integer.parseInt(text5.getText()))); //5% Total
	    		num[8].setText(String.valueOf(Integer.parseInt(num[5].getText()) + Integer.parseInt(num[6].getText()))); //fundo total somado
	    		num[7].setText(String.valueOf(Integer.parseInt(text4.getText()) - Integer.parseInt(num[8].getText()))); //fundo para compras
	    	}
	    	
	    	if(e == button[1]){
	    		num[1].setText("0");//fundo 10% acumulado
	    		num[3].setText("0");//fundo 5% acumulado
	    		num[4].setText("0");//fundo total acumulado
	    		num[9].setText("0");//novo mes
	    		count = 0;//novo mes
	    	}
	    	
	    }
	}	
}

