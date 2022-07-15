package com.cts.spring.boot.data.jdbc.demo.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.spring.boot.data.jdbc.demo.model.Employee;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

	public static final String GET_ALL = "SELECT empId,fullName,basic,joinDate FROM emps";
	public static final String GET_BY_ID = "SELECT empId,fullName,basic,joinDate FROM emps WHERE empId=:empId";
	public static final String INS = "INSERT INTO emps(fullName,basic,joinDate) VALUES(:fullName,:basic,:joinDate)";
	public static final String DEL_BY_ID = "DELETE FROM emps WHERE empId=:empId";
	
	private RowMapper<Employee> empRowMapper = (rs,rowNum) -> {
		Employee emp = new Employee();
		emp.setEmpId(rs.getLong(1));
		emp.setFullName(rs.getString(2));
		emp.setBasic(rs.getDouble(3));
		emp.setJoinDate(rs.getDate(4).toLocalDate());
		return emp;
	};	

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Employee save(Employee emp) {
		jdbcTemplate.update(INS, new BeanPropertySqlParameterSource(emp));
		return emp;
	}
	
	@Override
	public void deleteById(Long empId) {
		jdbcTemplate.update(DEL_BY_ID, new MapSqlParameterSource("empId", empId));
	}

	@Override
	public Optional<Employee> findById(Long empId) {
		Employee emp = jdbcTemplate.queryForObject(GET_BY_ID, new MapSqlParameterSource("empId", empId), empRowMapper);
		return Optional.of(emp);
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query(GET_ALL,empRowMapper);
	}

}
