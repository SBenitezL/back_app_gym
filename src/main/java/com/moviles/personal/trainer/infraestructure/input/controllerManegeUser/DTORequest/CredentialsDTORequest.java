package com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialsDTORequest {
    private String login;
    private String pass;

}
