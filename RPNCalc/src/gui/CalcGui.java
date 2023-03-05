package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import Fuctions.*;

public class CalcGui extends JFrame {

		private static final long serialVersionUID = 1L;
		protected static JTextField calcLabel=new JTextField(""); 
		static int width;
		static int height;
		static JPanel calpanel=new JPanel();
		
		public CalcGui(int width, int height) {
			CalcGui.width=width;
			CalcGui.height=height;
			this.setSize(width, height);	
			this.setTitle("[ECE_Y325] Week9");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
			this.setLayout(new BorderLayout());
	    	this.add(calcLabel,BorderLayout.NORTH);
	    	this.add(centerpanel(),BorderLayout.CENTER);
			this.setLocationRelativeTo(null); 		
			this.setFocusable(true);
			setResizable(false);
			this.setVisible(true); 	
			this.setBackground(Color.RED);
		}
		
		 private JPanel centerpanel() {
			 Color clr1=new Color(245,190,190);
			 Color clr2=new Color(240,220,220);
			 Color clr3=new Color(250,180,57);
			 Font font=new Font("Courier",Font.PLAIN,18);
			 JButton ClearB= new JButton("C");
			 ClearB.setBackground(clr1);
			 ClearB.setFont(font);
			 JButton RparenthesisB= new JButton(")");
			 RparenthesisB.setBackground(clr1);
			 RparenthesisB.setFont(font);
			 JButton LparenthesisB= new JButton("(");
			 LparenthesisB.setBackground(clr1);
			 LparenthesisB.setFont(font);
			 JButton DivB= new JButton("/");
			 DivB.setBackground(clr1);
			 DivB.setFont(font);
			 JButton MultB= new JButton("*");
			 MultB.setBackground(clr1);
			 MultB.setFont(font);
			 JButton MinusB= new JButton("-");
			 MinusB.setBackground(clr1);
			 MinusB.setFont(font);
			 JButton PlusB= new JButton("+");
			 PlusB.setBackground(clr1);
			 PlusB.setFont(font);
			 JButton EqualsB= new JButton("=");
			 EqualsB.setBackground(clr3);
			 EqualsB.setFont(font);
			 JButton dotB= new JButton(".");
			 dotB.setBackground(clr2);
			 dotB.setFont(font);
			 JButton PowerB= new JButton("^");
			 PowerB.setBackground(clr2);
			 PowerB.setFont(font);
			 JButton num0= new JButton("0");
			 num0.setBackground(clr2);
			 num0.setFont(font);
			 JButton num1= new JButton("1");
			 num1.setBackground(clr2);
			 num1.setFont(font);
			 JButton num2= new JButton("2");
			 num2.setBackground(clr2);
			 num2.setFont(font);
			 JButton num3= new JButton("3");
			 num3.setBackground(clr2);
			 num3.setFont(font);
			 JButton num4= new JButton("4");
			 num4.setBackground(clr2);
			 num4.setFont(font);
			 JButton num5= new JButton("5");
			 num5.setBackground(clr2);
			 num5.setFont(font);
			 JButton num6= new JButton("6");
			 num6.setBackground(clr2);
			 num6.setFont(font);
			 JButton num7= new JButton("7");
			 num7.setBackground(clr2);
			 num7.setFont(font);
			 JButton num8= new JButton("8");
			 num8.setBackground(clr2);
			 num8.setFont(font);
			 JButton num9= new JButton("9");
			 num9.setBackground(clr2);
			 num9.setFont(font);

			 
			 ClearB.addActionListener(new Handler());
			 RparenthesisB.addActionListener(new Handler());
			 LparenthesisB.addActionListener(new Handler());
			 DivB.addActionListener(new Handler());
			 MultB.addActionListener(new Handler());
			 MinusB.addActionListener(new Handler());
			 PlusB.addActionListener(new Handler());
			 EqualsB.addActionListener(new Handler());
			 dotB.addActionListener(new Handler());		 
			 PowerB.addActionListener(new Handler());
			 num0.addActionListener(new Handler());
			 num1.addActionListener(new Handler());
			 num2.addActionListener(new Handler());
			 num3.addActionListener(new Handler());
			 num4.addActionListener(new Handler());
			 num5.addActionListener(new Handler());
			 num6.addActionListener(new Handler());
			 num7.addActionListener(new Handler());
			 num8.addActionListener(new Handler());
			 num9.addActionListener(new Handler());
			 
			 JPanel cpanel=new JPanel();
			 cpanel.setLayout(new GridLayout(5,4));
			 cpanel.setBackground(new java.awt.Color(245,168,168));
			 cpanel.add(ClearB);
			 cpanel.add(LparenthesisB);
			 cpanel.add(RparenthesisB);
			 cpanel.add(DivB);
			 
			 cpanel.add(num7);
			 cpanel.add(num8);
			 cpanel.add(num9);
			 cpanel.add(MultB);
			 
			 cpanel.add(num4);
			 cpanel.add(num5);
			 cpanel.add(num6);
			 cpanel.add(MinusB);
			 
			 cpanel.add(num1);
			 cpanel.add(num2);
			 cpanel.add(num3);
			 cpanel.add(PlusB);
			 
			 cpanel.add(num0);
			 cpanel.add(dotB);
			 cpanel.add(PowerB);
			 cpanel.add(EqualsB);
			
			 return cpanel;
		 }
		 private class Handler implements ActionListener{

			 public void actionPerformed(ActionEvent event) {
				String btnaction;
				JButton btn= (JButton) event.getSource();
				btnaction=btn.getText();
				if(btnaction.equalsIgnoreCase("C"))cleartext();
				else if(btnaction.equalsIgnoreCase("="))calculate();
				else appendLabel(btnaction);
				 
			 }
		 }
		 
		 protected static void cleartext() {
			 calcLabel.setText("");
		 }
		 protected void calculate() {
				String infixExpression=calcLabel.getText();
				
				InfixToPostFix v=new InfixToPostFix(infixExpression);
				v.print_infix();
				v.print_postfix();
				
				cleartext();
		 }
		 protected static void appendLabel(String action) {
			 Font font=new Font("Courier",Font.BOLD,18);
			 calcLabel.setFont(font);
			 String tmp=calcLabel.getText();
			 tmp+=action;
			 calcLabel.setText(tmp);
			 
		 }
	}

