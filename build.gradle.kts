import kr.entree.spigradle.kotlin.spigot

plugins {
    kotlin("jvm") version "1.3.71"
    id("kr.entree.spigradle") version "1.2.2"
}

group = "com.gmail@kmj57667" // 본인의 홈페이지 주소 또는 이메일 주소를 거꾸로 적음
version = "1.0.0"

repositories {
    maven("https://maven.heartpattern.kr/repository/maven-public/") // 마인크래프트 관련 artifact들을 모아둔 repo
}

dependencies {
    implementation(kotlin("stdlib-jdk8")) // kotlin stdlib

    compileOnly(spigot("1.12.2")) // spigot api
}

spigot { // plugin.yml 설정
    authors = listOf("HeartPattern")
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    jar {
        from(
                shade.map {
                    if (it.isDirectory)
                        it
                    else
                        zipTree(it)
                }
        )
    }
}
