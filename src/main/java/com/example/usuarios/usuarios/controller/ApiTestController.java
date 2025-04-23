package com.example.usuarios.usuarios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ApiTestController {

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String apiBaseUrl = "http://localhost:5000/api";

    @GetMapping("/api-test")
    public String mostrarFormularioApiTest() {
        return "api-test"; // nombre del HTML en templates
    }
    @PostMapping("/api-test")
    public String consumirApi(@RequestParam String tipo, Model model) {
        return "api-test";
    }
}