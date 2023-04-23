package ru.piedpipers.backend.general.message.model.responsemessage;

import ru.piedpipers.backend.general.message.intefaces.IResponseMessage;

public record ResponseMessage(String message) implements IResponseMessage {
}
