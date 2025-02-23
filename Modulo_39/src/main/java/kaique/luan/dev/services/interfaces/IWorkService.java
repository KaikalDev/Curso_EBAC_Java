package kaique.luan.dev.services.interfaces;

import kaique.luan.dev.Enuns.WorkLevel;
import kaique.luan.dev.Enuns.WorkStatus;
import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.TipoChaveNaoEncontradaException;
import kaique.luan.dev.domain.Work;
import kaique.luan.dev.services.generic.IGenericService;

import java.util.Collection;

public interface IWorkService extends IGenericService<Work, Long> {
    public Collection<Work> findByUser(Long userId);

    public Collection<Work> filter(WorkStatus status, Collection<Work> works);

    public Collection<Work> filter(WorkLevel level, Collection<Work> works);

    public Collection<Work> filter(String title, Collection<Work> works);

    public void toggleCompleted(Work work) throws DAOException, TipoChaveNaoEncontradaException;
}
