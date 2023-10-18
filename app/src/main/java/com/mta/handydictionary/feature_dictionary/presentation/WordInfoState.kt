package com.mta.handydictionary.feature_dictionary.presentation

import com.mta.handydictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
  val wordInfoItems: List<WordInfo> = emptyList(),
  val isLoading: Boolean = false
)