/*
 *  Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package br.com.zup.beagle.defaults.cache

import android.app.Application
import br.com.zup.beagle.android.store.StoreHandler
import br.com.zup.beagle.android.store.StoreType


open class StoreHandlerDefault(
    private val memoryLocalStore: MemoryLocalStore = MemoryLocalStore
) : StoreHandler {
    private lateinit var databaseLocalStore: DatabaseLocalStore
    fun init(application: Application) {
        databaseLocalStore = DatabaseLocalStore(application)
    }

    override fun save(storeType: StoreType, data: Map<String, String>) {
        data.forEach {
            if (storeType == StoreType.DATABASE) {
                databaseLocalStore.save(it.key, it.value)
            } else {
                MemoryLocalStore.save(it.key, it.value)
            }
        }
    }

    override fun restore(storeType: StoreType, vararg keys: String): Map<String, String?> {
        val values = mutableMapOf<String, String?>()
        keys.forEach {
            val value = if (storeType == StoreType.DATABASE) {
                databaseLocalStore.restore(it)
            } else {
                MemoryLocalStore.restore(it)
            }
            values[it] = value
        }
        return values
    }

    override fun delete(storeType: StoreType, key: String) {
        if (storeType == StoreType.DATABASE) {
            databaseLocalStore.delete(key)
        } else {
            MemoryLocalStore.delete(key)
        }
    }

    override fun getAll(storeType: StoreType): Map<String, String> {
        return if (storeType == StoreType.DATABASE) {
            databaseLocalStore.getAll()
        } else {
            MemoryLocalStore.getAll()
        }
    }
}