package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.service.LecturesService;

@Controller
public class LecturesController {

	LecturesService lecturesService = new LecturesService();

	@Autowired
	public void setLecturesService(LecturesService lecturesService) {
		this.lecturesService = lecturesService;
	}

	public LecturesService getLecturesService() {
		return lecturesService;
	}

	// 학기별 검색 
	@RequestMapping("/semester")
	public String showbyterms(Model model, Lecture lecture) {

		model.addAttribute("lectures", lecturesService.getSumbysemester());

		return "bysemester";
	}

	// 학기별 검색 
	@RequestMapping("/division")
	public String showbydivisions(Model model) {

		// model.addAttribute(arg0, arg1)
		model.addAttribute("mandatory1", lecturesService.getSumbydivision("교필"));
		model.addAttribute("mandatory2",
				lecturesService.getSumbydivision("핵교A") + lecturesService.getSumbydivision("핵교B"));
		model.addAttribute("major1", lecturesService.getSumbydivision("전지"));
		model.addAttribute("major2", lecturesService.getSumbydivision("전기"));
		model.addAttribute("major3", lecturesService.getSumbydivision("전선"));

		return "bydivision";
	}

	// 상세보기
	@RequestMapping("/detailview")
	public String lectureDetail(Model model, Integer year, Integer semester) {
		List<Lecture> lectures = lecturesService.getLecture(year, semester);

		// 저장된 모델이 아닌 새로운 모델로 초기화!
		model.addAttribute("lectures", lectures); // 빼면 null Point Error!!

		return "detailview";
	}

	// 신청 항목 보
	@RequestMapping("/lecturesapplied")
	public String showLectures(Model model) {

		List<Lecture> lectures = lecturesService.getApplyLectures();

		// 저장된 모델이 아닌 새로운 모델로 초기화!
		model.addAttribute("lectures", lectures); // 빼면 null Point Error!!

		return "lecturesapplied";
	}

	
	@RequestMapping("/applylecture")
	public String applyLectures(Model model) {

		// 저장된 모델이 아닌 새로운 모델로 초기화!
		model.addAttribute("lecture", new Lecture()); // 빼면 null Point Error!!

		return "applylecture";
	}


	@RequestMapping("/doapply")
	public String Lectureapplied(Model model, @Valid Lecture lecture, BindingResult result) {

		//if(model==null) model.addAttribute("lecture", new Lecture());
		
		if (result.hasErrors()) {
			System.out.println("From data does validate.");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());

			}
			return "applylecture";
		}
		// service 객체를 이용하여 db에 insert!!
		else {
			lecturesService.insert(lecture);

			// lectureappied라는 jsp파일 이름 리턴
			return "applysuccess";
		}
	}
}
