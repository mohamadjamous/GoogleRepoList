package com.app.googlerepolist.presentation.repo_detail.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.app.googlerepolist.presentation.repo_detail.viewmodel.RepoDetailViewModel

@Composable
fun RepoDetailScreen(
    viewModel: RepoDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val repo = state.repo
    var openUrl by remember { mutableStateOf(false) }

    if (openUrl) {
        repo?.let { launchUrl(it.html_url) }
        openUrl = false
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center
            )
        } else if (repo != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = repo.owner.avatar_url,
                        contentDescription = repo.name,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = repo.full_name,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = repo.owner.login,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Divider()


                Text(
                    text = repo.description ?: "No description provided.",
                    style = MaterialTheme.typography.bodyLarge
                )

                InfoRow(label = "Language", value = repo.language ?: "Unknown")
                InfoRow(label = "Stars", value = repo.stargazers_count.toString())
                InfoRow(label = "Forks", value = repo.forks_count.toString())
                InfoRow(label = "Open Issues", value = repo.open_issues_count.toString())
                InfoRow(label = "Visibility", value = repo.visibility)
                InfoRow(label = "Default Branch", value = repo.default_branch)
                InfoRow(label = "Status", value = if (repo.archived) "Archived" else "Active")

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { openUrl = true },
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                ) {
                    Text("View on GitHub")
                }
            }
        }
    }
}

@Composable
fun launchUrl(url: String) {
    val context = LocalContext.current

    LaunchedEffect(url) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}



@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
}
