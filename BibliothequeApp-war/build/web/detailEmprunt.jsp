<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Détails de l'Emprunt</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
        <style>
            .card-modern {
                border: none;
                border-radius: 15px;
                box-shadow: 0 8px 25px rgba(0,0,0,0.1);
            }
            .detail-row {
                padding: 1rem 0;
                border-bottom: 1px solid #f0f0f0;
            }
            .detail-row:last-child {
                border-bottom: none;
            }
            .detail-label {
                font-weight: 600;
                color: #495057;
                font-size: 0.95rem;
            }
            .detail-value {
                color: #212529;
                font-size: 1.05rem;
            }
            .status-success {
                background: linear-gradient(135deg, #28a745, #20c997);
                border: none;
            }
            .status-warning {
                background: linear-gradient(135deg, #ffc107, #fd7e14);
                border: none;
            }
            .navbar-gradient {
                background: linear-gradient(135deg, #343a40, #495057) !important;
            }
        </style>
    </head>
    <body class="bg-light">
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
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <h3 class="text-primary mb-4 fw-bold">
                        <i class="bi bi-info-circle"></i> Détails de l'Emprunt
                    </h3>

                    <div class="card card-modern">
                        <div class="card-body p-4">
                            <div class="row detail-row">
                                <div class="col-sm-4">
                                    <span class="detail-label">
                                        <i class="bi bi-hash text-primary me-2"></i>ID
                                    </span>
                                </div>
                                <div class="col-sm-8">
                                    <span class="detail-value fw-bold">
                                        <bean:write name="emprunt" property="id"/>
                                    </span>
                                </div>
                            </div>

                            <div class="row detail-row">
                                <div class="col-sm-4">
                                    <span class="detail-label">
                                        <i class="bi bi-book text-info me-2"></i>Livre
                                    </span>
                                </div>
                                <div class="col-sm-8">
                                    <span class="detail-value">
                                        <bean:write name="emprunt" property="livre.titre"/>
                                    </span>
                                </div>
                            </div>

                            <div class="row detail-row">
                                <div class="col-sm-4">
                                    <span class="detail-label">
                                        <i class="bi bi-person text-success me-2"></i>Adhérent
                                    </span>
                                </div>
                                <div class="col-sm-8">
                                    <span class="detail-value">
                                        <bean:write name="emprunt" property="adherent.prenom"/>
                                        <bean:write name="emprunt" property="adherent.nom"/>
                                    </span>
                                </div>
                            </div>

                            <div class="row detail-row">
                                <div class="col-sm-4">
                                    <span class="detail-label">
                                        <i class="bi bi-calendar-plus text-warning me-2"></i>Date Emprunt
                                    </span>
                                </div>
                                <div class="col-sm-8">
                                    <span class="detail-value">
                                        <bean:write name="emprunt" property="dateEmprunt"/>
                                    </span>
                                </div>
                            </div>

                            <div class="row detail-row">
                                <div class="col-sm-4">
                                    <span class="detail-label">
                                        <i class="bi bi-calendar-event text-danger me-2"></i>Date Retour Prévue
                                    </span>
                                </div>
                                <div class="col-sm-8">
                                    <span class="detail-value">
                                        <bean:write name="emprunt" property="dateRetourPrevue"/>
                                    </span>
                                </div>
                            </div>

                            <div class="row detail-row">
                                <div class="col-sm-4">
                                    <span class="detail-label">
                                        <i class="bi bi-calendar-check text-secondary me-2"></i>Date Retour Réelle
                                    </span>
                                </div>
                                <div class="col-sm-8">
                                    <span class="detail-value">
                                        <logic:present name="emprunt" property="dateRetour">
                                            <bean:write name="emprunt" property="dateRetour"/>
                                        </logic:present>
                                        <logic:notPresent name="emprunt" property="dateRetour">
                                            <span class="text-muted fst-italic">Non encore retourné</span>
                                        </logic:notPresent>
                                    </span>
                                </div>
                            </div>

                            <div class="row detail-row">
                                <div class="col-sm-4">
                                    <span class="detail-label">
                                        <i class="bi bi-flag text-dark me-2"></i>Statut
                                    </span>
                                </div>
                                <div class="col-sm-8">
                                    <logic:equal name="emprunt" property="statut" value="actif">
                                        <span class="badge bg-primary-subtle text-primary px-3 py-2">
                                            <i class="bi bi-clock-history me-1"></i> Actif
                                        </span>
                                    </logic:equal>
                                    <logic:equal name="emprunt" property="statut" value="retard">
                                        <span class="badge bg-danger-subtle text-danger px-3 py-2">
                                            <i class="bi bi-exclamation-triangle me-1"></i> En Retard
                                        </span>
                                    </logic:equal>
                                    <logic:equal name="emprunt" property="statut" value="retourne">
                                        <span class="badge bg-success-subtle text-success px-3 py-2">
                                            <i class="bi bi-check-circle me-1"></i> Retourné
                                        </span>
                                    </logic:equal>
                                </div>
                            </div>
                        </div>
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