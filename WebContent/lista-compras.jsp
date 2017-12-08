<%@page import="java.util.ArrayList"%>
<%@page import="model.Compra"%>
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
<title>Compra</title>
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
				<li><a href="FuncionarioController">Funcionários</a></li>
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
				<h1>Compras</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Data</th>
								<th>Preco</th>
								<th>Id do Funcionário</th>
								<th>Id do Fornecedor</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<Compra> cs = (ArrayList<Compra>) request.getAttribute("listaCompras");
								for (Compra c : cs) {
							%>
							<tr>
								<td><%=c.getId()%></td>
								<td><%=c.getData()%></td>
								<td><%=c.getPreco()%></td>
								<td><%=c.getIdFuncionario()%></td>
								<td><%=c.getIdFornecedor()%></td>
								<td><a href="AtualizarCompraController?id=<%=c.getId()%>"
									class="btn btn-warning btn-sm"> <span
										class="glyphicon glyphicon-eye-open"></span>
								</a>
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