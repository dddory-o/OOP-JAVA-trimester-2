package assignment_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends Entity> {
    protected Connection getConnection() {
        return DBConnection.getInstance().dbConnect();

    }

    public abstract void add(T entity);

    public abstract void update(T entity);

    public abstract void delete(int id);

    public abstract List<T> getAll();
}

