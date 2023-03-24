package cn.zeroable.shop.utils.id;

import cn.hutool.core.lang.Snowflake;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 雪花算法工厂.
 *
 * @author zeroable
 * @version 2023/3/24 14:58
 * @see
 * @since 0.0.1
 */
public class SnowFlakeFactory {
    /**
     * 默认数据中心id
     */
    private static final long DEFAULT_DATACENTER_ID = SnowFlakeLoader.getDataCenterId();
    /**
     * 默认的机器id
     */
    private static final long DEFAULT_MACHINE_ID = SnowFlakeLoader.getMachineId();

    /**
     * 最大支持机器节点数0~31，一共32个
     */
    private static final long MAX_WORKER_ID = ~(-1L << 5L);

    /**
     * 最大支持数据中心节点数0~31，一共32个
     */
    private static final long MAX_DATA_CENTER_ID = ~(-1L << 5L);

    /**
     * 默认的雪花算法句柄
     */
    private static final String DEFAULT_SNOW_FLAKE = "snow_flake";


    /**
     * 缓存Snowflake对象
     */
    private static ConcurrentMap<String, Snowflake> snowFlakeCache = new ConcurrentHashMap<>(2);

    private static Snowflake getSnowflake(long datacenterId, long machineId) {
        return new Snowflake(datacenterId, machineId);
    }

    private static Snowflake getSnowflake() {
        return new Snowflake(DEFAULT_DATACENTER_ID, DEFAULT_MACHINE_ID);
    }

    public static Snowflake getSnowFlakeFromCache() {
        Snowflake snowFlake = snowFlakeCache.get(DEFAULT_SNOW_FLAKE);
        if (snowFlake == null) {
            snowFlake = new Snowflake(DEFAULT_DATACENTER_ID, DEFAULT_MACHINE_ID);
            snowFlakeCache.put(DEFAULT_SNOW_FLAKE, snowFlake);
        }
        return snowFlake;
    }

    /**
     * 根据数据中心id和机器id从缓存中获取全局id
     *
     * @param dataCenterId: 取值为1~31
     * @param machineId:    取值为1~31
     */
    public static Snowflake getSnowFlakeByDataCenterIdAndMachineIdFromCache(Long dataCenterId, Long machineId) {
        if (dataCenterId > MAX_WORKER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_WORKER_ID or less than 0");
        }
        if (machineId > MAX_DATA_CENTER_ID || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_DATA_CENTER_ID or less than 0");
        }
        String key = DEFAULT_SNOW_FLAKE.concat("_").concat(String.valueOf(dataCenterId)).concat("_").concat(String.valueOf(machineId));
        Snowflake snowFlake = snowFlakeCache.get(key);
        if (snowFlake == null) {
            snowFlake = new Snowflake(dataCenterId, machineId);
            snowFlakeCache.put(key, snowFlake);
        }
        return snowFlake;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getSnowFlakeFromCache().nextId());
        }
    }
}
