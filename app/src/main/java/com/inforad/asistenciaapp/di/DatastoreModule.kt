package com.inforad.asistenciaapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.inforad.asistenciaapp.core.Config
import com.inforad.asistenciaapp.data.dataSource.local.datastore.AuthDatastore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    @Provides
    @Singleton
    fun providePreferenceDataStore(
        @ApplicationContext
        context: Context
    ): DataStore<Preferences> = PreferenceDataStoreFactory.create(
        produceFile = {
            context.preferencesDataStoreFile(Config.AUTH_PREFERENCE)
        }
    )

    @Provides
    @Singleton
    fun provideAuthDatastore(dataStore: DataStore<Preferences>) = AuthDatastore(dataStore)
}