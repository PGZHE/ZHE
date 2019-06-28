package com.cssl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cssl.pojo.House;
import com.cssl.pojo.Street;
import com.cssl.service.HouseService;
import com.cssl.vo.HouseVo;

@Controller
public class RentingHouseController {
	@Autowired
	private HouseService housic;//���з���ҵ��������
	
	@RequestMapping("jiazai")
	public ModelAndView jiazai(HouseVo hvo,ModelAndView mav,String pageindex) {//��ͨ�û�ҳ�����
		House h=new House();
		if(pageindex==null) {
			pageindex="1";   
		}
		int size=4;//��ʾ������
		h.setI((Integer.valueOf(pageindex)-1)*size);
		h.setS(size);
		int count = housic.countHouse();//��¼��
		int pagetotal=count%size==0?count/size:count/size+1;//��ҳ��
		
		BeanUtils.copyProperties(hvo, h);
		
		mav.addObject("ptotal",pagetotal);//�ܼ�¼��
		mav.addObject("pindex",pageindex);//��ʼ�Ǳ�
		mav.addObject("type", housic.selectType());//��������
		mav.addObject("qu",housic.selectDistrict());//����
		mav.addObject("fang",housic.selectTJHouse(h));//������Ϣ
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping(value="jiejiazai", produces="application/json;charset=utf-8")//����json������������
	@ResponseBody
	public String jiejz(int quid){//��������id��ѯ��Ӧ�Ľֵ�
		List<Street> chajie = housic.selectQuJie(quid);
		String rs=JSON.toJSONString(chajie);
		return rs;
	}
	
	@RequestMapping("guanli")
	public ModelAndView gljiazai(ModelAndView mav,String pageindex) {//����Աҳ�����
		if(pageindex==null) {
			pageindex="1";
		}
		int size=4;//��ʾ������
		int count = housic.countHouse();//��¼��
		int pagetotal=count%size==0?count/size:count/size+1;//��ҳ��
		mav.addObject("ptotal",pagetotal);//�ܼ�¼��
		mav.addObject("pindex",pageindex);//��ʼ�Ǳ�
		mav.addObject("fang",housic.selectHouse((Integer.valueOf(pageindex)-1)*size,size));//������Ϣ
		mav.setViewName("guanli");
		return mav;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public void shanchu(int id,HttpServletResponse response) throws IOException {//����idɾ��
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		if(housic.deleteHouse(id)>0) {
			out.print("ok");
		}else {
			out.print("no");
		}
		out.flush();
		out.close();
	}
	
	@RequestMapping("update1")
	public ModelAndView xiugaihuixian(ModelAndView mav,int id) {//�޸�֮ǰ����
		mav.addObject("xx",housic.selectZDHouse(id).get(0));//����id��ѯ���ķ�����ϸ��Ϣ
		mav.addObject("type", housic.selectType());
		mav.addObject("jie", housic.slectStreet());
		mav.addObject("qu", housic.selectDistrict());
		mav.setViewName("update");
		return mav;
	}
	
	@RequestMapping("update2")
	public ModelAndView xiugai(HouseVo hvo,ModelAndView mav) {//�޸ķ�����Ϣ
		House h=new House();
		BeanUtils.copyProperties(hvo, h);
		housic.updateHouse(h);
		System.out.println("====================================�������޸�");
		mav.setViewName("forward:guanli");
		return mav;
	}
	
	@RequestMapping("fabu")
	public ModelAndView fabujiazai(ModelAndView mav) {//��������ֵ���������
		mav.addObject("type", housic.selectType());
		mav.addObject("jie", housic.slectStreet());
		mav.addObject("qu", housic.selectDistrict());
		mav.setViewName("fabu");
		return mav;
	}
	
	@RequestMapping("insertfabu")
	public ModelAndView insertfabu(HouseVo hvo,ModelAndView mav) {
		House h=new House();
		BeanUtils.copyProperties(hvo, h);
		if(housic.insertFaBu(h)>0) {
			mav.setViewName("forward:guanli");
		}else {
			mav.setViewName("fabu");
		}
		return mav;//����������Ϣ
		
	}
	
}
