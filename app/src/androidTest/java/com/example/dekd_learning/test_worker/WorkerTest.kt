package com.example.dekd_learning.test_worker

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.work.ListenableWorker
import androidx.work.testing.TestListenableWorkerBuilder
import androidx.work.workDataOf
import com.example.dekd_learning.workers.BlurWorker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BlurWorkerTest {

    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testBlurWorker_returnsSuccess() = runTest {
        val mockInputData = workDataOf(
            "KEY_IMAGE_URI" to "android.resource://com.example.app/drawable/test_image",
            "KEY_BLUR_LEVEL" to 1
        )


        val worker = TestListenableWorkerBuilder<BlurWorker>(context)
            .setInputData(mockInputData)
            .build()

        val result = worker.doWork()

        assertTrue(result is ListenableWorker.Result.Success)
        val outputUri = result.outputData.getString("KEY_IMAGE_URI")
        assertNotNull(outputUri)
    }
}