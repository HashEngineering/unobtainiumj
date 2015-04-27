package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Unobtainium";
    public static final String coinTicker = "NMC";
    public static final String coinURIScheme = "unobtanium";
    public static final String cryptsyMarketId = "133";
    public static final String cryptsyMarketCurrency = "UNO";
    public static final String PATTERN_PRIVATE_KEY_START = "[56]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[KL]";
    public static final String PATTERN_PRIVATE_KEY_START_TESTNET = "9";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED_TESTNET = "c";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "https://chainz.cryptoid.info/uno/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address.dws?";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx.dws?";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block.dws?";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "udXV3ezmdjDKThagShgkp1i2ky3JGgDH5G";  //HashEngineering donation UNO address

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/uno/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;

    public static final int TARGET_TIMESPAN = (int)(3 * 60);  // 3 minutes per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(60);  // 1 minutes per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //

    public static final int nAveragingInterval = INTERVAL * 20;
    public static final int nAveragingTargetTimespan = nAveragingInterval * TARGET_SPACING;

    public static final int nMaxAdjustDown = 20; // 20% adjustment down
    public static final int nMaxAdjustUp = 10; // 10% adjustment up

    public static final int nTargetTimespanAdjDown = TARGET_TIMESPAN * (100 + nMaxAdjustDown) / 100;

    public static final int nMinActualTimespan = nAveragingTargetTimespan * (100 - nMaxAdjustUp) / 100;
    public static final int nMaxActualTimespan = nAveragingTargetTimespan * (100 + nMaxAdjustDown) / 100;

    public static final int AUXPOW_START_TESTNET = 500;
    public static final int AUXPOW_START_MAINNET = 600000;

    public static final int getIntervalCheckpoints() {
            return INTERVAL * 1000;

    }
    public static int getFullRetargetStartBlock()
    {
        return 19200;
    }
    public static final int PROOF_OF_WORK_FORK_BLOCK_MAINNET = 450000;
    public static final int PROOF_OF_WORK_FORK_BLOCK_TESTNET = 50;
    public  static boolean AllowMinDifficultyBlocks = false;
    public  static boolean MineBlocksOnDemand = true;

    public static int spendableCoinbaseDepth = 100; //main.h: static const int CINBASE_MATURITY
    public static final int MAX_COINS = 250000;                 //main.h:  MAX_MONEY


    public static final Coin DEFAULT_MIN_TX_FEE = Coin.valueOf(500000);   // MIN_TX_FEE
    public static final Coin DUST_LIMIT = Coin.valueOf(10000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 60000;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION
    public static final int INIT_PROTO_VERSION = 209;            //version.h

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }

    public static final int Port    = 65534;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 18334;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 130;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 30;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int privateAddressHeader = 224;
    public static final long PacketMagic = 0x03d5b503;      //0xf9, 0xbe, 0xb4, 0xd9

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1375548986L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (1211565L);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000004c2fc5fffb810dccc197d603690099a68305232e552d96ccbe8e2c52b75"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 1;
    static public int genesisBlockVersion = 1; //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer

    static public String genesisTxInBytes = "04ffff001d01043f53616e204672616e636973636f20706c617a612065766163756174656420616674657220737573706963696f7573207061636b61676520697320666f756e64";   //"The Times 03/Jan/2009 Chancellor on brink of second bailout for banks";
    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";



    //static public String genesisMerkleRoot = "3ce968df58f9c8a752306c4b7264afab93149dbc578bd08a42c446caaa6628bb";


    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "108.61.10.90",
            "107.170.63.157",
            "192.241.254.222",
            "198.199.97.43",
            "128.199.174.196",
            "rockchain.info",
            "seed1.coinlab.info",
            "seed3.coinlab.info"
    };

    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.

    //
    // TestNet
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfabfb5da;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "00000007199508e34a9ff81e6ec0c477a4cccff2a4767a8eee39c11db367b008";
    static public long testnetGenesisBlockDifficultyTarget = (0x1d07fff8L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1296688602L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (384568319);                         //main.cpp: LoadBlockIndex

    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(15, 0);



            //return nSubsidy.shiftRight(height / subsidyDecreaseBlockCount);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210000;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04fd68acb6a895f3462d91b43eef0da845f0d531958a858554feab3ac330562bf76910700b3f7c29ee273ddc4da2bb5b953858f6958a50e8831eb43ee30c32f21d";
    public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.unobtanium.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.unobtanium.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.unobtanium.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0, new Sha256Hash(CoinDefinition.genesisHash));
        checkpoints.put( 10000,    new Sha256Hash("000000000009cac39f4ba7dc3dc3bdaabcfdfdea35769fa4475ead20982c5ddf"));
        checkpoints.put( 25000,    new Sha256Hash("00000000000e71ca092325be6f2049903245deb75a3a90b428ecdd51a2dfae9c"));
        checkpoints.put( 50000,    new Sha256Hash("000000000002b1b79ab02f97c7e7e0f219ae648484fa1ba8a6efcac2a19d197a"));
        checkpoints.put( 100000,   new Sha256Hash("0000000000040fb1542b598085adf40d9b69f5284f2ef9305cb2071f7714e681"));
        checkpoints.put( 150000,   new Sha256Hash("00000000000038517177bde8b937af2eed16424e64af730690401e08c8a5e00c")) ;
        checkpoints.put( 200000,	new Sha256Hash("0000000000007a29a6d40e353c54d3de868f8f8f47b9cf5834cdcaf0dc214023"));
        checkpoints.put( 250000,	new Sha256Hash("00000000000002f102d009610190f6bcf356823259600c7cdc8106ba47b3ee89"));
        checkpoints.put( 300000,	new Sha256Hash("00000000000011c7eec259d9be4694b4460217fc82929ce1e380de371ccf3131"));
        checkpoints.put( 350000,	new Sha256Hash("00000000000078d00a08c6e655d95cbf5011b10676f1b94a106ddb3b9df62202"));
        checkpoints.put( 400000,   new Sha256Hash("0000000000001833336d69645601662b9252d09d64426e518c1bcf22eca46013"));
        checkpoints.put( 449999,	new Sha256Hash("000000000000abc7c4e2a51394faa3a6dddbfaf4b8a961724ba47b332356b9de"));
        checkpoints.put( 450000,   new Sha256Hash("00000000000037801b25318e156bd65082c6b25758da742df8a4431a4e3350a0")) ;
        checkpoints.put( 450001,	new Sha256Hash("00000000000031e9eb8de67ba3299f4d2d96fde10349542a6aab48b46d31e35d"));
        checkpoints.put( 475000,	new Sha256Hash("0000000000001d0bbf2f2cf5b4994dd13e97a232ef943c3cd6f17270886eefa9"));
        checkpoints.put( 500000,	new Sha256Hash("0000000000000e8c9abf99b54350a546e6350443fb418db11205688fa09ab594"));
        checkpoints.put( 525000,	new Sha256Hash("0000000000000b5244cf2d5a8836a76fbbc838573710688fa3739686dc129f21")) ;
        checkpoints.put( 550000,	new Sha256Hash("0000000000000c4faf48d3ebafcebe74d016a2e932b634dd88b97588907692e3"));


    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "";

}
