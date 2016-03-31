/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statefullCounter;

import javax.ejb.Local;

/**
 *
 * @author fours
 */
@Local
public interface StatefullCounter {
     void count();

    int getCount();
}
