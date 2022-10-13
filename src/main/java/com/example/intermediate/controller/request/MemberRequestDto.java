package com.example.intermediate.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {

  @NotBlank(message = "nickname은 공백일 수 없습니다.")
  @Size(min = 4,max = 12, message = "nickname은 4~12 개의 영문자만 허용합니다.")
  @Pattern(regexp = "^[a-z]*$")
  private String nickname;

  @NotBlank(message = "패스워드는 공백일 수 없습니다.")
  @Size(min = 8,max = 20, message = "패스워드는 8~20 개의 문자만 허용합니다.")
  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$", message = "패스워드는 무조건 영문, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다.")
  private String password;

  @NotBlank
  private String passwordConfirm;
}
