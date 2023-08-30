package com.aallam.openai.sample.jvm

import com.aallam.openai.api.file.FileSource
import com.aallam.openai.api.image.ImageCreation
import com.aallam.openai.api.image.ImageEdit
import com.aallam.openai.api.image.ImageSize
import com.aallam.openai.client.OpenAI
import okio.FileSystem
import okio.Path.Companion.toPath

suspend fun images(openAI: OpenAI) {
    println("\n> Create images...")
    val images = openAI.imageURL(
        creation = ImageCreation(
            prompt = "A cute baby sea otter",
            n = 2,
            size = ImageSize.is1024x1024
        )
    )
    println(images)

    println("\n> Edit images...")
    val imageEdit = ImageEdit(
        image = FileSource(path = "image.png".toPath(), fileSystem = FileSystem.RESOURCES),
        mask = FileSource(path = "image.png".toPath(), fileSystem = FileSystem.RESOURCES),
        prompt = "a sunlit indoor lounge area with a pool containing a flamingo",
        n = 1,
        size = ImageSize.is1024x1024,
    )

    val imageEdits = openAI.imageURL(imageEdit)
    println(imageEdits)
}
