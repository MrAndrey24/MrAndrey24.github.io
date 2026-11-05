/**
 * MIT License
 *
 * Copyright (c) 2026 Andrey Acosta  Ramirez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.mrandrey24.portfolio.ui.data

data class Project(
    val title: String,
    val techs: List<String>,
    val link: String,
    val isComingSoon: Boolean?,
)

val projects =
    listOf(
        Project(
            title = "Bus a lo Tico",
            techs = listOf("Kotlin Multiplatform", "Firebase", "Android", "Swift"),
            link = "https://github.com/MrAndrey24/Bus-A-Lo-Tico",
            isComingSoon = false,
        ),
        Project(
            title = "Portfolio",
            techs = listOf("Kotlin Multiplatform"),
            link = "https://github.com/MrAndrey24/mrandrey24.github.io",
            isComingSoon = false,
        ),
        Project(
            title = "Clean Architecture - Java Spring Boot",
            techs = listOf("Java", "Spring Boot"),
            link = "https://github.com/MrAndrey24/clean-arch",
            isComingSoon = false,
        ),
        Project(
            title = "Caching Proxy Server",
            techs = listOf("Go"),
            link = "https://github.com/MrAndrey24/cache-proxy",
            isComingSoon = false,
        ),
        Project(
            title = "Media-Organizer",
            techs = listOf("Python"),
            link = "https://github.com/MrAndrey24/Media-Organizer",
            isComingSoon = false,
        ),
        Project(
            title = "URL Shortener Service",
            techs = listOf("Go"),
            link = "https://github.com/MrAndrey24/url-shortener",
            isComingSoon = false,
        ),
        Project(
            title = "Personal-Blog",
            techs = listOf("Python", "Django"),
            link = "https://github.com/MrAndrey24/Personal-Blog",
            isComingSoon = false,
        ),
        Project(
            title = "BeeVsPanda",
            techs = listOf("Java"),
            link = "https://github.com/MrAndrey24/BeeVsPanda",
            isComingSoon = false,
        ),
    )
