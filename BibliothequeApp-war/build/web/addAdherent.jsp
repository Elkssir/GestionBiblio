<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="h" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Adhérent – BibliothèqueApp</title>
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

<!-- Formulaire -->
<div class="container mt-5">
    <div class="card shadow-sm border-0 card-hover form-container">
        <div class="card-body">
            <h3 class="text-success mb-4 text-center">
                <i class="bi bi-person-plus-fill me-2"></i>Ajouter un Adhérent
            </h3>

            <h:form action="addAdherent.do" method="post">
                <div class="mb-3">
                    <label>Numéro</label>
                    <h:text property="numero" styleClass="form-control"/>
                    <div class="text-danger small"><h:errors property="numero"/></div>
                </div>

                <div class="mb-3">
                    <label>Prénom</label>
                    <h:text property="prenom" styleClass="form-control"/>
                    <div class="text-danger small"><h:errors property="prenom"/></div>
                </div>

                <div class="mb-3">
                    <label>Nom</label>
                    <h:text property="nom" styleClass="form-control"/>
                    <div class="text-danger small"><h:errors property="nom"/></div>
                </div>

                <div class="mb-3">
                    <label>Email</label>
                    <h:text property="email" styleClass="form-control"/>
                    <div class="text-danger small"><h:errors property="email"/></div>
                </div>

                <div class="mb-3">
                    <label>Téléphone</label>
                    <h:text property="telephone" styleClass="form-control"/>
                    <div class="text-danger small"><h:errors property="telephone"/></div>
                </div>

                <div class="mb-3">
                    <label>Date d'inscription</label>
                    <h:text property="dateInscription" styleClass="form-control" onfocus="this.type='date'"/>
                    <div class="text-danger small"><h:errors property="dateInscription"/></div>
                </div>

                <div class="mb-3">
                    <label>Statut</label>
                    <h:select property="statut" styleClass="form-select">
                        <h:option value="actif">Actif</h:option>
                        <h:option value="inactif">Inactif</h:option>
                    </h:select>
                    <div class="text-danger small"><h:errors property="statut"/></div>
                </div>

                <div class="d-flex justify-content-between">
                    <h:submit value="Ajouter" styleClass="btn btn-success"/>
                    <a href="listAdherents.do" class="btn btn-outline-secondary">Annuler</a>
                </div>
            </h:form>
        </div>
    </div>
</div>

</body>
</html>
