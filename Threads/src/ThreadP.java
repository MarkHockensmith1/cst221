/**
 * Mark Hockensmith
 * Semaphores and monitors
 * some code ideas from https://www.geeksforgeeks.org/semaphore-in-java/
 */


import java.util.concurrent.*;

public class ThreadP extends Thread {
	
	    Semaphore sem; 
	    String tName; 
	    public ThreadP(Semaphore sem, String tName)  
	    { 
	        super(); 
	        this.sem = sem; 
	        this.tName = tName; 
	    }
	    
	    @Override
	    public void run()
	    {
	    	System.out.println("running");
	    	if(this.tName.equals("thrd1"))
	    	{
	    		System.out.println("starting thread 1");
			    try 
			    {
			    	int i = 25;
			    	while(i>=0)
			    	{
				    	System.out.println("in thread 1, i = " + i);
						sem.acquire();
						Thread.sleep(1);
						i--;
			    	}
				} 
			    catch (InterruptedException e) 
			    {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    sem.release();
	    	}
	    	else if(this.tName.equals("thred2"))
	    	{
	    		System.out.println("starting thread 2");
	    		try 
			    {
	    			int i = 25;
			    	while(i>=0)
			    	{
				    	System.out.println("in thread 2, i= " + i);
						sem.acquire();
						Thread.sleep(1);
						i--;
			    	}
				} 
			    catch (InterruptedException e) 
			    {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    sem.release();
	    	}
	    	else {
	    		System.out.println("Error: misspelled name");
	    	}
	    	
	    
	    }

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		Semaphore sem = new Semaphore(1);
		ThreadP thrd = new ThreadP(sem, "thrd1");
		ThreadP thrd2 = new ThreadP(sem, "thred2");
		thrd.start();
		thrd2.start();
		thrd.join();
		thrd2.join();
		System.out.println("Main method running");
	}

}
