package ru.piedpipers.backend.general.message.realization.crud.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.piedpipers.backend.database.model.IEntity;

public interface ICrudEntity<E extends IEntity<?>> {
    @JsonIgnore
    CrudType getType();
}
