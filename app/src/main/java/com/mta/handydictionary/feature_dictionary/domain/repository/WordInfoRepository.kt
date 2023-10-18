package com.mta.handydictionary.feature_dictionary.domain.repository

import com.mta.handydictionary.core.util.Resource
import com.mta.handydictionary.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

  fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}