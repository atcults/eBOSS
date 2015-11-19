package org.sanelib.eboss.common.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

@Service
@Scope("singleton")
public class MapDictionaryServiceImpl implements MapDictionaryService {

	@Autowired
	private AppProperties appProperties;

	private final Map<String, Map<String, String>> mapDictionary = new ConcurrentHashMap<>();

	private Map<String, String> buildMapDictionary(String locale) {

		String messageBundle = appProperties.getMessageBundle();

		System.out.println("Generating MapDictionary.....................");

		Map<String, String> keyValuePair = new HashMap<>();
		String directoryPath = "classpath:MessagesBundle/" + locale + "/*." + messageBundle;

		PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

		try {
			Resource[] resources = resourceResolver.getResources(directoryPath);
			if (resources != null && resources.length != 0) {
				for (Resource resource : resources) {
					if (Objects.equals(messageBundle, "yml")) {
						buildResourceFromYaml(resource, keyValuePair);
					} else if (Objects.equals(messageBundle, "properties")) {
						buildResourceFromProperties(resource, keyValuePair);
					}
				}
			} else {
				System.err.println("Directory/Locale Not Found");
			}
		} catch (IOException e) {
			System.err.println("Directory/Locale Not Found.");
		}

		System.out.println("Finished Generating MapDictionary...............");

		return keyValuePair;
	}

	private void buildResourceFromProperties(Resource resource, Map<String, String> keyValuePair) throws IOException {
		Properties properties = new Properties();
		String prefix = resource.getFilename().substring(0, resource.getFilename().lastIndexOf("."));
		properties.load(new FileInputStream(resource.getFile()));
		for (Object k : properties.keySet()) {
			String key = prefix + "." + k;
			keyValuePair.put(key, properties.getProperty(String.valueOf(k)));
		}
	}

	@SuppressWarnings("unchecked")
	private void buildResourceFromYaml(Resource resource, Map<String, String> keyValuePair) throws IOException {
		String prefix = resource.getFilename().substring(0, resource.getFilename().lastIndexOf("."));
		Yaml yaml = new Yaml();
		Map<String, Object> map = (Map<String, Object>) yaml.load(new FileInputStream(resource.getFile()));
		buildDictionary(prefix, keyValuePair, map);
	}

	@SuppressWarnings("unchecked")
	private void buildDictionary(String prefix, Map<String, String> keyValuePair, Map<String, Object> map) {
		for (Object k : map.keySet()) {
			String key = prefix.length() > 0 ? prefix + "." + k.toString() : k.toString();
			if (map.get(k) instanceof Map) {
				buildDictionary(key, keyValuePair, (Map<String, Object>) map.get(k));
			} else {
				keyValuePair.put(key, map.get(k).toString());
			}
		}
	}

	@Override
	public String getValue(String key) {

		String locale = appProperties.getLocale();

		if (mapDictionary.get(locale) == null) {
			mapDictionary.put(locale, buildMapDictionary(locale));
		}

		return mapDictionary.get(locale).get(key);
	}
}
