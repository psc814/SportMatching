package com.sports.matching.ctrl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sports.matching.api.KakaoApi;
import com.sports.matching.dtos.MembersDto;
import com.sports.matching.dtos.StadiumAdminDto;
import com.sports.matching.model.MemberShip_IService;


@Controller
public class LoginController {

	
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private KakaoApi kakao;
	
	@Autowired
	private MemberShip_IService service;
	
	@RequestMapping(value = "/loginForm.do")
	public String apiLogin() {
		return "LoginPage";
	}

	
	/**
	 * 카카오 로그인
	 */
	@RequestMapping(value = "/login.do")
	public String login(@RequestParam(value = "code", required = false) String code, HttpSession session,String member_id, Model model) {
		log.info("code {}",code);
		String access_Token = null;
		if (code !=null) {
			access_Token = kakao.getAccessToken(code);
			session.setAttribute("access_Token", access_Token);			
		}
		System.out.println(access_Token);
		String Token = (String) session.getAttribute("access_Token");
		System.out.println(Token);
		HashMap<String, Object> userInfo = kakao.getUserInfo(Token);
		System.out.println("login Controller : " + userInfo);
		log.info("카카오 로그인 시작",member_id);
		session.setAttribute("userInfo", userInfo.get("email"));
		
		String[] MyId = ((String) userInfo.get("email")).split("@");			
		String userEmail = MyId[0];
		System.out.println(userEmail);
		int n = service.duplicateUserId(userEmail);
		
		if(n>0) {
			log.info("중복되어있을때");
			userInfo.put("uEmail", userEmail);
			MembersDto mdto = service.selectUser(userEmail);
			if(mdto != null) {
				log.info("로그인 정보가 있을 때");
				session.setAttribute("uEmail", mdto.getMember_id());
			}else {
				log.info("로그인정보가 없을 때");
				return "redirect:/LoginPage";
			}
		}else {
			log.info("중복X");
			boolean isc = service.apiLogin(userEmail);
			if(isc) {
				userInfo.put("id", userEmail);
			}else {
				return "LoginPage";
			}
		}
	
		return "SearchPage";

		// 클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
		// 나중에 컨트롤러 합칠때 네이버는 n 카카오는 k 를 붙여서 db에저장
//		if (userInfo.get("email") != null) {
//			session.setAttribute("userId", userInfo.get("email"));
//			session.setAttribute("access_Token", access_Token);
//			System.out.println("유저인포 : " + userInfo.get("email"));
//			String[] MyId = ((String) userInfo.get("email")).split("@");
//			System.out.println(MyId[0]);
//			System.out.println(MyId[1]);
//			String result = ""; 
//			if (MyId[1].equalsIgnoreCase("naver.com")) {
//				result = "naver-" + MyId[0];
//			} else {
//				result = "kakao-" + MyId[0];
//			}
//			System.out.println(result);
//		}
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		kakao.kakaoLogout((String) session.getAttribute("access_Token"));
		session.removeAttribute("access_Token");
		session.removeAttribute("userId");
		session.invalidate();
		return "LoginPage";
	}
	
	/**
	 * 네이버 로그인
	 */
	@RequestMapping(value = "/loginForm.do",method = RequestMethod.GET)
    public String naverlogin(Model model, HttpSession session) throws UnsupportedEncodingException{
       log.info("네이버 로그인 진입1");
       
       String clientId = "KeGpnYEEcMzRab38ZzNy";//애플리케이션 클라이언트 아이디값";
       String redirectURI = URLEncoder.encode("http://localhost:8090/SportsMatching/callback.do", "UTF-8");
       SecureRandom random = new SecureRandom();
       String state = new BigInteger(130, random).toString();
       String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
       apiURL += "&client_id=" + clientId;
       apiURL += "&redirect_uri=" + redirectURI;
       apiURL += "&state=" + state;
       session.setAttribute("state", state);
       model.addAttribute("apiURL", apiURL);
       System.out.println("kkkkkkkkkkkkkkkkkkkk"+apiURL);
       return "LoginPage";
       
    }
    
    @RequestMapping(value = "/callback.do",method = RequestMethod.GET)
    public String navercallback(Model model, HttpSession session, String code, String state) throws UnsupportedEncodingException{
       log.info("네이버 로그인 진입2");
       
        String clientId = "KeGpnYEEcMzRab38ZzNy";//애플리케이션 클라이언트 아이디값";
           String clientSecret = "G3VZyzfKTL";//애플리케이션 클라이언트 시크릿값";
           String redirectURI = URLEncoder.encode("http://localhost:8090/SportsMatching/callback.do", "UTF-8");
           String apiURL;
           apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
           apiURL += "client_id=" + clientId;
           apiURL += "&client_secret=" + clientSecret;
           apiURL += "&redirect_uri=" + redirectURI;
           apiURL += "&code=" + code;
           apiURL += "&state=" + state;
           String access_token = "";
           String refresh_token = "";
           System.out.println("apiURL="+apiURL);
           try {
             URL url = new URL(apiURL);
             HttpURLConnection con = (HttpURLConnection)url.openConnection();
             con.setRequestMethod("GET");
             int responseCode = con.getResponseCode();
             BufferedReader br;
             System.out.print("responseCode="+responseCode);
             if(responseCode==200) {
               br = new BufferedReader(new InputStreamReader(con.getInputStream()));
             } else {  
               br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
             }
             String inputLine;
             StringBuffer res = new StringBuffer();
             while ((inputLine = br.readLine()) != null) {
               res.append(inputLine);
             }
             br.close();
             if(responseCode==200) { 
                 model.addAttribute("res", res.toString()); 
                  
                 Object obj = JSONValue.parse(res.toString());  // 엑세스 토큰 JSON으로 받아와서 String 으로 변환해줌 
                 System.out.println(obj+"오브젝트 제이슨"); 
                 JSONObject json = (JSONObject)obj; 
                 refresh_token = (String)json.get("refresh_token"); 
                 access_token = (String)json.get("access_token"); 
                 model.addAttribute("access_token",access_token); 
               }
           } catch (Exception e) {
             System.out.println(e);
           }
       return "redirect:/naverjoin.do";
    }
    
    @RequestMapping(value="/naverjoin.do", method = RequestMethod.GET)
    public String personalInfo(HttpSession session, HttpServletRequest request, String access_token) throws IOException {
       String token = access_token;
       
       String header = "Bearer " + token;
       
       try {
          String apiURL = "https://openapi.naver.com/v1/nid/me";
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection) url.openConnection();
         con.setRequestMethod("GET");
         con.setRequestProperty("Authorization", header);
         int responseCode = con.getResponseCode();
         BufferedReader br;
         if(responseCode==200) {
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));   
         }else {
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
         }
         String inputLine;
         StringBuffer response = new StringBuffer();
         while((inputLine = br.readLine()) != null) {
            response.append(inputLine);
         }
         br.close();
         // json객체에 담아서 db에 저장할 session정보
         System.out.println("계정 정보"+response.toString());
         JSONObject json = (JSONObject) JSONValue.parse(response.toString()); 
         JSONObject sjon = (JSONObject) json.get("response");
         String id = (String) sjon.get("id");
         System.out.println("아이디" + id);                  
         
         String[] userEmail = ((String) sjon.get("email")).split("@");
         String uEmail = userEmail[0];
         
         session.setAttribute("uEmail", uEmail);
         
         session.setAttribute("response", response);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      }
		/*
		 * 쿼리테스트 이후에 아이디 중복검사를 실행한후 중복이 o/x 여부에 따라 서비스를 태워 디비에 저장해준다.
		 * service.dup() if() {
		 * 
		 * } service.regi(response.id);
		 */
       
       return "SearchPage"; //여기 이제 메인(검색 페이지로)넘어갈곳 정해줘야함
    }
	
    @RequestMapping(value = "/adminLogin.do", method = RequestMethod.GET)
    public String admingLogin(HttpSession session, StadiumAdminDto SADto) {
    	log.info("관리자 로그인 \t:{}", SADto);
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("admin_id", SADto.getAdmin_id());
    	map.put("admin_pw", SADto.getAdmin_pw());
    	StadiumAdminDto sadto = service.adminLogin(map);
    	System.out.println("sadto 값 확인 : "+sadto);
    	if(sadto != null) {
    		session.setAttribute("sadto", sadto);
    	}else {
    		return "LoginPage";
    	}
    	return "AdminReservationPage";
    }
    
	
}
