package com.Spring_project.Keycloackuser.frontend;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class login {
    private final RestTemplate restTemplate;
    private  ObjectMapper objectMapper;

    public login(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @PostMapping("/submit")
    public String handleSubmit(@RequestParam String username, @RequestParam String password){
         String url = "http://localhost:8080/realms/SpringBootKeycloak/protocol/openid-connect/token";

         MultiValueMap<String, String> bodyParams = new LinkedMultiValueMap<>();
        bodyParams.add("grant_type", "password");
        bodyParams.add("client_id", "login-app");
        bodyParams.add("username", username);
        bodyParams.add("password", password);
         HttpEntity<String> entity = new HttpEntity<>(bodyParams);
        String access_token="";
        // Make the HTTP request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,  String.class);
        String responseBody = response.getBody();
        try {
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            access_token= jsonNode.get("access_token").asText();


      
        } catch (Exception e) {
            // Handle the parsing exception
            e.printStackTrace();
            return null;
        }

        // model.addAttribute("accessToken", access_token);

        // Return the template name
        return "token";
    }
}
