/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single;

import boundary.AbstractFacade;
import entities.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

/**
 *
 * @author fours
 */
@Singleton
@LocalBean
@Named
public class CaheMessages {
    public List<Message> cachedMessages;
    public boolean isActual;
    
 
    
    public boolean isACtual(){
        return isActual;
    }
    
    public void reset(){
        cachedMessages.clear();
        isActual=false;
    }
    
    public void cache(List<Message> messages){
        messages.forEach(m -> cachedMessages.add(m));
        isActual=true; 
    }

    public List<Message> getCachedMessages() {
        return cachedMessages;
    }

    public void setCachedMessages(List<Message> cachedMessages) {
        this.cachedMessages = cachedMessages;
    }

    public boolean isIsActual() {
        return isActual;
    }

    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }
    
    @PostConstruct
    public void cacheList(){
        cachedMessages = new ArrayList<>();
    }
    
   
    
    
    
}
