package com.creativedrewy.nativ.viewmodel

// Screen status state --------------------------------------------------

sealed class NftGalleryViewState(
    val listItems: List<NftViewProps>
)

class Empty: NftGalleryViewState(listOf())

class Loading: NftGalleryViewState(
    listOf(
        NftViewProps(
            name = "Text text text text text text text text text"
        ),
        NftViewProps(
            name = "Text text text text text text text text text"
        )
    )
)

class Display(
    val items: List<NftViewProps>
): NftGalleryViewState(items)

// Visual properties to render Nft in the UI --------------------------------------------------

data class NftViewProps(
    val name: String = "",
    val description: String = "",
    val blockchain: Blockchain = Dev,
    val siteUrl: String = "",
    val assetType: AssetType = Image,
    val assetUrl: String = "",
    val mediaBytes: ByteArray = byteArrayOf()
)

sealed class AssetType

object Model3d : AssetType()
object Image: AssetType()

sealed class Blockchain(
    val name: String
)

object Dev: Blockchain("Development")
object Solana : Blockchain("Solana")