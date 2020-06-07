package it.academy.rent.car.booking.controller;

import it.academy.rent.car.booking.bean.AuthenticationRequestDto;
import it.academy.rent.car.booking.bean.User;
import it.academy.rent.car.booking.security.JwtTokenProvider;
import it.academy.rent.car.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/")
    public String hello() {
        return "main";
    }

    @GetMapping("/userComeIn")
    public String comeInUser(AuthenticationRequestDto requestDto) {
        return "comeInForm";
    }

    @PostMapping("/userComeIn")
    public String userComeInByForm(AuthenticationRequestDto requestDto, Model model) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());
            model.addAttribute(username);
            model.addAttribute(token);

            return "index";
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @GetMapping("/userRegistration")
    public String registrationUser(User user, Model model) {
        return "registration";
    }

    @PostMapping("/userRegistration")
    public String saveUserByForm(User user) {
        User user1 = userService.register(user);
        return "index";
    }


}
