package com.creativedrewy.nativ.injection

import com.creativedrewy.nativ.chainsupport.IBlockchainNftLoader
import com.creativedrewy.nativ.chainsupport.ISupportedChains
import com.creativedrewy.nativ.chainsupport.SupportedChain
import com.creativedrewy.nativ.metaplex.MetaplexNftUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(
    ViewModelComponent::class
)
@Module
class BlockchainSupportModule {

    @Provides
    fun providesISupportedChains(
        metaplex: MetaplexNftUseCase
    ): ISupportedChains {
        return object : ISupportedChains {
            override val chainsToNftLoadersMap: Map<SupportedChain, IBlockchainNftLoader> = mapOf()
        }
    }

}