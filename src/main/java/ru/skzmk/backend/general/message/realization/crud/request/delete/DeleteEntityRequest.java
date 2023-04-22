package ru.skzmk.backend.general.message.realization.crud.request.delete;

import lombok.Data;
import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.realization.crud.base.request.IDeleteEntityRequest;

@Data
public class DeleteEntityRequest<ID, E extends IEntity<ID>> implements IDeleteEntityRequest<ID, E> {
}
