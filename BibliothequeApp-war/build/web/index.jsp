<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil – BibliothèqueApp</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .hero {
            padding: 80px 0;
        }
        .card-hover:hover {
            transform: translateY(-5px);
            transition: 0.3s ease-in-out;
        }
    </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
    <div class="container">
        <a class="navbar-brand fw-bold" href="index.jsp">
            <i class="bi bi-book me-2"></i>BibliothèqueApp
        </a>
    </div>
</nav>

<!-- Contenu principal -->
<div class="container hero text-center">
    <h1 class="display-5 text-dark mb-3">Bienvenue dans votre bibliothèque</h1>
    <p class="lead text-muted mb-5">Gérez vos livres, vos adhérents et vos emprunts en toute simplicité</p>

    <div class="row justify-content-center">
        <div class="col-md-4 mb-4">
            <div class="card card-hover border-0 shadow-sm">
                <div class="card-body">
                    <i class="bi bi-journal-bookmark display-4 text-primary mb-3"></i>
                    <h5 class="card-title">Gestion des Livres</h5>
                    <p class="card-text text-muted">Ajoutez, modifiez ou supprimez les livres de votre collection.</p>
                    <a href="listLivres.do" class="btn btn-primary mt-2 w-100">Accéder</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-4">
            <div class="card card-hover border-0 shadow-sm">
                <div class="card-body">
                    <i class="bi bi-person-badge display-4 text-success mb-3"></i>
                    <h5 class="card-title">Gestion des Adhérents</h5>
                    <p class="card-text text-muted">Gérez les informations des utilisateurs inscrits à la bibliothèque.</p>
                    <a href="listAdherents.do" class="btn btn-success mt-2 w-100">Accéder</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-4">
            <div class="card card-hover border-0 shadow-sm">
                <div class="card-body">
                    <i class="bi bi-arrow-left-right display-4 text-warning mb-3"></i>
                    <h5 class="card-title">Gestion des Emprunts</h5>
                    <p class="card-text text-muted">Suivez les emprunts et les retours de livres de vos adhérents.</p>
                    <a href="listEmprunts.do" class="btn btn-warning mt-2 w-100">Accéder</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
