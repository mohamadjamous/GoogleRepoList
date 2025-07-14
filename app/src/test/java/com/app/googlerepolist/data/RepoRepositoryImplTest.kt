package com.app.googlerepolist.data

import com.app.googlerepolist.data.remote.GoogleRepoApi
import com.app.googlerepolist.data.remote.dto.CustomProperties
import com.app.googlerepolist.data.remote.dto.License
import com.app.googlerepolist.data.remote.dto.Owner
import com.app.googlerepolist.data.remote.dto.Permissions
import com.app.googlerepolist.data.remote.dto.RepoDto
import com.app.googlerepolist.data.repository.RepoRepositoryImpl
import com.app.googlerepolist.domain.repository.RepoRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
@ExperimentalCoroutinesApi
class RepoRepositoryImplTest {

    private lateinit var api: GoogleRepoApi
    private lateinit var repository: RepoRepository

    @Before
    fun setup() {
        api = mockk()
        repository = RepoRepositoryImpl(api)
    }

    @Test
    fun `getRepos returns list of RepoDto`(): Unit = runTest {
        val repoList = listOf(
            RepoDto(
                id = 1,
                name = "TestRepo",
                full_name = "user/TestRepo",
                `private` = false,
                owner = Owner(
                    login = "testUser", id = 101,
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
                html_url = "https://github.com/user/TestRepo",
                description = "This is a test repository.",
                fork = false,
                url = "https://api.github.com/repos/user/TestRepo",
                forks_url = "https://api.github.com/repos/user/TestRepo/forks",
                keys_url = "https://api.github.com/repos/user/TestRepo/keys{/key_id}",
                collaborators_url = "https://api.github.com/repos/user/TestRepo/collaborators{/collaborator}",
                teams_url = "https://api.github.com/repos/user/TestRepo/teams",
                hooks_url = "https://api.github.com/repos/user/TestRepo/hooks",
                issue_events_url = "https://api.github.com/repos/user/TestRepo/issues/events{/number}",
                events_url = "https://api.github.com/repos/user/TestRepo/events",
                assignees_url = "https://api.github.com/repos/user/TestRepo/assignees{/user}",
                branches_url = "https://api.github.com/repos/user/TestRepo/branches{/branch}",
                tags_url = "https://api.github.com/repos/user/TestRepo/tags",
                blobs_url = "https://api.github.com/repos/user/TestRepo/git/blobs{/sha}",
                git_tags_url = "https://api.github.com/repos/user/TestRepo/git/tags{/sha}",
                git_refs_url = "https://api.github.com/repos/user/TestRepo/git/refs{/sha}",
                trees_url = "https://api.github.com/repos/user/TestRepo/git/trees{/sha}",
                statuses_url = "https://api.github.com/repos/user/TestRepo/statuses/{sha}",
                languages_url = "https://api.github.com/repos/user/TestRepo/languages",
                stargazers_url = "https://api.github.com/repos/user/TestRepo/stargazers",
                contributors_url = "https://api.github.com/repos/user/TestRepo/contributors",
                subscribers_url = "https://api.github.com/repos/user/TestRepo/subscribers",
                subscription_url = "https://api.github.com/repos/user/TestRepo/subscription",
                commits_url = "https://api.github.com/repos/user/TestRepo/commits{/sha}",
                git_commits_url = "https://api.github.com/repos/user/TestRepo/git/commits{/sha}",
                comments_url = "https://api.github.com/repos/user/TestRepo/comments{/number}",
                issue_comment_url = "https://api.github.com/repos/user/TestRepo/issues/comments{/number}",
                contents_url = "https://api.github.com/repos/user/TestRepo/contents/{+path}",
                compare_url = "https://api.github.com/repos/user/TestRepo/compare/{base}...{head}",
                merges_url = "https://api.github.com/repos/user/TestRepo/merges",
                archive_url = "https://api.github.com/repos/user/TestRepo/{archive_format}{/ref}",
                downloads_url = "https://api.github.com/repos/user/TestRepo/downloads",
                issues_url = "https://api.github.com/repos/user/TestRepo/issues{/number}",
                pulls_url = "https://api.github.com/repos/user/TestRepo/pulls{/number}",
                milestones_url = "https://api.github.com/repos/user/TestRepo/milestones{/number}",
                notifications_url = "https://api.github.com/repos/user/TestRepo/notifications{?since,all,participating}",
                labels_url = "https://api.github.com/repos/user/TestRepo/labels{/name}",
                releases_url = "https://api.github.com/repos/user/TestRepo/releases{/id}",
                deployments_url = "https://api.github.com/repos/user/TestRepo/deployments",
                created_at = "2023-01-15T10:00:00Z",
                updated_at = "2023-10-20T12:30:00Z",
                pushed_at = "2023-10-20T12:00:00Z",
                git_url = "git://github.com/user/TestRepo.git",
                ssh_url = "git@github.com:user/TestRepo.git",
                clone_url = "https://github.com/user/TestRepo.git",
                svn_url = "https://github.com/user/TestRepo",
                homepage = "https://user.github.io/TestRepo",
                size = 1024,
                stargazers_count = 100,
                watchers_count = 100,
                language = "Kotlin",
                has_issues = true,
                has_projects = true,
                has_downloads = true,
                has_wiki = true,
                has_pages = false,
                has_discussions = false,
                forks_count = 10,
                mirror_url = null, // Or some "https://example.com/mirror" if needed
                archived = false,
                disabled = false,
                open_issues_count = 5,
                license = License(
                    name = "Apache License 2.0",
                    key = "apache-2.0",
                    node_id = "MDEwOlJlcG9zaXRvcnkxMjk2MjY5",
                    spdx_id = "123",
                    url = "https://github.com/user/TestRepo.git"
                ),
                allow_forking = true,
                is_template = false,
                web_commit_signoff_required = false,
                topics = listOf("kotlin", "android", "test", "example"),
                visibility = "public",
                forks = 10,
                open_issues = 5,
                watchers = 100,
                default_branch = "main",
                custom_properties = CustomProperties(
                    requires_action_scanning = "exampleValue",
                    requires_two_party_review = "exampleValue"
                ),
                permissions = Permissions(
                    admin = false,
                    push = false,
                    pull = true,
                    triage = false,
                    maintain = false,
                ),
                node_id = "MDEwOlJlcG9zaXRvcnkxMjk2MjY5"
            )
        )
        coEvery { api.getRepos() } returns repoList

        val result = repository.getRepos()

        assertEquals(1, result.size)
        assertEquals("TestRepo", result[0].name)
    }
}
