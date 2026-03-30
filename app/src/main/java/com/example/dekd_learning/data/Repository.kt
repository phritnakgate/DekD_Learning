package com.example.dekd_learning.data

import com.example.dekd_learning.data.local.Item
import com.example.dekd_learning.data.local.ItemDao
import com.example.dekd_learning.data.model.MarsPhoto
import com.example.dekd_learning.data.remote.ApiService
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>

    //LOCAL
    fun getAllItemsStream(): Flow<List<Item>>
    fun getItemStream(id: Int): Flow<Item?>
    suspend fun insertItem(item: Item)
    suspend fun deleteItem(item: Item)
    suspend fun updateItem(item: Item)
}

class Repository(
    private val apiService: ApiService,
    private val itemDao: ItemDao
) : IRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return apiService.getPhotos()
    }
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)
}