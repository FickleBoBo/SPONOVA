package com.gens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gens.dto.user.User;
import com.gens.service.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/newsports")
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// 로그인: 게시글 검색을 참고함
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String userID, @RequestParam String userPW, HttpServletRequest request){
		User user = userService.login(userID, userPW);
		
		// 로그인 정보가 없는 경우
		if (user == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
	    }
		// 로그인 가능
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//		return ResponseEntity.ok(user); // 아래 주석 참조
		HttpSession session = request.getSession();
	    session.setAttribute("user", user);
	    return ResponseEntity.ok(user);
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	    return ResponseEntity.ok().build();
//		return ResponseEntity.ok().build(); // 간단하게 설명하자면, 작업이 성공적으로 완료되었지만, 특별히 반환할 데이터가 없는 경우
	}
	// ok() : Http 상태 코드 200과 함께 responeEntity 객체 생성
	// ok().build(): 본문이 없는 응답 생성
	// ok(T body) : T는 응답 본문에 포함될 데이터 타입 + 응답 본문에 body를 포함하여 응답 생성
	
	
	
	// 회원가입 : 게시글 작성을 참고함
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody User user){
		if (userService.existsById(user.getUserID())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("UserID already exists.");
	    }
		userService.signup(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	
}
