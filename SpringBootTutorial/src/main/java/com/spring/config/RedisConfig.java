package com.spring.config;

import io.lettuce.core.ClientOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.timeout}")
    private Duration redisCommandTimeout;

    @Value("${spring.redis.pool.max-active}")
    private int maxPool;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.database}")
    private Integer database;
    /**
     * Chúng ta cần sử dụng lettuce để kết nối tới Redis, nên tôi tạo ra bean LettuceConnectionFactory và Spring Data sẽ tự động nhận vào cấu hình của mình.
     *
     * @return
     */
//    @Bean
//    protected LettuceConnectionFactory redisConnectionFactory() {
//        // Tạo Standalone Connection tới Redis
//        final ClientOptions clientOptions = ClientOptions.builder().build();
//        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
//                .commandTimeout(redisCommandTimeout)
//                .clientOptions(clientOptions).build();
//        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(redisHost,
//                redisPort);
//        return new LettuceConnectionFactory(serverConfig, clientConfig);
//    }
//
//    /**
//     * tạo ra một RedisTemplate
//     * Với Key là Object
//     * Value là Object
//     * RedisTemplate giúp chúng ta thao tác với Redis
//     * @return
//     */
//    @Bean
//    public RedisTemplate<?, ?> redisTemplate() {
////         tạo ra một RedisTemplate
//        // Với Key là Object
//        // Value là Object
//        // RedisTemplate giúp chúng ta thao tác với Redis
//        final RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return redisTemplate;
//    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);
        redisStandaloneConfiguration.setDatabase(database);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericToStringSerializer<>(String.class));
        template.setHashValueSerializer(new GenericToStringSerializer<>(String.class));
        return template;
    }
}

