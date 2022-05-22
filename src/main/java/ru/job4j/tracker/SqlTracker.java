package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Данный класс описывает основные
 * механизмы работы трекера.
 * Отличивается от {@link MemTracker}
 * тем, что данные хранятся в БД.
 * Т.е. класс будет подключаться
 * к БД, создавать в ней записи,
 * редактировать, читать и удалять.
 */
public class SqlTracker  implements Store, AutoCloseable {

    private Connection cn;

    /**
     * Данный метод инициализирует
     * подключение к БД.
     *
     * Данные для подключения хранятся
     * в файле app.properties.
     * Загружаем данные из файла
     * в объект {@link Properties}.
     *
     * 1.Регистрируем драйвер в системе.
     *
     * 2.Далее подключимся к БД.
     * Для этого воспользуемся классом
     * {@link DriverManager}.
     *
     * 3.Для подключения необходимы
     * url, логин и пароль.
     *
     * 4.В url стоит префикс “jdbc:postgres”.
     * Это указывает, что мы подключаемся
     * к postgres через jdbc. Далее как
     * обычно идет хост и порт, а за
     * ними уже имя базы данных.
     *
     * 5.Таким образом, мы получили объект
     * типа {@link Connection}.
     * Если он не равен null, то это значит,
     * что установлено подключение.
     */
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("postgre-SqlTracker"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            try (Statement statement = cn.createStatement()) {
                String sql = String.format("CREATE TABLE IF NOT EXISTS items (%s, %s, %s)",
                "id serial PRIMARY KEY",
                "name text",
                "created TIMESTAMP"
                );
                statement.execute(sql);
            }
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    /**
     * Данный метод осуществляет вставку
     * заявки в таблицу.
     *
     * В методе реализовано получение
     * id вставленного элемента.
     *
     * Для этого нужно при создании
     * {@link PreparedStatement}
     * вторым аргументом передать
     * {@link Statement#RETURN_GENERATED_KEYS}.
     * После как обычно выполнить запрос.
     * Наконец, чтобы получить ключ,
     * нужно вызвать метод
     * {@link Statement#getGeneratedKeys()}.
     *
     * @param item заявка {@link Item}.
     */
    @Override
    public Item add(Item item) {
        String sql = "INSERT INTO items (name, created) VALUES (?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getLocalDateTime()));
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Данный метод производит замену
     * заявки по номеру id.
     *
     * 1.В SQL запросе использовал "EXISTS",
     * чтобы проверить, что заявка с таким
     * id существует. Вынес его в переменную
     * "sqlV2", проверил - к сожалению
     * такой запрос не работает. В инете
     * похожее было, но думаю, что без
     * указания конкретного id замена
     * не произойдет.
     *
     * @param id номер заявки.
     * @param item заявка {@link Item},
     *             на которую меняем.
     * @return true, если замена была
     * произведена успешно.
     */
    @Override
    public boolean replace(int id, Item item) {
        String ls = System.lineSeparator();
        boolean result = false;
        String sqlV1 = "UPDATE items SET name = ?, created = ? WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(sqlV1)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getLocalDateTime()));
            ps.setInt(3, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Данный метод удаляет заявку по id.
     *
     * Использовали метод
     * {@link PreparedStatement#executeUpdate()},
     * т.к. он как раз предназначен и удобен для
     * выполнения операций типа INSERT/UPDATE
     * или DELETE. Метод вернет 0, если ничего не
     * не было удалено, поэтому проверяем, что
     * результат > 0.
     *
     * @param id номер заявки.
     * @return true, если удаление прошло успешно.
     */
    @Override
    public boolean delete(int id) {
        boolean result = false;
        String sql = "DELETE FROM items WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Данный метод находит все заявки.
     *
     * @return список заявок {@link Item}.
     */
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items ORDER BY id";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    items.add(setItemParameter(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Данный метод находит заявку по имени.
     *
     * @param key наименование заявки.
     * @return список найденных заявок по
     * указанному имени.
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE name = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, key);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    items.add(setItemParameter(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Данный метод находит заявку по id.
     *
     * Замечание: т.к. заявка должна
     * возвращаться только одна, то цикл
     * в этом методе НЕ НУЖЕН.
     *
     * @param id номер заявки.
     * @return найденная заявка {@link Item}.
     */
    @Override
    public Item findById(int id) {
        String sql = "SELECT * FROM items WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return setItemParameter(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Данный метод задает параметры
     * для {@link Item}.
     *
     * Он необходим, чтобы исключить
     * дублирвоание кода в методах.
     *
     * @param resultSet набор результатов БД.
     * @return заявка с заданными параметрами.
     * @throws SQLException
     */
    private Item setItemParameter(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getTimestamp(3).toLocalDateTime()
        );
    }
}
