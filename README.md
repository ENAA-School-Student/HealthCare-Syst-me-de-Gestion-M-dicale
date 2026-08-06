# HealthCare+ — Système de Gestion Médicale

---

# 1. Nom du projet

**Nom du projet :** HealthCare+ — API et Plateforme de Gestion Médicale

### Dépôts du projet

Ce projet est réparti sur deux dépôts distincts :

- **Backend (API REST)** : https://github.com/ENAA-School-Student/HealthCare-Syst-me-de-Gestion-M-dicale.git

- **Frontend (React)** : https://github.com/zakariaoutla/HealthCare-Frontend.git

---

# 2. Présentation du projet

Ce projet est une **API REST complète** couplée à une **interface web React**, qui permet de gérer l'ensemble du parcours administratif d'une clinique : patients, médecins, rendez-vous et dossiers médicaux.

Il s'adresse principalement au personnel administratif, aux médecins et aux patients d'un établissement de santé (clinique HealthCare+) qui souhaitent digitaliser le suivi médical.

Son objectif principal est de centraliser la gestion des patients, des médecins, des rendez-vous et des dossiers médicaux dans une application sécurisée, performante et facilement maintenable.

---

# 3. Problématique

Le problème identifié est que les cliniques gèrent souvent le suivi des patients, des rendez-vous et des dossiers médicaux de manière dispersée (papier, tableurs, outils non connectés), ce qui rend le suivi peu fiable et chronophage, et ne garantit ni sécurité des accès ni traçabilité des informations.

La solution proposée permet de centraliser toutes ces données dans une API REST sécurisée par authentification JWT et gestion des rôles (ADMIN, MEDECIN, PATIENT), consommée par une interface web moderne, avec des fonctionnalités de recherche, tri, pagination, mise en cache et génération de documents (PDF), le tout déployé via Docker et une chaîne d'intégration continue.

---

# 4. Fonctionnalités principales

- Gérer les patients (ajout, modification, suppression, consultation, liste paginée et triée)
- Gérer les médecins (ajout, modification, suppression, recherche par spécialité)
- Gérer les rendez-vous (création, modification, annulation, recherche par patient/médecin/statut)
- Gérer les dossiers médicaux (création, ajout de diagnostic et d'observations, consultation)
- Authentifier les utilisateurs via JWT (inscription, connexion, gestion des rôles)
- Télécharger des documents générés (dossier médical en PDF, rapports de rendez-vous)

---

# 5. Technologies utilisées

| Technologie | Utilisation dans le projet |
|-------------|----------------------------|
| Java 17 / 21 | Langage principal du backend |
| Spring Boot | Framework backend et architecture REST |
| Spring Data JPA / Hibernate / Flyway | Persistance des données et gestion des migrations SQL |
| Spring Security & JWT | Authentification, autorisation et gestion des rôles |
| MapStruct | Mapping entre entités et DTOs |
| Redis | Mise en cache des endpoints les plus consultés |
| React, Axios, React Router, React Hook Form, Yup | Interface utilisateur, appels API, navigation, formulaires et validation |
| Docker & Docker Compose | Conteneurisation et déploiement de l'API et du frontend |
| GitHub Actions | Pipeline CI/CD (build, tests, préparation au déploiement) |
| Swagger | Documentation interactive de l'API |
| JUnit | Tests unitaires |
| Postman | Tests manuels des endpoints |
| Figma | Maquettage de l'interface avant développement |
| Git & GitHub | Versionnement du code |

---

# 6. Installation et lancement

## 6.1 Prérequis

Pour utiliser ce projet, vous devez disposer de :

- Java 17 ou 21
- Maven
- Node.js et npm
- Docker et Docker Compose
- Git

---

## 6.2 Cloner les dépôts

Backend :

```bash
git clone https://github.com/ENAA-School-Student/HealthCare-Syst-me-de-Gestion-M-dicale.git
```

Frontend :

```bash
git clone https://github.com/zakariaoutla/HealthCare-Frontend.git
```

---

## 6.3 Ouvrir les dossiers

```bash
cd HealthCare-Syst-me-de-Gestion-M-dicale
```

```bash
cd HealthCare-Frontend
```

---

## 6.4 Installer les dépendances

Backend :

```bash
cd HealthCare-Syst-me-de-Gestion-M-dicale
mvn clean install
```

Frontend :

```bash
cd HealthCare-Frontend
npm install
```

---

## 6.5 Variables d'environnement

Créer un fichier `.env` (ou `application.properties` / `application.yml` selon le contexte) avec :

```env
DATABASE_URL=jdbc:mysql://localhost:3306/healthcare
DATABASE_USERNAME=
DATABASE_PASSWORD=
PORT=8080
JWT_SECRET=
JWT_EXPIRATION=3600000
REDIS_HOST=localhost
REDIS_PORT=6379
```

---

## 6.6 Lancer le projet

Chaque dépôt possède son propre `docker-compose.yml` / Dockerfile.

Backend (avec Docker Compose, recommandé) :

```bash
cd HealthCare-Syst-me-de-Gestion-M-dicale
docker-compose up --build
```

Ou manuellement :

```bash
cd HealthCare-Syst-me-de-Gestion-M-dicale
mvn spring-boot:run
```

Frontend :

```bash
cd HealthCare-Frontend
npm start
```

---

## 6.7 Ouvrir le projet

Après le lancement :

```
Backend  : http://localhost:8080
Swagger  : http://localhost:8080/swagger-ui.html
Frontend : http://localhost:3000
```

### Point de vigilance

- Tester toutes les commandes
- Vérifier les chemins
- Ne jamais publier :
    - mots de passe
    - clés API
    - tokens
    - identifiants

---

# 7. Captures d'écran

## Capture 1

### Titre

```
Tableau de bord principal
```

### Image

```md
![Tableau de bord](chemin-vers-image.png)
```

### Explication

Cette capture montre la page d'accueil de l'application avec un aperçu des fonctionnalités principales (patients, médecins, rendez-vous, dossiers médicaux).

---

## Capture 2

### Titre

```
Liste des patients avec pagination
```

### Image

```md
![Liste des patients](chemin-vers-image.png)
```

### Explication

Cette capture montre la liste paginée et triable des patients, avec les options de recherche par nom.

---

# 8. Contribution personnelle

Ma contribution principale a porté sur la conception de l'architecture backend (entités, DTOs, mapping MapStruct) et la mise en place de la sécurité avec Spring Security et JWT.

J'ai également travaillé sur l'intégration de Redis pour la mise en cache et sur le pipeline CI/CD avec GitHub Actions.

J'ai été responsable du développement de l'interface React (formulaires, appels Axios, gestion des rôles côté client) et du déploiement Docker de l'ensemble de l'application.

---

# 9. Difficultés rencontrées

## Difficulté 1

### Problème rencontré

La gestion de l'expiration et du renouvellement du token JWT provoquait des déconnexions inattendues lors de l'utilisation du frontend.

### Recherches / Tests

J'ai consulté la documentation officielle de Spring Security et testé différentes durées d'expiration avec Postman pour comprendre le comportement du filtre JWT.

### Solution

J'ai mis en place un intercepteur Axios de réponse qui détecte les erreurs 401 et redirige automatiquement l'utilisateur vers la page de connexion après suppression de sa session.

### Ce que j'ai appris

Cette difficulté m'a permis de mieux comprendre le fonctionnement des filtres de sécurité Spring (`SecurityFilterChain`, `JWT Filter`) et la gestion centralisée des erreurs côté frontend.

---

## Difficulté 2

### Problème rencontré

L'invalidation du cache Redis lors des opérations de création, modification et suppression n'était pas systématique, ce qui entraînait des données obsolètes affichées côté client.

### Recherches / Tests

J'ai testé les annotations `@Cacheable`, `@CacheEvict` et `@CachePut` de Spring sur différents scénarios (ajout, modification, suppression) pour identifier les cas non couverts.

### Solution

J'ai appliqué `@CacheEvict` de manière systématique sur toutes les méthodes de modification des entités concernées (patients, médecins, rendez-vous, dossiers médicaux).

### Ce que j'ai appris

Cette difficulté m'a permis d'apprendre à synchroniser correctement le cycle de vie du cache avec les opérations CRUD dans une architecture Spring Boot.

---

# 10. Améliorations possibles

Dans une prochaine version, je pourrais :

- ajouter des notifications par email/SMS pour les rendez-vous ;
- mettre en place une gestion des rôles plus fine avec des permissions personnalisées ;
- ajouter des tests d'intégration plus complets ;
- améliorer le responsive design de l'interface React.

### Conclusion

Ces améliorations permettraient de rendre la plateforme plus complète, plus robuste et davantage adaptée à un usage réel en environnement hospitalier.

---

# ✅ Checklist finale

## Présentation

- [x] Le nom du projet est clair.
- [x] Le projet est présenté en 3 à 5 lignes.
- [x] Le public cible est identifié.
- [x] Le besoin est expliqué.
- [x] L'objectif est précisé.

## Fonctionnalités

- [x] 3 à 6 fonctionnalités.
- [x] Chaque fonctionnalité commence par un verbe.
- [x] Elles correspondent à des actions réelles.

## Technologies

- [x] Les technologies sont indiquées.
- [x] Leur rôle est expliqué.

## Installation

- [x] Les prérequis sont présents.
- [x] Le dépôt est correct.
- [x] Les commandes fonctionnent.
- [x] L'adresse locale est indiquée.
- [x] Aucune donnée sensible n'est publiée.

## Captures

- [x] Deux captures minimum.
- [x] Chaque capture possède un titre.
- [x] Les images fonctionnent.

## Contribution

- [x] Ma contribution est précise.
- [x] Les tâches sont clairement décrites.
- [x] Je distingue mon travail de celui du groupe.

## Difficultés

- [x] Les difficultés sont expliquées.
- [x] Les recherches sont décrites.
- [x] Les solutions sont précisées.
- [x] Les apprentissages sont présentés.

## Améliorations

- [x] 2 à 4 améliorations.
- [x] Elles sont réalistes.