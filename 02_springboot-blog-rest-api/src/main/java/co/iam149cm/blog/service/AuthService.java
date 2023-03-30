package co.iam149cm.blog.service;

import co.iam149cm.blog.payload.LoginDto;
import co.iam149cm.blog.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
