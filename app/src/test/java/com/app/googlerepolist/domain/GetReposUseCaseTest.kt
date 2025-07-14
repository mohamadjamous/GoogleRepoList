package com.app.googlerepolist.domain

import com.app.googlerepolist.common.Resource
import com.app.googlerepolist.data.remote.dto.CustomPropertiesX
import com.app.googlerepolist.data.remote.dto.License
import com.app.googlerepolist.data.remote.dto.Organization
import com.app.googlerepolist.data.remote.dto.OwnerX
import com.app.googlerepolist.data.remote.dto.RepoDetailDto
import com.app.googlerepolist.domain.repository.RepoRepository
import com.app.googlerepolist.domain.user_case.get_repo.GetRepoUseCase
import com.app.googlerepolist.domain.user_case.get_repos.GetReposUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
@ExperimentalCoroutinesApi
class GetReposUseCaseTest {

    private lateinit var repository: RepoRepository
    private lateinit var useCase: GetReposUseCase

    @Before
    fun setup() {
        repository = mockk()
        useCase = GetReposUseCase(repository)
    }

    @Test
    fun `emits repo detail successfully`() = runTest {
        val fakeDto = RepoDetailDto(
            id = 1,
            name = "TestRepoDetail",
            full_name = "testorg/TestRepoDetail",
            owner = OwnerX(
                login = "detailOwner", id = 202,
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
            html_url = "https://github.com/testorg/TestRepoDetail",
            description = "Detailed description of a test repository.",
            fork = false,
            url = "https://api.github.com/repos/testorg/TestRepoDetail",
            archive_url = "https://api.github.com/repos/testorg/TestRepoDetail/{archive_format}{/ref}",
            assignees_url = "https://api.github.com/repos/testorg/TestRepoDetail/assignees{/user}",
            blobs_url = "https://api.github.com/repos/testorg/TestRepoDetail/git/blobs{/sha}",
            branches_url = "https://api.github.com/repos/testorg/TestRepoDetail/branches{/branch}",
            clone_url = "https://github.com/testorg/TestRepoDetail.git",
            collaborators_url = "https://api.github.com/repos/testorg/TestRepoDetail/collaborators{/collaborator}",
            comments_url = "https://api.github.com/repos/testorg/TestRepoDetail/comments{/number}",
            commits_url = "https://api.github.com/repos/testorg/TestRepoDetail/commits{/sha}",
            compare_url = "https://api.github.com/repos/testorg/TestRepoDetail/compare/{base}...{head}",
            contents_url = "https://api.github.com/repos/testorg/TestRepoDetail/contents/{+path}",
            contributors_url = "https://api.github.com/repos/testorg/TestRepoDetail/contributors",
            created_at = "2022-05-10T08:00:00Z",
            custom_properties = CustomPropertiesX(
                requires_action_scanning = "exampleValue",
                requires_two_party_review = "exampleValue"
            ),
            default_branch = "main",
            deployments_url = "https://api.github.com/repos/testorg/TestRepoDetail/deployments",
            disabled = false,
            downloads_url = "https://api.github.com/repos/testorg/TestRepoDetail/downloads",
            events_url = "https://api.github.com/repos/testorg/TestRepoDetail/events",
            forks = 5,
            forks_count = 5,
            forks_url = "https://api.github.com/repos/testorg/TestRepoDetail/forks",
            git_commits_url = "https://api.github.com/repos/testorg/TestRepoDetail/git/commits{/sha}",
            git_refs_url = "https://api.github.com/repos/testorg/TestRepoDetail/git/refs{/sha}",
            git_tags_url = "https://api.github.com/repos/testorg/TestRepoDetail/git/tags{/sha}",
            git_url = "git://github.com/testorg/TestRepoDetail.git",
            has_discussions = true,
            has_downloads = true,
            has_issues = true,
            has_pages = false,
            has_projects = true,
            has_wiki = true,
            homepage = "https://testorg.github.io/TestRepoDetail",
            hooks_url = "https://api.github.com/repos/testorg/TestRepoDetail/hooks",
            is_template = false,
            issue_comment_url = "https://api.github.com/repos/testorg/TestRepoDetail/issues/comments{/number}",
            issue_events_url = "https://api.github.com/repos/testorg/TestRepoDetail/issues/events{/number}",
            issues_url = "https://api.github.com/repos/testorg/TestRepoDetail/issues{/number}",
            keys_url = "https://api.github.com/repos/testorg/TestRepoDetail/keys{/key_id}",
            labels_url = "https://api.github.com/repos/testorg/TestRepoDetail/labels{/name}",
            language = "Kotlin",
            languages_url = "https://api.github.com/repos/testorg/TestRepoDetail/languages",
            license = License(
                name = "Apache License 2.0",
                key = "apache-2.0",
                node_id = "MDEwOlJlcG9zaXRvcnkxMjk2MjY5",
                spdx_id = "123",
                url = "https://github.com/user/TestRepo.git"
            ),
            merges_url = "https://api.github.com/repos/testorg/TestRepoDetail/merges",
            milestones_url = "https://api.github.com/repos/testorg/TestRepoDetail/milestones{/number}",
            mirror_url = null,
            network_count = 15,
            node_id = "MDEwOlJlcG9zaXRvcnkyMzQ1Njc4",
            notifications_url = "https://api.github.com/repos/testorg/TestRepoDetail/notifications{?since,all,participating}",
            open_issues = 2,
            open_issues_count = 2,
            organization = Organization(
                login = "testorg",
                id = 303,
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
            pushed_at = "2023-11-01T10:00:00Z",
            releases_url = "https://api.github.com/repos/testorg/TestRepoDetail/releases{/id}",
            size = 2048,
            ssh_url = "git@github.com:testorg/TestRepoDetail.git",
            stargazers_count = 250,
            stargazers_url = "https://api.github.com/repos/testorg/TestRepoDetail/stargazers",
            statuses_url = "https://api.github.com/repos/testorg/TestRepoDetail/statuses/{sha}",
            subscribers_count = 20,
            subscribers_url = "https://api.github.com/repos/testorg/TestRepoDetail/subscribers",
            subscription_url = "https://api.github.com/repos/testorg/TestRepoDetail/subscription",
            svn_url = "https://github.com/testorg/TestRepoDetail",
            tags_url = "https://api.github.com/repos/testorg/TestRepoDetail/tags",
            teams_url = "https://api.github.com/repos/testorg/TestRepoDetail/teams",
            temp_clone_token = null,
            topics = listOf(
                "kotlin",
                "android",
                "testing",
                "jetpack-compose",
                mapOf("name" to "advanced-topic", "value" to 123)
            ),
            trees_url = "https://api.github.com/repos/testorg/TestRepoDetail/git/trees{/sha}",
            updated_at = "2023-11-01T10:00:00Z",
            visibility = "public",
            watchers = 250,
            watchers_count = 250,
            web_commit_signoff_required = false,
            allow_forking = true,
            archived = false,
            pulls_url = "https://api.github.com/repos/testorg/TestRepoDetail/teams"
        )


        coEvery { repository.getRepoBydId("1") } returns fakeDto

        val result = useCase().toList()
        assertTrue(result[1] is Resource.Success)
        assertEquals("Test", (result[1] as Resource.Success).data)
    }

}