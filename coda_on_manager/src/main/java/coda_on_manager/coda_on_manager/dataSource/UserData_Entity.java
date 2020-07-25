package coda_on_manager.coda_on_manager.dataSource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//ユーザーデータのエンティティクラス

@Entity
@Table(name="user_info")
public class UserData_Entity {

@Column(name="ID") @Id @GeneratedValue private Integer ID;
@Column(name="USER_NAME") private String USER_NAME;
@Column(name="MAIL") private String MAIL;
@Column(name="PASSWORD") private String PASSWORD;
@Column(name="SECRET_QUESTION") private String SECRET_QUESTION;

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

  //ここからset method

  public void setId(int Id){
    this.ID = Id;
  }
  public void setName(String Name){
    this.USER_NAME = Name;
  }
  public void setMail(String Mail){
    this.MAIL=Mail;
    }
  public void setPass(String Pass){
    this.PASSWORD=Pass;
    }
  public void setSecret(String Secret){
    this.SECRET_QUESTION=Secret;
    }
 
}