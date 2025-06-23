<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nouvel Emprunt – BibliothèqueApp</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .form-container {
                max-width: 700px;
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
                        <i class="bi bi-arrow-left-right me-2"></i>Nouvel Emprunt
                    </h3>

                    <h:form action="addEmprunt.do" method="post">

                        <!-- Livre -->
                        <div class="mb-3">
                            <label class="form-label">Livre</label>
                            <select name="livreCode" class="form-select">
                                <logic:iterate id="l" name="livres" type="entity.Livre">
                                    <option value="<bean:write name='l' property='code'/>">
                                        <bean:write name="l" property="titre"/> — <bean:write name="l" property="auteur"/>
                                    </option>
                                </logic:iterate>
                            </select>
                            <div class="text-danger small"><h:errors property="livreCode"/></div>
                        </div>

                        <!-- Adhérent -->
                        <div class="mb-3">
                            <label class="form-label">Adhérent</label>
                            <select name="adherentNumero" class="form-select">
                                <logic:iterate id="a" name="adherents" type="entity.Adherent">
                                    <option value="<bean:write name='a' property='numero'/>">
                                        <bean:write name="a" property="prenom"/> <bean:write name="a" property="nom"/>
                                    </option>
                                </logic:iterate>
                            </select>
                            <div class="text-danger small"><h:errors property="adherentNumero"/></div>
                        </div>

                        <!-- Date d'emprunt -->
                        <div class="mb-3">
                            <label class="form-label">Date d'emprunt</label>
                            <h:text property="dateEmprunt" styleClass="form-control" onfocus="this.type='date'"/>
                            <div class="text-danger small"><h:errors property="dateEmprunt"/></div>
                        </div>

                        <!-- Date de retour prévue -->
                        <div class="mb-3">
                            <label class="form-label">📅 Date de retour prévue</label>
                            <h:text property="dateRetourPrevue" styleClass="form-control" onfocus="this.type='date'"/>
                            <div class="text-danger small"><h:errors property="dateRetourPrevue"/></div>
                        </div>

                        <!-- Boutons -->
                        <div class="d-flex justify-content-between">
                            <h:submit value="Enregistrer" styleClass="btn btn-success"/>
                            <a href="listEmprunts.do" class="btn btn-outline-secondary">Annuler</a>
                        </div>


                    </h:form>
                </div>
            </div>
        </div>

    </body>
</html>
