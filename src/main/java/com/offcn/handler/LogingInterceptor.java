package com.offcn.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.po.ActiveUser;
import com.offcn.util.ResourcesUtil;

public class LogingInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 * ������֮ǰ�����ط���
	 */

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//1\���������������ʵ���Դ��ַ
		List<String> list = ResourcesUtil.getKeyList("anonymousURL");
		//2\��ȡ�û�����ĵ�ַ
		String url=request.getRequestURI();
		for(String obj:list){
			if(url.indexOf(obj)>=0){
				//�Ա�������ַ�������ַ,��������ַ���������������ַ,֤���û�����ĵ�ַ������������,����
				return true;
			}
			
		//3\����Ƿ���ڵ�¼��session
			HttpSession session = request.getSession();
			ActiveUser auser=null;
			auser=(ActiveUser) session.getAttribute("auser");
			//���session�����ܹ���ȡ����¼��Ϣ,��ʾ�û��Ѿ���¼��,ֱ�ӷ���
			if(auser!=null){
				return true;
			}
			
		//4\����2����������� �û����ʼ�����������ַ,Ҳû�е�½��,ֱ��ת�򵽵�¼����
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		return false;
	}

}
