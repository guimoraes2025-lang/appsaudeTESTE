package com.br.appSaude.modules.auth.dto;

public record LoginResponse(String token, UsuarioAutenticadoResponse usuario) {}
