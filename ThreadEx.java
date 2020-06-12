import java.lang.*;

class MyThread extends Thread
{
   private boolean running =true;

   public void run()
   {
     String fool = "  "; 
     while ( running )
     {
         try {
            System.out.println("From Worker Thread");
            synchronized(fool) 
            { 
            wait();
            }
         }
         catch( Exception e )
         {

         } 
      }
   }

   public void StopThread()
   {
          running = false;
    } 

}


class ThreadEx 
{

public static void main(String[] ar )
 {
    MyThread er = new MyThread();  
    er.start();
    try {
             er.sleep(200);
           }
           catch(Exception e )
           {


            }

    
    for( int i = 0; i<10; ++i )
    {
          try {
              System.out.println("Before Notify");
              er.notify();
              System.out.println("After Notify");
           }
           catch(Exception e )
           {


            }


     }      
 }




}