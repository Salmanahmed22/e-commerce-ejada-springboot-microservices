package org.codewithsoly.shopservice.service;

import jakarta.transaction.Transactional;
import org.codewithsoly.shopservice.Dto.UserDto;
import org.codewithsoly.shopservice.feign.WalletInterface;
import org.codewithsoly.shopservice.model.User;
import org.codewithsoly.shopservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private WalletInterface walletInterface;
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
    @Transactional
    public Map<String, Object> registerUser(UserDto userDto) {
        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setName(userDto.getName());
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        newUser.setRole(userDto.getRole());
        userRepo.save(newUser);
        System.out.println("user created: "+newUser);
        walletInterface.create(newUser.getId());
        System.out.println("wallet created: ");
        String token = jwtService.generateToken(newUser.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", newUser);

        return response;
    }

    public Map<String, Object> loginUser(User user) {
        User foundUser = userRepo.findByEmail(user.getEmail()).orElse(null);
        if (foundUser == null || !bCryptPasswordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return null;
        }
        String token = jwtService.generateToken(foundUser.getId());
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", foundUser);
        return response;
    }

}
