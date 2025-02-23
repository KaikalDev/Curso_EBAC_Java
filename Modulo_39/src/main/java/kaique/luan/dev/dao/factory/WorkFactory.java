package kaique.luan.dev.dao.factory;

import kaique.luan.dev.Enuns.WorkLevel;
import kaique.luan.dev.Enuns.WorkStatus;
import kaique.luan.dev.domain.User;
import kaique.luan.dev.domain.Work;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkFactory {

    public static Work convert(ResultSet rs) throws SQLException {
        User user = UserFactory.convert(rs);
        Work work = new Work();
        work.setId(rs.getLong("id"));
        work.setTitle(rs.getString("title"));
        work.setDescription(rs.getString("description"));
        work.setLevel(WorkLevel.getByName(rs.getString("level")));
        work.setStatus(WorkStatus.getByName(rs.getString("status")));
        work.setUser(user);
        return work;
    }
}
