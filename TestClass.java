import java.awt.*;
import java.awt.event.*;

class Poor {
protected void finalize() throws Throwable {
    System.out.println("Hello World");
}
}



public class TestClass  
{
 
 class AjithException extends Exception
 {



 } 
 boolean Hell()
 {
   new Poor();
   return true;
 }
 public static void main( String[] ar )  
  {
        try {
     Frame xt = new Frame("PAI IS FROM ALWAYE");
     xt.setSize(200,400);       
     xt.show();
     WindowListener shaheer = new WindowAdapter() {
       public void windowClosing(WindowEvent e) 
     {
               
               System.runFinalization();
            
               System.exit(0);
     }

     };
     xt.addWindowListener(shaheer);
     throw  new TestClass(). new AjithException();
     

   }
   catch(Exception e )
   {
      System.out.println(e.getMessage());
   }
  finally  {

   System.out.println("i will be always called");
  }


   

  }
 
 class Eventer extends WindowAdapter {
     public void windowClosing(WindowEvent e) 
     {
                                     
               System.exit(0);
     }

}


protected void finalize() throws Throwable {
    System.out.println("Hello World");
}


 


}
