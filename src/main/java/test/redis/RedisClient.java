package test.redis;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class RedisClient {
	private static Scanner scanner;
	private JedisCluster jedisCluster;
	private RedisEnv currentRedisEnv;
	
	private RedisClient() {
		
	}
	
	public void readCommand(String[] command) {
		switch (command[0]) {
		case "env":
			listEnv();
			break;
		case "connect":
			if(command.length > 1) {
				connect(command[1]);
			}
			break;
		case "current":
			currentEnv();
			break;
		case "keys":
			if(command.length > 1) {
				listKeys(command[1]);
			} else {
				listAllKeys();
			}
			break;
		case "get":
			if(command.length > 1) {
				getData(command[1]);
			}
			break;
		case "set":
			if(command.length > 2) {
				setData(command[1], command[2]);
			}
			break;
		case "delete":
			if(command.length > 1) {
				delete(command[1]);
			}
			break;
		case "hget":
			if(command.length > 2) {
				getHashData(command[1], command[2]);
			}
			break;
		case "hgetall":
			if(command.length > 1) {
				getAllHashData(command[1]);
			}
			break;
		case "hset":
			if(command.length > 3) {
				setHashData(command[1], command[2], command[3]);
			}
			break;
		case "exit":
			close();
			break;
		case "abc":
			setInitData();
			break;
		}
	}
	
	private void setInitData() {
		String data = "{\"extObject\":[{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1517909896000,\"gmtModified\":1517909898000,\"id\":4,\"increment\":0.01,\"isDefault\":1,\"isQuote\":true,\"isSettlement\":1,\"isStable\":false,\"logo\":\"20180827653657.png\",\"maxSize\":1000000.0,\"minSize\":0.01,\"name\":\"US Dollar\",\"shortName\":\"USD\",\"sortId\":1,\"status\":1,\"symbol\":\"$\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066023572,\"id\":80,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":1,\"isStable\":false,\"logo\":\"20180904456422.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Euro\",\"shortName\":\"EUR\",\"sortId\":2,\"status\":1,\"symbol\":\"€\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066151921,\"id\":81,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":1,\"isStable\":false,\"logo\":\"20180904271975.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Great Britain Pound\",\"shortName\":\"GBP\",\"sortId\":3,\"status\":1,\"symbol\":\"£\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066260626,\"id\":82,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":1,\"isStable\":false,\"logo\":\"20180904264652.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Hong Kong Dollar\",\"shortName\":\"HKD\",\"sortId\":4,\"status\":1,\"symbol\":\"HK$\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066286733,\"id\":83,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":1,\"isStable\":false,\"logo\":\"20180904787406.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Singapore Dollar\",\"shortName\":\"SGD\",\"sortId\":5,\"status\":1,\"symbol\":\"S$\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066308576,\"id\":84,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904827989.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Malaysian Ringgit\",\"shortName\":\"MYR\",\"sortId\":6,\"status\":1,\"symbol\":\"M.＄\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1534767807559,\"id\":77,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":1,\"isStable\":false,\"logo\":\"20180831701970.png\",\"maxSize\":1000000.0,\"minSize\":0.01,\"name\":\"Chinese Yuan\",\"shortName\":\"CNY\",\"sortId\":7,\"status\":1,\"symbol\":\"￥\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066392150,\"id\":85,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904438315.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Indonesia Rupiah\",\"shortName\":\"IDR\",\"sortId\":8,\"status\":1,\"symbol\":\"Rp\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066413019,\"id\":86,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904209523.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Thai Baht\",\"shortName\":\"THB\",\"sortId\":9,\"status\":1,\"symbol\":\"฿\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1534767981433,\"id\":78,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":1,\"isStable\":false,\"logo\":\"20180831399263.png\",\"maxSize\":1000000.0,\"minSize\":0.01,\"name\":\"Japanese Yen\",\"shortName\":\"JPY\",\"sortId\":10,\"status\":1,\"symbol\":\"￥\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066453921,\"id\":87,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904961202.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"South Korean Won\",\"shortName\":\"KRW\",\"sortId\":11,\"status\":3,\"symbol\":\"₩\",\"type\":1},{\"coinFuncSwitch\":{\"listedAsSpotQuote\":false},\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066474262,\"id\":88,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904314622.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Australian Dollar\",\"shortName\":\"AUD\",\"sortId\":12,\"status\":1,\"symbol\":\"A$\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066496721,\"id\":89,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904694602.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Arab Emir. Dirham\",\"shortName\":\"AED\",\"sortId\":13,\"status\":1,\"symbol\":\"د.إ\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066530122,\"id\":90,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904089035.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Canadian Dollar\",\"shortName\":\"CAD\",\"sortId\":14,\"status\":1,\"symbol\":\"C$\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066552705,\"id\":91,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904794566.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Vietnam Dong\",\"shortName\":\"VND\",\"sortId\":15,\"status\":1,\"symbol\":\"₫\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066651435,\"id\":92,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904045611.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Indian Rupee\",\"shortName\":\"INR\",\"sortId\":16,\"status\":1,\"symbol\":\"₹\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066690053,\"id\":93,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904891062.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Philippine Pesso\",\"shortName\":\"PHP\",\"sortId\":17,\"status\":1,\"symbol\":\"Phi\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1536066714325,\"id\":94,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180904505103.png\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Swiss franc\",\"shortName\":\"CHF\",\"sortId\":18,\"status\":1,\"symbol\":\"CHF\",\"type\":1},{\"coinFuncSwitch\":{\"walletDeposit\":false},\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1516123349000,\"gmtModified\":1540793275000,\"id\":2,\"increment\":1.0E-5,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180827224655.png\",\"maxSize\":2000.0,\"minSize\":0.002,\"name\":\"Bitcoin\",\"shortName\":\"BTC\",\"sortId\":51,\"status\":1,\"symbol\":\"BTC\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1516112883000,\"gmtModified\":1520939365000,\"id\":1,\"increment\":1.0E-5,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180827654463.png\",\"maxSize\":5000.0,\"minSize\":1.0E-5,\"name\":\"Ethereum\",\"shortName\":\"ETH\",\"sortId\":52,\"status\":1,\"symbol\":\"ETH\",\"type\":2},{\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1534768098032,\"id\":79,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":true,\"logo\":\"20180904005430.png\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Tether USD\",\"shortName\":\"USDT\",\"sortId\":53,\"status\":1,\"symbol\":\"₮\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1516813157000,\"gmtModified\":1516813157000,\"id\":3,\"increment\":1.0E-5,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180908185553876508.png\",\"maxSize\":4000.0,\"minSize\":1.0E-5,\"name\":\"Bitcoin Cash\",\"shortName\":\"BCH\",\"sortId\":53,\"status\":3,\"symbol\":\"BCH\",\"type\":2},{\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1562668591152,\"id\":96,\"increment\":0.0,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":true,\"logo\":\"20190709103629487113.png\",\"maxSize\":20000.0,\"minSize\":1.0E-5,\"name\":\"TrueUSD\",\"shortName\":\"TUSD\",\"sortId\":54,\"status\":1,\"symbol\":\"TUSD\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1516123349000,\"gmtModified\":1516123352000,\"id\":7,\"increment\":1.0E-5,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"20180827518218.png\",\"maxSize\":20000.0,\"minSize\":1.0E-5,\"name\":\"Litecoin\",\"shortName\":\"LTC\",\"sortId\":54,\"status\":1,\"symbol\":\"LTC\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1517909896000,\"id\":110,\"increment\":0.01,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":1,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":1000.0,\"name\":\"FEE\",\"shortName\":\"FEE\",\"sortId\":55,\"status\":1,\"symbol\":\"$\",\"type\":1},{\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1562753917523,\"id\":97,\"increment\":0.0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":true,\"logo\":\"\",\"maxSize\":20000.0,\"minSize\":1.0E-5,\"name\":\"USD Coin\",\"shortName\":\"USDC\",\"sortId\":55,\"status\":1,\"symbol\":\"USDC\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1517909896000,\"id\":111,\"increment\":0.01,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":1,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":1000.0,\"name\":\"BNS\",\"shortName\":\"BNS\",\"sortId\":56,\"status\":1,\"symbol\":\"$\",\"type\":1},{\"decimals\":12,\"depositMin\":0.0,\"gmtCreate\":1569482935544,\"id\":112,\"increment\":0.0,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Monero\",\"shortName\":\"XMR\",\"sortId\":57,\"status\":1,\"symbol\":\"XMR\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1571270400000,\"id\":103,\"increment\":1.0E-5,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":2000.0,\"minSize\":0.002,\"name\":\"Bitcoin(Liquid)\",\"shortName\":\"LBTC\",\"sortId\":58,\"status\":3,\"symbol\":\"LBTC\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":9,\"depositMin\":0.0,\"gmtCreate\":1581510449000,\"id\":118,\"increment\":1.0E-5,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":true,\"logo\":\"\",\"maxSize\":9.0E7,\"minSize\":0.0,\"name\":\"Diamond Coin(DC)\",\"shortName\":\"DC\",\"sortId\":59,\"status\":1,\"symbol\":\"DC\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1583262798000,\"id\":119,\"increment\":0.001,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":2000.0,\"minSize\":0.002,\"name\":\"BTSE\",\"shortName\":\"BTSE\",\"sortId\":60,\"status\":1,\"symbol\":\"BTSE\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1584421319000,\"id\":120,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":true,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Gold Tether\",\"shortName\":\"XAUT\",\"sortId\":61,\"status\":1,\"symbol\":\"XAUT\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1586247516000,\"id\":121,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"BCB\",\"shortName\":\"BCB\",\"sortId\":61,\"status\":1,\"symbol\":\"BCB\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1589366595000,\"id\":123,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":true,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"BiLira\",\"shortName\":\"TRYB\",\"sortId\":62,\"status\":1,\"symbol\":\"TRYB\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1588265513095,\"id\":124,\"increment\":1.0E-6,\"isQuote\":true,\"isSettlement\":0,\"isStable\":true,\"logo\":\"20180904005430.png\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Tether USD for TRYB\",\"shortName\":\"TR_USDT\",\"sortId\":64,\"status\":1,\"symbol\":\"₮\",\"type\":2},{\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1589774791000,\"id\":122,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Ripple XRP\",\"shortName\":\"XRP\",\"sortId\":65,\"status\":1,\"symbol\":\"XRP\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1592380655000,\"id\":126,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Bitfinex LEO\",\"shortName\":\"LEO\",\"sortId\":66,\"status\":1,\"symbol\":\"LEO\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1594181918000,\"id\":127,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Tron\",\"shortName\":\"TRX\",\"sortId\":67,\"status\":1,\"symbol\":\"TRX\",\"type\":2},{\"decimals\":7,\"depositMin\":0.0,\"gmtCreate\":1595331952097,\"id\":129,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1.0E7,\"minSize\":10.0,\"name\":\"Stellar\",\"shortName\":\"XLM\",\"sortId\":67,\"status\":1,\"symbol\":\"XLM\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1597771260000,\"id\":134,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"logo\":\"\",\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"xDAI Stake\",\"shortName\":\"STAKE\",\"sortId\":68,\"status\":1,\"symbol\":\"STAKE\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1597940465088,\"id\":135,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"JUST GOV\",\"shortName\":\"JST\",\"sortId\":69,\"status\":1,\"symbol\":\"JST\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1598880650845,\"id\":142,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"PhoenixDAO\",\"shortName\":\"PHNX\",\"sortId\":70,\"status\":1,\"symbol\":\"PHNX\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1598880651752,\"id\":143,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Ferrum Network Token\",\"shortName\":\"FRM\",\"sortId\":71,\"status\":1,\"symbol\":\"FRM\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1598880652370,\"id\":144,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Hxro\",\"shortName\":\"HXRO\",\"sortId\":72,\"status\":1,\"symbol\":\"HXRO\",\"type\":2},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1598896800000,\"id\":145,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"New Zealand Dollar\",\"shortName\":\"NZD\",\"sortId\":73,\"status\":1,\"symbol\":\"NZD\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1598896800000,\"id\":146,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"Russian Ruble\",\"shortName\":\"RUB\",\"sortId\":74,\"status\":1,\"symbol\":\"RUB\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1598896800000,\"id\":147,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"South African Rand\",\"shortName\":\"ZAR\",\"sortId\":75,\"status\":1,\"symbol\":\"ZAR\",\"type\":1},{\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1598896800000,\"id\":148,\"increment\":0.01,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":0.0,\"name\":\"New Taiwan Dollar\",\"shortName\":\"TWD\",\"sortId\":76,\"status\":1,\"symbol\":\"TWD\",\"type\":1},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1599658250000,\"id\":149,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Loki\",\"shortName\":\"LOKI\",\"sortId\":77,\"status\":1,\"symbol\":\"LOKI\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1600176650000,\"id\":155,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Swerve\",\"shortName\":\"SWRV\",\"sortId\":79,\"status\":1,\"symbol\":\"SWRV\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1600690747330,\"id\":157,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Uniswap\",\"shortName\":\"UNI\",\"sortId\":81,\"status\":1,\"symbol\":\"UNI\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1600691684949,\"id\":158,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Curve DAO Token\",\"shortName\":\"CRV\",\"sortId\":82,\"status\":1,\"symbol\":\"CRV\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1600691768347,\"id\":159,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Compound\",\"shortName\":\"COMP\",\"sortId\":83,\"status\":1,\"symbol\":\"COMP\",\"type\":2},{\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1600863912237,\"id\":160,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Cosmos ATOM\",\"shortName\":\"ATOM\",\"sortId\":84,\"status\":1,\"symbol\":\"ATOM\",\"type\":2},{\"coinFuncSwitch\":{\"walletTransferToFutures\":false},\"decimals\":4,\"depositMin\":0.0,\"gmtCreate\":1600863912237,\"id\":162,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Brazilian Digital Token\",\"shortName\":\"BRZ\",\"sortId\":85,\"status\":1,\"symbol\":\"BRZ\",\"type\":2},{\"decimals\":6,\"depositMin\":0.0,\"gmtCreate\":1601396783000,\"id\":163,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":true,\"isSettlement\":0,\"isStable\":true,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Tether USD for TWD\",\"shortName\":\"BG_USDT\",\"sortId\":86,\"status\":1,\"symbol\":\"USDT\",\"type\":2},{\"decimals\":12,\"depositMin\":0.0,\"gmtCreate\":1603191401793,\"id\":164,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"DOT\",\"shortName\":\"DOT\",\"sortId\":87,\"status\":1,\"symbol\":\"DOT\",\"type\":2},{\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1603376793508,\"id\":165,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":false,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"PARADISE TOKEN\",\"shortName\":\"PDT\",\"sortId\":88,\"status\":1,\"symbol\":\"PDT\",\"type\":2},{\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1603376808079,\"id\":166,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":true,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Dai Stablecoin\",\"shortName\":\"DAI\",\"sortId\":89,\"status\":1,\"symbol\":\"DAI\",\"type\":2},{\"decimals\":18,\"depositMin\":0.0,\"gmtCreate\":1603376861159,\"id\":167,\"increment\":1.0E-6,\"isDefault\":0,\"isQuote\":false,\"isSettlement\":0,\"isStable\":true,\"maxSize\":1000000.0,\"minSize\":10.0,\"name\":\"Paxos Standard\",\"shortName\":\"PAX\",\"sortId\":90,\"status\":1,\"symbol\":\"PAX\",\"type\":2}],\"lastActiveDateTime\":1603765426}";
		jedisCluster.set("COINS", data);
	}
	
	private void listEnv() {
		for(RedisEnv redisEnv : RedisEnv.values()) {
			System.out.println(redisEnv.name());
		}
	}
	
	private void connect(String env) {
		RedisEnv redisEnv;
		try {
			redisEnv = RedisEnv.valueOf(env);
		} catch(IllegalArgumentException e) {
			System.out.println("Can't find this environment.");
			return;
		}
		
		Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : redisEnv.getIps().split(",")) {
            String ip = ipPort.split(":")[0];
            String port = ipPort.split(":")[1];
            HostAndPort hostAndPort = new HostAndPort(ip, Integer.parseInt(port));
            nodes.add(hostAndPort);
        }

        currentRedisEnv = redisEnv;
        jedisCluster = new JedisCluster(nodes);
	}
	
	private void currentEnv() {
		if(currentRedisEnv != null) {
			System.out.println(currentRedisEnv);
		} else {
			System.out.println("no connection");
		}
	}
	
	private void listAllKeys() {
		Set<String> setKeys = getKeys("*");

        for (String key : setKeys) {
            System.out.println(key);
        }
	}
	
	private void listKeys(String pattern) {
		Set<String> setKeys = getKeys(pattern);
		for (String key : setKeys) {
            System.out.println(key);
        }
	}
	
	private void getData(String topic) {
		System.out.println(jedisCluster.get(topic));
	}
	
	private void setData(String topic, String value) {
		jedisCluster.set(topic, value);
	}
	
	private void getHashData(String topic, String key) {
		System.out.println(jedisCluster.hget(topic, key));
	}
	
	private void getAllHashData(String topic) {
		Map<String, String> map = jedisCluster.hgetAll(topic);
		for(String key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}
	}
	
	private void setHashData(String topic, String key, String value) {
		jedisCluster.hset(topic, key, value);
	}
	
	private void delete(String topic) {
		jedisCluster.del(topic);
	}
	
	private Set<String> getKeys(String pattern) {
		Set<String> setKeys = new HashSet<>();
        Map<String, JedisPool> map = jedisCluster.getClusterNodes();
        for (String redisKey : map.keySet()) {
            JedisPool jedisPool = map.get(redisKey);
            Jedis jedis = jedisPool.getResource();
            Set<String> set = jedis.keys(pattern);
            setKeys.addAll(set);
        }
        return setKeys;
	}
	
	private void close() {
		scanner.close();
		System.exit(0);
	}
	
	public static void main(String[] s) {
		RedisClient client = new RedisClient();

        scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            client.readCommand(cmd.split(" "));
        }
	}
}
