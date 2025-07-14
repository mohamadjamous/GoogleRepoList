package com.app.googlerepolist.presentation.repo_list.view

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.googlerepolist.common.UiEvent
import com.app.googlerepolist.presentation.Screen
import com.app.googlerepolist.presentation.repo_list.components.RepoListItem
import com.app.googlerepolist.presentation.repo_list.viewmodel.RepoListViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RepoListScreen(
    navController: NavController,
    viewModel: RepoListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val searchQuery = viewModel.searchQuery

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.NavigateToDetail -> {
                    navController.navigate(Screen.RepoDetailScreen.route + "/${event.repoId}")
                }
                is UiEvent.ShowSnackBar -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.onSearchQueryChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search repositories") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true,
        )

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center )
        {

            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                state.error.isNotBlank() -> {
                    Text(
                        text = state.error,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .align(Alignment.Center)
                    )
                }

                else -> {

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        items(viewModel.filteredRepos, key = { it.id }) { repo ->
                            this@Column.AnimatedVisibility(visible = true) {
                                RepoListItem(repo = repo, onItemClick = {
                                    navController.navigate(Screen.RepoDetailScreen.route + "/${repo.id}")
                                })
                            }
                        }

                    }
                }
            }
        }
    }
}
