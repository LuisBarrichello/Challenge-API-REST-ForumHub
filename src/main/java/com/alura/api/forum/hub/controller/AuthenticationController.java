package com.alura.api.forum.hub.controller;

import com.alura.api.forum.hub.domain.user.User;
import com.alura.api.forum.hub.domain.user.UserAuthenticationDTO;
import com.alura.api.forum.hub.infra.security.TokenJWTDTO;
import com.alura.api.forum.hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity Login(@RequestBody @Valid UserAuthenticationDTO userAuthenticationDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(userAuthenticationDTO.login(), userAuthenticationDTO.password());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
    }
}
