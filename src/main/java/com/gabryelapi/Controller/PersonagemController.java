package com.gabryelapi.Controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabryelapi.model.Personagem;
import com.gabryelapi.model.Casas;
import com.gabryelapi.model.Resposta;
import com.gabryelapi.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api")
@JsonIgnoreProperties
public class PersonagemController {
    @Value("${api_key}") private String api_key;
    
    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping("/personagem")
    public List<Personagem> listarPersonagens() {
            return personagemRepository.findAll();
    }

    @GetMapping("/personagem/{house}")
    public List<Personagem> findByhouse(@PathVariable(value = "house") String house) {
        return personagemRepository.findByhouse(house);
    }

    @PostMapping("/personagem")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity cadastrar(@RequestBody Personagem personagem){
        if (!this.validarCasa(personagem.getHouse())) {
            Resposta resposta = new Resposta();
            resposta.setMensagem("Casa informada não encontrada ou chave de acesso inválida!");

            return new ResponseEntity<Resposta>(resposta, HttpStatus.NOT_FOUND);
        }
        personagemRepository.save(personagem);
        return new ResponseEntity<Personagem>(personagem, HttpStatus.OK);
    }

    @DeleteMapping("/personagem")
    public ResponseEntity delete(@RequestBody Personagem personagem){
        try {
            personagemRepository.delete(personagem);
            return new ResponseEntity<Personagem>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Personagem>(personagem, HttpStatus.BAD_REQUEST);
        }
    }


    private Boolean validarCasa(String idCasa){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", api_key);

        HttpEntity entity = new HttpEntity(headers);
        Long resultado = new Long(0);

        try {


        ResponseEntity<JsonNode> response = restTemplate.exchange(
                "http://us-central1-rh-challenges.cloudfunctions.net/potterApi/houses",
                HttpMethod.GET,
                entity,
                JsonNode.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        Casas[] listaCasas = objectMapper.convertValue(response.getBody().get("houses"), Casas[].class);

        resultado = Arrays.stream(listaCasas).filter(casa -> casa.getId().equals(idCasa)).count();
        } catch (Exception e){
            return Boolean.FALSE;
        }

        return resultado > 0;
    }

}
