package ru.skzmk.backend.general.data.action.realization;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.data.action.ActionResultType;
import ru.skzmk.backend.general.message.intefaces.IResponseMessage;

public class RepositoryActionResult<E extends IEntity<?>> extends ActionResult<E> {
    public RepositoryActionResult(E data, ActionResultType type, IResponseMessage... messages) {
        super(data, type, messages);
    }
}
