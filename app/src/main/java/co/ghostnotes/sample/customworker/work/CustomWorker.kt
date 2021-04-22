package co.ghostnotes.sample.customworker.work

import android.content.Context
import android.widget.Toast
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import co.ghostnotes.sample.customworker.repository.CustomWorkerRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@HiltWorker
class CustomWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val customWorkerRepository: CustomWorkerRepository,
): CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        delay(1000L)

        withContext(Dispatchers.Main) {
            Toast.makeText(
                applicationContext,
                "CustomWorker! + repo=${customWorkerRepository.getText()}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return Result.success()
    }
}