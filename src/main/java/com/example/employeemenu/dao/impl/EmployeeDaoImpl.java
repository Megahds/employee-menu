package com.example.employeemenu.dao.impl;

import com.example.employeemenu.dao.EmployeeDao;
import com.example.employeemenu.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    // Add new employee to Postgres database
    @Override
    public void addEmployeeToDB(Employee emp) {
        String sql = "INSERT INTO employee "
                + "(name, tanggal_masuk, no_hp, limit_reimb, created_date, updated_date) "
                + "VALUES (?, ?, ?, ?, CURRENT_DATE, CURRENT_DATE)";

        getJdbcTemplate().update(sql, new Object[] {
                emp.getName(),
                emp.getTglMasuk(),
                emp.getNoHP(),
                emp.getLimitReimb()
        });
    }

    // Get all employees from Postgres database
    @Override
    public List<Employee> getAllEmployeeFromDB() {
        String sql = "SELECT * FROM employee ORDER BY id";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList();
        for (Map<String, Object> row:rows) {
            Employee emp = new Employee();
            emp.setId((int)row.get("id"));
            emp.setName((String)row.get("name"));
            emp.setTglMasuk((Date) row.get("tanggal_masuk"));
            emp.setNoHP((String)row.get("no_hp"));
            emp.setLimitReimb((String)row.get("limit_reimb"));
            emp.setUpdatedDate((Date) row.get("updated_date"));
            result.add(emp);
        }

        return result;
    }

    // Get employee by id
    @Override
    public Employee getEmployeeByIdFromDB(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";

        return (Employee)getJdbcTemplate().queryForObject(
                sql,
                new Object[]{id},
                new RowMapper() {
                    @Override
                    public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
                        Employee emp = new Employee();
                        emp.setId(rs.getInt("id"));
                        emp.setName(rs.getString("name"));
                        emp.setTglMasuk(rs.getDate("tanggal_masuk"));
                        emp.setNoHP(rs.getString("no_hp"));
                        emp.setLimitReimb(rs.getString("limit_reimb"));
                        emp.setUpdatedDate(rs.getDate("updated_date"));
                        return emp;
                    }
                });
    }

    // Update employee by id
    public void updateEmployeeById(int id, Employee employee) {
        String sql = "UPDATE employee "
                + "SET name = ?, "
                + "tanggal_masuk = ?, "
                + "no_hp = ?, "
                + "limit_reimb = ?, "
                + "updated_date = CURRENT_DATE "
                + "WHERE id = ?";

        getJdbcTemplate().update(sql,
                employee.getName(),
                employee.getTglMasuk(),
                employee.getNoHP(),
                employee.getLimitReimb(),
                id
        );
    }

    // Delete employee by id
    @Override
    public int deleteEmployeeById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return getJdbcTemplate().update(sql, id);
    }
}
