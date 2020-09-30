package com.nick.mowen.adtproject.skeleton

import kotlinx.coroutines.CoroutineScope

abstract class AbstractPresenter(activityScope: CoroutineScope) : CoroutineScope by activityScope