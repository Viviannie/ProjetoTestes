<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar Vendedores</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
		
	</head>
	<body>
	
		<div class="container">
		
		
		<h1>Cadastro de Vendedores</h1>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="cadastro_vendedor.jsp">Home<span class="sr-only">(cadastro_vendedor.jsp)</span></a>
		      </li>
		    </ul>
		  </div>
		</nav>
			
			<br>
		
			<form action="CadastroVendedor" method="post">
			  <div class="form-group">
			    <label for="nomeID">Nome</label>
			    <input type="text" name="nome" value="${ vendedor.nome }" class="form-control" id="nome" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="cpfID">CPF</label>
			    <input type="text" name="cpf" value="${ vendedor.cpf }" class="form-control" id="cpf" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="emailID">E-mail</label>
			    <input type="text" name="email" value="${ vendedor.email }" class="form-control" id="email" placeholder="">
			  </div>
			  <div class="form-group">
			    <label for="senhaID">Senha</label>
			    <input type="password" name="senha" value="${ vendedor.senha }" class="form-control" id="senha" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="logradouroID">Logradouro</label>
			    <input type="text" name="logradouro" value="${ vendedor.logradouro }" class="form-control" id="logradouro" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="numeroID">Número</label>
			    <input type="text" name="numero" value="${ vendedor.numero }" class="form-control" id="numero" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="bairroID">Bairro</label>
			    <input type="text" name="bairro" value="${ vendedor.bairro }" class="form-control" id="bairro" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="cidadeID">Cidade</label>
			    <input type="text" name="cidade" value="${ vendedor.cidade }" class="form-control" id="cidade" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="estadoID">Estado</label>
			    <input type="text" name="estado" value="${ vendedor.estado }" class="form-control" id="estado" placeholder="" required>
			  </div>
			  <div class="form-group">
			    <label for="ativoID">Ativo</label>
			    <input type="text" name="ativo" value="${ vendedor.ativo }" class="form-control" id="ativo" placeholder="" required>
			  </div>
			  
			  <br>
			  <tr>
				<td>
					<input type="hidden" value="inserir" name="action">
					<input type="hidden" value="${ vendedor.id }" name="id_vendedor">
				</td>
			  </tr>
	
			  <button type="submit" name="btnSalvar" id="btnSalvar" class="btn btn-primary">Salvar</button>
			</form>
			
			<br>
		
		</div>
	
	</body>
</html>