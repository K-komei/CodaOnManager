package coda_on_manager.coda_on_manager.dataSource;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//ユーザーデータのエンティティクラス

@Entity
@Table(name="user_info")
public class UserData_Entity {
@Id
private Integer ID;

private String USER_NAME;
private String MAIL;
private String PASSWORD;
private String SECRET_QUESTION;
private Date CREATED;
private Date MODIFIED;

//ここからget method
public Integer getId(){
  return ID;
}
public String getName(){
  return USER_NAME;
}
public String getMail(){
    return MAIL;
  }
public String getPass(){
    return PASSWORD;
  }
public String getSecret(){
    return SECRET_QUESTION;
  }
public Date getCreated(){
   return CREATED;
}
public Date getModified(){
    return MODIFIED;
  }

  //ここからset method

  public void setId(int id){
    this.ID = id;
  }
  public void setName(String name){
    this.USER_NAME = name;
  }
  public void setMail(String mail){
    this.MAIL=mail;
    }
  public void setPass(String pass){
    this.PASSWORD=pass;
    }
  public void setSecret(String secret){
    this.SECRET_QUESTION=secret;
    }
  public void setCreated(Date created){
    this.CREATED = created;
  }
  public void setModified(Date modified){
    this.MODIFIED = modified;
  }
}