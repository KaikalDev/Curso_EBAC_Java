package kaique.luan.dev.dao;

import kaique.luan.dev.dao.generic.GenericDAO;
import kaique.luan.dev.dao.interfaces.IUserDAO;
import kaique.luan.dev.domain.User;

import javax.persistence.NoResultException;

public class UserDAO extends GenericDAO<User, Long> implements IUserDAO {
    public UserDAO() {
        super(User.class);
    }

    @Override
    public User findByUserName(String userName) {
        openConnection();
        User user = null;
        try {
            user = (User) entityManager.createQuery("SELECT u FROM " + persistenteClass.getSimpleName() + " u WHERE u.userName = :userName")
                        .setParameter("userName", userName)
                        .getSingleResult();
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            return null;
        } finally {
            closeConnection();
        }
        return user;
    }
}
