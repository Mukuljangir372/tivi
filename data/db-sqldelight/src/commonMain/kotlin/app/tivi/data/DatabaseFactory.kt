/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tivi.data

import app.cash.sqldelight.adapter.primitive.FloatColumnAdapter
import app.cash.sqldelight.adapter.primitive.IntColumnAdapter
import app.tivi.data.columnadaptors.DayOfWeekColumnAdapter
import app.tivi.data.columnadaptors.InstantColumnAdapter
import app.tivi.data.columnadaptors.LocalTimeColumnAdapter
import app.tivi.data.columnadaptors.ShowStatusColumnAdapter
import app.tivi.data.columnadaptors.TimeZoneColumnAdapter
import me.tatarka.inject.annotations.Inject

@Inject
class DatabaseFactory(
    private val driverFactory: DriverFactory,
) {
    fun build(): Database = Database(
        driver = driverFactory.createDriver(),
        showsAdapter = Shows.Adapter(
            trakt_idAdapter = IntColumnAdapter,
            tmdb_idAdapter = IntColumnAdapter,
            trakt_ratingAdapter = FloatColumnAdapter,
            trakt_votesAdapter = IntColumnAdapter,
            runtimeAdapter = IntColumnAdapter,
            first_airedAdapter = InstantColumnAdapter,
            statusAdapter = ShowStatusColumnAdapter,
            airs_dayAdapter = DayOfWeekColumnAdapter,
            airs_timeAdapter = LocalTimeColumnAdapter,
            airs_tzAdapter = TimeZoneColumnAdapter,
        ),
    )
}
