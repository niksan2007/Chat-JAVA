package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для работы с таблицей Users в БД
 * @author Admin
 */
public class QueryUsers extends DBConnection {

    //запрос в БД
    private final String QUERY_INSERT_OR_UPDATE_BY_NAME = "INSERT INTO users(name, date) VALUES(?, ?) ON CONFLICT(name) DO UPDATE SET date = ?";

    private Connection conn;

    
    /**
     * Добавление в базу данных нового пользователя. Если пользователь с таким именем уже существует, то обновить только дату
     * @param name имя пользователя
     * @return true - в смлучае успеха, иначе false
     */
    public boolean insertOrUpdate(String name) {
        PreparedStatement ps = null;
        int executeUpdate = -1;
        try {
            conn = open();
            //получение объекта типа PreparedStatement
            ps = conn.prepareStatement(QUERY_INSERT_OR_UPDATE_BY_NAME);
            //получаем текущее время в миллисекундах
            long date = new Date().getTime();
            //установка параметров
            ps.setString(1, name);
            ps.setLong(2, date);
            ps.setLong(3, date);

            //запрос в БД
            executeUpdate = ps.executeUpdate();
            ps.close();
            close(conn);
        } catch (SQLException ex) {
            try {
                ps.close();
                close(conn);
                Logger.getLogger(QueryUsers.class.getName()).log(Level.SEVERE, null, ex);
                return executeUpdate > -1;
            } catch (SQLException ex1) {
                Logger.getLogger(QueryUsers.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return executeUpdate > -1;
    }

}
