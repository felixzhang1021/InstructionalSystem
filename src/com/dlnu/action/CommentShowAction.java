package com.dlnu.action;

import java.text.DateFormat;
import java.text.ParseException;
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

import com.dlnu.model.Comment;
import com.dlnu.model.Message;
import com.dlnu.service.CommentService;
import com.dlnu.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Namespace("/")
@Action(value="showcomment",results={@Result(name="success",type="redirect",location="/comment.jsp")})
public class CommentShowAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	private int comId;
	private int messageId;
	private String comcontent;
	private String comperson;
	private Date comDate;
	private String error;
	private Comment comment;
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	@Resource
	private CommentService commentService;
	@Resource
	private MessageService messageService;

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getComcontent() {
		return comcontent;
	}

	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}

	public String getComperson() {
		return comperson;
	}

	public void setComperson(String comperson) {
		this.comperson = comperson;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("--messageId-->>"+messageId);
		List<Comment> commentShow = commentService.showCommentList(messageId);
		List<Message> messageById = messageService.showMessageById(messageId);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		JSONArray jsonArray = new JSONArray();
		
		Message messageByIdList = (Message)messageById.get(0);
		JSONObject messageJsonObject = new JSONObject();
		messageJsonObject.put("messageId", messageByIdList.getMessageId());
		messageJsonObject.put("content", messageByIdList.getContent());
		messageJsonObject.put("stuName", messageByIdList.getStuName());
		messageJsonObject.put("messageDate", formatter.format(messageByIdList.getMessageDate()));
		jsonArray.add(messageJsonObject);
		
		for(int i=0;i<commentShow.size();i++){
			Comment commentList =(Comment)commentShow.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("comId", commentList.getComId());
			jsonObject.put("messageId", commentList.getMessageId());
			jsonObject.put("comContent", commentList.getComcontent());
			jsonObject.put("comPerson", commentList.getComperson());
			jsonObject.put("comDate", formatter.format(commentList.getComDate()));
			jsonArray.add(jsonObject);
			}

		session.setAttribute("json", jsonArray);
		System.out.println("--jsonArray-->>"+jsonArray);
		return SUCCESS;
	}
	public String save() throws ParseException{
		HttpSession session = request.getSession();
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		String dateString = sm.format(currentDate);
		Date currentTime_2 = sm.parse(dateString);


		Comment commentTemp = new Comment();
		commentTemp.setComcontent(comcontent);
		commentTemp.setComperson(comperson);
		commentTemp.setMessageId(messageId);
		commentTemp.setComDate(currentTime_2);
		
		try {
			if(commentService.save(commentTemp)==1){
				return SUCCESS;
			}
			else{
				error="����ʧ��";
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
