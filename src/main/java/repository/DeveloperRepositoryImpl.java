package repository;

import model.Developer;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository{

    private DataSource dataSource;

    private final String CREATE_DEVELOPER = "insert into developer(name, age, gender) values (?, ?, ?)";

    public DeveloperRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Developer get(String name) {
        return null;
    }

    @Override
    public Developer get(int id) {
        return null;
    }

    @Override
    public void create(Developer developer) {
        try(PreparedStatement statement = dataSource.getConnection().prepareStatement(CREATE_DEVELOPER)) {
            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setString(3, developer.getGender().getGender());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Developer> getAll() {
        return null;
    }
}
