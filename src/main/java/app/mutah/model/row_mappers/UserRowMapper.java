package app.mutah.model.row_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import app.mutah.domain.user.Email;
import app.mutah.enums.Country;
import app.mutah.enums.UserRole;
import app.mutah.model.UserModel;
import app.mutah.util.Timestamp;

@Component
public class UserRowMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        UserModel user = new UserModel(rs.getString("name"), rs.getString("surname"), rs.getLong("phone"),
                new Email(rs.getString("email")), null,
                UserRole.valueOf(rs.getString("role").toUpperCase()), new Timestamp(rs.getString("created_at")),
                new Timestamp(rs.getString("created_at")),
                Optional.ofNullable(rs.getString("image")), Country.valueOf(rs.getString("country").toUpperCase()),
                rs.getBoolean("banned"),
                null, null,
                rs.getBoolean("verified"), null);
        return user;
    }

}
