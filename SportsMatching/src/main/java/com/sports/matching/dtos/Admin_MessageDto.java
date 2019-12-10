package com.sports.matching.dtos;

import java.io.Serializable;
import java.util.Date;

public class Admin_MessageDto implements Serializable {

	private static final long serialVersionUID = 4423861992927555551L;

	private String msg_chat_id;
	private String message_content;
	private Date message_date;
	private String chat_id;
	private String sender;

	public Admin_MessageDto() {
		// TODO Auto-generated constructor stub
	}

}
