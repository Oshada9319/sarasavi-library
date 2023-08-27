package com.sarasavi.nansala.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sarasavi.nansala.model.AuthenticationRequest;
import com.sarasavi.nansala.model.AuthenticationResponse;
import com.sarasavi.nansala.model.Book;
import com.sarasavi.nansala.model.RegisterRequest;
import com.sarasavi.nansala.service.AuthenticationService;
import com.sarasavi.nansala.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
