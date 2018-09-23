/**
 * Mark Hockensmith
 * 9/20/18
 */


import java.util.Stack;

public class PC {
	
	private int producer; //used to see prodects used by producer and consumer
	private Stack buffer2 = new Stack();//creates a stack to be used for products
	
	private PC()//default constructor is empty
	{
	}
	
	//this method checks how many products are in the stack, and if it is not full, it produces more.
	public void produce()
	{
		if(producer<= 15)
		{
			buffer2.add("product");
			producer ++;
			System.out.println("product added to buffer. buffer count is: " + producer + ".");
			try {
				Thread.sleep(100);//slows the process
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else//if stack is full
		{
			System.out.println("the stack is full, must wait for consumer.");
		}
	}
	
	//this method consumes products if there are products available in the stack
	//if the stack is empty, it starts up the producer again to create more products
	public void consume()
	{
		if(producer>=1) 
		{
			buffer2.pop();//removes a product form stack
			producer --;
			System.out.println("product consumed from buffer. buffer count is: " + producer + ".");
			try {
				Thread.sleep(100);//slows execution of program
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else//if the stack is empty
		{
			System.out.println("the stack is empty, starting producer.");
			produce();//starting producer here
		}
	}
	
	//main method. runs the program with a test PC
	public static void main(String[] args) {
		PC test = new PC();
		int i = 100;
			while (i>74)
			{
				test.produce();
				i--;
			}
			while (i>53)
			{
				test.consume();
				i--;
			}
			while (i>44)
			{
				test.produce();
				i--;
			}
			while (i>22)
			{
				test.produce();
				i--;
			}
			while (i>5)
			{
				test.produce();
				i--;
			}
			while (i>0)
			{
				test.produce();
				i--;
			}
			System.out.println("system finished");
	}

}
