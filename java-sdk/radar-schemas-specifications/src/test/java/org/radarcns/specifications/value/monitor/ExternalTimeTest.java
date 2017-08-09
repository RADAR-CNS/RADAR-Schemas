package org.radarcns.specifications.value.monitor;

/*
 * Copyright 2017 King's College London and The Hyve
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.Assert.assertEquals;
import static org.radarcns.specifications.value.Utility.testTopicNonAggregatable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.radarcns.catalogue.DataType;
import org.radarcns.catalogue.MonitorSourceType;
import org.radarcns.catalogue.Unit;
import org.radarcns.specifications.SourceCatalogue;
import org.radarcns.specifications.source.KafkaActor;
import org.radarcns.specifications.source.passive.MonitorSource;

/**
 * TODO.
 */
public class ExternalTimeTest {

    private static MonitorSource externalTime;

    @BeforeClass
    public static void initSource() {
        externalTime = SourceCatalogue.getMonitorSource(MonitorSourceType.EXTERNAL_TIME);
    }

    @Test
    public void validate() {
        assertEquals("org.radarcns.application.ApplicationServiceProvider",
                externalTime.getAppProvider());

        KafkaActor actor = externalTime.getKafkaActor();

        assertEquals(DataType.RAW.name(), actor.getDataType().name());
        assertEquals(0.08, actor.getSampleRate(), 0.0);
        assertEquals(MonitorSourceType.EXTERNAL_TIME.name(), externalTime.getType().name());
        assertEquals(Unit.NON_DIMENSIONAL, actor.getUnit());

        testTopicNonAggregatable("application_external_time",
            "org.radarcns.kafka.key.KeyMeasurement",
            "org.radarcns.monitor.application.ApplicationExternalTime",
            actor.getTopic());
    }
}