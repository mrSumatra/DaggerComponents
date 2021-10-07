package dagger.components.di.component

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import dagger.components.di.module.ActivityModule
import dagger.components.di.scope.ActivityScope
import javax.inject.Named

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Named("appContext")
    fun getApplicationContext(): Context

    @Named("activityContext")
    fun getActivityContext(): Context

    fun getProvideEvent(): MutableLiveData<Int>

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activityContext(@Named("activityContext") context: Context): Builder

        fun applicationComponent(appComponent: ApplicationComponent): Builder

        fun build(): MainActivityComponent
    }
}