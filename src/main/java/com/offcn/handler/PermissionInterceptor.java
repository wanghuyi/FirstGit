package com.offcn.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.po.ActiveUser;
import com.offcn.po.Permission;
import com.offcn.util.ResourcesUtil;

public class PermissionInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * ֮ǰ��д��Ȩ���ط���
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//1\��ȡ���ʵ�ַ
		String url = request.getRequestURI();
		
		//0\��ȡ������ַ
		List<String> list1 = ResourcesUtil.getKeyList("anonymousURL");
		for(String obj:list1){
			if(url.indexOf(obj)>=0){
				//�Ա�������ַ�������ַ,��������ַ���������������ַ,֤���û�����ĵ�ַ������������,����
				return true;
			}
		}
		//2\���ص�¼��֤ͨ���Ժ���Թ������ʵ���Դ��ַ
		List<String> list = ResourcesUtil.getKeyList("commonURL");
		
		//3\�жϷ��ʵ�ַ�Ƿ��ǹ�����ַ
		for(String obj:list){
			if(url.indexOf(obj)>=0){
				return true;
			}
		}
		//4\������ǹ������ʵ�ַ,�ж��û��Ƿ��¼��
		HttpSession session = request.getSession();
		ActiveUser auser=null;
		auser=(ActiveUser) session.getAttribute("auser");
		
		//5\�ж��û����ʵ�ַ�Ƿ�����Ȩ��Χ��
		if(auser!=null){
		List<Permission> listPermission = auser.getPermissions();
		for (Permission permission : listPermission) {
			if(permission!=null){
			String purl=permission.getUrl();
			if(url.indexOf(purl)>=0){
				return true;
			}
			}
		}
		}
		//6\���϶�û��ƥ����,��ת����Ȩ��ҳ��
		request.getRequestDispatcher("/refuse.jsp").forward(request, response);
		
		return false;
	}

}
