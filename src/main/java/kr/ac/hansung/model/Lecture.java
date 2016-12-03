package kr.ac.hansung.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Lecture {
	// field
	private Integer id;
	@Max(value = 9999, message = "수강년도를 확인해 주세요.")
	@Min(value = 2017, message = "수강년도를 확인해 주세요.")
	@NotNull(message = "수강년도를 입력해주세요.")
	private Integer year;
	@Max(value = 10, message = "수강학기를 확인해 주세요.")
	@Min(value = 1, message = "수강학기를 확인해 주세요.")
	@NotNull(message = "수강학기를 입력해주세요.")
	private Integer semester;
	@Size(min = 7, max = 7, message = "과목코드는 7자입니다.")
	@NotEmpty(message = "과목 코드를 입력해주세요.")
	private String code;
	@NotEmpty(message = "과목명 입력해주세요.")
	private String name;
	@NotEmpty(message = "구분 지정해주세요.")
	private String division;
	@Max(value = 10, message = "학점을 확인해 주세요.")
	@Min(value = 1, message = "학점을 확인해 주세요.")
	@NotNull(message = "학점 입력해주세요.")
	private Integer unit;

	public Lecture() {

	}

	public Lecture(Integer id, Integer year, Integer semester, String code, String name, String division,
			Integer unit) {

		this.id = id;
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.division = division;
		this.unit = unit;
	}

	public Lecture(Integer year, Integer semester, String code, String name, String division, Integer unit) {

		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.division = division;
		this.unit = unit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public String toString() {
		return "Lecture [id=" + id + ", year=" + year + ", semester=" + semester + ", code=" + code + ", name=" + name
				+ ", division=" + division + ", unit=" + unit + "]";
	}
}
