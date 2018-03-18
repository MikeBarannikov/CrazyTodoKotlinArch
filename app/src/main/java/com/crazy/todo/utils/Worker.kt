package com.crazy.todo.utils

import kotlinx.coroutines.experimental.newFixedThreadPoolContext

@PublishedApi
internal var POOL = newFixedThreadPoolContext(2 * Runtime.getRuntime().availableProcessors(), "bg")