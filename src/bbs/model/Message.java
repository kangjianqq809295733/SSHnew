package bbs.model;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_message")

public class Message  implements java.io.Serializable {


    // Fields    

     private Integer messageId;
     private User user;
     private String messageTitle;
     private String messageContent;
     private Timestamp messageDate;


    // Constructors

    /** default constructor */
    public Message() {
    }

    
    /** full constructor */
    public Message(User user, String messageTitle, String messageContent, Timestamp messageDate) {
        this.user = user;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.messageDate = messageDate;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="message_id", unique=true, nullable=false)

    public Integer getMessageId() {
        return this.messageId;
    }
    
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="user_id")

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="message_title", length=100)

    public String getMessageTitle() {
        return this.messageTitle;
    }
    
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }
    
    @Column(name="message_content", length=100)

    public String getMessageContent() {
        return this.messageContent;
    }
    
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    
    @Column(name="message_date", length=19, updatable=false)

    public Timestamp getMessageDate() {
        return this.messageDate;
    }
    
    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }
   








}