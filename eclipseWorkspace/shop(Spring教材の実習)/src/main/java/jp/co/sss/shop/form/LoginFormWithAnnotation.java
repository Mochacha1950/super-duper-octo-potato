package jp.co.sss.shop.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jp.co.sss.shop.util.Login;

@Login
public class LoginFormWithAnnotation {
	
	@NotNull
	@Max(value = 999)
	private Integer userId;
	
	@NotBlank
	@Size(max = 16)
	@Pattern(regexp = "^[a-zA-Z0-9!?.\\-+*]+$")
	private String userPassword;

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
