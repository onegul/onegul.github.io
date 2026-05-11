# [Gulshan Kumar](https://onegul.github.io/)

My personal website for [onegul.github.io](https://onegul.github.io/) — built with Kotlin/JS + Compose HTML.

## Branching & Deployment
The repository follows a clean-source strategy:
1. `main`: The source of truth. Contains Kotlin code, Gradle build logic, and raw assets.
2. **Automated Artifacts**: The production site is built and deployed directly to GitHub Pages via an automated pipeline whenever code is merged into `main`.

## Getting Started
1. Clone the repository and navigate to root directory ([/onegul](/onegul)).
   ```bash
   git clone https://github.com/onegul/onegul.github.io.git
   cd onegul
   ```
2. Build the Project
   ```bash
   ./gradlew jsBrowserDevelopmentRun
   ```
   Opens at `http://localhost:8080` with hot-reload.

## Updating Content
To update the contents of the website (Experience, Projects, Skills):
1. Navigate to [content directory](/onegul/src/jsMain/kotlin/co/gul/model/content).
2. Modify the objects or lists (e.g., `SKILLS`, `PROJECTS`, `EXPERIENCE`).
3. Rebuild the project and preview the changes.

## Publishing Updates
**No manual deployment is required.**
1. Commit your changes to a feature branch.
2. Open a **Pull Request** to `main`.
3. GitHub Actions will verify the build.
4. Once merged, the site is automatically deployed to [onegul.github.io](https://onegul.github.io/).

## Design System
Material You — tonal green palette, light scheme.
Fonts: Cormorant Garamond (display) + DM Sans (body) + DM Mono (mono).
