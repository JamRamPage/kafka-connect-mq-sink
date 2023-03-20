/**
 * Copyright 2017, 2018 IBM Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.ibm.eventstreams.connect.mqsink.builders;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.kafka.connect.sink.SinkRecord;

/**
 * Builds messages from Kafka Connect SinkRecords.
 */
public interface MessageBuilder {
    /**
     * Configure this class.
     * 
     * @param props initial configuration
     *
     * @throws ConnectException   Operation failed and connector should stop.
     */
    default void configure(Map<String, String> props) {}

    /**
     * Convert a Kafka Connect SinkRecord into a message.
     * 
     * @param mqSession          the JMS session to use for building messages
     * @param record             the Kafka Connect SinkRecord
     * 
     * @return the message
     * @throws JMSException
     */
    Message fromSinkRecord(Session mqSession, SinkRecord record) throws JMSException;
}