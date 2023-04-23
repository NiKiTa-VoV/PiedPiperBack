package ru.piedpipers.backend.general.message.realization.user.auth;


import ru.piedpipers.backend.general.message.intefaces.IRequest;

public record LoginRequest(String email, String password) implements IRequest {

}
