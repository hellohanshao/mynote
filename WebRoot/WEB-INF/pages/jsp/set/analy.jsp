<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/common.jsp"%>
<div class="layui-main">
	<fieldset class="layui-elem-field">
		<legend>新增 &amp; 编辑</legend>
		<div class="layui-field-box">
			<div class="layui-form">
				<div class="layui-form-item admin-item-inline">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input type="text" name="title" required="" lay-verify="required"
								placeholder="登录账号" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input type="password" name="title" required=""
								lay-verify="required" placeholder="登录密码" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input type="password" name="title" required=""
								lay-verify="required" placeholder="确认密码" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<div class="layui-input-inline">
							<select name="quiz"><option value="">选择角色</option>
								<option value="1">超级管理员</option>
								<option value="2">客服部</option>
								<option value="3">生产部</option></select>
							<div class="layui-unselect layui-form-select">
								<div class="layui-select-title">
									<input type="text" placeholder="选择角色" value="" readonly=""
										class="layui-input layui-unselect"><i
										class="layui-edge"></i>
								</div>
								<dl class="layui-anim layui-anim-upbit">
									<dd lay-value="1" class="">超级管理员</dd>
									<dd lay-value="2" class="">客服部</dd>
									<dd lay-value="3" class="">生产部</dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="layui-inline">
						<div class="layui-input-inline">
							<button class="layui-btn">新增</button>
							<button class="layui-btn layui-btn-danger">修改</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="50">
				<col width="200">
				<col width="200">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary"
						lay-filter="allChoose">
					<div class="layui-unselect layui-form-checkbox" lay-skin="primary">
							<i class="layui-icon"></i>
						</div></th>
					<th>登录账号</th>
					<th>真实姓名</th>
					<th>所属角色</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" name="" lay-skin="primary">
					<div class="layui-unselect layui-form-checkbox" lay-skin="primary">
							<i class="layui-icon"></i>
						</div></td>
					<td>admin</td>
					<td>梵天</td>
					<td>超级管理员</td>
					<td><a title="编辑"
						class="layui-btn layui-btn-mini layui-btn-primary"><i
							class="layui-icon"></i> </a><a title="删除"
						class="layui-btn layui-btn-mini layui-btn-primary"><i
							class="layui-icon"></i></a></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="11"><div class="pages-account">
							<div class="layui-box layui-laypage layui-laypage-molv"
								id="layui-laypage-33">
								<span class="layui-laypage-curr"><em
									class="layui-laypage-em" style="background-color: #5FB878;"></em><em>1</em></span><a
									href="javascript:;" data-page="2">2</a><a href="javascript:;"
									data-page="3">3</a><a href="javascript:;"
									class="layui-laypage-next" data-page="2">下一页</a><span
									class="layui-laypage-total">到第 <input type="number"
									min="1" onkeyup="this.value=this.value.replace(/\D/, '');"
									value="1" class="layui-laypage-skip"> 页
									<button type="button" class="layui-laypage-btn">确定</button></span>
							</div>
						</div></td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>