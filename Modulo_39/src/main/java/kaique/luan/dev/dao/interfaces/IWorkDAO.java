package kaique.luan.dev.dao.interfaces;

import kaique.luan.dev.dao.generic.IGenericDAO;
import kaique.luan.dev.domain.Work;

import java.util.Collection;

public interface IWorkDAO extends IGenericDAO<Work, Long> {
    public Collection<Work> findByUser(Long userId);
}
