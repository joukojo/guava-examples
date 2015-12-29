package org.yogocodes.guava.examples.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
			@Override
			public String load(String key) throws Exception {
				System.out.println("really loading data");
				Thread.sleep(500L);
				return "value-" + key;
			}
		};
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.concurrencyLevel(5)
				.build(cacheLoader);

		for (int i = 0; i < 5000; i++) {

			for (int j = 0; j < 50; j++) {
				String key = "key-" + j;
				String value = cache.get(key);
				System.out.println("key=" + key + "-->" + value);
			}
			Thread.sleep(500L);
		}
		System.exit(0);
	}
}
