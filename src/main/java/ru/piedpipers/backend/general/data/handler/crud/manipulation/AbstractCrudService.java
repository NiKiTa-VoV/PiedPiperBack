package ru.piedpipers.backend.general.data.handler.crud.manipulation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.database.repository.RepositoryHelper;
import ru.piedpipers.backend.general.data.action.realization.ActionResult;

@RequiredArgsConstructor
public abstract class AbstractCrudService<R extends JpaRepository<E, ID>, E extends IEntity<ID>, ID> implements ICrudService<E, ID> {
    protected final R repository;
    protected final RepositoryHelper helper;

    @Override
    public ActionResult<E> create(E entity) {
        return helper.save(repository, entity);
    }

    @Override
    public ActionResult<E> read(ID id) {
        return helper.findById(repository, id);
    }

    @Override
    public ActionResult<E> update(ID id, E entity) {
        return helper.update(repository, id, entity);
    }

    @Override
    public ActionResult<E> delete(ID id) {
        return helper.delete(repository, id);
    }

    public boolean existId(ID id) {
        if (id == null) return false;
        return  repository.existsById(id);
    }
}
