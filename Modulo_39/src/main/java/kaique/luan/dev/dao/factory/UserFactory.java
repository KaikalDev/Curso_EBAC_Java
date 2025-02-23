package kaique.luan.dev.dao.factory;

import kaique.luan.dev.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {

    public static User convert(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
