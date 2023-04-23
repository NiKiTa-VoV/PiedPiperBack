package ru.piedpipers.backend.general.message.model.wrapper;

import lombok.Data;
import ru.piedpipers.backend.general.message.intefaces.IResponseMessage;
import ru.piedpipers.backend.general.util.util.CollectionUtil;

import java.util.Arrays;
import java.util.List;

@Data
public class MessageWrapper<R> {
    private final R response;
    private final List<IResponseMessage> messages;

    public MessageWrapper(R response, List<IResponseMessage> messages) {
        this.response = response;
        this.messages = messages;
        CollectionUtil.clearOfNull(this.messages);
    }

    public MessageWrapper(R response, IResponseMessage... messages) {
        this.response = response;
        this.messages = Arrays.asList(messages);
        CollectionUtil.clearOfNull(this.messages);
    }

    public static <R> MessageWrapper<R> create(R response, List<IResponseMessage> messages) {
        return new MessageWrapper<>(response, messages);
    }

    public static <R> MessageWrapper<R> create(R response, IResponseMessage... messages) {
        return new MessageWrapper<>(response, messages);
    }
}
