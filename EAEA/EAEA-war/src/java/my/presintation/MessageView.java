/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presintation;

import boundary.MessageFacade;
import entities.Message;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import single.CaheMessages;
import statefullCounter.StatefullCounter;

@Named(value = "messageView")
@SessionScoped
public class MessageView implements Serializable {

    @EJB
    private MessageFacade messageFacade;

    @EJB
    private StatefullCounter counter;

    @EJB
    private CaheMessages cacheMessages;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new Message();
    }

    // Creates a new field
    private Message message;

    // Calls getMessage to retrieve the message
    public Message getMessage() {

        return message;
    }

    // Returns the total number of messages
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }

    public int getNumberOfMessagesSession() {
        return counter.getCount();
    }

    // Saves the message and then returns the string "theend"
    public String postMessage() {
        cacheMessages.reset(); //reset cache
        message.setId(Long.valueOf(0));
        this.messageFacade.create(message);
        counter.count(); //count msg in session
        return "theend";

    }

    public List<Message> getAllMessages() {
        if (cacheMessages.isACtual()) {
            System.out.print("Кэшировано");
            return cacheMessages.getCachedMessages();         
        } else {
            List<Message> tmpmsg = messageFacade.findAll();
            cacheMessages.cache(tmpmsg);
            System.out.print("Не кэшировано"); 
            return tmpmsg;
        }

    }

    /*  public List<Message> getAllMessages() {
        if (cacheMessages.isActual) { 
            return cacheMessages.cachedMessages;
        } else {
            System.out.print("Не кешируется");
            return messageFacade.findAll();
        }

    } */
}
