package com.efundae.moviles.nivel4.ud3.reto6.di

import android.content.Context
import android.content.SharedPreferences
import com.efundae.moviles.nivel4.ud3.reto6.models.TareaRepository
import com.efundae.moviles.nivel4.ud3.reto6.models.mocks.TareaDaoMock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTareaDaoMock(): TareaDaoMock = TareaDaoMock()

    @Provides
    @Singleton
    fun provideMiRepositorio(
        tareaDaoMock: TareaDaoMock
    ): TareaRepository = TareaRepository(dao = tareaDaoMock)

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("App", Context.MODE_PRIVATE)
    }

}