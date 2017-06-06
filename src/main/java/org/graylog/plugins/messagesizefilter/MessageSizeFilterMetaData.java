package org.graylog.plugins.messagesizefilter;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

public class MessageSizeFilterMetaData implements PluginMetaData {
    private static final String PLUGIN_PROPERTIES = "org.graylog.plugins.graylog-plugin-filter-messagesize/graylog-plugin.properties";

    @Override
    public String getUniqueId() {
        return "org.graylog.plugins.messagesizefilter.MessageSizeFilterPlugin";
    }

    @Override
    public String getName() {
        return "Message Size Filter";
    }

    @Override
    public String getAuthor() {
        return "Lennart Koopmann <lennart@graylog.com>";
    }

    @Override
    public URI getURL() {
        return URI.create("https://github.com/graylog-labs/graylog-plugin-filter-messagesize");
    }

    @Override
    public Version getVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "version", Version.from(0, 0, 2));
    }

    @Override
    public String getDescription() {
        return "Plugin to print out information about large messages that can cause issues and lock-ups in Graylog.";
    }

    @Override
    public Version getRequiredVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "graylog.version", Version.from(2, 0, 0));
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
