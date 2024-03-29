package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.example.config.JwtProvider;
import com.example.exception.UserException;
<<<<<<< HEAD
import com.example.model.Cart;
=======
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.request.LoginRequest;
import com.example.response.AuthResponse;
<<<<<<< HEAD
import com.example.service.CartService;
=======
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
import com.example.service.CustomUserServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {
<<<<<<< HEAD

=======
	
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private CustomUserServiceImplementation customUserService;
<<<<<<< HEAD
	private CartService cartService;

	public AuthController(UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder,
			CustomUserServiceImplementation customUserService, CartService cartService) {
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
		this.passwordEncoder = passwordEncoder;
		this.customUserService = customUserService;
		this.cartService=cartService;
	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		

		User isEmailExist = userRepository.findByEmail(email);

		if (isEmailExist != null) {
			throw new UserException("Email Is Already Used With Another Account");
		}

		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);

		User savedUser = userRepository.save(createdUser);
		System.out.println(savedUser);
		Cart cart=cartService.createCart(savedUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
				savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse(token, token);
		authResponse.setJwt(token);
		authResponse.setMessage("Signup Success");

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);

	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {
		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		Authentication authentication = authenticate(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse(token, token);

		authResponse.setJwt(token);
		authResponse.setMessage("Signin Success");

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserService.loadUserByUsername(username);

		if (userDetails == null) {
			throw new BadCredentialsException("Invalid Username...");
		}

		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password...");
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
=======
	
	public AuthController(UserRepository userRepository,JwtProvider jwtProvider,PasswordEncoder passwordEncoder,CustomUserServiceImplementation customUserService) {
		this.userRepository=userRepository;
		this.jwtProvider=jwtProvider;
		this.passwordEncoder=passwordEncoder;
		this.customUserService=customUserService;
	}
	
	
	
	
	@PostMapping("/signup")
    public ResponseEntity<AuthResponse>createUserHandler(@RequestBody User user)throws UserException{
    	String email=user.getEmail();
    	String password=user.getPassword();
    	String firstName=user.getFirstName();
    	String lastName=user.getLastName();
    	
    	User isEmailExist=userRepository.findByEmail(email);
    	
    	if(isEmailExist!=null) {
    		throw new UserException("Email Is Already Used With Another Account");
    	}
    	
    	User createdUser=new User();
    	createdUser.setEmail(email);
    	createdUser.setPassword(passwordEncoder.encode(password));
    	createdUser.setFirstName(firstName);
    	createdUser.setLastName(lastName);
    	
    	User savedUser=userRepository.save(createdUser);
    	
    	Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	
    	String token = jwtProvider.generateToken(authentication);
    	
    	AuthResponse authResponse = new AuthResponse(token, token);
    	authResponse.setJwt(token);
    	authResponse.setMessage("Signup Success");
    	
    	return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.CREATED);
    	
    }
	
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse>loginUserHandler(@RequestBody LoginRequest loginRequest){
		String username=loginRequest.getEmail();
		String password=loginRequest.getPassword();
		
		Authentication authentication = authenticate(username,password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
        String token = jwtProvider.generateToken(authentication);
    	
    	AuthResponse authResponse = new AuthResponse(token, token);
    	
    	authResponse.setJwt(token);
    	authResponse.setMessage("Signin Success");
    	
    	return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.CREATED);
	}


	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserService.loadUserByUsername(username);
		
		if(userDetails==null) {
			throw new BadCredentialsException("Invalid Username...");
		}
		
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password...");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
>>>>>>> b85a357c66aeb8ae99b89a940ff6945a4067f389
	}
}
