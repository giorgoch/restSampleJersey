package com.giorgoch.projectClient.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.giorgoch.projectClient.Model.User;

@Component("userdao")
public class UserDaoImpl implements UserDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource  jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Override
	public List<User> getUsers() {
		String sqlGetUser = "Select id,name,lname,username," + "password,postcode,authority,email,"
				+ "address,dateofbirth,city,country," + "gender " + " from Users";
		return jdbc.query(sqlGetUser, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setLname(rs.getString("lname"));
				user.setPostcode(rs.getString("postcode"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setTel(rs.getString("tel"));
				return user;
			}
		});
	}

	@Override
	public boolean updateUser(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update("update Users set name=:name " + ",lname=:lname," + "postcode=:postcode,"
				+ "address=:address," + "city=:city," + "tel=:tel", params) == 1;
	}

	@Override
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		String sqlDelete = "delete from users where id=:id";
		return jdbc.update(sqlDelete, params) == 1;
	}

	@Override
	public User getUser(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		String sqlGetUser = "select * from person where id=:id";
		return jdbc.queryForObject(sqlGetUser, params, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setLname(rs.getString("lname"));
				user.setPostcode(rs.getString("postcode"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setTel(rs.getString("tel"));
				return user;
			}

		});
	}

	@Override
	public boolean create(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		String sqlCreate = "insert into users (name,lname,postcode,address,tel,city)"
				+ "values (:name,:lname,:postcode,:address,:tel,:city)";
		return jdbc.update(sqlCreate, params) == 1;
	}

}
