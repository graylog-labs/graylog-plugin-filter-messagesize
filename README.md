# Message Size Filter Plugin for Graylog

[![Build Status](https://travis-ci.org/graylog-labs/graylog-plugin-filter-messagesize.svg?branch=master)](https://travis-ci.org/graylog-labs/graylog-plugin-filter-messagesize)

This plugin installs a new filter that prints out all messages that have an estimated size crossing a configured threshold during processing. Huge messages can lead to issues in Graylog or Elasticsearch and this plugin aims to help with identifying the source of these large messages.

It will log any message that crosses the threshold like this:

```
2017-06-06 13:55:17,031 INFO : org.graylog.plugins.messagesizefilter.MessageSizeFilter - SIZE: [1520680 byte], SOURCE: [foo.example.org], INPUT: [5936f6fe277f695f099ff512], REMOTE ADDR: [/127.0.0.1]
```

**Required Graylog version:** 2.0 and later

Installation
------------

[Download the plugin](https://github.com/graylog-labs/graylog-plugin-filter-messagesize/releases)
and place the `.jar` file in your Graylog plugin directory. The plugin directory
is the `plugins/` folder relative from your `graylog-server` directory by default
and can be configured in your `graylog.conf` file.

Restart `graylog-server` and you are done.

Usage
-----

The default size threshold is 1MB. You can change the threshold in your `graylog-server.conf` configuration file like this:

```
# Set large message thresshold to 2MB
message_size_filter_threshold_bytes = 2000000
```

Plugin Release
--------------

We are using the maven release plugin:

```
$ mvn release:prepare
[...]
$ mvn release:perform
```

This sets the version numbers, creates a tag and pushes to GitHub. Travis CI will build the release artifacts and upload to GitHub automatically.
