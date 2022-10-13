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

  @NotBlank
  @NonNull
  @Size(min = 4,max = 12)
  @Pattern(regexp = "^[a-z]*$")
  private String nickname;

  @NotBlank
  @NonNull
  @Size(min = 8,max = 20)
  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]$")
  private String password;

  @NotBlank
  private String passwordConfirm;
}
