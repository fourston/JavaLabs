/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statefullCounter;

import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author fours
 */
@Stateful
public class Impl implements StatefullCounter, Serializable{
    
      private int counter;
    
    @Override
    public void count() {
        System.out.println("=========== NewSessionBean.count invocation________" + this);
        counter++;
        System.out.println("count = " + counter);
    }
    
    @Override
    public int getCount() {
        System.out.println("=========== NewSessionBean.getCount invocation________" + this);
        System.out.println("count = " + counter);
        return counter;
    }
    
    
}
