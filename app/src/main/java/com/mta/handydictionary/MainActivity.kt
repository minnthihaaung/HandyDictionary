package com.mta.handydictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mta.handydictionary.feature_dictionary.presentation.SearchTextField
import com.mta.handydictionary.feature_dictionary.presentation.WordInfoItem
import com.mta.handydictionary.feature_dictionary.presentation.WordInfoViewModel
import com.mta.handydictionary.ui.theme.HandyDictionaryTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HandyDictionaryTheme {
        val viewModel: WordInfoViewModel = hiltViewModel()
        val state = viewModel.state.value

        LaunchedEffect(key1 = true) {
          viewModel.eventFlow.collectLatest { event ->
            when (event) {
              is WordInfoViewModel.UIEvent.ShowSnackBar -> {
              }
            }
          }
        }
        Scaffold(
          topBar = {
            TopAppBar(
              colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
              ),
              title = {
                Text("Handy Dictionary", style = MaterialTheme.typography.titleLarge)
              }
            )
          }
        ) { padding ->
          Box(
            modifier = Modifier
              .padding(paddingValues = padding)
          ) {
            Column(
              modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            ) {
              SearchTextField(
                value = viewModel.searchQuery.value,
                onValueChange = viewModel::onSearch,
                placeholder = "Search...",
              )
              Spacer(modifier = Modifier.height(16.dp))
              LazyColumn(
                modifier = Modifier.fillMaxSize()
              ) {
                items(state.wordInfoItems.size) { i ->
                  val wordInfo = state.wordInfoItems[i]
                  if (i > 0) {
                    Spacer(modifier = Modifier.height(8.dp))
                  }
                  WordInfoItem(wordInfo = wordInfo)
                  if (i < state.wordInfoItems.size - 1) {
                    Divider()
                  }
                }
              }
            }
            if (state.isLoading) {
              CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
          }
        }
      }
    }
  }
}