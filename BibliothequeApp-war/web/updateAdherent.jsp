<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="h" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Adhérent – BibliothèqueApp</title>
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
                <i class="bi bi-pencil me-2"></i>Modifier Adhérent
            </h3>

            <h:form action="updateAdherent.do" method="post">
                <div class="mb-3">
                    <label class="form-label">Numéro</label>
                    <h:text property="numero" styleClass="form-control" readonly="true"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Prénom</label>
                    <h:text property="prenom" styleClass="form-control"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Nom</label>
                    <h:text property="nom" styleClass="form-control"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <h:text property="email" styleClass="form-control"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Téléphone</label>
                    <h:text property="telephone" styleClass="form-control"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Date d'inscription</label>
                    <h:text property="dateInscription" styleClass="form-control" onfocus="this.type='date'"/>
                </div>

                <div class="mb-4">
                    <label class="form-label">Statut</label>
                    <h:select property="statut" styleClass="form-select">
                        <h:option value="actif">Actif</h:option>
                        <h:option value="inactif">Inactif</h:option>
                    </h:select>
                </div>

                <div class="d-flex justify-content-between">
                    <h:submit value="Mettre à jour" styleClass="btn btn-warning"/>
                    <a href="listAdherents.do" class="btn btn-outline-secondary">Annuler</a>
                </div>
            </h:form>
        </div>
    </div>
</div>

</body>
</html>
