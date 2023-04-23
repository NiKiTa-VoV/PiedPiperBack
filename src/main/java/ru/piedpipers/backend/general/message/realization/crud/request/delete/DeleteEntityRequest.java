package ru.piedpipers.backend.general.message.realization.crud.request.delete;

import lombok.Data;
import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.realization.crud.base.request.IDeleteEntityRequest;

@Data
public class DeleteEntityRequest<ID, E extends IEntity<ID>> implements IDeleteEntityRequest<ID, E> {
}
