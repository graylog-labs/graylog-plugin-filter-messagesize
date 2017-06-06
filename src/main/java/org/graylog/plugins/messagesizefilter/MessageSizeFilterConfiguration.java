package org.graylog.plugins.messagesizefilter;

import com.github.joschi.jadconfig.Parameter;
import com.github.joschi.jadconfig.validators.PositiveIntegerValidator;
import org.graylog2.plugin.PluginConfigBean;

public class MessageSizeFilterConfiguration implements PluginConfigBean {

    private static final String PREFIX = "message_size_filter_";

    @Parameter(value = PREFIX + "threshold_bytes", validator = PositiveIntegerValidator.class)
    private int threshold = 1000000; // 1MB

    public int getThreshold() {
        return threshold;
    }

}
