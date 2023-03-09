<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="author" content="LiJin">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/btn.css" />
	<style type="text/css">
	td {
		padding-top: 8px;
	}
	#file_upload1 {
		display: none;
	}
	#file_upload1_label {
		display: inline-block;
		border: 1px solid #aaa;
		width: 120px;
		height: 145px;
		margin-left: 20px;
		text-align: center;
		line-height: 145px;
		cursor: pointer;
	}
	</style>
</head>

<body
	style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">添加图书</div>
	<hr />
	<div align="center">
		<form action="${pageContext.request.contextPath}/book/insertBook" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>书名：</td>
<%--					name属性需要和实体类一致--%>
					<td><input type="text" name="name"
						class="el-input__inner"></td>
					<td rowspan="14" style="width: 300px">
					<td></td>
				</tr>
				<tr>
					<td>价格：</td>
					<td><input type="number" name="price" class="el-input__inner" step="any"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<span id="uploadtip">添加图书封面</span>
							<img id="uploadimg" src="" alt="" width="118px" height="143px" />
						</label>
						<input type="file" name="coverFile" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="stock"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="author"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="press"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="pressDate"
						class="el-input__inner"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>
