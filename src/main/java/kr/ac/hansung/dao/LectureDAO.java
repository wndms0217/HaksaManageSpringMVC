package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import kr.ac.hansung.model.Lecture;

@Repository
public class LectureDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dateSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dateSource);
	}

	// DB call method
	// 현재 레코드 수 카운트
	public int getRowCount() {
		String sqlStatement = "select count(*) from lectures";

		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);

	}

	public List<Lecture> getSumbysemester() {

		String sqlStatement = "select year, semester, sum(unit) from lectures group by year, semester";
		List<Lecture> lectures = jdbcTemplateObject.query(sqlStatement, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				Lecture lecture = new Lecture();

				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setUnit(rs.getInt("SUM(unit)"));

				return lecture;
			}
		});

		return lectures;
	}

	public int getSumbydivision(String division) {

		String sqlStatement = "select sum(unit) from lectures where division=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class, division);
	}
	public List<Lecture> getLecture(Integer year, Integer semester){
	
		String sqlStatement = "select * from lectures where year=? and semester=?";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Lecture객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, new LectureMapper());
	
	}
	
	// querying and returning a single object
	public Lecture getLecture(String name) {
		String sqlStatement = "select * from lectures where name=?";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Lecture객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new LectureMapper());
	}

	// querying and returning a multiple object
	public List<Lecture> getLecture() { // Offer의 list를 넘겨줌
		String sqlStatement = "select * from lectures";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Lecture객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.query(sqlStatement, new LectureMapper());
	}
	// querying and returning a single object
	public Lecture getApplyLectures(String name) {
		String sqlStatement = "select * from application where name=?";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new LectureMapper());
	}
	public List<Lecture> getApplyLectures() { // Lecture의 list를 넘겨줌
		String sqlStatement = "select * from application";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		return jdbcTemplateObject.query(sqlStatement, new LectureMapper());
	}
	public boolean insert(Lecture lecture) {

		Integer year = lecture.getYear();
		Integer semester = lecture.getSemester();
		String code = lecture.getCode();
		String name = lecture.getName();
		String division = lecture.getDivision();
		Integer unit = lecture.getUnit();

		String sqlStatement = "insert into application (year, semester, code, name, division, unit) values (?,?,?,?,?,?)";

		// 몇개가 update됐는지 갯수가 return
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, division, unit }) == 1);

	}

	public boolean update(Lecture lecture) {

		Integer year = lecture.getYear();
		Integer semester = lecture.getSemester();
		String code = lecture.getCode();
		String name = lecture.getName();
		String division = lecture.getDivision();
		Integer unit = lecture.getUnit();

		String sqlStatement = "update lectures set name=?, email=?, text=? where id=?";

		// 몇개가 update됐는지 갯수가 return
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, division, unit }) == 1);

	}

	public boolean delete(Integer id) {

		String sqlStatement = "delete from lecture where id=?";

		// 몇개가 delete됐는지 갯수가 return
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { id }) == 1);

	}

}
