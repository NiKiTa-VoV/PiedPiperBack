package ru.skzmk.backend.general.message.model.responsemessage;

import ru.skzmk.backend.general.message.intefaces.IResponseMessage;

public record ResponseMessage(String message) implements IResponseMessage {
}
