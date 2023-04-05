/*
 * Copyright (c) 2013-2022 kopiLeft Services SARL, Tunis TN
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

import org.asciidoctor.gradle.jvm.pdf.AsciidoctorPdfTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.asciidoctor.jvm.convert") version "3.3.2"
  id("org.asciidoctor.jvm.pdf") version "3.3.2"
  id("org.asciidoctor.jvm.gems") version "3.3.2"
}

group = "com.progmag"

repositories {
  mavenCentral()
}

tasks {
  "asciidoctorPdf"(AsciidoctorPdfTask::class) {
    sources(delegateClosureOf<PatternSet> {
      include("main.adoc")
    })
    fontsDirs(files("src/docs/asciidoc/fonts"))
  }
}

pdfThemes {
  local("pdv-theme") {
    themeDir = file("src/docs/asciidoc")
  }
}
