<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<BODY>

	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>

	<DIV id=view class="main wrap">
		<DIV class=intro>
			<DIV class=lefter>
				<H1>${xx.hname }</H1>
				<DIV class=subinfo>${xx.shijian}</DIV>
				<DIV class=houseinfo>
					<P>
						户 型：<SPAN>
						<c:if test="${xx.tid eq 1}">一室一厅</c:if>
						<c:if test="${xx.tid eq 2}">一室两厅</c:if>
						<c:if test="${xx.tid eq 3}">两室一厅</c:if>
						<c:if test="${xx.tid eq 4}">两室两厅</c:if>
						</SPAN>
					</P>
					<P>
						面 积：<SPAN>${xx.hmianji}m<SUP>2</SUP></SPAN>
					</P>
					<P>
						位 置：<SPAN>
						<c:if test="${xx.did eq 1}">开福区</c:if>
						<c:if test="${xx.did eq 2}">岳麓区</c:if>
						<c:if test="${xx.did eq 3}">天心区</c:if>
						<c:if test="${xx.did eq 4}">雨花区</c:if>
									
						<c:if test="${xx.sid eq 1}">共和街道</c:if>
						<c:if test="${xx.sid eq 2}">美合街</c:if>
						<c:if test="${xx.sid eq 3}">麻马飒飒街</c:if>
						<c:if test="${xx.sid eq 4}">赫利街</c:if>
							</SPAN>
					</P>
					<P>
						联系方式：<SPAN>${xx.dianhua}</SPAN>
					</P>
				</DIV>
			</DIV>
			<DIV class=side>
				<P>
					<A class=bold href="http://localhost:8080/House-2/#">北京青鸟房地产经纪公司</A>
				</P>
				<P>资质证书：有</P>
				<P>内部编号:1000</P>
				<P>联 系 人：PG</P>
				<P>
					联系电话：<SPAN>0731-5213</SPAN>
				</P>
				<P>
					手机号码：<SPAN>151321525</SPAN>
				</P>
			</DIV>
			<DIV class=clear></DIV>
			<DIV class=introduction>
				<H2>
					<SPAN><STRONG>房源详细信息</STRONG></SPAN>
				</H2>
				<DIV class=content>
					<P>${xx.xiangxi}</P>
				</DIV>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</BODY>
</HTML>
