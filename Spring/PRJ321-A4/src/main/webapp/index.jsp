<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form action="login" method="post">
          
				<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>

                  <div class="form-outline mb-4">
                  	<label class="form-label">Username</label>
                    <input type="text" name="username" class="form-control form-control-lg" />
                    
                  </div>

                  <div class="form-outline mb-4">
                  	<label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control form-control-lg" />
                    
                  </div>

                  <div class="pt-1 mb-4">
                    <button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
                  </div>

                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>



