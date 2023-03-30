package co.iam149cm.blog.service;

import co.iam149cm.blog.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
