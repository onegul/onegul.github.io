# [Gulshan Kumar](https://onegul.github.io/)

My personal website for [onegul.github.io](https://onegul.github.io/) — built with Kotlin/JS + Compose HTML.

## Branches
The repository is split into two functional branches:
1. `main`: Contains the Kotlin source code, Gradle build logic, and raw assets. All development branches will be created from this branch.
2. `gh-pages`: A "deployment-only" branch. It contains only the compiled JavaScript, HTML, and CSS. This branch is served by GitHub Pages.

## Getting Started
1. Clone the repository
   ```bash
   git clone https://github.com/onegul/onegul.github.io.git
   cd onegul
   ```
2. Build the Project
   ```bash
   ./gradlew jsBrowserDevelopmentRun
   ```
   Opens at `http://localhost:8080` with hot-reload.

## Making Changes
To update the content of the website (Experience, Projects, Skills):
1. Navigate to [content directory](/onegul/src/jsMain/kotlin/co/gul/model/content).
2. Modify the objects or lists (e.g., `SKILLS`, `PROJECTS`, `EXPERIENCE`).
3. Refresh your local development server to preview:
   ```bash
   ./gradlew jsBrowserRun --continuous
   ```

## Publishing Updates
This project uses a Git WorkTree strategy to map the Gradle build folder directly to the `gh-pages` branch. This ensures the branches stay separated and the URL remains clean.

### Initial Setup
If you've not linked the branches yet, run:
```bash
git worktree add onegul/build/dist/js/productionExecutable gh-pages
```

### Deployment Workflow
Every time you want to push updates to the live site:
1. Generate the Build:
   ```bash
   ./gradlew jsBrowserDistribution
   ```
   Output: `build/dist/js/productionExecutable/`


2. Commit and Push:
   ```bash
   cd onegul/build/dist/js/productionExecutable
   git add .
   git commit -m "Deploy: Updated portfolio content; version=[major.minor.patch]"
   git push origin gh-pages
   ```

## Design System
Material You — tonal green palette, light scheme.
Fonts: Cormorant Garamond (display) + DM Sans (body) + DM Mono (mono).
