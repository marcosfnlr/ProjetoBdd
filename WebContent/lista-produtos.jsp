<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Funcionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/funcionario.css">
<title>Produtos</title>
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
		<div class="row listHeader">
			<div class="col-sm-10">
				<h1>Produtos</h1>
			</div>
			<div class="col-sm-2">
				<a href="CadastroProdutoController" class="btn btn-warning">
					<span class="glyphicon glyphicon-plus"></span> Novo Produto
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nome</th>
								<th>Descri��o</th>
								<th>A��es</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<Produto> ps = (ArrayList<Produto>) request.getAttribute("listaProdutos");
								for (Produto p : ps) {
							%>
							<tr>
								<td><%=p.getId()%></td>
								<td><%=p.getNome()%></td>
								<td><%=p.getDescricao().length() > 20 ? p.getDescricao().substring(0, 18) + "..." : p.getDescricao()%></td>
								<td><a
									href="AtualizarProdutoController?id=<%=p.getId()%>"
									class="btn btn-warning btn-sm"> <span
										class="glyphicon glyphicon-pencil"></span>
								</a> <a href="ExcluirProdutoController?id=<%=p.getId()%>"
									class="btn btn-danger btn-sm"> <span
										class="glyphicon glyphicon-remove"></span>
								</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>