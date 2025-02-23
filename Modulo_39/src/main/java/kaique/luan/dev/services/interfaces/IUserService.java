package kaique.luan.dev.services.interfaces;

import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.domain.User;
import kaique.luan.dev.services.generic.IGenericService;

public interface IUserService extends IGenericService<User, Long> {
    boolean validateUser(String name) throws DAOException;

    User findByUserName(String userName) throws DAOException;
}
