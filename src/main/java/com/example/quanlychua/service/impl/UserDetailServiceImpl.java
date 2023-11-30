package com.example.quanlychua.service.impl;

import com.example.quanlychua.entity.PhatTu;
import com.example.quanlychua.jwt.JwtService;
import com.example.quanlychua.model.UserCustomDetails;
import com.example.quanlychua.repository.PhatTuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PhatTuRepository phatTuRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PhatTu> phatTu = phatTuRepository.findByTenTaiKhoan(username);
        return new UserCustomDetails(phatTu.get());
    }
}
