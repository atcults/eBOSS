package org.sanelib.eboss.common.properties;

import java.util.List;

public interface MapDictionaryService {

    String generateMessage(String key, List<String> termNames, List<String> values);
}
