<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Fornecedor"%>
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
<title>Cadastro Fornecedor</title>
</head>
<body>
	<nav class="navbar" data-spy="affix">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navItems">
				<span class="glyphicon glyphicon-menu-hamburger"></span>
			</button>
			<a class="navbar-brand" href="/PrjBancoDeDados/"><span
				class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
		</div>

		<div class="collapse navbar-collapse" id="navItems">
			<ul class="nav navbar-nav">
				<li><a href="FuncionarioController">Funcion�rios</a></li>
				<li><a href="CompraController">Compras</a></li>
				<li><a href="ProdutoController">Produtos</a></li>
				<li><a href="FornecedorController">Fornecedores</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<h1>Atualizar Fornecedor</h1>
		<form action="AtualizarFornecedorController" method="post">
			<%
			Fornecedor f = (Fornecedor) request.getAttribute("fornecedor");
			%>
			<input type="hidden" value="<%= f.getId() %>" name="id"/>
			<div class="row linhaForm">
				<div class="col-sm-2 labelForm">Raz�o Social:</div>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="razaoSocial"
						value="<%=f.getRazaoSocial()%>" />
				</div>
				<div class="col-sm-1 labelForm">CNPJ:</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="cnpj"
						value="<%=f.getCnpj()%>" />
				</div>
			</div>
			<button type="submit" class="btn btn-warning btnForm">
				<span class="glyphicon glyphicon-ok-circle"></span> Salvar
			</button>
		</form>
	</div>
</body>
</html>
