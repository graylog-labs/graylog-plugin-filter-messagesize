package org.graylog.plugins.messagesizefilter;

import com.google.common.collect.ImmutableSet;
import org.graylog2.plugin.PluginConfigBean;
import org.graylog2.plugin.PluginModule;

import java.util.Set;

public class MessageSizeFilterModule extends PluginModule {

    @Override
    public Set<? extends PluginConfigBean> getConfigBeans() {
        return ImmutableSet.of(
                new MessageSizeFilterConfiguration()
        );
    }

    @Override
    protected void configure() {
        addMessageFilter(MessageSizeFilter.class);
    }
}
