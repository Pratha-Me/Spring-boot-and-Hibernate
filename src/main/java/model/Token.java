/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;

public class Token {

	String key = "980987876645765433";
	String userId, userName, userType;
	boolean status;

	public Token() {
	}

	public Token(String Authorization) {
		status = false;
		try {
			String token = Authorization.substring(7);
			Claims cl = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			status = true;
			userId = cl.getId();
			userName = cl.getSubject();
			userType = cl.getAudience();

		} catch (Exception e) {
			setUserId(""); 
			setUserName("");
			setUserType("");

		}

	}

	public String get(String userId, String userName, String userType) {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, 1);
		Date expDate = c.getTime();
		String token = Jwts.builder()
			.setId(userId)
			.setSubject(userName)
			.setAudience(userType)
			.claim("roles", "user")
			.setIssuedAt(d)
			.setExpiration(expDate)
			.signWith(SignatureAlgorithm.HS256, key).compact();
		return token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isValid() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
