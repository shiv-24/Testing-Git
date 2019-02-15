package codingPractice.gfg;

import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		Stack<Integer>input	=	new Stack<Integer>();
		input.push(23);
		input.push(23);
		input.push(21);
		input.push(20);
		input.push(2);
		Stack<Integer> s	=	sortStack(input);
		
		while(!s.isEmpty()) {
			System.out.println(s.peek());
			s.pop();
		}
	}
	
	static Stack<Integer> sortStack(Stack<Integer> items) {
		
		Stack<Integer> temp	=	new Stack<>();
		

		int fNumber	=	items.pop();
		temp.add(fNumber);
		
		while(!items.isEmpty()) {
			
			int sNumber	=	items.peek();
			int tempTop	=	temp.peek();
			
			while(temp.size()!=0 && sNumber>tempTop) {
				items.push(tempTop);
				temp.pop();
				if(temp.size()!=0)
				tempTop	=	temp.peek();
			}
			
			temp.push(sNumber);
			
			while(items.peek()!=sNumber) {
				temp.push(items.pop());
			}
			items.pop();
		}
		
		items	=	temp;
		return items;
	}
}
