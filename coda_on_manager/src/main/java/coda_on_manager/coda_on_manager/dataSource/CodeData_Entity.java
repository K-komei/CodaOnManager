package coda_on_manager.coda_on_manager.dataSource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//コードデータのエンティティクラス

@Entity
@Table(name="codedata")
public class CodeData_Entity {

@Column(name="ID") @Id  @GeneratedValue private Integer ID;
@Column(name="CODENAME") private String CODENAME;
@Column(name="CODEBODY") private String CODEBODY;
@Column(name="CREATE_USER_ID") private int CREATE_USER_ID;


//ここからget method
public Integer getId(){
  return ID;
}
public String getCodename(){
  return CODENAME;
}
public String getCodebody(){
    return CODEBODY;
  }
public int getCreate_user_id(){
    return CREATE_USER_ID;
  }

  //ここからset method

  public void setId(int Id){
    this.ID = Id;
  }
  public void setCodename(String Name){
    this.CODENAME = Name;
  }
  public void setCodebody(String Codebody){
    this.CODEBODY=Codebody;
    }
  public void setCreate_user_id(int Cid){
    this.CREATE_USER_ID=Cid;
    }
 
}