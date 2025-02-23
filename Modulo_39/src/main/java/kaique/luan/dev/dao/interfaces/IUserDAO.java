package kaique.luan.dev.dao.interfaces;

import kaique.luan.dev.dao.generic.IGenericDAO;
import kaique.luan.dev.domain.User;

public interface IUserDAO extends IGenericDAO<User, Long> {
    public User findByUserName(String UserName);
}
