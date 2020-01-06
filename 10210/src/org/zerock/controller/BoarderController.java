package org.zerock.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.BoardDAO;
import org.zerock.dao.BoardDAOimpl;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PagingDTO;

/**
 * Servlet implementation class BoarderController
 */
@WebServlet("/board/*") 
public class BoarderController extends BasicController {
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/board/Register", type="POST")
	public String addPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("add.post...................");
		System.out.println(req.getParameter("title"));
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value = "/board/Register", type="GET")
	public String add(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("add....................");
		
		return "/board/Register";
	}
	
	@RequestMapping(value = "/board/list", type="GET")
	public String list(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
//		System.out.println("list...................");
		
		BoardDAO dao = new BoardDAOimpl();
		BoardVO vo = new BoardVO();
		
		PagingDTO dto = new PagingDTO();
		
		String amountString = req.getParameter("amount");
		String pageString = req.getParameter("page");
		if(amountString!=null) {
			int amount = Integer.parseInt(amountString);
			dto.setAmount(amount);
		}
		if(pageString!=null) {
			int page = Integer.parseInt(pageString);
			dto.setPage(page);
		}
		
		int pageCount = dao.getCount()/dto.getAmount();
		List li = dao.getList(dto);
		
		req.setAttribute("list", li);
		req.setAttribute("page", dto);
//		System.out.println(dto.getPage());
		req.setAttribute("pageCount", pageCount);
		
		return "/board/list";
	}
	
	@RequestMapping(value = "/board/index", type="GET")
	public String main(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		return "/board/index";
	}

	@RequestMapping(value = "/board/text", type="GET")
	public String text(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardDAO<?> dao = new BoardDAOimpl();
		BoardVO vo = new BoardVO();
		PagingDTO dto = new PagingDTO();
		String numString = req.getParameter("num");
		
		int num = Integer.parseInt(numString);

		vo = (BoardVO)dao.selectOne((long) num);
		
		req.setAttribute("vo", vo);
		req.setAttribute("that", num);
		
		
		return "/board/text";
	}
	
}
