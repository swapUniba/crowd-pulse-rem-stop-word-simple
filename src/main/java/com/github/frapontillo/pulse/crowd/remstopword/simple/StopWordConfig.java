package com.github.frapontillo.pulse.crowd.remstopword.simple;

import com.google.gson.JsonElement;
import com.github.frapontillo.pulse.spi.IPluginConfig;
import com.github.frapontillo.pulse.spi.PluginConfigHelper;

import java.util.Arrays;
import java.util.List;

/**
 * Configuration class for the stop word removal step.
 *
 * @author Francesco Pontillo
 */
public class StopWordConfig implements IPluginConfig<StopWordConfig> {
    public final static String APPLY_TO_TOKENS = "tokens";
    public final static String APPLY_TO_TAGS = "tags";
    public final static String APPLY_TO_CATEGORIES = "categories";

    private List<String> applyTo;
    private StopWordDictionaries dictionaries;

    public StopWordConfig() {
        // default is "apply stop word removal to all"
        applyTo = Arrays.asList(APPLY_TO_TOKENS, APPLY_TO_TAGS, APPLY_TO_CATEGORIES);
        // avoid NPEs and instantiate it
        dictionaries = new StopWordDictionaries();
    }

    public List<String> getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(List<String> applyTo) {
        this.applyTo = applyTo;
    }

    public StopWordDictionaries getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(StopWordDictionaries dictionaries) {
        this.dictionaries = dictionaries;
    }

    public boolean mustStopTokens() {
        return (applyTo != null && applyTo.contains(APPLY_TO_TOKENS));
    }

    public boolean mustStopTags() {
        return (applyTo != null && applyTo.contains(APPLY_TO_TAGS));
    }

    public boolean mustStopCategories() {
        return (applyTo != null && applyTo.contains(APPLY_TO_CATEGORIES));
    }

    @Override public StopWordConfig buildFromJsonElement(JsonElement json) {
        StopWordConfig config = PluginConfigHelper.buildFromJson(json, StopWordConfig.class);
        return config;
    }

    public class StopWordDictionaries {
        private List<String> all;
        private List<String> tokens;
        private List<String> tags;
        private List<String> categories;

        public List<String> getAll() {
            return all;
        }

        public void setAll(List<String> all) {
            this.all = all;
        }

        public List<String> getTokens() {
            return tokens;
        }

        public void setTokens(List<String> tokens) {
            this.tokens = tokens;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }
    }
}
