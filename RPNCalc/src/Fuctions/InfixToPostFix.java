package Fuctions;

import java.util.Stack;




public class InfixToPostFix {
	
	private String infixExpression;
	private  Stack<String> inFix = new Stack<>();
	private  Stack<String> postFix = new Stack<>();
	
	public InfixToPostFix(String Infix){
		this.infixExpression=new String(Infix);
		createInFixExpression();
		convertToPostfix();
	}
	

	
	public Stack<String> getinFixExpression(){return inFix;}
	public Stack<String> getPostFixExpression(){return postFix;}
	
	private int precedence(String op)  // * and / divide have higher precedence than + and -
	{
	 if(op.equalsIgnoreCase("+") ||op.equalsIgnoreCase("-")) return 1;
	 else if(op.equalsIgnoreCase("*") ||op.equalsIgnoreCase("/")) return 2;                      
	 else if(op.equalsIgnoreCase("^")) return 3;
	  return 0;
	}
	
	public void convertToPostfix() {
		 Stack<String> operators = new Stack<>();
		 inFix.forEach(elem -> { 
			 if(elem.equalsIgnoreCase("("))
				   operators.push(elem);
			 else if(elem.equalsIgnoreCase(")")) {
				 while(!operators.peek().equalsIgnoreCase("("))
				   {
					 postFix.push(operators.pop());
				   }
				 operators.pop();     // pop '(' from stack.
			 }
			 else if(elem.equalsIgnoreCase("+") ||elem.equalsIgnoreCase("-") ||elem.equalsIgnoreCase("*") 
					 || elem.equalsIgnoreCase("/") ||elem.equalsIgnoreCase("^") ) {
				 while(operators.size()>0  && precedence(elem) <= precedence(operators.peek()))
				   {
					 postFix.push(operators.pop());
				   }
				 operators.push(elem);
			 }else  postFix.push(elem); //operand
	       });
		 if(postFix.peek().equalsIgnoreCase(""))postFix.pop();
		 while(operators.size()>0) {
			 if(!operators.pop().equalsIgnoreCase("(")) {
				 if(!operators.pop().equalsIgnoreCase("")) {
					 postFix.push(operators.pop());
				 }
			 }
		 }
	}
	
	
	private void createInFixExpression() {
		String operand="";
		char previous='\0';
		for(int i=0;i<infixExpression.length();i++){
		    char ch=infixExpression.charAt(i);         // current character.
		    //System.out.println(ch);
		    if(Character.isDigit(ch) || ch=='.')operand=operand+ch; //re-generate operator
		    else {
		    	if(operand!="")inFix.push(operand);//push operator
		    	
		    	if(ch=='-' && previous=='\0') inFix.push("0"); //-9 -> 0-9 
		    	if(ch=='-' && previous=='(') inFix.push("0");  //(-9 -> (0-9 
		    	if(ch=='+' && previous=='\0') inFix.push("0"); //+9 -> 0+9
		    	if(ch=='+' && previous=='(') inFix.push("0");  //(+9 -> (0+9
		    	
		    	inFix.push(Character.toString(ch));//push operator
		    	operand="";
		        
		    }
		    previous=ch;
		   }
		inFix.push(operand); //finally add the last operand
		
	}
	
	
	
	public void print_infix() {
		 System.out.println("infix:"+inFix);
	}
	public void print_postfix() {
		 System.out.println("postfix:"+postFix);

	}
}