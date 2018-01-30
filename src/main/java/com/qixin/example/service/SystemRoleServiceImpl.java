package com.qixin.example.service;

import com.qixin.example.entity.SystemOrganization;
import com.qixin.example.entity.SystemRole;
import com.qixin.example.mapper.SystemRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 文    件     名： RoleServiceImpl
 * 包           名： com.qixin.example.service
 * 创  建   时  间： 2018/1/18 23:17
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Override
    public Set<String> findRoles(List<Long> roleIds) {
        if(roleIds.isEmpty()) return Collections.emptySet();
        return systemRoleMapper.findRoles(roleIds);
    }

    @Override
    public Set<String> findPermissions(Long[] longs) {
        return null;
    }

    @Override
    public SystemRole findById(Long roleId) {
        final String sql = "SELECT id, role, description, resource_ids as resourceIdsStr, available FROM system_role WHERE id=?";
        List<SystemRole> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(SystemRole.class), roleId);
        if(roleList.size() == 0) {
            return null;
        }
        return roleList.get(0);
    }

    @Override
    public List<SystemRole> findAll() {
        final String sql = "SELECT id, role, description, resource_ids AS resourceIdsStr, available FROM system_role ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(SystemRole.class));
        //return systemRoleMapper.findAll();
    }

    @Override
    public Set<String> findAllRole() {

        return systemRoleMapper.findAllRole();
    }

    @Override
    public int save(SystemRole entity) {
        final String sql = "INSERT INTO system_role(role, description, resource_ids, available) VALUES (?,?,?,?) ";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, entity.getRole());
                psst.setString(count++, entity.getDescription());
                psst.setString(count++, entity.getResourceIdsStr());
                psst.setBoolean(count++, entity.getAvailable());
                return psst;
            }
        }, keyHolder);
        entity.setId(keyHolder.getKey().longValue());
        return 1;
    }

    @Override
    public int update(SystemRole role) {
        final String sql = "UPDATE system_role SET role=?, description=?, resource_ids=?, available=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                role.getRole(), role.getDescription(), role.getResourceIdsStr(), role.getAvailable(), role.getId());
        return 1;
    }

    @Override
    public int deleteById(Long id) {
        final String sql = "DELETE FROM system_role WHERE id=? ";
        return jdbcTemplate.update(sql, id);
    }
}
