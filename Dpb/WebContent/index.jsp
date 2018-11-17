<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		
		<style type="text/css">
		
			* {box-sizing: border-box}
	
			/* style the container */
			.container {
			  position: relative;
			  border-radius: 5px;
			  background-color: #f2f2f2;
			  padding: 20px 0 30px 0;
			} 
			
			/* style inputs and link buttons */
			input,
			.btn {
			  width: 100%;
			  padding: 12px;
			  border: none;
			  border-radius: 4px;
			  margin: 5px 0;
			  opacity: 0.85;
			  display: inline-block;
			  font-size: 17px;
			  line-height: 20px;
			  text-decoration: none; /* remove underline from anchors */
			}
			
			input:hover,
			.btn:hover {
			  opacity: 1;
			}			
						
			/* style the submit button */
			input[type=submit] {
			  background-color: #4CAF50;
			  color: white;
			  cursor: pointer;
			}
			
			input[type=submit]:hover {
			  background-color: #45a049;
			}
			
			/* Two-column layout */
			.col {
			  float: left;
			  width: 50%;
			  margin: auto;
			  padding: 0 50px;
			  margin-top: 6px;
			}
			
			/* Clear floats after the columns */
			.row:after {
			  content: "";
			  display: table;
			  clear: both;
			}
			
			/* vertical line */
			.vl {
			  position: absolute;
			  left: 50%;
			  transform: translate(-50%);
			  border: 2px solid #ddd;
			  height: 175px;
			}
			
			/* text inside the vertical line */
			.inner {
			  position: absolute;
			  top: 50%;
			  transform: translate(-50%, -50%);
			  background-color: #f1f1f1;
			  border: 1px solid #ccc;
			  border-radius: 50%;
			  padding: 8px 10px;
			}
			
			/* hide some text on medium and large screens */
			.hide-md-lg {
			  display: none;
			}
			
			/* bottom container */
			.bottom-container {
			  text-align: center;
			  background-color: #666;
			  border-radius: 0px 0px 4px 4px;
			}
			
			/* Responsive layout - when the screen is less than 650px wide, make the two columns stack on top of each other instead of next to each other */
			@media screen and (max-width: 650px) {
			  .col {
			    width: 100%;
			    margin-top: 0;
			  }
			  /* hide the vertical line */
			  .vl {
			    display: none;
			  }
			  /* show the hidden text on small screens */
			  .hide-md-lg {
			    display: block;
			    text-align: center;
			  }
			}
		
		</style>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
						
	</head>
	<body>
		<div class="container">
			<form action="CadastroVendedor">
			    <div class="bottom-container">
				  <div class="row">
				    <div class="col">
				      <a href="cadastro_vendedor.jsp" style="color:white" class="btn">Cadastrar</a>
				    </div>				  
				  </div>
				</div>		
			</form>
		</div>		
	</body>
</html>