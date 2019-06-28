<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<META name=GENERATOR>
</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
		<DIV class=search>
			<LABEL class="ui-green searchs"><a href="fabu" title="">发布房屋信息</a></LABEL>
			<LABEL class=ui-green><INPUT
				onclick='document.location="login.jsp"' value="退       出"
				type=button name=search></LABEL>
		</DIV>
	</DIV>
	<DIV class="main wrap">
		<DIV id=houseArea>
			<TABLE class=house-list>
				<TBODY>
				
				<c:forEach items="${fang}" var="f">
					<TR>
						<TD class=house-thumb><SPAN><A href="FaBu?action=ddfwxx&id=${f.hid }"
								target="_blank"><img src="images/thumb_house.gif"
									width="100" height="75" alt=""></A></SPAN></TD>
						<TD>
							<DL>
								<DT>
									<A href="FaBu?action=ddfwxx&id=${f.hid }" target="_blank">${f.hname}</A>
								</DT>
								<DD>
									<c:if test="${f.did eq 1}">开福区</c:if>
									<c:if test="${f.did eq 2}">岳麓区</c:if>
									<c:if test="${f.did eq 3}">天心区</c:if>
									<c:if test="${f.did eq 4}">雨花区</c:if>
									
									<c:if test="${f.sid eq 1}">共和街道</c:if>
									<c:if test="${f.sid eq 2}">美合街</c:if>
									<c:if test="${f.sid eq 3}">麻马飒飒街</c:if>
									<c:if test="${f.sid eq 4}">赫利街</c:if>
									,${f.hmianji}平米<BR>联系方式：${f.dianhua}
								</DD>
							</DL>
						</TD>
						<TD class=house-type><LABEL class=ui-green><INPUT
								onclick='document.location="update2?hid=${f.hid }"' value="修    改" type=button name=search></LABEL></TD>
						<TD class=house-price><LABEL class=ui-green>
						<INPUT onclick='document.location="javascript:void(0)"' value="删    除" type=button name=search class="del">
						<input type="hidden" value="${f.hid }">
						</LABEL></TD>
					</TR>
					</c:forEach>
					
				</TBODY>
			</TABLE>
		</DIV>
		<DIV class=pager>
			<UL>
				<LI class=current><A id=widget_338868862
					href="guanli?pageindex=1"
					parseContent="true" showError="true" targets="houseArea"
					ajaxAfterValidation="false" validate="false"
					dojoType="struts:BindAnchor">首页</A>
				</LI>
				<LI class=current><A id=widget_338868862
					href="guanli?pageindex=${pindex-1}"
					parseContent="true" showError="true" targets="houseArea"
					ajaxAfterValidation="false" validate="false"
					dojoType="struts:BindAnchor">上一页</A>
				</LI>
				<LI class=current><A id=widget_1160989910
					href="guanli?pageindex=${pindex+1}"
					parseContent="true" showError="true" targets="houseArea"
					ajaxAfterValidation="false" validate="false"
					dojoType="struts:BindAnchor">下一页</A>
				</LI>
				<LI class=current><A id=widget_1160989910
					href="guanli?pageindex=${ptotal}"
					parseContent="true" showError="true" targets="houseArea"
					ajaxAfterValidation="false" validate="false"
					dojoType="struts:BindAnchor">尾页</A>
				</LI>
			</UL>
			<SPAN class=total>${pindex}/${ptotal}页</SPAN>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</BODY>

  <script type="text/javascript">
  $(function(){
	  $(".del").click(function(){
		  if(confirm("确认删除吗?")){
			  var id=$(this).next().val();
			  var tr=$(this).parent().parent();
			  $.post("delete",{"id":id},function(data){
				  if(data=="ok"){
					  alert("删除成功");
					  tr.remove();
				  }else{
					  alert("删除失败");
				  }
			  });
		  }else{
			  
		  }
	 });
	  
  })
  </script>
</HTML>