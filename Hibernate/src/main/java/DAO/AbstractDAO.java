package DAO;

import org.hibernate.Session;

/**
 * Created by lordusmd on 17.04.2016.
 */
public interface AbstractDAO {

    public Session getCurrentSession();
}
