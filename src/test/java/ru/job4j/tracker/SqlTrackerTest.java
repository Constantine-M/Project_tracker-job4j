package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SqlTrackerTest {

    private static Connection connection;

    /**
     * Метод с данной аннтоацией
     * выполняется один раз до начала тестов!
     */
    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("h2driver-sql-tracker"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Метод с данной аннотацией
     * выполняется один раз после тестов!
     *
     * @throws SQLException
     */
    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    /**
     * Метод с данной аннотацией
     * выполняется после каждого теста!
     *
     * @throws SQLException
     */
    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item american = new Item("dollar");
        tracker.add(american);
        Item chinese = new Item("yuan");
        tracker.replace(american.getId(), chinese);
        assertThat(tracker.findById(american.getId()).getName(), is("yuan"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item american = new Item("dollar");
        tracker.delete(american.getId());
        assertThat(tracker.findById(american.getId()), is(nullValue()));
    }

    @Test
    public void whenAdd() {
        SqlTracker tracker = new SqlTracker(connection);
        Item american = new Item("dollar");
        assertThat(tracker.add(american), is(american));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bonnie = tracker.add(new Item("Bonnie"));
        Item clyde = tracker.add(new Item("Clyde"));
        assertThat(tracker.findAll(), is(List.of(bonnie, clyde)));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bonnie = tracker.add(new Item("Bonnie"));
        Item clyde = tracker.add(new Item("Bonnie"));
        assertThat(tracker.findByName("Bonnie"), is(List.of(bonnie, clyde)));
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bonnie = new Item("Bonnie");
        tracker.add(bonnie);
        assertThat(tracker.findById(bonnie.getId()), is(bonnie));
    }
}