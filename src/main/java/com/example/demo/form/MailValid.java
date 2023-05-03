package com.example.demo.form;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import jakarta.validation.Constraint;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Documented
//@Target()
///*↑どこにアノテーションを付けたいかを指定する。
// * Patternの定義を見てみると、ターゲットが絞られていたのでそれを利用する。
// * →今回は使わなくてよかった！*/
@Retention(RUNTIME)
/*↑コンパイラ時に無視させるか否かを決定する。デフォは無視。
 * RUNTIMEにすると読み取りされる。 */
@ReportAsSingleViolation
/*↑これがないと主で使いたいアノテーションのエラーメッセージが出る。
 * 今回は@Patternだから使わない場合に@Patternのエラーが出ちゃう。*/
@Constraint(validatedBy={})
/*↑制約。メッセージ出すときに必要。
 * ないとmessage = をオーバーライドできない。*/
@Pattern(regexp="^([\\w])+([\\w\\._\\-])*@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$")
/*↑パターンの表記。
 * \\w =  [_a-zA-Z0-9] 、^→直前の文字が行の先頭にある場合にマッチ */
@NotNull(message = "メールアドレスが違います。")
@NotBlank(message = "空白文字は使えません。")
public @interface MailValid {
}
