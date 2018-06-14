package com.hp.curriculum.web.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Arrays;


/**
 * @author Administrator
 * @date 2018/5/28
 */
@Configuration
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig extends CachingConfigurerSupport {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> method.getName() + ":" + Arrays.toString
                (params);
    }

    @Override
    @Bean
    public CacheManager cacheManager() {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisJsonSerializer<Object> redisJsonSerializer = new RedisJsonSerializer<>();
        RedisSerializationContext.SerializationPair<Object> valueSerializer = RedisSerializationContext
                .SerializationPair.fromSerializer(redisJsonSerializer);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration
                .ofMinutes(1)).serializeValuesWith(valueSerializer).disableCachingNullValues();
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public <K, V> RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<K, V> redisTemplate = new RedisTemplate<>();
        RedisJsonSerializer<V> redisJsonSerializer = new RedisJsonSerializer<>();
        redisTemplate.setValueSerializer(redisJsonSerializer);
        redisTemplate.setHashValueSerializer(redisJsonSerializer);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }

    private class RedisJsonSerializer<T> implements RedisSerializer<T> {

        private final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

        private final byte[] EMPTY_BYTE = new byte[0];

        @Resource
        private Class<T> aClass;

        @Nullable
        @Override
        public byte[] serialize(@Nullable T t) throws SerializationException {
            return t == null ? EMPTY_BYTE : JSON.toJSONString(t, SerializerFeature.WriteClassName, SerializerFeature
                    .WriteDateUseDateFormat)
                    .getBytes
                            (DEFAULT_CHARSET);
        }

        @Nullable
        @Override
        public T deserialize(@Nullable byte[] bytes) throws SerializationException {
            return bytes == null || bytes.length <= 0 ? null : JSON.parseObject(new String(bytes, DEFAULT_CHARSET),
                    aClass);
        }
    }
}
