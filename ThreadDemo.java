import java.lang.*;
import java.io.*;

class MyThread extends Thread 
{
   volatile boolean running=true;
   int io=0;
   public void run()
   {
     
     while (running )
     {
        try {
        System.out.println("From Worker thread");     
        synchronized(this) {
        wait();
        } 

        io++;

        if ( io == 7 ) {
            return;
        }
      
        }
        catch(Exception e )
        {
  
          System.out.println("Exception From Worker");
          return;
        }
    
     }

   }
   public void StopThread()
   {
    running = false;
   }

}



class ThreadDemo  
{

  public static  void main(String[] ar )
  {
     MyThread st = new MyThread();
     st.start();

     for( int i=0; i<10; ++i )
     {
          try { 
          System.out.println("From Main thread");   
         
            st.notify();
          
          }
          catch(Exception e )
          {
            System.out.println("Exception From main" + e.getMessage());
            break;
          }
     }
     try {
     st.join();
     }
     catch(Exception e)
     {
        
 
     }
     st.StopThread();     
 

   }




}
 

