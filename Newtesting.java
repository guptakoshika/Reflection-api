package reflectionapi;
/*
  * this is an example of reflection api in java 8.
  * in this example I am calling the System class constructor which is private by default.
*/
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Newtesting {
    public static void main(String[] args){
        try{
            
           /*
            *to get class constructors use Constructor , 
            *for methods use Method and 
            *for data members we can use fields
            */
           
             Constructor constructor = System.class.getDeclaredConstructor(new Class[0]);
             /*
             *by default for private modifier the accessibilty is false .
             */
             constructor.setAccessible(true);
             /*
                the above statement will change the accessibilty on runtime of the class.
             */
             System systemObj = (System) constructor.newInstance(new Object[0]);
             /* 
             *make the Object of that class using the newInstance method. 
             *this will call the constructor of the class
             *now this object can be used to call any private or public method of that class.
             */
             System.out.println(systemObj);
        }
       catch(IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e)
       {
           System.err.println(e);
       }
    }
}
