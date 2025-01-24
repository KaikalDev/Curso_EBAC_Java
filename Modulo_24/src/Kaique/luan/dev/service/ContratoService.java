package Kaique.luan.dev.service;

import Kaique.luan.dev.dao.IContratoDao;

public class ContratoService implements IContratoService{
    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String Excluir() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String Buscar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String Atualizar() {
        contratoDao.salvar();
        return "Sucesso";
    }
}
