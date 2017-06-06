package org.graylog.plugins.messagesizefilter;

import com.google.inject.Inject;
import org.graylog2.plugin.Message;
import org.graylog2.plugin.filters.MessageFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MessageSizeFilter implements MessageFilter {

    private static final Logger LOG = LoggerFactory.getLogger(MessageSizeFilter.class);

    public static final String NAME = "Message Size Filter";

    private final MessageSizeFilterConfiguration configuration;

    @Inject
    public MessageSizeFilter(MessageSizeFilterConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean filter(Message message) {
        int size = estimateSize(message);

        if(size > this.configuration.getThreshold()) {
            LOG.info("SIZE: [{} byte], SOURCE: [{}], INPUT: [{}], REMOTE ADDR: [{}]", size, message.getSource(), message.getSourceInputId(), message.getInetAddress().toString());
        }

        return false;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getPriority() {
        // Always run first to make sure other filters did not cut stuff out yet. Check processor order, too.
        return -9001;
    }

    /**
     * Estimate the size of the message. This is not at all accurate in favor of simplicity. Every type will be
     * converted to a String so longs and booleans will skew the result. This is not considered an issue because
     * we only want to find huge messages and not do any calculations.
     *
     * @param message
     * @return
     */
    private int estimateSize(Message message) {
        int size = 0;
        for (Map.Entry<String, Object> field : message.getFields().entrySet()) {
            if(field.getValue() != null) {
                size += field.getValue().toString().getBytes().length;
            }
        }

        return size;
    }

}
