package com.qixin.example.dao;

import com.qixin.example.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * 文    件     名： UserDaoImpl
 * 包           名： com.qixin.example.dao
 * 创  建   时  间： 2018/1/18 23:15
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Repository
public class SystemUserDaoImpl implements SystemUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SystemUser createUser(final SystemUser user) {
        System.out.println("jdbcTemplate:"+jdbcTemplate);
        final String sql = "INSERT INTO system_user(organization_id, username, password, salt, role_ids, locked) VALUES(?,?,?,?,?,?) ";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setLong(count++, user.getOrganizationId());
                psst.setString(count++, user.getUsername());
                psst.setString(count++, user.getPassword());
                psst.setString(count++, user.getSalt());
                psst.setString(count++, user.getRoleIdsStr());
                psst.setBoolean(count++, user.getLocked());
                return psst;
            }
        }, keyHolder);

        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    @Override
    public SystemUser updateUser(final SystemUser user) {
        String sql = "UPDATE system_user SET organization_id=?,username=?, password=?, salt=?, role_ids=?, locked=? WHERE id=? ";
        jdbcTemplate.update(
                sql,
                user.getOrganizationId(), user.getUsername(), user.getPassword(), user.getSalt(), user.getRoleIdsStr(), user.getLocked(), user.getId());
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        String sql = "DELETE FROM system_user WHERE id=? ";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public SystemUser findOne(Long userId) {
        String sql = "SELECT id, organization_id, username, password, salt, role_ids AS roleIdsStr, locked FROM system_user WHERE id=? ";
        List<SystemUser> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(SystemUser.class), userId);
        return userList.size()==0?null:userList.get(0);
    }

    @Override
    public List<SystemUser> findAll() {
        String sql = "SELECT id, organization_id, username, password, salt, role_ids AS roleIdsStr, locked FROM system_user ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(SystemUser.class));
    }

    @Override
    public SystemUser findByUsername(String username) {
        String sql = "SELECT id, organization_id, username, password, salt, role_ids AS roleIdsStr, locked FROM system_user WHERE username=? ";
        List<SystemUser> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(SystemUser.class), username);
        return userList.size()==0?null:userList.get(0);
    }

}
