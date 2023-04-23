package ru.piedpipers.backend.general.message.model.wrapper;


import ru.piedpipers.backend.general.message.intefaces.IResponseMessage;

import java.util.Collection;
import java.util.List;

public class CollectionMessageWrapper<R> extends MessageWrapper<Collection<R>> {
    public CollectionMessageWrapper(Collection<R> response, List<IResponseMessage> messages) {
        super(response, messages);
    }
}
