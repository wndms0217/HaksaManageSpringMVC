package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Lecture;

public class LectureMapper implements RowMapper<Lecture> {

	@Override
	public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Lecture lecture = new Lecture();

		lecture.setYear(rs.getInt("year"));
		lecture.setSemester(rs.getInt("semester"));
		lecture.setCode(rs.getString("code"));
		lecture.setName(rs.getString("name"));
		lecture.setDivision(rs.getString("division"));
		lecture.setUnit(rs.getInt("unit"));

		return lecture;
	}

}
