<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar Clientes</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
		
	</head>
	<body>
	
		<div class="container">
		
		
		<h1>Cadastro de Clientes</h1>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="cadastro_cliente.jsp">Home<span class="sr-only">(cadastro_cliente.jsp)</span></a>
		      </li>
		    </ul>
		  </div>
		</nav>
			
			<br>
		
			<form action="CadastroVendedor" method="post">
			  <div class="form-group">
			    <label for="razaoSocialID">Razão Social</label>
			    <input type="text" name="razaoSocial" value="${ cliente.razaoSocial }" class="form-control" id="razaoSocial" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="nomeFantasiaID">Nome Fantasia</label>
			    <input type="text" name="nomeFantasia" value="${ cliente.nomeFantasia }" class="form-control" id="nomeFantasia" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="cnpjID">CNPJ</label>
			    <input type="text" name="cnpj" value="${ cliente.cnpj }" class="form-control" id="cnpj" placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="logradouroID">Logradouro</label>
			    <input type="text" name="logradouro" value="${ cliente.logradouro }" class="form-control" id="logradouro" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="numeroID">Número</label>
			    <input type="text" name="numero" value="${ cliente.numero }" class="form-control" id="numero" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="bairroID">Bairro</label>
			    <input type="text" name="bairro" value="${ cliente.bairro }" class="form-control" id="bairro" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="cidadeID">Cidade</label>
			    <input type="text" name="cidade" value="${ cliente.cidade }" class="form-control" id="cidade" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="estadoID">Estado</label>
			    <input type="text" name="estado" value="${ cliente.estado }" class="form-control" id="estado" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="emailID">E-mail</label>
			    <input type="text" name="email" value="${ cliente.email }" class="form-control" id="email" placeholder="" required>
			  </div>
			  
			  <br>
			  <tr>
				<td>
					<input type="hidden" value="inserir" name="action">
					<input type="hidden" value="${ cliente.id }" name="id_cliente">
				</td>
			  </tr>
	
			  <button type="submit" name="btnSalvar" id="btnSalvar" class="btn btn-primary">Salvar</button>
			</form>
			
			<br>
		
		</div>
	
	</body>
</html>