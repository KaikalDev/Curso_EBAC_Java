package kaique.luan.dev.dao;

import kaique.luan.dev.dao.generic.GenericDAO;
import kaique.luan.dev.dao.interfaces.IWorkDAO;
import kaique.luan.dev.domain.Work;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.Collections;

public class WorkDAO extends GenericDAO<Work, Long> implements IWorkDAO {
    public WorkDAO() {
        super(Work.class);
    }

    @Override
    public Collection<Work> findByUser(Long userId) {
        openConnection();
        Collection<Work> works;

        try {
            works = entityManager.createQuery(
                            "SELECT w FROM " + persistenteClass.getSimpleName() + " w WHERE w.user.id = :userId", Work.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        } finally {
            closeConnection();
        }

        return works;
    }
}
