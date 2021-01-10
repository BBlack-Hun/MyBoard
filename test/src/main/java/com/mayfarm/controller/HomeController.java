package com.mayfarm.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mayfarm.service.BoardService;
import com.mayfarm.service.ReplyService;
import com.mayfarm.vo.BoardVO;
import com.mayfarm.vo.PageMaker;
import com.mayfarm.vo.ReplyVO;
import com.mayfarm.vo.SearchCriteria;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	BoardService service;
	
	@Inject
	ReplyService replyService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 게시판 목록
	@RequestMapping(value="/board/index", method= RequestMethod.GET)
	public String index(Model model, @ModelAttribute("scrl") SearchCriteria scrl) throws Exception{
		logger.info("boardIndex");
		
		model.addAttribute("list", service.list(scrl));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCrl(scrl);
		pageMaker.SetTotalCount(service.listCount(scrl));
		System.out.println(scrl);
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "/board/index";
	}
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{
		logger.info("write");
		
		service.write(boardVO);
		
		return "redirect:/board/index";
	}
	
	// 게시글 조회
	@RequestMapping(value = "/board/readView", method=RequestMethod.GET)
	public String read(BoardVO boardVO, @ModelAttribute("scrl") SearchCriteria scrl, Model model) throws Exception {
		logger.info("read");
		
		model.addAttribute("read", service.read(boardVO.getNo()));
		model.addAttribute("scrl", scrl);
		
		List<ReplyVO> replyList = replyService.readReply(boardVO.getNo());
		model.addAttribute("replyList", replyList);
		
		return "board/readView";
	}
	
	// 게시글 수정뷰
	@RequestMapping(value="/board/updateView", method=RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model) throws Exception {
		logger.info("updateView");
		
		model.addAttribute("update", service.read(boardVO.getNo()));
		
		return "/board/updateView";
	}
	
	// 게시글 수정
	@RequestMapping(value = "/board/update", method=RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception {
		logger.info("update");
		
		service.update(boardVO);
		
		return "redirect:/board/index";
	}
	
	// 게시글 삭제
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		logger.info("delete");
		
		service.delete(boardVO.getNo());
		
		return "redirect:/board/index";
	}
	
	// 댓글 작성
	@RequestMapping(value="/board/replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVO vo, SearchCriteria scrl, RedirectAttributes rttr) throws Exception {
		logger.info("reply Write");
		
		replyService.writeReply(vo);
		
		// 댓글을 작성하였을때, 그 페이지로 리다이렉션을 위한 필요한 값을 저장
		rttr.addAttribute("no", vo.getNo());
		rttr.addAttribute("page", scrl.getPage());
		rttr.addAttribute("perPageNum", scrl.getPerPageNum());
		rttr.addAttribute("searchType", scrl.getSearchType());
		rttr.addAttribute("keyword", scrl.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	// 댓글 수정 GET
	@RequestMapping(value="/board/replyUpdateView", method=RequestMethod.GET)
	public String replyUpdateView(ReplyVO vo, SearchCriteria scrl, Model model) throws Exception {
		logger.info("reply Write");
		
		model.addAttribute("replyUpdate", replyService.selectReply(vo.getRno()));
		model.addAttribute("scrl", scrl);
		
		return "/board/replyUpdateView";
	}
	
	// 댓글 수정 POST
	@RequestMapping(value="/board/replyUpdate", method=RequestMethod.POST)
	public String replyUPdate(ReplyVO vo, SearchCriteria scrl, RedirectAttributes rttr) throws Exception {
		logger.info("reply Write");
		
		replyService.updateReply(vo);
		
		rttr.addAttribute("no", vo.getNo());
		rttr.addAttribute("page", scrl.getPage());
		rttr.addAttribute("perPageNum", scrl.getPerPageNum());
		rttr.addAttribute("searchType", scrl.getSearchType());
		rttr.addAttribute("keyword", scrl.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	//댓글 삭제 GET
	@RequestMapping(value="/board/replyDeleteView", method=RequestMethod.GET)
	public String replyDeleteView(ReplyVO vo, SearchCriteria scrl, Model model) throws Exception {
		logger.info("reply Delete");
		
		model.addAttribute("replyDelete", replyService.selectReply(vo.getRno()));
		model.addAttribute("scrl", scrl);
		
		return "/board/replyDeleteView";
	}
	
	// 댓글 삭제
	@RequestMapping(value="/board/replyDelete", method=RequestMethod.POST)
	public String replyDelete(ReplyVO vo, SearchCriteria scrl, RedirectAttributes rttr) throws Exception {
		logger.info("reply Delete");
		
		replyService.deleteReply(vo);
		
		rttr.addAttribute("bno", vo.getNo());
		rttr.addAttribute("page", scrl.getPage());
		rttr.addAttribute("perPageNum", scrl.getPerPageNum());
		rttr.addAttribute("searchType", scrl.getSearchType());
		rttr.addAttribute("keyword", scrl.getKeyword());

		return "redirct:/board/readView";
	}
}
