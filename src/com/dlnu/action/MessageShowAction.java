package com.dlnu.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.dlnu.model.Message;
import com.dlnu.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Namespace("/")
@Action(value="messageshow",results={@Result(name="success",type="redirect",location="/message.jsp")})
public class MessageShowAction extends ActionSupport implements ServletRequestAware{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageId;
	private String stuName;
	private String content;
	private int comCount;
	private String messageDate;
	private String error;
	@Resource
	private MessageService messageService;
	HttpServletRequest request;
	
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getComCount() {
		return comCount;
	}

	public void setComCount(int comCount) {
		this.comCount = comCount;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public MessageService getMessageShowService() {
		return messageService;
	}

	public void setMessageShowService(MessageService messageService) {
		this.messageService = messageService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<Message> message = messageService.showMessageService();
		JSONArray jsonArray = new JSONArray();
		JSONObject result = new JSONObject();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<message.size();i++){
			Message messageList =(Message)message.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("messageId", messageList.getMessageId());
			jsonObject.put("content", messageList.getContent());
			jsonObject.put("stuName", messageList.getStuName());
			jsonObject.put("comCount", messageList.getComCount());
			jsonObject.put("messageDate", formatter.format(messageList.getMessageDate()));
			System.out.println("-date-->>"+formatter.format(messageList.getMessageDate()));
			jsonArray.add(jsonObject);
			}
		session.setAttribute("json", jsonArray);
		return SUCCESS;
	}
	public String save(){
		Message message = null;
		try {
			if(messageService.save(message)==1){
				return SUCCESS;
			}else{
				error = "¡Ù—‘ ß∞‹";
				return ERROR;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}
	
}
