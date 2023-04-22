package ru.skzmk.backend.general.message.realization.user.auth;


import ru.skzmk.backend.general.message.intefaces.IRequest;

public record LoginRequest(String email, String password) implements IRequest {

}
