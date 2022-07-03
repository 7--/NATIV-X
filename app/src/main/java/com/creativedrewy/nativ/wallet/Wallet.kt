package com.creativedrewy.nativ.usecase

import com.solana.mobilewalletadapter.clientlib.protocol.JsonRpc20Client
import com.solana.mobilewalletadapter.clientlib.protocol.MobileWalletAdapterSession

class Wallet {

    constructor(){
        var jsonRpc20Client : JsonRpc20Client = JsonRpc20Client();
        var mobileWalletAdapterSession : MobileWalletAdapterSession = MobileWalletAdapterSession(jsonRpc20Client, null);

    }
}
