<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>青鸟租房 - 用户登录</TITLE>
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
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DIV class=box>
				<H4>用户登录</H4>
				<FORM id=user method="post" name=user action=denglu>
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD colSpan=2></TD>
								</TR>
								<TR>
									<TD class=field>用 户 名：</TD>
									<TD>
										<!-- <input type="text" class="text" name="name" /> --> <INPUT
										id=user_name class=text type=text name=uname>
									</TD>
								</TR>
								<TR>
									<TD class=field>密 码：</TD>
									<TD>
										<!-- <input type="password" class="text" name="password" /> -->
										<INPUT id=user_password class=text type=password name=upwd>
									</TD>
								</TR>
								<!--
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						-->
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT value=登陆 type="submit"> <INPUT
								onclick='document.location="regs.jsp"' value=注册 type=button>
						</DIV>
					</DIV>
				</FORM>
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
