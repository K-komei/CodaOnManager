package coda_on_manager.coda_on_manager;
import java.io.Serializable;

@SuppressWarnings("serial")

public class Code_send implements Serializable{
    
    //Webフォームより入力されたコードを格納する。
    private String code_text;

    //格納されたcode_textを返す
	public String getCode() {
		return code_text;
    }
    
    //code_textに値を格納する
	public void setCode(final String code) {
		this.code_text = code;
    }
    
    //code_textを初期化する。
    public void resetCode() {
		this.code_text = "";
    }

    
}