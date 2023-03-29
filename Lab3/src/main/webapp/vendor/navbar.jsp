<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/Lab3_war_exploded/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Lab3_war_exploded/addStudent">Add Item</a>
                </li>
                <form class="d-flex" role="search" action="/Lab3_war_exploded/search" method = "get">
                    <select name="mySelect">
                        <option value="name">Name</option>
                        <option value="surname">Surname</option>
                        <option value="age">Age</option>
                        <option value="year">Year of addmission</option>
                    </select>
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </ul>
        </div>
    </div>
</nav>