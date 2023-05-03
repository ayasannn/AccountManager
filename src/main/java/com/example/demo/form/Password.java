package com.example.demo.form;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import jakarta.validation.Constraint;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Documented
@Retention(RUNTIME)
@ReportAsSingleViolation
@Constraint(validatedBy={})
@Pattern(regexp="^([\\w\\._\\-\\+]))+{6,12}$")
@NotNull(message = "パスワードは必須です。")
@Size(min = 6, max = 12)
//↑String型の対象物に付けるなら最小が6文字、最大が12文字という制限。
public @interface Password {
}
