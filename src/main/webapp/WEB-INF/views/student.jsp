<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
  	<div class="container">
  		 <h1>Student Register Page</h1>
  		 <h6>${msg}</h6>
  		 <form action="save" method="post">
  		 
  		 	<div class="mb-3">
			  <label for="exampleFormControlInput1" class="form-label">Name</label>
			  <input type="text" class="form-control" id="exampleFormControlInput1" name="name" placeholder="Name" required>
			</div>
			<div class="mb-3">
			  <label for="exampleFormControlInput1" class="form-label">Email address</label>
			  <input type="email" class="form-control" id="exampleFormControlInput1" name="email" placeholder="name@example.com" required>
			</div>
			<div class="mb-3">
			  <label for="exampleFormControlInput1" class="form-label">Phone Number</label>
			  <input type="number" class="form-control" id="exampleFormControlInput1" name="phone" placeholder="1234567890" required>
			</div>
			<button type="submit" class="btn btn-primary"> Add </button>
  		 </form>
  		 <a href="home">Home</a>
  	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>