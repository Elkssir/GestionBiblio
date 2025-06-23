<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="h" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Livre – BibliothèqueApp</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
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
<div class="container mt-5">
    <div class="card shadow-sm border-0 card-hover form-container">
        <div class="card-body">
            <h3 class="text-warning text-center mb-4">
                <i class="bi bi-pencil me-2"></i>Modifier Livre
            </h3>

            <h:form action="updateLivre.do" method="post">
                <div class="mb-3">
                    <label class="form-label">Code</label>
                    <h:text property="code" styleClass="form-control" readonly="true"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Titre</label>
                    <h:text property="titre" styleClass="form-control"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Auteur</label>
                    <h:text property="auteur" styleClass="form-control"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Catégorie</label>
                    <h:text property="categorie" styleClass="form-control"/>
                </div>

                <div class="mb-4">
                    <label class="form-label">Nombre d'exemplaires</label>
                    <h:text property="nbExemplaires" styleClass="form-control"/>
                </div>

                <div class="d-flex justify-content-between">
                    <h:submit value="Mettre à jour" styleClass="btn btn-warning"/>
                    <a href="listLivres.do" class="btn btn-outline-secondary">Annuler</a>
                </div>
            </h:form>
        </div>
    </div>
</div>

</body>
</html>
