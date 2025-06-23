<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Liste des Emprunts – BibliothèqueApp</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .badge-light-blue {
                background-color: #e7f1ff;
                color: #0d6efd;
            }
            .badge-light-green {
                background-color: #d1f7e3;
                color: #198754;
            }
            .badge-light-red {
                background-color: #f8d7da;
                color: #dc3545;
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
                            <i class="bi bi-arrow-left-right me-2"></i>Liste des Emprunts
                        </h3>
                        <a href="formEmprunt.do" class="btn btn-success">
                            <i class="bi bi-plus-circle me-1"></i>Nouvel Emprunt
                        </a>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-striped table-bordered align-middle">
                            <thead class="table-dark text-center">
                                <tr>
                                    <th>ID</th>
                                    <th>Livre</th>
                                    <th>Adhérent</th>
                                    <th>Date Emprunt</th>
                                    <th>Date Retour Prévue</th>
                                    <th>Date Retour</th>
                                    <th>Statut</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate id="e" name="emprunts" type="entity.Emprunt">
                                    <tr>
                                        <td class="text-center"><bean:write name="e" property="id"/></td>
                                        <td><bean:write name="e" property="livre.titre"/></td>
                                        <td>
                                            <bean:write name="e" property="adherent.prenom"/>
                                            <bean:write name="e" property="adherent.nom"/>
                                        </td>
                                        <td class="text-center"><bean:write name="e" property="dateEmprunt"/></td>
                                        <td class="text-center"><bean:write name="e" property="dateRetourPrevue"/></td>
                                        <td class="text-center"><bean:write name="e" property="dateRetour"/></td>

                                        <!-- Statut dynamique -->
                                        <td class="text-center">
                                            <logic:equal name="e" property="statut" value="actif">
                                                <span class="badge badge-light-blue p-2">
                                                    <i class="bi bi-calendar-check"></i> Actif
                                                </span>
                                            </logic:equal>
                                            <logic:equal name="e" property="statut" value="retard">
                                                <span class="badge badge-light-red p-2">
                                                    <i class="bi bi-exclamation-triangle"></i> En retard
                                                </span>
                                            </logic:equal>
                                            <logic:equal name="e" property="statut" value="retourne">
                                                <span class="badge badge-light-green p-2">
                                                    <i class="bi bi-check-circle"></i> Retourné
                                                </span>
                                            </logic:equal>
                                        </td>

                                        <!-- Actions conditionnelles -->
                                        <td class="text-center">
                                            <logic:match name="e" property="statut" value="actif">
                                                <a href="rendreEmprunt.jsp?id=<bean:write name='e' property='id'/>"
                                                   class="text-success me-2 fw-bold">Retourner</a>
                                            </logic:match>

                                            <logic:match name="e" property="statut" value="retard">
                                                <a href="rendreEmprunt.jsp?id=<bean:write name='e' property='id'/>"
                                                   class="text-danger me-2 fw-bold">Retourner</a>
                                            </logic:match>


                                            <a href="detailEmprunt.do?id=<bean:write name='e' property='id'/>"
                                               class="text-primary fw-bold">Détails</a>
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
