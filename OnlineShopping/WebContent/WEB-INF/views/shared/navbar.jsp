 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li id="home">
              <a class="nav-link" href="${pageContext.request.contextPath}/home">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li id="about">
              <a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
            </li>
            <li id="listProducts">
              <a class="nav-link" href="${pageContext.request.contextPath}/showAllProducts">Product</a>
            </li>
            <li id="contact">
              <a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>