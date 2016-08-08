package com.saveToDB.dao;

import com.saveToDB.pojos.Account;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AccountDao extends AbstractDao {

    private static AccountDao accountDao;
    static Logger logger = Logger.getLogger(AccountDao.class.getName());

    public static AccountDao getInstanse(){                 // singelton
        if(accountDao == null){
            return accountDao = new AccountDao();
        }
        else{
            return accountDao;
        }
    }


    public void add(Account accountBean) throws SQLException {
        try {
            logger.info("- try to add account to DB");
            String sql = ResourceBundle.getBundle("queries").getString("AddAccount");

            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, accountBean.getUserName());
            ps.setString(2, accountBean.getPassword());
            ps.executeUpdate();
            logger.info("- add account to DB");

        } catch (SQLException e) {
            logger.error("- SQLException");
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            logger.error("- PropertyVetoException");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("- IOException");
            e.printStackTrace();
        }
    }

}
