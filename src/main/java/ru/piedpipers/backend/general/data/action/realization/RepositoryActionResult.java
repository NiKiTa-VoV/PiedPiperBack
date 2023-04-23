package ru.piedpipers.backend.general.data.action.realization;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.data.action.ActionResultType;
import ru.piedpipers.backend.general.message.intefaces.IResponseMessage;

public class RepositoryActionResult<E extends IEntity<?>> extends ActionResult<E> {
    public RepositoryActionResult(E data, ActionResultType type, IResponseMessage... messages) {
        super(data, type, messages);
    }
}
