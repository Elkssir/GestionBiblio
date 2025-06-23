<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Liste des Adhérents – BibliothèqueApp</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
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
            <div class="card shadow-sm border-0 card-hover">
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <h3 class="text-primary mb-0">
                            <i class="bi bi-people me-2"></i>Liste des Adhérents
                        </h3>
                        <a href="addAdherent.jsp" class="btn btn-success">
                            <i class="bi bi-person-plus me-1"></i>Ajouter
                        </a>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-striped table-bordered align-middle">
                            <thead class="table-dark text-center">
                                <tr>
                                    <th>Numéro</th>
                                    <th>Nom</th>
                                    <th>Prénom</th>
                                    <th>Email</th>
                                    <th>Téléphone</th>
                                    <th>Statut</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate id="a" name="adherents" type="entity.Adherent">
                                    <tr>
                                        <td class="text-center"><bean:write name="a" property="numero"/></td>
                                        <td><bean:write name="a" property="nom"/></td>
                                        <td><bean:write name="a" property="prenom"/></td>
                                        <td><bean:write name="a" property="email"/></td>
                                        <td><bean:write name="a" property="telephone"/></td>
                                        <td class="text-center">
                                            <logic:equal name="a" property="statut" value="actif">
                                                <span class="badge bg-success"><i class="bi bi-check-circle"></i> Actif</span>
                                            </logic:equal>
                                            <logic:equal name="a" property="statut" value="inactif">
                                                <span class="badge bg-secondary"><i class="bi bi-slash-circle"></i> Inactif</span>
                                            </logic:equal>
                                            <logic:equal name="a" property="statut" value="suspendu">
                                                <span class="badge bg-danger"><i class="bi bi-x-circle"></i> Suspendu</span>
                                            </logic:equal>
                                        </td>

                                        <td class="text-center">
                                            <a href="editAdherent.do?numero=<bean:write name='a' property='numero'/>" class="btn btn-sm btn-warning me-1" title="Modifier">
                                                <i class="bi bi-pencil-square"></i>
                                            </a>
                                            <a href="deleteAdherent.do?numero=<bean:write name='a' property='numero'/>"
                                               onclick="return confirm('Confirmer la suppression ?');"
                                               class="btn btn-sm btn-danger" title="Supprimer">
                                                <i class="bi bi-trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </logic:iterate>
                            </tbody>
                        </table>
                    </div>

                    <div class="text-end mt-4">
                        <a href="index.jsp" class="btn btn-outline-secondary">
                            <i class="bi bi-arrow-left-circle me-1"></i>Retour à l'accueil
                        </a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
