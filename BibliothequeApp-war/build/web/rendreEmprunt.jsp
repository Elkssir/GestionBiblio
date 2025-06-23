<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Retour d'Emprunt – BibliothèqueApp</title>
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
                    <i class="bi bi-book me-2"></i> BibliothèqueApp
                </a>
            </div>
        </nav>

        <!-- Contenu principal -->
        <div class="container mt-5">
            <div class="card shadow-sm border-0 form-container">
                <div class="card-body">
                    <h3 class="text-warning text-center mb-4">
                        <i class="bi bi-arrow-return-left me-2"></i>Retour d’un Emprunt
                    </h3>

                    <h:form action="rendreEmprunt.do" method="post">
                        <h:hidden property="id" value="<%=request.getParameter("id")%>"/>


                        <div class="mb-4">
                            <label class="form-label">📅 Date de retour</label>
                            <input type="date" name="dateRetour" class="form-control"
                                   value="<bean:write name='empruntForm' property='dateRetour'/>" />


                            <div class="text-danger small">
                                <h:errors property="dateRetour"/>
                            </div>
                        </div>

                        <div class="d-flex justify-content-between">
                            <h:submit value="Valider le retour" styleClass="btn btn-warning"/>
                            <a href="listEmprunts.do" class="btn btn-outline-secondary">Annuler</a>
                        </div>
                    </h:form>
                </div>
            </div>
        </div>

    </body>
</html>
