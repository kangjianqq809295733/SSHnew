package bbs.model;
// default package

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_user")

public class User  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String userName;
     private String userPassword;
     private Boolean userAccess;
     private List<Message> messages = new ArrayList<Message>();


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String userName, String userPassword, Boolean userAccess, List<Message> messages) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAccess = userAccess;
        this.messages = messages;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="user_id", unique=true, nullable=false)

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    @Column(name="user_name", length=10)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="user_password", length=10)

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Column(name="user_access")

    public Boolean getUserAccess() {
        return this.userAccess;
    }
    
    public void setUserAccess(Boolean userAccess) {
        this.userAccess = userAccess;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")

    public List<Message> getMessages() {
        return this.messages;
    }
    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
   








}