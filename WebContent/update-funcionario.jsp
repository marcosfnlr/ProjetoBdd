<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Cargo"%>
<%@page import="model.Funcionario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/funcionario.css">
<title>Cadastro Funcionario</title>
</head>
<body>
	<nav class="navbar" data-spy="affix">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navItems">
				<span class="glyphicon glyphicon-menu-hamburger"></span>
			</button>
			<a class="navbar-brand" href="#"><span
				class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
		</div>

		<div class="collapse navbar-collapse" id="navItems">
			<ul class="nav navbar-nav">
				<li><a href="FuncionarioController">Funcionários</a></li>
				<li><a href="CompraController">Compras</a></li>
				<li><a href="ProdutoController">Produtos</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<h1>Atualizar Funcionário</h1>
		<form action="AtualizarFuncionarioController" method="post">
			<%
				Funcionario f = (Funcionario) request.getAttribute("funcionario");
			%>
			<input type="hidden" value="<%= f.getId() %>" name="id"/>
			<div class="row linhaForm">
				<div class="col-sm-1 labelForm">Nome:</div>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="nome"
						value="<%=f.getNome()%>" />
				</div>
				<div class="col-sm-1 labelForm">CPF:</div>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="cpf"
						value="<%=f.getCpf()%>" />
				</div>
			</div>
			<div class="row linhaForm">
				<div class="col-sm-1 labelForm">Cargo:</div>
				<div class="col-sm-5">
					<select class="form-control" name="cargo">
						<%
							ArrayList<Cargo> cargos = (ArrayList<Cargo>) request.getAttribute("listaCargos");
							for (Cargo cargo : cargos) {
						%>
						<option <%=f.getIdCargo() == cargo.getId() ? "selected" : ""%>
							value="<%=cargo.getId()%>"><%=cargo.getTitulo()%></option>
						<%
							}
						%>
					</select>
				</div>

				<div class="col-sm-1 labelForm">E-mail:</div>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="email"
						value="<%=f.getEmail()%>" />
				</div>
			</div>
			<button type="submit" class="btn btn-warning btnForm">
				<span class="glyphicon glyphicon-ok-circle"></span> Salvar
			</button>
		</form>
	</div>
</body>
</html>
