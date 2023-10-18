package com.mta.handydictionary.feature_dictionary.domain.use_case

import com.mta.handydictionary.core.util.Resource
import com.mta.handydictionary.feature_dictionary.domain.model.WordInfo
import com.mta.handydictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
  private val repository: WordInfoRepository,
) {

  operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
    if (word.isBlank()) {
      return flow { }
    }
    return repository.getWordInfo(word)
  }
}