package coda_on_manager.coda_on_manager;

import javax.validation.constraints.NotBlank;

public class UserData {
  private Long id;

  @NotBlank(message = "ユーザー名を記入してください。")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}