package com.app.googlerepolist.presentation

import androidx.lifecycle.SavedStateHandle
import com.app.googlerepolist.MainDispatcherRule
import com.app.googlerepolist.data.remote.dto.CustomPropertiesX
import com.app.googlerepolist.data.remote.dto.License
import com.app.googlerepolist.data.remote.dto.Organization
import com.app.googlerepolist.data.remote.dto.OwnerX
import com.app.googlerepolist.data.remote.dto.RepoDetailDto
import com.app.googlerepolist.data.remote.dto.RepoDto
import com.app.googlerepolist.domain.repository.RepoRepository
import com.app.googlerepolist.domain.user_case.get_repo.GetRepoUseCase
import com.app.googlerepolist.presentation.repo_detail.viewmodel.RepoDetailViewModel
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule


@OptIn(ExperimentalCoroutinesApi::class)
@ExperimentalCoroutinesApi
class RepoDetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `fetch repo detail returns success`() = runTest {

        val fakeRepo = object : RepoRepository {

            override suspend fun getRepos(): List<RepoDto> = emptyList()
            override suspend fun getRepoBydId(repoId: String): RepoDetailDto {
                return RepoDetailDto(
                    id = 1,
                    name = "Compose",
                    full_name = "google/Compose",
                    owner = OwnerX(
                        login = "google",
                        id = 1342004,
                        avatar_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        events_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        followers_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        following_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        gists_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        gravatar_id = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        html_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        node_id = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        organizations_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        received_events_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        repos_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        site_admin = false,
                        starred_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        subscriptions_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        type = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        user_view_type = "type"
                    ),
                    `private` = false,
                    html_url = "https://github.com/google/Compose",
                    description = "Jetpack Compose is Android’s modern toolkit for building native UI.",
                    fork = false,
                    url = "https://api.github.com/repos/google/Compose",
                    archive_url = "https://api.github.com/repos/google/Compose/{archive_format}{/ref}",
                    assignees_url = "https://api.github.com/repos/google/Compose/assignees{/user}",
                    blobs_url = "https://api.github.com/repos/google/Compose/git/blobs{/sha}",
                    branches_url = "https://api.github.com/repos/google/Compose/branches{/branch}",
                    clone_url = "https://github.com/google/Compose.git",
                    collaborators_url = "https://api.github.com/repos/google/Compose/collaborators{/collaborator}",
                    comments_url = "https://api.github.com/repos/google/Compose/comments{/number}",
                    commits_url = "https://api.github.com/repos/google/Compose/commits{/sha}",
                    compare_url = "https://api.github.com/repos/google/Compose/compare/{base}...{head}",
                    contents_url = "https://api.github.com/repos/google/Compose/contents/{+path}",
                    contributors_url = "https://api.github.com/repos/google/Compose/contributors",
                    created_at = "2019-05-07T16:00:00Z",
                    custom_properties = CustomPropertiesX(
                        requires_action_scanning = "exampleValue",
                        requires_two_party_review = "exampleValue"
                    ),
                    default_branch = "main",
                    deployments_url = "https://api.github.com/repos/google/Compose/deployments",
                    disabled = false,
                    downloads_url = "https://api.github.com/repos/google/Compose/downloads",
                    events_url = "https://api.github.com/repos/google/Compose/events",
                    forks = 1500,
                    forks_count = 1500,
                    forks_url = "https://api.github.com/repos/google/Compose/forks",
                    git_commits_url = "https://api.github.com/repos/google/Compose/git/commits{/sha}",
                    git_refs_url = "https://api.github.com/repos/google/Compose/git/refs{/sha}",
                    git_tags_url = "https://api.github.com/repos/google/Compose/git/tags{/sha}",
                    git_url = "git://github.com/google/Compose.git",
                    has_discussions = true,
                    has_downloads = true,
                    has_issues = true,
                    has_pages = true,
                    has_projects = true,
                    has_wiki = true,
                    homepage = "https://developer.android.com/jetpack/compose",
                    hooks_url = "https://api.github.com/repos/google/Compose/hooks",
                    is_template = false,
                    issue_comment_url = "https://api.github.com/repos/google/Compose/issues/comments{/number}",
                    issue_events_url = "https://api.github.com/repos/google/Compose/issues/events{/number}",
                    issues_url = "https://api.github.com/repos/google/Compose/issues{/number}",
                    keys_url = "https://api.github.com/repos/google/Compose/keys{/key_id}",
                    labels_url = "https://api.github.com/repos/google/Compose/labels{/name}",
                    language = "Kotlin",
                    languages_url = "https://api.github.com/repos/google/Compose/languages",
                    license = License(
                        key = "apache-2.0",
                        name = "Apache License 2.0",
                        spdx_id = "Apache-2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html",
                        node_id = "MDc6TGljZW5zZTI="
                    ),
                    merges_url = "https://api.github.com/repos/google/Compose/merges",
                    milestones_url = "https://api.github.com/repos/google/Compose/milestones{/number}",
                    mirror_url = null,
                    network_count = 500,
                    node_id = "MDEwOlJlcG9zaXRvcnkxNzk4NTM4NzI=",
                    notifications_url = "https://api.github.com/repos/google/Compose/notifications{?since,all,participating}",
                    open_issues = 100,
                    open_issues_count = 100,
                    organization = Organization(
                        login = "google",
                        id = 1342004,
                        avatar_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        events_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        followers_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        following_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        gists_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        gravatar_id = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        html_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        node_id = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        organizations_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        received_events_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        repos_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        site_admin = false,
                        starred_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        subscriptions_url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        type = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        url = "https://avatars.githubusercontent.com/u/1342004?v=4",
                        user_view_type = "type"
                    ),
                    pushed_at = "2023-11-15T10:00:00Z",
                    releases_url = "https://api.github.com/repos/google/Compose/releases{/id}",
                    size = 500000,
                    ssh_url = "git@github.com:google/Compose.git",
                    stargazers_count = 20000,
                    stargazers_url = "https://api.github.com/repos/google/Compose/stargazers",
                    statuses_url = "https://api.github.com/repos/google/Compose/statuses/{sha}",
                    subscribers_count = 700,
                    subscribers_url = "https://api.github.com/repos/google/Compose/subscribers",
                    subscription_url = "https://api.github.com/repos/google/Compose/subscription",
                    svn_url = "https://github.com/google/Compose",
                    tags_url = "https://api.github.com/repos/google/Compose/tags",
                    teams_url = "https://api.github.com/repos/google/Compose/teams",
                    temp_clone_token = null,
                    topics = listOf(
                        "android",
                        "jetpack",
                        "compose",
                        "ui",
                        "kotlin",
                        "declarative-ui"
                    ),
                    trees_url = "https://api.github.com/repos/google/Compose/git/trees{/sha}",
                    updated_at = "2023-11-15T09:00:00Z",
                    visibility = "public",
                    watchers = 20000,
                    watchers_count = 20000,
                    web_commit_signoff_required = false,
                    allow_forking = true,
                    archived = false,
                    pulls_url = "https://api.github.com/repos/google/Compose/git/trees{/sha}"
                )

            }
        }

        val savedStateHandle = SavedStateHandle(mapOf("repoId" to "1"))
        val viewModel = RepoDetailViewModel(GetRepoUseCase(fakeRepo), savedStateHandle)

        advanceUntilIdle()
        assertEquals("Compose", viewModel.state.value.repo?.name)
    }
}
