package com.sports.matching.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;

@Controller
public class ChatController implements ServletConfigAware {

	private ServletContext servletContext;
	private Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		servletContext = servletConfig.getServletContext();
	}

	@RequestMapping(value = "/chat.do", method = RequestMethod.GET)
	public String chat() {
		return "chat";
	}
	
	@RequestMapping(value = "/socketOpen.do", method = RequestMethod.GET)
	public String socketOpen(HttpSession session, String mem_id, String gr_id, Model model) {
		logger.info("!!!socketOpen!!!");
//		String mem_id = (String)session.getAttribute("mem_id");
//		String gr_id = (String)session.getAttribute("gr_id");
		session.setAttribute("mem_id", mem_id);
		session.setAttribute("gr_id", gr_id);

		HashMap<String, String> chatList = (HashMap<String, String>) servletContext.getAttribute("chatList");
		if (chatList == null) {
			chatList = new HashMap<String, String>();
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList);
		} else {
			chatList.put(mem_id, gr_id);
			servletContext.setAttribute("chatList", chatList);
		}
		logger.info("!!!socketOpen!!!");

		return "groupChat";
	}

	@RequestMapping(value = "/socketOut.do", method = { RequestMethod.GET, RequestMethod.POST })
	public void socketOut(HttpSession session) {
		logger.info("!!!socketOut!!!");
		String mem_id = (String) session.getAttribute("mem_id");
		HashMap<String, String> chatList = (HashMap<String, String>) servletContext.getAttribute("chatList");
		System.out.println("chatList :" + chatList);
		if (chatList != null) {
			chatList.remove(mem_id);
		}
		System.out.println("chatList :" + chatList);
		servletContext.setAttribute("chatList", chatList);

	}

	@RequestMapping(value = "/viewChatList.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Map<String, String>> viewChatList() {
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		Map<String, String> chatList = (HashMap<String, String>) servletContext.getAttribute("chatList");
		map.put("list", chatList);
		return map;
	}

}
