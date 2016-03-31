package entities;

import entities.Author;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-31T19:41:16")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Author> author;
    public static volatile SingularAttribute<Message, Long> id;
    public static volatile SingularAttribute<Message, String> message;

}