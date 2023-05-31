// Copyright 2023, Christopher Banes and the Tivi project contributors
// SPDX-License-Identifier: Apache-2.0

package app.tivi.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.tivi.inject.ApplicationScope
import me.tatarka.inject.annotations.Provides

actual interface SqlDelightDatabasePlatformComponent {
    @Provides
    @ApplicationScope
    fun provideDriverFactory(): SqlDriver {
        return NativeSqliteDriver(Database.Schema, "tivi.db").also { db ->
            Database.Schema.create(db)
            db.execute(null, "PRAGMA foreign_keys=ON", 0)
        }
    }
}