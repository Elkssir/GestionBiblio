# 📚 BibliothèqueApp – Application Java EE

Une application de gestion de bibliothèque développée en **Java EE** avec les frameworks **Struts 1**, **Hibernate**, et une interface moderne en **Bootstrap 5**.

## 🚀 Fonctionnalités

- 📘 **Gestion des livres** : ajouter, modifier, supprimer, lister
- 👤 **Gestion des adhérents** : ajouter, modifier, supprimer, lister
- 🔁 **Gestion des emprunts** : effectuer un emprunt, retour d’un livre, statut automatique
- 🟢 **Statuts dynamiques** : *Actif*, *En retard*, *Retourné*
- ✅ **Validation des formulaires Struts**
- 🎨 Interface utilisateur responsive (Bootstrap)

## 🛠 Technologies

- Java EE (Servlets/JSP)
- Struts 1.3
- Hibernate 5
- MySQL
- Bootstrap 5

## 📂 Structure

```
📁 src/
 ├── controller/           → Actions Struts
 ├── model/                → ActionForm (Struts)
 ├── entity/               → Entités Hibernate (Livre, Adherent, Emprunt)
 ├── metier/               → Métiers (GererLivres, GererAdherents...)
 ├── ApplicationResources.properties
📁 WebContent/
 ├── *.jsp                 → Vues JSP
 └── WEB-INF/
      ├── web.xml
      └── struts-config.xml
```

## 🧪 Installation

1. 📦 Cloner le dépôt :

```bash
git clone https://github.com/votre-utilisateur/BibliothequeApp.git
```

2. 🔧 Importer dans un IDE Java EE (NetBeans, Eclipse EE, IntelliJ...)

3. 🛠 Configurer votre base de données MySQL :

```sql
CREATE DATABASE bibliotheque;
```

4. 📋 Importer le script SQL fourni (tables : `livre`, `adherent`, `emprunt`)

```sql
CREATE TABLE `adherent` (
  `numero` varchar(20) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `date_inscription` date NOT NULL,
  `statut` varchar(20) DEFAULT 'actif'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `emprunt` (
  `id` int(11) NOT NULL,
  `livre_code` varchar(10) NOT NULL,
  `adherent_numero` varchar(20) NOT NULL,
  `date_emprunt` date NOT NULL,
  `date_retour` date DEFAULT NULL,
  `retourne` tinyint(1) DEFAULT 0,
  `date_retour_prevue` date NOT NULL DEFAULT '2025-01-01'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `livre` (
  `code` varchar(10) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `auteur` varchar(100) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `nb_exemplaires` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`numero`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `livre_code` (`livre_code`),
  ADD KEY `adherent_numero` (`adherent_numero`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`code`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `emprunt`
--
ALTER TABLE `emprunt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_ibfk_1` FOREIGN KEY (`livre_code`) REFERENCES `livre` (`code`) ON DELETE CASCADE,
  ADD CONSTRAINT `emprunt_ibfk_2` FOREIGN KEY (`adherent_numero`) REFERENCES `adherent` (`numero`) ON DELETE CASCADE;
COMMIT;
```


5. ⚙ Modifier le fichier `hibernate.cfg.xml` avec vos identifiants :

```xml
<property name="connection.url">jdbc:mysql://localhost:3306/bibliotheque</property>
<property name="connection.username">root</property>
<property name="connection.password">votre_mot_de_passe</property>
```

6. ▶ Déployer sur un serveur Tomcat ou GlassFish

## 🧠 Astuces pour développeurs

- ✅ Valider les formulaires avec la méthode `validate()` dans chaque `ActionForm`
- 📅 Utiliser `input type="date"` pour un format cohérent (`yyyy-MM-dd`)
- 🧪 Toujours passer par une action Struts (`formEmprunt.do`, etc.) pour charger les données dynamiques (livres, adhérents...)

## ✨ Captures d’écran

![image](https://github.com/user-attachments/assets/33f2e29c-c24a-4ac1-83b2-f2e716aa9974)


## 📄 Licence

Ce projet est sous licence MIT.  
Feel free to fork & contribute!
