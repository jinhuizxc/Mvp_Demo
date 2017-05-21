package com.example.jh.mvp_demo.db;

import com.example.jh.daogenerator.dao.User;
import com.example.jh.daogenerator.dao.UserDao;
import com.example.jh.mvp_demo.App;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class DbUtils {


    public static boolean isExit(String id) {
        QueryBuilder<User> query = App.getUserDao().queryBuilder();

        query.where(UserDao.Properties.Uid.eq(id));

        long count = query.buildCount().count();

        return count > 0 ? true : false;
    }

    public static void insertUser(User user) {
        UserDao userDao = App.getUserDao();
        userDao.insertOrReplace(user);
    }


    public static void updateUser(User user) {
        UserDao userDao = App.getUserDao();
        userDao.refresh(user);
    }

    public static void deleteUser(User user) {
        UserDao userDao = App.getUserDao();
        userDao.delete(user);
    }

    public static User getUserById(String id) {

        if (!DbUtils.isExit(id)) {
            return null;
        }
        QueryBuilder<User> query = App.getUserDao().queryBuilder();

        query.where(UserDao.Properties.Uid.eq(id));
        return query.unique();
    }

    public static void deleteUserById(String userId) {

    }
}
