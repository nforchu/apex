<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block">
              <img src="<c:url value="/images/welcome.webp" />" 
                   alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form name="f" action="/login" method="post">

                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                    <span class="h1 fw-bold mb-0">Logo</span>
                  </div>

                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Apex Admin Console</h5>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="email">Email address</label>
                    <input name="email" type="text" id="email" class="form-control form-control-lg" />
                  </div>

                  <div class="form-outline mb-4">
                  	<label class="form-label" for="password">Password</label>
                    <input name="password" type="password" id="password" class="form-control form-control-lg" />                    
                  </div>

                  <div class="pt-1 mb-4">
                    <input type="submit" class="btn btn-dark btn-lg btn-block" />
                  </div>

                  <a class="small text-muted" href="#!">Forgot password?</a>
                  
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  
                  <div>
	                  <a href="#!" class="small text-muted">Terms of use.</a>
	                  <a href="#!" class="small text-muted">Privacy policy</a>
                  </div>
                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>