package kaique.luan.dev.services;

import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.dao.interfaces.IUserDAO;
import kaique.luan.dev.domain.User;
import kaique.luan.dev.services.generic.GenericService;
import kaique.luan.dev.services.interfaces.IUserService;

import java.util.Collection;

public class UserService extends GenericService<User, Long> implements IUserService {
    public UserService(IUserDAO userDAO) {
        super(userDAO);
    }

    @Override
    public boolean validateUser(String name) throws DAOException {
        Collection<User> users = buscarTodos();

        if (users == null) {
            return true;
        }

        for (User user : users) {
            if (user.getUserName().equals(name)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public User findByUserName(String userName) {
        return ((IUserDAO) dao).findByUserName(userName);
    }


}
