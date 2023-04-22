package ru.skzmk.backend.general.message.model.responsemessage;


import ru.skzmk.backend.general.message.intefaces.IResponseMessage;

public record FieldResponseMessage(String fieldName, String localizedFieldName, String message) implements IResponseMessage {
}
