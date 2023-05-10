package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterForm{
	
	@Pattern(regexp="^([\\w])+([\\w\\._\\-])*@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$",
			message = "正しいメールアドレスを入力してください。")
	@NotBlank(message = "メールアドレスが未入力です。")//OK
	private String mail;
	
	private Date birth;
	
	@Pattern(regexp="^([\\w\\._\\-\\+])*$",
			message ="入力できない文字があります。")
	@NotBlank(message = "パスワードが未入力です。")//OK
	@Size(min = 6, max = 12, message = "パスワードは6～12文字です。")
	private String pass;
}
