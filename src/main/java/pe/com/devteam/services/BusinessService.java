package pe.com.devteam.services;

import pe.com.devteam.bean.Business;

import java.sql.SQLException;
import java.util.List;

public interface BusinessService {

    Business findById(int id) throws SQLException;

    List<Business> findAll(Business business) throws SQLException;

}
