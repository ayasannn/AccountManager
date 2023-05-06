package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertForm {

	@Pattern(regexp="^([\\w])+([\\w\\._\\-])*@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$",
			message = "正しいメールアドレスを入力してください。")
	@NotBlank(message = "メールアドレスは未入力です。")//OK
	private String mail;
	
	@Pattern(regexp="^([\\w\\._\\-\\+])*$",
			message ="入力できない文字があります。")
	@NotBlank(message = "パスワードは未入力です。")//OK
	@Size(min = 6, max = 12, message = "パスワードは6～12文字です。")
	private String pass;
}
