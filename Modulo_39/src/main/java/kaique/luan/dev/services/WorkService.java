package kaique.luan.dev.services;

import kaique.luan.dev.Enuns.WorkLevel;
import kaique.luan.dev.Enuns.WorkStatus;
import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.TipoChaveNaoEncontradaException;
import kaique.luan.dev.dao.interfaces.IWorkDAO;
import kaique.luan.dev.domain.Work;
import kaique.luan.dev.services.generic.GenericService;
import kaique.luan.dev.services.interfaces.IWorkService;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class WorkService extends GenericService<Work, Long> implements IWorkService {
    public WorkService(IWorkDAO workDAO) {
        super(workDAO);
    }

    @Override
    public Collection<Work> findByUser(Long userId) {
        return ((IWorkDAO) dao).findByUser(userId);
    }

    @Override
    public Collection<Work> filter(WorkStatus status, Collection<Work> works) {
        return works.stream()
                .filter(work -> work.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Work> filter(WorkLevel level, Collection<Work> works) {
        return works.stream()
                .filter(work -> work.getLevel().equals(level))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Work> filter(String title, Collection<Work> works) {
        if (works == null || works.isEmpty()) {
            return Collections.emptyList();
        }

        if (title == null || title.trim().isEmpty()) {
            return works;
        }

        String titleLower = title.toLowerCase().trim();

        return works.stream()
                .filter(work -> work.getTitle() != null && work.getTitle().toLowerCase().contains(titleLower))
                .collect(Collectors.toList());
    }

    @Override
    public void toggleCompleted(Work work) throws DAOException, TipoChaveNaoEncontradaException {
        WorkStatus status = work.getStatus();
        switch (status) {
            case PENDENTE:
                work.setStatus(WorkStatus.CONCLUIDA);
                break;
            case CONCLUIDA:
                work.setStatus(WorkStatus.PENDENTE);
                break;
        }
        dao.alterar(work);
    }

}
