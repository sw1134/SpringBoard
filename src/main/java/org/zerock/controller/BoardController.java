package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());	
	}
	@GetMapping("/register")
	public void register() {}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: "+board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
//	@GetMapping ("/get")
	@GetMapping({"/get", "/modify"})
	//	public void get(@RequestParam("bno") Long bno, Model model) { // 좀더 명시적으로bno 값얻기 위해
	public void get( Long bno, Model model) {		
	log.info("/get OR /modify => ");
	model.addAttribute("board", service.get(bno));
	}
	//수정
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	//삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove: " + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}	
//	@GetMapping("/blank")
//	public String blank() {
//		log.info("blank 시작");
//		return "/navbarleft/blank";
//	}
//	@GetMapping("/buttons")
//	public String buttons() {
//		log.info("buttons 시작");
//		return "/buttons/blank";
//	}
//	@GetMapping("/flot")
//	public String flot() {
//		log.info("flot 시작");
//		return "/navbarleft/flot";
//	}
//	@GetMapping("/forms")
//	public String forms() {
//		log.info("forms 시작");
//		return "/navbarleft/forms";
//	}
//	@GetMapping("/grid")
//	public String grid() {
//		log.info("grid 시작");
//		return "/board/grid";
//	}
//	@GetMapping("/icons")
//	public String icons() {
//		log.info("icons 시작");
//		return "/board/icons";
//	}
//	@GetMapping("/login")
//	public String login() {		
//		return "/board/login";
//	}
//	@GetMapping("/morris")
//	public String morris() {		
//		return "/board/morris";
//	}
//	@GetMapping("/notifications")
//	public String notifications() {		
//		return "/board/notifications";
//	}
//	@GetMapping("/panelswells")
//	public String panelswells() {		
//		return "/navbarleft/panelswells";
//	}
//	@GetMapping("/tables")
//	public String tables() {		
//		return "/navbarleft/table";
//	}
//	@GetMapping("/typography")
//	public String typography() {		
//		return "/board/typography";
//	}
}//end
