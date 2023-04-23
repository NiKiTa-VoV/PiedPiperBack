package ru.piedpipers.backend.general.message.realization.crud.request.read;

import lombok.Data;
import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.realization.crud.base.request.IReadEntityRequest;

@Data
public class ReadEntityRequest<ID, E extends IEntity<ID>> implements IReadEntityRequest<ID, E> {
}
