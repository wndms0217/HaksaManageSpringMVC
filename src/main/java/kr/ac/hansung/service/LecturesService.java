package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.LectureDAO;
import kr.ac.hansung.model.Lecture;

@Service
public class LecturesService {

	// DAO use
	private LectureDAO lectureDao;

	@Autowired
	public void setLectureDao(LectureDAO lectureDao) {
		this.lectureDao = lectureDao;
	}

	public List<Lecture> getApplyLectures() {
		return lectureDao.getApplyLectures();
	}

	public int getSumbydivision(String division) {
		// TODO Auto-generated method stub
		
		return lectureDao.getSumbydivision(division);

	}
	
	public List<Lecture> getSumbysemester( ) {
		// TODO Auto-generated method stub
		
		return lectureDao.getSumbysemester();

	}

	public void insert(Lecture lecture) {

		lectureDao.insert(lecture);

	}

	public List<Lecture> getLecture(Integer year, Integer semester) {
		// TODO Auto-generated method stub
		return lectureDao.getLecture(year, semester);
	}



}
