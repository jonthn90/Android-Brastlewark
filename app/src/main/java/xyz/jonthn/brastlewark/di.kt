package xyz.jonthn.brastlewark

import android.app.Application
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module
import xyz.jonthn.brastlewark.data.server.APIDataSource
import xyz.jonthn.brastlewark.view.ui.inhabitantdetail.InhabitantDetailFragment
import xyz.jonthn.brastlewark.view.ui.inhabitantdetail.InhabitantDetailViewModel
import xyz.jonthn.brastlewark.view.ui.inhabitants.InhabitantsFragment
import xyz.jonthn.brastlewark.view.ui.inhabitants.InhabitantsViewModel
import xyz.jonthn.data.repository.InhabitantsRepository
import xyz.jonthn.data.source.RemoteDataSource
import xyz.jonthn.usescases.GetInhabitants

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    factory<RemoteDataSource> { APIDataSource() }

}

private val dataModule = module {
    factory { InhabitantsRepository(get()) }
}


private val scopesModule = module {
    scope(named<InhabitantsFragment>()) {
        viewModel { InhabitantsViewModel(get()) }
        scoped { GetInhabitants(get()) }
    }

    scope(named<InhabitantDetailFragment>()) {
        viewModel { (id: Int) -> InhabitantDetailViewModel(id) }
    }
}