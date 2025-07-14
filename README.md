# GoogleRepoList

A modern Android app built with **Jetpack Compose**, **Kotlin**, and **Material 3** that displays repositories from Google's GitHub organization.

---

## Features

- View a list of Google public repositories.
- Search repositories by name.
- Tap to see detailed information about each repository.
- Supports both **Light & Dark Themes** (Material 3).
- Splash screen with custom design.
- Unit tests for ViewModels, UseCases, and Repositories.
- Test coverage with **Jacoco**.

---

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **MVVM + Clean Architecture**
- **Hilt for Dependency Injection**
- **Retrofit for API calls**
- **StateFlow & SharedFlow** for state management
- **MockK** & **Turbine** for testing
- **Jacoco** for code coverage

---

## Screens

| Repo List | Repo Details |
|-----------|--------------|


---

## API Used

This app uses the public GitHub API:

- List Repos: `https://api.github.com/orgs/google/repos`
- Repo Details: `https://api.github.com/repositories/{repoId}`

No authentication needed.

---

## Testing

- Use `./gradlew testDebugUnitTest` to run unit tests.
- Test coverage with Jacoco:
  ```bash
  ./gradlew jacocoTestReport
