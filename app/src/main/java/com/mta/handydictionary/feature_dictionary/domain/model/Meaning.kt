package com.mta.handydictionary.feature_dictionary.domain.model

data class Meaning(
  val definitions: List<Definition>,
  val partOfSpeech: String,
)