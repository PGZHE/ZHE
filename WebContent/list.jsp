<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<DIV id=navbar class=wrap>
		<DL class="search clearfix">
			<FORM id=sform action=jiazai method="post">
				<DT>
					<UL>
						<LI class=bold>房屋信息</LI>
						<LI>标题：<INPUT class=text type=text name=hname> <LABEL
							class=ui-blue><INPUT
								onclick='document.location="jiazai"' value=搜索房屋
								type="submit" name=search></LABEL>
						</LI>
					</UL>
				</DT>

				<DD>
					<UL>
						<LI class=first>区县</LI>
						<LI><SELECT id="district" name=did>
								<OPTION selected value="0">请选择:</OPTION>
								<c:forEach items="${qu}" var="q">
									<OPTION selected value=${q.did}>${q.dname}</OPTION>
								</c:forEach>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>街道</LI>
						<LI><SELECT id=jiestreet name=sid>
								<OPTION selected value="0">请选择:</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>房型</LI>
						<LI><SELECT name=tid>
								<OPTION selected value="">请选择:</OPTION>
								<c:forEach items="${type}" var="t">
									<OPTION selected value=${t.tid}>${t.tname}</OPTION>
								</c:forEach>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>价格</LI>
						<LI><SELECT name=hqian>
								<OPTION selected value="">不限</OPTION>
								<OPTION value=99>100元以下</OPTION>
								<OPTION value=150>100元—200元</OPTION>
								<OPTION value=200>200元以上</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>面积</LI>
						<LI><SELECT name=hmianji>
								<OPTION selected value="">不限</OPTION>
								<OPTION value=39>40以下</OPTION>
								<OPTION value=200>40-500</OPTION>
								<OPTION value=500>500以上</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
			</FORM>
		</DL>
	</DIV>
	<DIV class="main wrap">
		<TABLE class=house-list>
			<TBODY>

				<c:forEach items="${fang}" var="f">
					<TR>
						<TD class=house-thumb><span><A href="details.htm"
								target="_blank"><img src="images/thumb_house.gif"
									width="100" height="75" alt=""></a></span></TD>
						<TD>
							<DL>
								<DT>
									<A href="details.htm" target="_blank">${f.hname}</A>
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
									, ${f.hmianji }平米<BR>联系方式：${f.dianhua }
								</DD>
							</DL>
						</TD>
						<TD class=house-type><c:if test="${f.tid eq 1}">一室一厅</c:if> <c:if
								test="${f.tid eq 2}">一室两厅</c:if> <c:if test="${f.tid eq 3}">两室一厅</c:if>
							<c:if test="${f.tid eq 4}">两室两厅</c:if></TD>
						<TD class=house-price><SPAN>${f.hqian}</SPAN>元/月</TD>
					</TR>
				</c:forEach>

				<TR>无租房信息
				</TR>
			</TBODY>
		</TABLE>
		<DIV class=pager>
			<UL>
				<LI class=current><A href="jiazai?pageindex=1">首页</A></LI>
				<LI><A href="jiazai?pageindex=${pindex-1}">上一页</A></LI>
				<LI><A href="jiazai?pageindex=${pindex+1}">下一页</A></LI>
				<LI><A href="jiazai?pageindex=${ptotal}">末页</A></LI>
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
	$(function() {
		qu();
	});
	$("#district").change(function() {
		qu()
	});

	function qu() {
		var id = $("#district").val();
		if (id != 0) {
			$("#jiestreet").html("<OPTION selected value='0'>请选择</OPTION>");
			$.post("jiejiazai", {
				"quid" : id
			}, function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#jiestreet").append(
							"<OPTION selected value="+data[i].sid+">"
									+ data[i].sname + "</OPTION>");
				}
			}, "json");
		} else {
			$("#jiestreet").html("<OPTION selected value='0'>请选择</OPTION>");
		}

	}
</script>
</HTML>
