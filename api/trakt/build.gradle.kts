/*
 * Copyright 2017 Google LLC
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
 *
 */

plugins {
    id("kotlin")
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.android.lint)
}

dependencies {
    api(libs.traktJava) {
        exclude(group = "org.threeten", module = "threetenbp")
    }
    api("org.threeten:threetenbp:${libs.versions.threetenbp.get()}:no-tzdb")

    implementation(projects.base)

    implementation(libs.okhttp.okhttp)
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.gsonConverter)

    kapt(libs.dagger.compiler)
}